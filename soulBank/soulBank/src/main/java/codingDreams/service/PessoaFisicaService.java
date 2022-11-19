package codingDreams.service;

import codingDreams.model.ContaBancaria;
import codingDreams.model.Endereco;
import codingDreams.model.PessoaFisica;
import codingDreams.repository.EnderecoRepository;
import codingDreams.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import java.util.Optional;

@Service
public class PessoaFisicaService {
    @Autowired
    private PessoaFisicaRepository sr;

    @Autowired
    private EnderecoRepository er;

    @Autowired
    private ContaBancariaService cb;



    public Optional<PessoaFisica> realizarConsultaPF(String cpf) {
      
        return sr.findById(cpf);
    }

    public PessoaFisica cadastrarPF(PessoaFisica pessoaFisica) {//vamos realizar o cadastro do banco juntamente com o cadastro da pessoa, por isso criamos o metodo cadastrarConta e chamamos conta em pessoa
        
        Endereco endereco = er.save(pessoaFisica.getEndereco());
        pessoaFisica.setEndereco(endereco);

        ContaBancaria conta= cb.cadastrarConta(pessoaFisica.getContaBancaria());
        int tipoChavePix =  conta.getTipoChavePix();
        
        switch (tipoChavePix) {
            case 1: //chave aleatória
            break;

            case 2: //CPF / CNPJ
            break;

            case 3: //telefone
            break;

            case 4: //email
            break;

            default:
            break;

        }

        pessoaFisica.setContaBancaria(conta);

        pessoaFisica = sr.save(pessoaFisica);//ao cadastrar, pegar a alternativa do cliente de qual dado usar (cpf/cnpj, telefone, email), e cadastrar no banco de dados esse dado
                         
        return pessoaFisica;
    }

    public PessoaFisica realizarAlteracaoPF(PessoaFisica pessoaFisica) {
        Endereco endereco = er.save(pessoaFisica.getEndereco());
        pessoaFisica.setEndereco(endereco);

        ContaBancaria conta= cb.realizarAlteracaoConta(pessoaFisica.getContaBancaria());
        //para a realização do soft delete será alterado o status da conta de ativa para inativa
        //ao inativar cliente, automaticamente inativa a conta
        if (pessoaFisica.getStatusCliente() == false){
            conta.setStatusConta(false);
        }
        pessoaFisica.setContaBancaria(conta);

        return sr.save(pessoaFisica);
    }
}

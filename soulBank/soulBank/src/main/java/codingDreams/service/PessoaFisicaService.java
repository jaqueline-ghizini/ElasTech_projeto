package codingDreams.service;

import codingDreams.model.ContaBancaria;
import codingDreams.model.Endereco;
import codingDreams.model.PessoaFisica;
import codingDreams.repository.ContaBancariaRepository;
import codingDreams.repository.EnderecoRepository;
import codingDreams.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaFisicaService {
    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ContaBancariaService contaBancariaService;

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    public Optional<PessoaFisica> realizarConsultaPF(String cpf) {
        return pessoaFisicaRepository.findById(cpf);
    }

    public PessoaFisica cadastrarPF(PessoaFisica pessoaFisica) {//vamos realizar o cadastro do banco juntamente com o cadastro da pessoa, por isso criamos o metodo cadastrarConta e chamamos conta em pessoa
        
        Endereco endereco = enderecoRepository.save(pessoaFisica.getEndereco());
        pessoaFisica.setEndereco(endereco);

        ContaBancaria conta= contaBancariaService.cadastrarConta(pessoaFisica.getContaBancaria());
        int tipoChavePix =  conta.getTipoChavePix();//pega um int que difere qual tipo de chave pix será cadastrada
        
        switch (tipoChavePix) {
            case 1: //chave aleatória
                final String chaveAleatoria = UUID.randomUUID().toString().replace("-", "");
                conta.setChavePix(chaveAleatoria);
            break;

            case 2: //CPF / CNPJ
                String chaveCpf = pessoaFisica.getCpf();
                conta.setChavePix(chaveCpf);
            break;

            case 3: //telefone
                String chaveTelefone = pessoaFisica.getTelefone();
                conta.setChavePix(chaveTelefone);
            break;

            case 4: //email
                String chaveEmail = pessoaFisica.getEmail();
                conta.setChavePix(chaveEmail);
            break;

            default:
                conta.setChavePix(null);
            break;
        }

        //contaBancariaRepository.save(conta);
        pessoaFisica.setContaBancaria(conta);

        pessoaFisica = pessoaFisicaRepository.save(pessoaFisica);//ao cadastrar, pegar a alternativa do cliente de qual dado usar (cpf/cnpj, telefone, email), e cadastrar no banco de dados esse dado
                         
        return pessoaFisica;
    }

    public PessoaFisica realizarAlteracaoPF(PessoaFisica pessoaFisica) {
        Endereco endereco = enderecoRepository.save(pessoaFisica.getEndereco());
        pessoaFisica.setEndereco(endereco);

        ContaBancaria conta = contaBancariaRepository.findByContaAndAgencia(pessoaFisica.getContaBancaria().getConta(), pessoaFisica.getContaBancaria().getConta());
        //ContaBancaria conta= contaBancariaService.realizarAlteracaoConta(pessoaFisica.getContaBancaria());
        //para a realização do soft delete será alterado o status da conta de ativa para inativa
        //ao inativar cliente, automaticamente inativa a conta
        if (pessoaFisica.getStatusCliente() == false){
            conta.setStatusConta(false);
        }

        //verificação de chave
        int tipoChavePix =  conta.getTipoChavePix();//pega um int que difere qual tipo de chave pix será cadastrada

        switch (tipoChavePix) {
            case 1: //chave aleatória
                final String chaveAleatoria = UUID.randomUUID().toString().replace("-", "");
                conta.setChavePix(chaveAleatoria);
                break;

            case 2: //CPF / CNPJ
                String chaveCpf = pessoaFisica.getCpf();
                conta.setChavePix(chaveCpf);
                break;

            case 3: //telefone
                String chaveTelefone = pessoaFisica.getTelefone();
                conta.setChavePix(chaveTelefone);
                break;

            case 4: //email
                String chaveEmail = pessoaFisica.getEmail();
                conta.setChavePix(chaveEmail);
                break;

            default:
                conta.setChavePix(null);
                break;
        }

        contaBancariaRepository.save(conta);// for por findby
        pessoaFisica.setContaBancaria(conta);
        return pessoaFisicaRepository.save(pessoaFisica);
    }
}

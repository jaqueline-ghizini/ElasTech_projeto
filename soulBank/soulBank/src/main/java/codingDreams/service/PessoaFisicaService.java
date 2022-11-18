package codingDreams.service;

import codingDreams.model.ContaBancaria;
import codingDreams.model.Endereco;
import codingDreams.model.PessoaFisica;
import codingDreams.repository.EnderecoRepository;
import codingDreams.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
        //Endereco endereco = er.save(pessoaFisica.getEndereco());
        //pessoaFisica.setEndereco(endereco);


        return sr.findById(cpf);
    }

    public PessoaFisica cadastrarPF(PessoaFisica pessoaFisica) {//vamos realizar o cadastro do banco juntamente com o cadastro da pessoal,por isso criamos o metodo cadstrarConta e chamamos conta em pessoa
        try {
            Endereco endereco = er.save(pessoaFisica.getEndereco());
            pessoaFisica.setEndereco(endereco);

            ContaBancaria conta= cb.cadastrarConta(pessoaFisica.getContaBancaria());//cofirmar como fazer associação com a camis
            pessoaFisica.setContaBancaria(conta);

            pessoaFisica = sr.save(pessoaFisica);//ao cadastrar, pegar a alternativa do criente de qual dado usar (cpf/cnpj, telefone, email), e cadastrar no bando de dados esse dado
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return pessoaFisica;
    }

    public PessoaFisica realizarAlteracaoPF(PessoaFisica pessoaFisica) {
        Endereco endereco = er.save(pessoaFisica.getEndereco());
        pessoaFisica.setEndereco(endereco);

        //para a realização do soft delete será alterado o status da conta de ativa para inativa

        ContaBancaria conta= cb.realizarAlteracaoConta(pessoaFisica.getContaBancaria());
        pessoaFisica.setContaBancaria(conta);

        return sr.save(pessoaFisica);
    }
}

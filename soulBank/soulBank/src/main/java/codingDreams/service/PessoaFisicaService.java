package codingDreams.service;

import codingDreams.model.ContaBancaria;
import codingDreams.model.Endereco;
import codingDreams.model.PessoaFisica;
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
    private ContaBancariaService cb;

    //@Autowired
    //private Endereco end;
    public Optional<PessoaFisica> realizarConsultaPF(String cpf) {
        return sr.findById(cpf);
    }

    public PessoaFisica cadastrarPF(PessoaFisica pessoaFisica) {//vamos realizar o cadastro do banco juntamente com o cadastro da pessoal,por isso criamos o metodo cadstrarConta e chamamos conta em pessoa
        ContaBancaria conta= cb.cadastrarConta(pessoaFisica.getContaBancaria());//cofirmar como fazer associação com a camis
        //pessoaFisica.setEndereco();
       pessoaFisica.setContaBancaria(conta);
        return sr.save(pessoaFisica);//ao cadastrar, pegar a alternativa do criente de qual dado usar (cpf/cnpj, telefone, email), e cadastrar no bando de dados esse dado

    }

    public PessoaFisica realizarAlteracaoPF(PessoaFisica pessoaFisica) {
        return sr.save(pessoaFisica);
    }
}

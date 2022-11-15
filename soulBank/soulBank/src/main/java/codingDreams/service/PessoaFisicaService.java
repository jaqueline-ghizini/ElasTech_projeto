package codingDreams.service;

import codingDreams.model.PessoaFisica;
import codingDreams.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PessoaFisicaService {
    @Autowired
    private PessoaFisicaRepository sr;

    public Optional<PessoaFisica> realizarConsultaPF(String cpf) {
        return sr.findById(cpf);
    }

    public PessoaFisica cadastrarPF(PessoaFisica pessoaFisica) {
        //ao cadastrar, pegar a alternativa do criente de qual dado usar (cpf/cnpj, telefone, email), e cadastrar no bando de dados esse dado
        return sr.save(pessoaFisica);
    }

    public PessoaFisica realizarAlteracaoPF(PessoaFisica pessoaFisica) {
        return sr.save(pessoaFisica);
    }
}

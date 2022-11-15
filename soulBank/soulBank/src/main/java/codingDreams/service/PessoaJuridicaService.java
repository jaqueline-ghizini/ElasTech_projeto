package codingDreams.service;

import codingDreams.model.PessoaJuridica;
import codingDreams.repository.PessoaFisicaRepository;
import codingDreams.repository.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PessoaJuridicaService {

    @Autowired
    private PessoaJuridicaRepository sr;

    public void realizarAlteracaoPJ(){
        
    }

    public Optional<PessoaJuridica> realizarConsultaPJ(String cnpj) {
        return sr.findById(cnpj);
    }

    public PessoaJuridica cadastrarPJ(PessoaJuridica pessoaJuridica) {
        return sr.save(pessoaJuridica);
    }

    public PessoaJuridica realizarAlteracaoPJ(PessoaJuridica pessoaJuridica) {
        return sr.save(pessoaJuridica);
    }
}

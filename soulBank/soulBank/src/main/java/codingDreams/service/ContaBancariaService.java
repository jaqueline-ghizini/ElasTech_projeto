package codingDreams.service;

import codingDreams.model.ContaBancaria;
import codingDreams.repository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContaBancariaService {
    @Autowired
    private ContaBancariaRepository sr;

    public Optional<ContaBancaria> realizarConsultaConta(Long idConta) {
        return sr.findById(idConta);
    }

    public ContaBancaria realizarAlteracaoConta(ContaBancaria contaBancaria) {
        //fazer alteração conta

        //1 para especial e 0 para normal
        boolean tipoConta = false;

        if(tipoConta){

        }else{

        }
        return sr.save(contaBancaria);
    }

    public ContaBancaria cadastrarConta(ContaBancaria contaBancaria) {
        return sr.save(contaBancaria);
    }
}

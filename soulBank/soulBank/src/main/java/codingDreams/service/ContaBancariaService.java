package codingDreams.service;

import codingDreams.model.ContaBancaria;
import codingDreams.repository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ContaBancariaService {
    @Autowired
    private ContaBancariaRepository cr;

    public Optional<ContaBancaria> realizarConsultaConta(Long idConta) {
        return cr.findById(idConta);
    }

    public ContaBancaria realizarAlteracaoConta(ContaBancaria contaBancaria) {
        //fazer alteração conta

        //1 para especial e 0 para normal
        boolean tipoConta = false;

        if(tipoConta){

        }else{

        }
        return cr.save(contaBancaria);
    }
}

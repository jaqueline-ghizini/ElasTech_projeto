package codingDreams.service;

import codingDreams.model.ContaBancaria;
import codingDreams.repository.ContaBancariaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaBancariaService {
    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    public ContaBancaria realizarConsultaConta(String numConta, String numAgencia) {
        return contaBancariaRepository.findByContaAndAgencia(numConta, numAgencia);
    }

    public ContaBancaria realizarAlteracaoConta(ContaBancaria contaBancaria) {
        if (contaBancaria.getChequeEspecial() == false) {
            Double valorLimite = 0.00;
            contaBancaria.setLimite(valorLimite);
        }
            return contaBancariaRepository.save(contaBancaria);
    }

    public ContaBancaria cadastrarConta(ContaBancaria contaBancaria) {
       if (contaBancaria.getChequeEspecial() == false) {
            Double valorLimite = 0.00;
            contaBancaria.setLimite(valorLimite);
       }
            return contaBancariaRepository.save(contaBancaria);
    }
}

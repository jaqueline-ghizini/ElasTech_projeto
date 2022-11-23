package coding.dreams.service;

import coding.dreams.model.Transacao;
import coding.dreams.model.ContaBancaria;
import coding.dreams.repository.ContaBancariaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Transacao> consultarHistoricoTransacaoPorConta(String conta, String agencia) {
        ContaBancaria contaBancaria = contaBancariaRepository.findByContaAndAgencia(conta, agencia);
        contaBancaria.getHistoricoDestino().addAll(contaBancaria.getHistoricoOrigem());
       return contaBancaria.getHistoricoDestino();
    }
}

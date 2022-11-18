package codingDreams.service;

import codingDreams.model.ContaBancaria;
import codingDreams.model.Transacao;
import codingDreams.repository.ContaBancariaRepository;
import codingDreams.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository sr;

    @Autowired
    private ContaBancariaService cs;

    @Autowired
    private ContaBancariaRepository cr;

    public List<Transacao> consultarHistorico() {
        return sr.findAll();
    }

    public Optional<Transacao> consultarTransacao(Long idTransacao) {
        return sr.findById(idTransacao);
    }

    public Transacao realizarDeposito(Transacao transacao) {
        ContaBancaria contaDestino = cr.findByContaAndAgencia(transacao.getContaDestino().getConta(), transacao.getContaDestino().getAgencia());
        transacao.setContaDestino(contaDestino);

        Double saldoDestino = contaDestino.getSaldo();
        Double valorDeposito = transacao.getValor();

        saldoDestino = saldoDestino + valorDeposito;

        contaDestino.setSaldo(saldoDestino);
        cr.save(contaDestino);

        transacao.setContaDestino(contaDestino);

        return sr.save(transacao);
    }

    public Transacao realizarSaque(Transacao transacao) {
        return sr.save(transacao);
    }

    public Transacao realizarTransferencia(Transacao transacao) {
        ContaBancaria contaOrigem = cr.findByContaAndAgencia(transacao.getContaOrigem().getConta(), transacao.getContaOrigem().getAgencia());
        transacao.setContaOrigem(contaOrigem);

        ContaBancaria contaDestino = cr.findByContaAndAgencia(transacao.getContaDestino().getConta(), transacao.getContaDestino().getAgencia());
        transacao.setContaDestino(contaDestino);

        Double saldoOrigem = contaOrigem.getSaldo();
        Double saldoDestino = contaDestino.getSaldo();
        Double valorTransferencia = transacao.getValor();

        saldoOrigem = saldoOrigem - valorTransferencia;
        saldoDestino = saldoDestino + valorTransferencia;

        contaOrigem.setSaldo(saldoOrigem);
        cr.save(contaOrigem);

        contaDestino.setSaldo(saldoDestino);
        cr.save(contaDestino);

        transacao.setContaOrigem(contaOrigem);
        transacao.setContaDestino(contaDestino);

        return sr.save(transacao);
    }

    public Transacao realizarPix(Transacao transacao) {
        return sr.save((transacao));
    }
}

package codingDreams.service;

import codingDreams.exceptions.RegistroBancoException;
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

    public Transacao realizarDeposito(Transacao transacao) throws RegistroBancoException{

            ContaBancaria contaDestino = cr.findByContaAndAgencia(transacao.getContaDestino().getConta(), transacao.getContaDestino().getAgencia());
           if(contaDestino==null){
               throw new RegistroBancoException("Conta Destino não encontrada");
           }
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
        ContaBancaria contaOrigem = cr.findByContaAndAgencia(transacao.getContaOrigem().getConta(), transacao.getContaOrigem().getAgencia());
        transacao.setContaOrigem(contaOrigem);

        Double saldoOrigem = contaOrigem.getSaldo();
        Double valorTransferencia = transacao.getValor();

        saldoOrigem = saldoOrigem - valorTransferencia;

        contaOrigem.setSaldo(saldoOrigem);
        cr.save(contaOrigem);

        transacao.setContaOrigem(contaOrigem);
        return sr.save(transacao);
    }

    public Transacao realizarTransferencia(Transacao transacao) throws RegistroBancoException {
        ContaBancaria contaOrigem = cr.findByContaAndAgencia(transacao.getContaOrigem().getConta(), transacao.getContaOrigem().getAgencia());
        //if(contaOrigem==null){
           // throw new RegistroBancoException("Conta Origem não encontrada");
        //}
        transacao.setContaOrigem(contaOrigem);

        ContaBancaria contaDestino = cr.findByContaAndAgencia(transacao.getContaDestino().getConta(), transacao.getContaDestino().getAgencia());
        //if(contaDestino==null){
            //throw new RegistroBancoException("Conta Destino não encontrada");
       // }
        transacao.setContaDestino(contaDestino);

        Double saldoOrigem = contaOrigem.getSaldo();
        Double valorLimite = contaOrigem.getLimite();
        Double saldoDestino = contaDestino.getSaldo();
        Double valorTransferencia = transacao.getValor();

        Double saldoTotalOrigem = valorLimite + saldoOrigem;

        if(saldoTotalOrigem >= valorTransferencia){
            saldoOrigem = saldoOrigem - valorTransferencia;
            saldoDestino = saldoDestino + valorTransferencia;

            contaOrigem.setSaldo(saldoOrigem);
            cr.save(contaOrigem);

            contaDestino.setSaldo(saldoDestino);
            cr.save(contaDestino);
        }else {
            throw new RegistroBancoException("Saldo insuficiente para realizar a transação");
        }

        transacao.setContaOrigem(contaOrigem);
        transacao.setContaDestino(contaDestino);

        return sr.save(transacao);
    }

    public Transacao realizarPix(Transacao transacao) {
        ContaBancaria contaOrigem = cr.findByContaAndAgencia(transacao.getContaOrigem().getConta(),transacao.getContaOrigem().getAgencia());
        transacao.setContaOrigem(contaOrigem);

        ContaBancaria contaDestino = cr.findByChavePix(transacao.getContaDestino().getChavePix());
        transacao.setContaDestino(contaDestino);

        Double saldoOrigem = contaOrigem.getSaldo();
        Double saldoDestino = contaDestino.getSaldo();
        Double valorPix = transacao.getValor();

        saldoOrigem = saldoOrigem - valorPix;
        saldoDestino = saldoDestino + valorPix;

        contaOrigem.setSaldo(saldoOrigem);
        cr.save(contaOrigem);

        contaDestino.setSaldo(saldoDestino);
        cr.save(contaDestino);

        transacao.setContaOrigem(contaOrigem);
        transacao.setContaDestino(contaDestino);

        return sr.save(transacao);
    }
}

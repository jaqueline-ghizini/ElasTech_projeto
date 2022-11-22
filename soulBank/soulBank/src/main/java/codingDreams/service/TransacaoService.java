package codingDreams.service;

import codingDreams.exceptions.VerificacaoSistemaException;
import codingDreams.model.ContaBancaria;
import codingDreams.model.Transacao;
import codingDreams.repository.ContaBancariaRepository;
import codingDreams.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    public List<Transacao> consultarHistorico() {
        return transacaoRepository.findAll();
    }

    public Optional<Transacao> consultarTransacao(Long idTransacao) {
        return transacaoRepository.findById(idTransacao);
    }

    public Transacao realizarDeposito(Transacao transacao) throws VerificacaoSistemaException {

            ContaBancaria contaDestino = contaBancariaRepository.findByContaAndAgencia(transacao.getContaDestino().getConta(), transacao.getContaDestino().getAgencia());
           if(contaDestino==null){
               throw new VerificacaoSistemaException("Conta Destino não encontrada");
           }

            transacao.setDataTransacao(new Date());
            transacao.setContaDestino(contaDestino);

            Double saldoDestino = contaDestino.getSaldo();
            Double valorDeposito = transacao.getValor();

            saldoDestino = saldoDestino + valorDeposito;

            contaDestino.setSaldo(saldoDestino);
            contaBancariaRepository.save(contaDestino);

            transacao.setContaDestino(contaDestino);

            transacao.setTipoTransacao("Deposito");

           return transacaoRepository.save(transacao);

    }

    public Transacao realizarSaque(Transacao transacao) throws VerificacaoSistemaException {
        ContaBancaria contaOrigem = contaBancariaRepository.findByContaAndAgencia(transacao.getContaOrigem().getConta(), transacao.getContaOrigem().getAgencia());
        if(contaOrigem==null){
            throw new VerificacaoSistemaException("Conta Origem não encontrada");
        }
        transacao.setDataTransacao(new Date());
        transacao.setContaOrigem(contaOrigem);

        Double saldoOrigem = contaOrigem.getSaldo();
        Double valorSaque = transacao.getValor();
        Double valorLimite = contaOrigem.getLimite();

        Double saldoTotalOrigem = saldoOrigem + valorLimite;

        if(saldoTotalOrigem >= valorSaque) {

        saldoOrigem = saldoOrigem - valorSaque;

        contaOrigem.setSaldo(saldoOrigem);
        contaBancariaRepository.save(contaOrigem);

    }else {
        throw new VerificacaoSistemaException("Saldo insuficiente para realizar o saque");
    }
        transacao.setContaOrigem(contaOrigem);
        transacao.setTipoTransacao("Saque");
        return transacaoRepository.save(transacao);
    }

    public Transacao realizarTransferencia(Transacao transacao) throws VerificacaoSistemaException {
        ContaBancaria contaOrigem = contaBancariaRepository.findByContaAndAgencia(transacao.getContaOrigem().getConta(), transacao.getContaOrigem().getAgencia());
        if(contaOrigem==null){
           throw new VerificacaoSistemaException("Conta Origem não encontrada");
        }
        transacao.setDataTransacao(new Date());
        transacao.setContaOrigem(contaOrigem);

        ContaBancaria contaDestino = contaBancariaRepository.findByContaAndAgencia(transacao.getContaDestino().getConta(), transacao.getContaDestino().getAgencia());
        if(contaDestino==null){
            throw new VerificacaoSistemaException("Conta Destino não encontrada");
       }
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
            contaBancariaRepository.save(contaOrigem);

            contaDestino.setSaldo(saldoDestino);
            contaBancariaRepository.save(contaDestino);
        }else {
            throw new VerificacaoSistemaException("Saldo insuficiente para realizar a transação");
        }

        transacao.setContaOrigem(contaOrigem);
        transacao.setContaDestino(contaDestino);
        transacao.setTipoTransacao("Transferencia");
        return transacaoRepository.save(transacao);
    }

    public Transacao realizarPix(Transacao transacao) throws VerificacaoSistemaException {
        ContaBancaria contaOrigem = contaBancariaRepository.findByContaAndAgencia(transacao.getContaOrigem().getConta(),transacao.getContaOrigem().getAgencia());
        if(contaOrigem==null){
            throw new VerificacaoSistemaException("Conta Origem não encontrada");
         }
        transacao.setDataTransacao(new Date());
        transacao.setContaOrigem(contaOrigem);
      
        ContaBancaria contaDestino = contaBancariaRepository.findByChavePix(transacao.getContaDestino().getChavePix());
        if(contaDestino==null){
             throw new VerificacaoSistemaException("Conta Destino não encontrada");
        }
        transacao.setContaDestino(contaDestino);

        Double saldoOrigem = contaOrigem.getSaldo();
        Double valorLimite = contaOrigem.getLimite();
        Double saldoDestino = contaDestino.getSaldo();
        Double valorPix = transacao.getValor();

        Double saldoTotalOrigem = valorLimite + saldoOrigem;


        if (saldoTotalOrigem >= valorPix){
            saldoOrigem = saldoOrigem - valorPix;
            saldoDestino = saldoDestino + valorPix;

            contaOrigem.setSaldo(saldoOrigem);
            contaBancariaRepository.save(contaOrigem);

            contaDestino.setSaldo(saldoDestino);
            contaBancariaRepository.save(contaDestino);

         }else {
            throw new VerificacaoSistemaException("Saldo insuficiente para realizar a transação");
        }

        transacao.setContaOrigem(contaOrigem);
        transacao.setContaDestino(contaDestino);
        transacao.setTipoTransacao("Pix");
        
        return transacaoRepository.save(transacao);
    }
}

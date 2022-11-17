package codingDreams.service;

import codingDreams.model.ContaBancaria;
import codingDreams.model.Transacao;
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

    public List<Transacao> consultarHistorico() {
        return sr.findAll();
    }

    public Optional<Transacao> consultarTransacao(Long idTransacao) {return sr.findById(idTransacao);
    }

    public Transacao realizarDeposito(Transacao transacao) {

        return sr.save(transacao);
    }

    public Transacao realizarSaque(Transacao transacao) {
        return sr.save(transacao);
    }

    public Transacao realizarTransferencia(Transacao transacao) {
       
        return sr.save(transacao);
    }

    public Transacao realizarPix(Transacao transacao) {
        return sr.save((transacao));
    }
}

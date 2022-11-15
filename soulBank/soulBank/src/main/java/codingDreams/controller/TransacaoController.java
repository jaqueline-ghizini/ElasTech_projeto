package codingDreams.controller;

import codingDreams.model.ContaBancaria;
import codingDreams.model.Transacao;
import codingDreams.service.ContaBancariaService;
import codingDreams.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transacao") //apareceu um problema de ambiguidade e resolvemos colocando essa linha de código
public class TransacaoController {

    @Autowired
    private TransacaoService cs;

    @GetMapping("/consultarhistorico")
    public ResponseEntity<List<Transacao>> consultarHistorico(){
        return ResponseEntity.ok(cs.consultarHistorico());
    }

    @GetMapping("/consultartransacao/{idTransacao}")
    public ResponseEntity<?> consultarTransacao(@PathVariable Long idTransacao){
        /*System.out.println("Id da Transação a ser localizada: "+idTransacao);
        Transacao transacao = new Transacao();
        transacao.setIdTransacao(idTransacao);
        transacao.setValor(100.00);*/

        Optional<Transacao> opcao = cs.consultarTransacao(idTransacao);

        if(opcao.isPresent()){
            return ResponseEntity.ok(opcao.get());// Consulta especifica
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/depositar")
    public ResponseEntity<Transacao> realizarDeposito(@RequestBody Transacao transacao){
        return ResponseEntity.ok(cs.realizarDeposito(transacao));
    }

    @PostMapping("/sacar")
    public ResponseEntity<Transacao> realizarSaque(@RequestBody Transacao transacao){
        return ResponseEntity.ok(cs.realizarSaque(transacao));
    }

    @PostMapping("/transferir")
    public ResponseEntity<Transacao> realizarTransferencia(@RequestBody Transacao transacao){
        return ResponseEntity.ok(cs.realizarTransferencia(transacao));
    }

    @PostMapping("/pix")
    public ResponseEntity<Transacao> realizarPix(@RequestBody Transacao transacao){
        return ResponseEntity.ok(cs.realizarPix(transacao));
    }

}
package coding.dreams.controller;

import coding.dreams.exceptions.VerificacaoSistemaException;
import coding.dreams.model.Transacao;
import coding.dreams.service.TransacaoService;
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
    private TransacaoService transacaoService;

  /*  @GetMapping("/consultarhistorico/{conta}/{agencia}")
    public ResponseEntity<List<Transacao>> consultarHistorico(@PathVariable String conta, @PathVariable String agencia){
        ContaBancaria contaBancaria = cs.consultarHistorico(conta, agencia);

        if(contaBancaria != null){
            return ResponseEntity.ok(cs.consultarHistorico());
        }
        return new ResponseEntity<>("Conta Bancária não encontrada",HttpStatus.NOT_FOUND);
    }*/

    @GetMapping("/consultarhistorico")
    public ResponseEntity<List<Transacao>> consultarHistorico(){
            return ResponseEntity.ok(transacaoService.consultarHistorico());
    }

    @GetMapping("/consultartransacao/{idTransacao}")
    public ResponseEntity<?> consultarTransacao(@PathVariable Long idTransacao){

        Optional<Transacao> opcao = transacaoService.consultarTransacao(idTransacao);

        if(opcao.isPresent()){
            return ResponseEntity.ok(opcao.get());// Consulta especifica
        }
        return new ResponseEntity<>("Transação não encontrada.",HttpStatus.NOT_FOUND);
    }

    @PostMapping("/depositar")
    public ResponseEntity realizarDeposito(@RequestBody Transacao transacao){
        try{
          return ResponseEntity.ok(transacaoService.realizarDeposito(transacao));
        } catch(VerificacaoSistemaException e){
          return ResponseEntity
                  .status(HttpStatus.NOT_FOUND)
                  .body(e.getMessage());
        }
    }

    @PostMapping("/sacar")
    public ResponseEntity realizarSaque(@RequestBody Transacao transacao){
       try{
            return ResponseEntity.ok(transacaoService.realizarSaque(transacao));
       } catch(VerificacaoSistemaException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
       }
    }

    @PostMapping("/transferir")
    public ResponseEntity realizarTransferencia(@RequestBody Transacao transacao){
        try{
            return ResponseEntity.ok(transacaoService.realizarTransferencia(transacao));
        } catch(VerificacaoSistemaException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @PostMapping("/pix")
    public ResponseEntity realizarPix(@RequestBody Transacao transacao){
        try{
            return ResponseEntity.ok(transacaoService.realizarPix(transacao));
        } catch(VerificacaoSistemaException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}
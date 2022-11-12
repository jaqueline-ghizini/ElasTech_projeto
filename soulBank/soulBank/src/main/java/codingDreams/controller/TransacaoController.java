package codingDreams.controller;

import codingDreams.model.ContaBancaria;
import codingDreams.model.Transacao;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransacaoController {
    //private String mensagem;
    @GetMapping("/consultarHistorico")
    public String realizarConsultaHistoricoTransacao(){
        return "Consulta de historico Realizada"; // Consulta geral
    }

    @GetMapping("/consultarTransacao/{idTransacao}")
    public String realizarConsultaTransacao(@PathVariable Long idTransacao){
        System.out.println("Id da Transação a ser localizada: "+idTransacao);
        return "Id da transação: "+idTransacao;// Consulta especifica
    }

    @PostMapping("/depositar")
    public String realizarDeposito(@RequestBody Transacao transacao){
        return "Deposito Realizada";
    }

    @PostMapping("/sacar")
    public String realizarSaque(@RequestBody Transacao transacao){
        return "Saque Realizado";
    }

    @PostMapping("/transferir")
    public String realizarTransferencia(@RequestBody Transacao transacao){
        return "Transferencia Realizada";
    }

    @PostMapping("/pix")
    public String realizarTransferenciaPix(@RequestBody Transacao transacao){
        return "Transferencia de Pix Realizada";
    }

}
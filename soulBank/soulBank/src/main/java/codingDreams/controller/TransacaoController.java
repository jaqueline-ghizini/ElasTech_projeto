package codingDreams.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransacaoController {
    //private String mensagem;
    @GetMapping("/ ")
    public String realizarConsultaHistoricoTransacao(){
        return "Consulta de historico Realizada"; // Consulta geral     

    }

    @GetMapping("/ ")
    public String realizarConsultaTransacao(){
        return "Consulta Realizada";// Consulta especifica

    }

    @PostMapping()
    public String registrarTransacao(){
        return "Transacao Realizada";
    }
}
package codingDreams.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PessoaFisicaController {
    //private String mensagem;
    @GetMapping("/ ")
    public String realizarConsultaPF(){
        return "Consulta Realizada";
    }
    
    @PostMapping()
    public String cadastrarPF(){
        return "Cadastro Realizado";
    }
    @PutMapping()
        public String realizarAlteracaoPF(){
            return "Atualizado com sucesso";
        }
}


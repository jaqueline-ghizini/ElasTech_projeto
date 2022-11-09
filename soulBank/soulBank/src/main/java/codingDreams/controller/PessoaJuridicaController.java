package codingDreams.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaJuridicaController {
    
    //private String mensagem;
    @GetMapping("/ ")
    public String realizarConsultaPJ(){
        return "Consulta Realizada";
    }

    @PostMapping()
    public String cadastrarPJ(){
        return "Cadastro Realizado";
    }

    @PutMapping()
        public String realizarAlteracaoPJ(){
            return "Atualizado com sucesso";
        }
}

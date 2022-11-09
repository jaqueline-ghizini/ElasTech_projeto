package codingDreams.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class ContaBancariaController {
    //private String mensagem;
        @GetMapping("/ ")
        public String realizarConsultaConta(){
            return "Consulta Realizada";

        }
        @PutMapping()
        public String realizarAlteracaoConta(){
            return "Conta inativada com sucesso";
        }

    
  


}

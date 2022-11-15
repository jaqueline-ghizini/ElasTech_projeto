package codingDreams.controller;

import codingDreams.model.ContaBancaria;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/contabancaria") //apareceu um problema de ambiguidade e resolvemos colocando essa linha de código
//tivemos um problema com a porta padrão e setamos uma nova porta no application.properties
public class ContaBancariaController {
       //private String mensagem;
        @GetMapping("/consultarconta/{conta}")
        public ContaBancaria realizarConsultaConta(@PathVariable String conta){
            System.out.println("Conta a ser localizada: "+conta);

            ContaBancaria contBank = new ContaBancaria();
            contBank.setConta(conta);
            contBank.setSaldo(200.00);

            return contBank;
        }

        //  Só tem alteração e não tem cadastro pois é cadastrado juntamente com o cliente.
        //  Também tem SoftDelete, ou seja os dados não serão perdidos.
        //  A conta pode ser alterada entre comum e especial.
        //  A conta só é inativada juntamente com o cliente.
        @PutMapping
        public String realizarAlteracaoConta(@RequestBody ContaBancaria contaBancaria){
            return "Conta alterada com sucesso";
        }

}

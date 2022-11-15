package codingDreams.controller;

import codingDreams.model.ContaBancaria;
import codingDreams.service.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/contabancaria") //apareceu um problema de ambiguidade e resolvemos colocando essa linha de código
//tivemos um problema com a porta padrão e setamos uma nova porta no application.properties
public class ContaBancariaController {

        @Autowired
        private ContaBancariaService cs;

        @GetMapping("/consultarconta/{conta}")
        public ResponseEntity<?> realizarConsultaConta(@PathVariable Long idConta){
            //System.out.println("Conta a ser localizada: "+conta);
            //ContaBancaria contBank = new ContaBancaria();
            //contBank.setConta(conta);
            //contBank.setSaldo(200.00);

            Optional<ContaBancaria> opcao = cs.realizarConsultaConta(idConta);

            if(opcao.isPresent()){
                return ResponseEntity.ok(opcao.get());
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        //  Só tem alteração e não tem cadastro pois é cadastrado juntamente com o cliente.
        //  Também tem SoftDelete, ou seja os dados não serão perdidos.
        //  A conta pode ser alterada entre comum e especial.
        //  A conta só é inativada juntamente com o cliente.
        @PutMapping
        public ResponseEntity<ContaBancaria> realizarAlteracaoConta(@RequestBody ContaBancaria contaBancaria){
            return ResponseEntity.ok(cs.realizarAlteracaoConta(contaBancaria));
        }

}

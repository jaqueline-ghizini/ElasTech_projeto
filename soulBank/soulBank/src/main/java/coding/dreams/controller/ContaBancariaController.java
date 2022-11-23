package coding.dreams.controller;

import coding.dreams.model.ContaBancaria;
import coding.dreams.model.Transacao;
import coding.dreams.service.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/contabancaria") //apareceu um problema de ambiguidade e resolvemos colocando essa linha de código
//tivemos um problema com a porta padrão e setamos uma nova porta no application.properties
public class ContaBancariaController {

        @Autowired
        private ContaBancariaService contaBancariaService;

        @GetMapping("/consultarconta/{conta}/{agencia}")//pesquisa conta não pelo id, mas pela conta e agência
        public ResponseEntity<?> realizarConsultaConta(@PathVariable String conta, @PathVariable String agencia){
            
            ContaBancaria contaBancaria = contaBancariaService.realizarConsultaConta(conta, agencia);

            if(contaBancaria != null){
                return ResponseEntity.ok(contaBancaria);
            }
            return new ResponseEntity<>("Conta Bancária não encontrada.",HttpStatus.NOT_FOUND);
        }

        @GetMapping("/consultarhistorico/{conta}/{agencia}")//historico de transação
        public ResponseEntity<List<Transacao>> consultarHistoricoTransacaoPorConta(@PathVariable String conta, @PathVariable String agencia){

            List<Transacao> trasacao = contaBancariaService.consultarHistoricoTransacaoPorConta(conta, agencia);

                return ResponseEntity.ok(trasacao);
        }

        //  Só tem alteração e não tem cadastro pois é cadastrado juntamente com o cliente.
        //  Também tem SoftDelete, ou seja os dados não serão perdidos.
        //  A conta pode ser alterada entre comum e especial.
        //  A conta só é inativada juntamente com o cliente.
        @PutMapping
        public ResponseEntity<ContaBancaria> realizarAlteracaoConta(@RequestBody ContaBancaria contaBancaria){
            return ResponseEntity.ok(contaBancariaService.realizarAlteracaoConta(contaBancaria));
        }
        @PostMapping
        public ResponseEntity<ContaBancaria> cadastrarConta(@RequestBody ContaBancaria contaBancaria){
            return ResponseEntity.ok(contaBancariaService.cadastrarConta(contaBancaria));
    }

}

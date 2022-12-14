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

        //pesquisar conta não pelo id, mas pela conta e agência que é mais usual
        @GetMapping("/consultarconta/{conta}/{agencia}")
        public ResponseEntity<?> realizarConsultaConta(@PathVariable String conta, @PathVariable String agencia){
            
            ContaBancaria contaBancaria = contaBancariaService.realizarConsultaConta(conta, agencia);

            if(contaBancaria != null){
                return ResponseEntity.ok(contaBancaria);
            }
            return new ResponseEntity<>("Conta Bancária não encontrada.",HttpStatus.NOT_FOUND);
        }

        @GetMapping("/consultarhistoricotransacao/{conta}/{agencia}")//historico de transação
        public ResponseEntity<List<Transacao>> consultarHistoricoTransacaoPorConta(@PathVariable String conta, @PathVariable String agencia){

            List<Transacao> trasacao = contaBancariaService.consultarHistoricoTransacaoPorConta(conta, agencia);

                return ResponseEntity.ok(trasacao);
        }

        //  Também tem SoftDelete, ou seja os dados não serão perdidos.
        //  A conta pode ser alterada entre ter cheque Especial e não ter.
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

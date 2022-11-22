package codingDreams.controller;

import codingDreams.exceptions.VerificacaoSistemaException;
import codingDreams.model.PessoaFisica;
import codingDreams.service.PessoaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pessoafisica") //apareceu um problema de ambiguidade e resolvemos colocando essa linha de código
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @GetMapping("/consultapf/{cpf}")
    public ResponseEntity<?> realizarConsultaPF(@PathVariable String cpf){

        Optional<PessoaFisica> opcao = pessoaFisicaService.realizarConsultaPF(cpf);

        if(opcao.isPresent()){
            return ResponseEntity.ok(opcao.get());
        }
        return new ResponseEntity<>("Cliente não encontrado.",HttpStatus.NOT_FOUND);
    }
    
    @PostMapping
    public ResponseEntity<PessoaFisica> cadastrarPF(@RequestBody PessoaFisica pessoaFisica){ // Observação a ser excluida: ser for testar sem ter o banco ainda, alterar o metodo com o valor de retorno e também o return
        return ResponseEntity.ok(pessoaFisicaService.cadastrarPF(pessoaFisica));
    }
    @PutMapping
    public ResponseEntity realizarAlteracaoPF(@RequestBody PessoaFisica pessoaFisica){

        try{
            return ResponseEntity.ok(pessoaFisicaService.realizarAlteracaoPF(pessoaFisica));
        } catch(VerificacaoSistemaException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}


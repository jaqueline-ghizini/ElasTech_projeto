package codingDreams.controller;

import codingDreams.exceptions.VerificacaoSistemaException;
import codingDreams.model.PessoaJuridica;
import codingDreams.service.PessoaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pessoajuridica") //apareceu um problema de ambiguidade nos testes e resolvemos colocando essa linha de código
public class PessoaJuridicaController {

    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;

    @GetMapping("/consultarpj/{cnpj}")
    public ResponseEntity<?> realizarConsultaPJ(@PathVariable String cnpj ){

        Optional<PessoaJuridica> opcao = pessoaJuridicaService.realizarConsultaPJ(cnpj);

        if(opcao.isPresent()){
            return ResponseEntity.ok(opcao.get());
        }
        return new ResponseEntity<>("Cliente não encontrado.",HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<PessoaJuridica> cadastrarPJ(@RequestBody PessoaJuridica pessoaJuridica){
        return ResponseEntity.ok(pessoaJuridicaService.cadastrarPJ(pessoaJuridica));
    }

    @PutMapping
    public ResponseEntity realizarAlteracaoPJ(@RequestBody PessoaJuridica pessoaJuridica){

        try{
            return ResponseEntity.ok(pessoaJuridicaService.realizarAlteracaoPJ(pessoaJuridica));
        } catch(VerificacaoSistemaException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}

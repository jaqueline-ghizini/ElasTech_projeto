package codingDreams.controller;

import codingDreams.model.ContaBancaria;
import codingDreams.model.PessoaFisica;
import codingDreams.model.PessoaJuridica;
import codingDreams.service.ContaBancariaService;
import codingDreams.service.PessoaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pessoajuridica") //apareceu um problema de ambiguidade e resolvemos colocando essa linha de código
public class PessoaJuridicaController {

    @Autowired
    private PessoaJuridicaService cs;

    @GetMapping("/consultarpj/{cnpj}")
    public ResponseEntity<?> realizarConsultaPJ(@PathVariable String cnpj ){
       /* System.out.println("CNPJ do cliente a ser localizado: " +cnpj);
        ContaBancaria conta = new ContaBancaria();
        conta.setConta("1");
        PessoaJuridica pj = new PessoaJuridica();
        pj.setCnpj(cnpj);
        pj.setRazaoSocial("razao social");
        pj.setContaBancaria(conta);*/

        Optional<PessoaJuridica> opcao = cs.realizarConsultaPJ(cnpj);

        if(opcao.isPresent()){
            return ResponseEntity.ok(opcao.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<PessoaJuridica> cadastrarPJ(@RequestBody PessoaJuridica pessoaJuridica){
       /* System.out.println(pessoaJuridica.getCnpj());
        System.out.println(pessoaJuridica.getRazaoSocial());
        System.out.println(pessoaJuridica.getTelefone());
        System.out.println(pessoaJuridica.getEndereco().getLogradouro());
        System.out.println(pessoaJuridica.getContaBancaria().getSaldo());*/
        return ResponseEntity.ok(cs.cadastrarPJ(pessoaJuridica));
    }

    @PutMapping
    public ResponseEntity<PessoaJuridica> realizarAlteracaoPJ(@RequestBody PessoaJuridica pessoaJuridica){
        return ResponseEntity.ok(cs.realizarAlteracaoPJ(pessoaJuridica));
    }
}

package codingDreams.controller;

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
    private PessoaFisicaService cs;

    @GetMapping("/consultapf/{cpf}")
    public ResponseEntity<?> realizarConsultaPF(@PathVariable String cpf){
        /*System.out.println("CPF do cliente a ser localizado: " +cpf);
        ContaBancaria conta = new ContaBancaria();
        conta.setConta("1");
        PessoaFisica pf = new PessoaFisica();
        pf.setCpf(cpf);
        pf.setNome("Nome");
        pf.setContaBancaria(conta);*/

        Optional<PessoaFisica> opcao = cs.realizarConsultaPF(cpf);

        if(opcao.isPresent()){
            return ResponseEntity.ok(opcao.get());
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping
    public ResponseEntity<PessoaFisica> cadastrarPF(@RequestBody PessoaFisica pessoaFisica){ // Observação a ser excluida: ser for testar sem ter o banco ainda, alterar o metodo com o valor de retorno e também o return
       /* System.out.println(pessoaFisica.getCpf());
        System.out.println(pessoaFisica.getNome());
        System.out.println(pessoaFisica.getTelefone());
        System.out.println(pessoaFisica.getEndereco().getLogradouro());
        System.out.println(pessoaFisica.getContaBancaria().getSaldo());*/

        return ResponseEntity.ok(cs.cadastrarPF(pessoaFisica));

    }
    @PutMapping
    public ResponseEntity<PessoaFisica> realizarAlteracaoPF(@RequestBody PessoaFisica pessoaFisica){
        return ResponseEntity.ok(cs.realizarAlteracaoPF(pessoaFisica));
    }
}


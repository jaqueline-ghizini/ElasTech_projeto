package codingDreams.controller;

import codingDreams.model.PessoaFisica;
import org.springframework.web.bind.annotation.*;

@RestController

public class PessoaFisicaController {
    //private String mensagem;
    @GetMapping("/consultaPf/{cpf}")
    public String realizarConsultaPF(@PathVariable String cpf){
        System.out.println("CPF do cliente a ser localizado: " +cpf);
        return "Cpf consultado: "+cpf;
    }
    
    @PostMapping
    public String cadastrarPF(@RequestBody PessoaFisica pessoaFisica){
        System.out.println(pessoaFisica.getCpf());
        System.out.println(pessoaFisica.getNome());
        System.out.println(pessoaFisica.getTelefone());
        System.out.println(pessoaFisica.getEndereco().getLogradouro());
        return "Cadastro Realizado";
    }
    @PutMapping
    public String realizarAlteracaoPF(@RequestBody PessoaFisica pessoaFisica){
        return "Atualizado com sucesso";
    }
}


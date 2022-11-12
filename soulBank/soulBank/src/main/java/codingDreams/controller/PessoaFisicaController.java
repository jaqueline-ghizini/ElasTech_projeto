package codingDreams.controller;

import codingDreams.model.ContaBancaria;
import codingDreams.model.PessoaFisica;
import org.springframework.web.bind.annotation.*;

@RestController

public class PessoaFisicaController {
    //private String mensagem;
    @GetMapping("/consultaPf/{cpf}")
    public PessoaFisica realizarConsultaPF(@PathVariable String cpf){
        System.out.println("CPF do cliente a ser localizado: " +cpf);

        ContaBancaria conta = new ContaBancaria();
        conta.setConta("1");
        PessoaFisica pf = new PessoaFisica();
        pf.setCpf(cpf);
        pf.setNome("Nome");
        pf.setContaBancaria(conta);

        return pf;
    }
    
    @PostMapping
    public String cadastrarPF(@RequestBody PessoaFisica pessoaFisica){
        System.out.println(pessoaFisica.getCpf());
        System.out.println(pessoaFisica.getNome());
        System.out.println(pessoaFisica.getTelefone());
        System.out.println(pessoaFisica.getEndereco().getLogradouro());
        System.out.println(pessoaFisica.getContaBancaria().getSaldo());
        return "Cadastro Realizado";
    }
    @PutMapping
    public String realizarAlteracaoPF(@RequestBody PessoaFisica pessoaFisica){
        return "Atualizado com sucesso";
    }
}


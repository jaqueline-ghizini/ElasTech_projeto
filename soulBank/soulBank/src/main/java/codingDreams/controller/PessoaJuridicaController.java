package codingDreams.controller;

import codingDreams.model.PessoaFisica;
import codingDreams.model.PessoaJuridica;
import org.springframework.web.bind.annotation.*;

@RestController
public class PessoaJuridicaController {
    
    //private String mensagem;
    @GetMapping("/consultarPj/{cnpj}")
    public String realizarConsultaPJ(@PathVariable String cnpj ){
        System.out.println("CNPJ do cliente a ser localizado: " +cnpj);
        return "Cnpj pesquisado: "+cnpj;
    }

    @PostMapping
    public String cadastrarPJ(@RequestBody PessoaJuridica pessoaJuridica){
        System.out.println(pessoaJuridica.getCnpj());
        System.out.println(pessoaJuridica.getRazaoSocial());
        System.out.println(pessoaJuridica.getTelefone());
        System.out.println(pessoaJuridica.getEndereco().getLogradouro());
        return "Cadastro Realizado";
    }

    @PutMapping
    public String realizarAlteracaoPJ(@RequestBody PessoaJuridica pessoaJuridica){
        return "Atualizado com sucesso";
    }
}

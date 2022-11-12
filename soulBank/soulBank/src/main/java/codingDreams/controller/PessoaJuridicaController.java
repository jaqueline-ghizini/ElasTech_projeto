package codingDreams.controller;

import codingDreams.model.ContaBancaria;
import codingDreams.model.PessoaFisica;
import codingDreams.model.PessoaJuridica;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoajuridica") //apareceu um problema de ambiguidade e resolvemos colocando essa linha de código
public class PessoaJuridicaController {
    
    //private String mensagem;
    @GetMapping("/consultarpj/{cnpj}")
    public PessoaJuridica realizarConsultaPJ(@PathVariable String cnpj ){
        System.out.println("CNPJ do cliente a ser localizado: " +cnpj);

        ContaBancaria conta = new ContaBancaria();
        conta.setConta("1");
        PessoaJuridica pj = new PessoaJuridica();
        pj.setCnpj(cnpj);
        pj.setRazaoSocial("razao social");
        pj.setContaBancaria(conta);

        return pj;
    }

    @PostMapping
    public String cadastrarPJ(@RequestBody PessoaJuridica pessoaJuridica){
        System.out.println(pessoaJuridica.getCnpj());
        System.out.println(pessoaJuridica.getRazaoSocial());
        System.out.println(pessoaJuridica.getTelefone());
        System.out.println(pessoaJuridica.getEndereco().getLogradouro());
        System.out.println(pessoaJuridica.getContaBancaria().getSaldo());
        return "Cadastro Realizado";
    }

    @PutMapping
    public String realizarAlteracaoPJ(@RequestBody PessoaJuridica pessoaJuridica){
        return "Atualizado com sucesso";
    }
}

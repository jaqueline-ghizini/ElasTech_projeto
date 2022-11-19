package codingDreams.service;

import codingDreams.model.ContaBancaria;
import codingDreams.model.Endereco;
import codingDreams.model.PessoaJuridica;
import codingDreams.repository.EnderecoRepository;
import codingDreams.repository.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaJuridicaService {

    @Autowired
    private PessoaJuridicaRepository sr;

    @Autowired
    private EnderecoRepository er;

    @Autowired
    private ContaBancariaService cb;

    public Optional<PessoaJuridica> realizarConsultaPJ(String cnpj) {
        return sr.findById(cnpj);
    }

    public PessoaJuridica cadastrarPJ(PessoaJuridica pessoaJuridica) {
        Endereco endereco = er.save(pessoaJuridica.getEndereco());
        pessoaJuridica.setEndereco(endereco);

        ContaBancaria conta= cb.cadastrarConta(pessoaJuridica.getContaBancaria());//cofirmar como fazer associação com a camis
        pessoaJuridica.setContaBancaria(conta);

        return sr.save(pessoaJuridica);
    }

    public PessoaJuridica realizarAlteracaoPJ(PessoaJuridica pessoaJuridica) {

        Endereco endereco = er.save(pessoaJuridica.getEndereco());
        pessoaJuridica.setEndereco(endereco);

        ContaBancaria conta= cb.cadastrarConta(pessoaJuridica.getContaBancaria());
       //para a realização do soft delete será alterado o status da conta de ativa para inativa.
       //ao inativar cliente, automaticamente inativa a conta
        if (pessoaJuridica.getStatusCliente() == false){
            conta.setStatusConta(false);
        }

        pessoaJuridica.setContaBancaria(conta);

        return sr.save(pessoaJuridica);
    }
}

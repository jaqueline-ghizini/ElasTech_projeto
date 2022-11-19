package codingDreams.service;

import codingDreams.model.ContaBancaria;
import codingDreams.model.Endereco;
import codingDreams.model.PessoaJuridica;
import codingDreams.repository.ContaBancariaRepository;
import codingDreams.repository.EnderecoRepository;
import codingDreams.repository.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaJuridicaService {

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ContaBancariaService contaBancariaService;

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    public Optional<PessoaJuridica> realizarConsultaPJ(String cnpj) {
        return pessoaJuridicaRepository.findById(cnpj);
    }

    public PessoaJuridica cadastrarPJ(PessoaJuridica pessoaJuridica) {

        Endereco endereco = enderecoRepository.save(pessoaJuridica.getEndereco());
        pessoaJuridica.setEndereco(endereco);

        ContaBancaria conta= contaBancariaService.cadastrarConta(pessoaJuridica.getContaBancaria());//cofirmar como fazer associação com a camis
        int tipoChavePix =  conta.getTipoChavePix();//pega um int que difere qual tipo de chave pix será cadastrada

        switch (tipoChavePix) {
            case 1: //chave aleatória
                final String chaveAleatoria = UUID.randomUUID().toString().replace("-", "");
                conta.setChavePix(chaveAleatoria);
                break;

            case 2: //CPF / CNPJ
                String chaveCpf = pessoaJuridica.getCnpj();
                conta.setChavePix(chaveCpf);
                break;

            case 3: //telefone
                String chaveTelefone = pessoaJuridica.getTelefone();
                conta.setChavePix(chaveTelefone);
                break;

            case 4: //email
                String chaveEmail = pessoaJuridica.getEmail();
                conta.setChavePix(chaveEmail);
                break;

            default:
                conta.setChavePix(null);
                break;
        }
        //contaBancariaRepository.save(conta);
        pessoaJuridica.setContaBancaria(conta);

        pessoaJuridica = pessoaJuridicaRepository.save(pessoaJuridica);

        return pessoaJuridica;
    }

    public PessoaJuridica realizarAlteracaoPJ(PessoaJuridica pessoaJuridica) {

        Endereco endereco = enderecoRepository.save(pessoaJuridica.getEndereco());
        pessoaJuridica.setEndereco(endereco);

        ContaBancaria conta= contaBancariaService.realizarAlteracaoConta(pessoaJuridica.getContaBancaria());
       //para a realização do soft delete será alterado o status da conta de ativa para inativa.
       //ao inativar cliente, automaticamente inativa a conta
        if (pessoaJuridica.getStatusCliente() == false){
            conta.setStatusConta(false);
        }

        int tipoChavePix =  conta.getTipoChavePix();//pega um int que difere qual tipo de chave pix será cadastrada

        switch (tipoChavePix) {
            case 1: //chave aleatória
                final String chaveAleatoria = UUID.randomUUID().toString().replace("-", "");
                conta.setChavePix(chaveAleatoria);
                break;

            case 2: //CPF / CNPJ
                String chaveCpf = pessoaJuridica.getCnpj();
                conta.setChavePix(chaveCpf);
                break;

            case 3: //telefone
                String chaveTelefone = pessoaJuridica.getTelefone();
                conta.setChavePix(chaveTelefone);
                break;

            case 4: //email
                String chaveEmail = pessoaJuridica.getEmail();
                conta.setChavePix(chaveEmail);
                break;

            default:
                conta.setChavePix(null);
                break;
        }
        //contaBancariaRepository.save(conta);
        pessoaJuridica.setContaBancaria(conta);

        return pessoaJuridicaRepository.save(pessoaJuridica);
    }
}

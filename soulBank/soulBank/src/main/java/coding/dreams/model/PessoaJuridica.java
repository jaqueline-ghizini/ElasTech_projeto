package coding.dreams.model;

import javax.persistence.*;
import java.util.Objects;

@Entity

public class PessoaJuridica extends Cliente {
    @Column(unique=true)
    @Id
    private String cnpj;
    private String razaoSocial;
    @ManyToOne @JoinColumn(name="idEndereco")
    private Endereco endereco; //preferimos fazer em classe separada para ficar melhor estruturado//

    @OneToOne
    private ContaBancaria contaBancaria;

    public PessoaJuridica(){
        //construtor vazio pra teste, ao criar objeto utilizar set
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaJuridica pessoaJuridica = (PessoaJuridica) o;
        return Objects.equals(cnpj, pessoaJuridica.cnpj);
    }
    @Override
    public int hashCode() {
        return Objects.hash(cnpj);
    }

    public PessoaJuridica(String email, String telefone, boolean statusCliente, String cnpj, String razaoSocial, Endereco endereco, ContaBancaria contaBancaria) {
        super(email, telefone, statusCliente);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.endereco=endereco;
        this.contaBancaria= contaBancaria;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public String consultarCliente(){ //ver como botar endereço nas pessoas
        return super.email+"/"+super.telefone+"/"+ super.statusCliente + "/" + this.cnpj+"/"+this.razaoSocial+"/"+this.endereco.toString()+"/"+this.contaBancaria.toString();
    }
}

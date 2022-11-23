package coding.dreams.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

//@Embeddable
@Entity

public class Endereco {

    @Id
    @GeneratedValue
    private Long idEndereco;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    @OneToMany(mappedBy="endereco", targetEntity=PessoaFisica.class)
    @JsonIgnore
    private Collection pessoaFisica;

    @OneToMany(mappedBy="endereco", targetEntity=PessoaJuridica.class)
    @JsonIgnore
    private Collection pessoaJuridica;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco= (Endereco) o;
        return Objects.equals(idEndereco, endereco.idEndereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEndereco);
    }

    public Endereco(Long idEndereco, String logradouro, String complemento, String bairro, String cidade, String estado, String cep,Collection pessoaFisica, Collection pessoaJuridica) {
        this.idEndereco = idEndereco;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.pessoaFisica=pessoaFisica;
        this.pessoaJuridica= pessoaJuridica;
    }
    public Endereco(){

    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
       this.idEndereco = idEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Collection getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(Collection pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public Collection getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(Collection pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    @Override
	public String toString() {
		return this.logradouro + "," + this.complemento + "," + this.bairro + "," + this.cidade + "," + this.estado + "," + this.cep;
    }
}

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
    private String localidade;
    private String uf;
    private String cep;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    @OneToMany(mappedBy="endereco", targetEntity=PessoaFisica.class)//Separamos o endereço em uma classe separada para que mais clientes possam utilizar o mesmo endereço
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

    public Endereco(Long idEndereco, String logradouro, String complemento, String bairro, String localidade, String uf, String cep,String ibge, String gia, String ddd, String siafi, Collection pessoaFisica, Collection pessoaJuridica) {
        this.idEndereco = idEndereco;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.cep = cep;
        this.ibge = ibge;
        this.gia = gia;
        this.ddd = ddd;
        this.siafi = siafi;
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

    public String getLocalidade() {
        return localidade;
    }

    public void setCidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setEstado(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getSiafi() {
        return siafi;
    }

    public void setSiafi(String siafi) {
        this.siafi = siafi;
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
		return this.logradouro + "," + this.complemento + "," + this.bairro + "," + this.localidade + "," + this.uf + "," + this.cep +"," + this.ibge + "," + this.gia + "," + this.ddd + "," + this.siafi;
    }
}

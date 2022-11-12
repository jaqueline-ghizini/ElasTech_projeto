package codingDreams.model;


import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Embeddable
@Entity

public class Endereco {

    @Id
    //@GeneratedValue
    private Long idEndereco; //só get pq vai ser só pra consulta
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco(Long idEndereco, String logradouro, String complemento, String bairro, String cidade, String estado, String cep) {
        this.idEndereco = idEndereco;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    //public void setIdEndereco(Long idEndereco) {
    //    this.idEndereco = idEndereco;
    //}

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

    @Override
	public String toString() {
		return this.logradouro + "," + this.complemento + "," + this.bairro + "," + this.cidade + "," + this.estado + "," + this.cep;
    }
}

package codingDreams.model;

public class Endereco {
    private int idEndereco; //só get pq vai ser só pra consulta
    private String enderecoCompleto;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco(int idEndereco, String enderecoCompleto, String complemento, String bairro, String cidade, String estado, String cep) {
        this.idEndereco = idEndereco;
        this.enderecoCompleto = enderecoCompleto;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    //public void setIdEndereco(int idEndereco) {
    //    this.idEndereco = idEndereco;
    //}

    public String getEnderecoCompleto() {
        return enderecoCompleto;
    }

    public void setEnderecoCompleto(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
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
		return this.enderecoCompleto + "," + this.complemento + "," + this.bairro + "," + this.cidade + "," + this.estado + "," + this.cep;
    }
}

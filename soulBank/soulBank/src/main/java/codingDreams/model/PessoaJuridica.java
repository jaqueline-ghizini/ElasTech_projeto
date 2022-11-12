package codingDreams.model;

public class PessoaJuridica extends Cliente {
    private String cnpj;
    private String razaoSocial;

    public PessoaJuridica(){
        //construtor vazio pra teste, ao criar objeto utilizar set
    }
    public PessoaJuridica(Long idCliente, String email, String telefone, Endereco endereco, ContaBancaria contaBancaria, String cnpj, String razaoSocial) {
        super(idCliente, email, telefone, endereco, contaBancaria);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
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
        razaoSocial = razaoSocial;
    }

    public String consultarCliente(){ //ver como botar endereço nas pessoas
        return super.idCliente+"/"+super.email+"/"+super.telefone+"/"+super.endereco.toString()+"/"+super.contaBancaria.toString()+"/"+this.cnpj+"/"+this.razaoSocial;
    }
}

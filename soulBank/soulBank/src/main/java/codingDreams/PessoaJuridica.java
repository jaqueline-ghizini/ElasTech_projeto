package codingDreams;

public class PessoaJuridica extends Cliente {
    private String CNPJ;
    private String RazaoSocial;

    public PessoaJuridica(int IdCliente, String email, String telefone, String CNPJ, String razaoSocial) {
        super(IdCliente, email, telefone);
        this.CNPJ = CNPJ;
        RazaoSocial = razaoSocial;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        RazaoSocial = razaoSocial;
    }

    public String consultarCliente(){ //ver como botar endereço nas pessoas
        return super.IdCliente+"/"+super.email+"/"+super.telefone+"/"+this.CNPJ+"/"+this.RazaoSocial;
    }
}

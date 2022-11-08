package codingDreams;

public class PessoaFisica extends Cliente{
    private String CPF; //ver com a prof se fica automaticamente final
    private String RG;
    private String nome;

    public PessoaFisica(int IdCliente, String email, String telefone, String CPF, String RG, String nome) {
        super(IdCliente, email, telefone);
        this.CPF = CPF;
        this.RG = RG;
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String consultarCliente(){
        return super.IdCliente+"/"+super.email+"/"+super.telefone+"/"+this.CPF+"/"+this.RG+"/"+this.nome;
    }
}

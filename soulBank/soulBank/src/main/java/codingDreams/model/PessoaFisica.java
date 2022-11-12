package codingDreams.model;

public class PessoaFisica extends Cliente{
    private String cpf; //ver com a prof se fica automaticamente final
    private String rg;
    private String nome;

    public PessoaFisica(Long idCliente, String email, String telefone, Endereco endereco, ContaBancaria contaBancaria, String cpf, String rg, String nome) {
        super(idCliente, email, telefone, endereco, contaBancaria);
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String consultarCliente(){
        return super.idCliente+"/"+super.email+"/"+super.telefone+"/"+super.endereco.toString()+"/"+super.contaBancaria.toString()+"/"+this.cpf+"/"+this.rg+"/"+this.nome;
    }
}

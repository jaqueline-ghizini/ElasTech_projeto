package codingDreams.model;

public class Cliente {
    protected int idCliente; 
    protected String email;
    protected String telefone;
    protected Endereco endereco; //preferimos fazer em classe separada para ficar melhor estruturado//
    protected ContaBancaria contaBancaria;

    public Cliente(int idCliente, String email, String telefone, Endereco endereco, ContaBancaria contaBancaria) {
        super();
        this.idCliente = idCliente;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.contaBancaria = contaBancaria;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String consultarCliente(){
        return idCliente + "/" + email + "/" + telefone + "/" + endereco.toString()+ "/" + contaBancaria.toString();
    } 

    public void cadastrarCliente(){

    }

    public void alterarCliente(){

    }

   public void excluirCliente(){

    }
}

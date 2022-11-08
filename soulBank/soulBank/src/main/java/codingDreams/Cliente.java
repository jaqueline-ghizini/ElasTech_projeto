package codingDreams;

public class Cliente {
    protected int idCliente; //ver com camila sobre ser maiusculo, ou se o i fica minusculo
    protected String email;
    protected String telefone;
    //protected int idEndereco; //ver com camila

    public Cliente(int idCliente, String email, String telefone) {
        super();
        this.idCliente = idCliente;
        this.email = email;
        this.telefone = telefone;
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

    public String consultarCliente(Endereco endereco){
        return idCliente + "/" + email + "/" + telefone + "/" + endereco.getEnderecoCompleto() +", " + endereco.getComplemento() +", "+ endereco.getBairro()+", "+endereco.getCidade()+ ", "+ endereco.getEstado()+", "+ endereco.getCep();
    } //importa a classe endereco

    public void cadastrarCliente(){

    }

    public void alterarCliente(){

    }

   public void excluirCliente(){

    }
}

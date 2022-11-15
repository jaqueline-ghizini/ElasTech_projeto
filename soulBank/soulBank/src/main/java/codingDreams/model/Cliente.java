package codingDreams.model;

import javax.persistence.*;

@MappedSuperclass
public class Cliente {
    @Id
    @GeneratedValue
    protected Long idCliente;
    protected String email;
    protected String telefone;

    @OneToOne
    protected Endereco endereco; //preferimos fazer em classe separada para ficar melhor estruturado//

    @OneToOne
    protected ContaBancaria contaBancaria;

    public Cliente(){
        //construtor vazio pra teste, ao criar objeto utilizar set
    }

    //Inicialmente nós desclaramos o constructor, os gets e os sets, e posteriormente vimos que era possível fazer utilizando as anotações: @Getter,  @Setter e @NoArgsConstructor
    public Cliente(Long idCliente, String email, String telefone, Endereco endereco, ContaBancaria contaBancaria) {
        super();
        this.idCliente = idCliente;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.contaBancaria = contaBancaria;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
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

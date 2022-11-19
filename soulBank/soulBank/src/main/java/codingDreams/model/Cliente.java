package codingDreams.model;

import javax.persistence.*;

@MappedSuperclass
public class Cliente {//possibilidade de implementação relação n:n cliente e conta bancaria
    // não geramos id por ser uma superClasse, e toda consulta será nas classes filhas(entidades)
    @Column(unique=true)
    protected String email;
    @Column(unique=true)
    protected String telefone;
    protected boolean statusCliente;



    public Cliente(){
        //construtor vazio pra teste, ao criar objeto utilizar set
    }

    //Inicialmente nós desclaramos o constructor, os gets e os sets, e posteriormente vimos que era possível fazer utilizando as anotações: @Getter,  @Setter e @NoArgsConstructor
    public Cliente(String email, String telefone, boolean statusCliente) {
        super();
        //this.idCliente = idCliente;
        this.email = email;
        this.telefone = telefone;
        this.statusCliente = statusCliente;


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

    public boolean getStatusCliente() {
        return statusCliente;
    }

    public void setStatusCliente(boolean statusCliente) {
        this.statusCliente = statusCliente;
    }

    public String consultarCliente(){
        return  email + "/" + telefone + "/" + statusCliente;
    } 

}

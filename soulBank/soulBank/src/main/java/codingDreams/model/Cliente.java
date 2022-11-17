package codingDreams.model;

import javax.persistence.*;

@MappedSuperclass
public class Cliente {
    // não geramos id por ser uma superClasse, e toda consulta será nas classes filhas(entidades)
    protected String email;
    protected String telefone;



    public Cliente(){
        //construtor vazio pra teste, ao criar objeto utilizar set
    }

    //Inicialmente nós desclaramos o constructor, os gets e os sets, e posteriormente vimos que era possível fazer utilizando as anotações: @Getter,  @Setter e @NoArgsConstructor
    public Cliente(String email, String telefone) {
        super();
        //this.idCliente = idCliente;
        this.email = email;
        this.telefone = telefone;

    }

    //public Long getIdCliente() {
      //  return idCliente;
   // }

    //public void setIdCliente(Long idCliente) {
      //  this.idCliente = idCliente;
    //}

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
        return  email + "/" + telefone;
    } 

}

package codingDreams.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity

public class Transacao implements Serializable {

    @Id
    @GeneratedValue
    private Long idTransacao;
    private double valor;
    private int tipoTransacao;


    @ManyToOne @JoinColumn(name="idConta")
    private ContaBancaria contaOrigem, contaDestino; // como o relacionamento entre contaBancaria e transação é 2:N , sendo que contaBancaria realiza varias transações e transação recebe duas contas (Origem/Destino), decidimos importar objetos do tipo contaBancaria na transação

    public Transacao(){
        //construtor vazio pra teste, ao criar objeto utilizar set
    }
    public Transacao(Long idTransacao, double valor, int tipoTransacao, ContaBancaria contaOrigem, ContaBancaria contaDestino) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;

    }

    public Long getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Long idTransacao) {
        this.idTransacao = idTransacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(int tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public ContaBancaria getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(ContaBancaria contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public ContaBancaria getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(ContaBancaria contaDestino) {
        this.contaDestino = contaDestino;
    }


    @Override
    public String toString() {
		return this.idTransacao + "/" + this.valor + "/"  + this.tipoTransacao + "/" + contaOrigem.toString()+"/" + contaDestino.toString();

    }

    public void realizarTransferencia(){

    }

    public void realizarDeposito(){

    }

    public void realizarSaque(){

    }

}
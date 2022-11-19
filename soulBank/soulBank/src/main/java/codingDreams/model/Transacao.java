package codingDreams.model;

import javax.persistence.*;
import java.util.Date;

@Entity

public class Transacao{

    @Id
    @GeneratedValue
    private Long idTransacao;
    private double valor;
    private String tipoTransacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataTransacao;

    @ManyToOne @JoinColumn(name="idOrigem")
    private ContaBancaria contaOrigem; // como o relacionamento entre contaBancaria e transação é 2:N , sendo que contaBancaria realiza varias transações e transação recebe duas contas (Origem/Destino), decidimos importar objetos do tipo contaBancaria na transação

    @ManyToOne @JoinColumn(name="idDestino")
    private ContaBancaria  contaDestino;

    public Transacao(){
        //construtor vazio pra teste, ao criar objeto utilizar set
    }
    public Transacao(Long idTransacao, double valor, String tipoTransacao, Date dataTransacao, ContaBancaria contaOrigem, ContaBancaria contaDestino) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
        this.dataTransacao = dataTransacao;
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

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
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
		return this.idTransacao + "/" + this.valor + "/"  + this.tipoTransacao + "/" +this.dataTransacao+ "/" +contaOrigem.toString()+"/" + contaDestino.toString();
    }

}
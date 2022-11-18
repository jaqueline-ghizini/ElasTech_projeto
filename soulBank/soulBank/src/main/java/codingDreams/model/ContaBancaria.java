package codingDreams.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity

public class ContaBancaria  {

    @Id
    @GeneratedValue
    private Long idConta;

    private String conta;
    private String agencia;//botar como id tbm
    private double saldo;
    private double limite;

    private boolean chequeEspecial; // se for tipo false, não é conta especial, então o limite é zero. Se for tipo true, é especial e tem limite
    private String chavePix; // decidimos colocar essa opção por ser bem atual, prática e usada. Ele vai receber o dado (cpf/cnpj, telefone, email) juntamento com o cadastro do cliente.

    private boolean statusConta;
    @OneToMany (mappedBy="contaOrigem", targetEntity=Transacao.class)
    @JsonIgnore
    private List <Transacao> historicoOrigem;

    @OneToMany (mappedBy="contaDestino", targetEntity=Transacao.class)
    @JsonIgnore
    private List <Transacao> historicoDestino;// explicar pq não utlizamos ManyToMany



    public ContaBancaria(){
        //construtor vazio pra teste, ao criar objeto utilizar set
    }
    public ContaBancaria(Long idConta, String conta, String agencia, double saldo, double limite, boolean chequeEspecial, String chavePix, List historicoOrigem, List historicoDestino, boolean statusConta) {
        this.idConta = idConta;
        this.conta = conta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.limite = limite;
        this.chequeEspecial = chequeEspecial;
        this.chavePix = chavePix;
        this.historicoOrigem = historicoOrigem;
        this.historicoDestino= historicoDestino;
        this.statusConta = statusConta;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }
    
    public void setLimite(double limite) {
        this.limite = limite;
    }

    public boolean isChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(boolean chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    public List<Transacao> getHistoricoOrigem() {
        return historicoOrigem;
    }

    public void setHistoricoOrigem(List<Transacao> historicoOrigem) {
        this.historicoOrigem = historicoOrigem;
    }
    public List<Transacao> getHistoricoDestino() {
        return historicoDestino;
    }
    public void setHistoricoDestino(List<Transacao> historicoDestino) {
        this.historicoDestino = historicoDestino;
    }

    public boolean isStatusConta() {
        return statusConta;
    }

    public void setStatusConta(boolean statusConta) {
        this.statusConta = statusConta;
    }

    @Override
    public String toString() {
		return this.conta + "/" + this.agencia + "/" + this.saldo + "/" + this.limite + "/" + this.chequeEspecial + "/" + this.chavePix + "/" + this.statusConta;
    
    }


    public List<Transacao> consultarOrigem() { //checar cami
        return this.historicoOrigem; //vamos falar com a Cami
    }

    public List<Transacao> consultarDestino() { //checar cami
        return this.historicoDestino; //vamos falar com a Cami
    }

}
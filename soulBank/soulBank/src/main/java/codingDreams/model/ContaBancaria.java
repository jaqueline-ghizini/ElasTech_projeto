package codingDreams.model;

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
    private boolean tipoConta; // se for tipo false, não é conta especial, então o limite é zero. Se for tipo true, é especial e tem limite
    private String chavePix; // decidimos colocar essa opção por ser bem atual, prática e usada. Ele vai receber o dado (cpf/cnpj, telefone, email) juntamento com o cadastro do cliente.

    @OneToMany (mappedBy="contaOrigem", targetEntity=Transacao.class)
    private List <Transacao> historicoOrigem;

    @OneToMany (mappedBy="contaDestino", targetEntity=Transacao.class)
    private List <Transacao> historicoDestino;// explicar pq não utlizamos ManyToMany



    public ContaBancaria(){
        //construtor vazio pra teste, ao criar objeto utilizar set
    }
    public ContaBancaria(Long idConta, String conta, String agencia, double saldo, double limite, boolean tipoConta, String chavePix, List historicoOrigem, List historicoDestino) {
        this.idConta = idConta;
        this.conta = conta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.limite = limite;
        this.tipoConta = tipoConta;
        this.chavePix = chavePix;
        this.historicoOrigem = historicoOrigem;
        this.historicoDestino= historicoDestino;
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

    public boolean isTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(boolean tipoConta) {
        this.tipoConta = tipoConta;
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

    @Override
    public String toString() {
		return this.conta + "/" + this.agencia + "/" + this.saldo + "/" + this.limite + "/" + this.chavePix;
    
    }


    public List<Transacao> consultarOrigem() { //checar cami
        return this.historicoOrigem; //vamos falar com a Cami
    }

    public List<Transacao> consultarDestino() { //checar cami
        return this.historicoDestino; //vamos falar com a Cami
    }

}
package coding.dreams.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity

public class ContaBancaria  {

    @Id
    @GeneratedValue
    private Long idConta;
    //descidimos colocar como unique dados importantes que são unicos pra cada conta e também a chave
    //é possível fazer consulta por conta e agencia

    private String conta;
    private String agencia;
    private double saldo;
    private double limite;
    private boolean chequeEspecial; // se for tipo false, não é conta especial, então o limite é zero. Se for tipo true, é especial e tem limite
    @Column(unique=true)
    private String chavePix; // decidimos colocar essa opção por ser bem atual, prática e usada. Ele vai receber o dado (chave aleatória, cpf/cnpj, telefone, email) juntamento com o cadastro do cliente.
    private int tipoChavePix; //escolhemos usar o int pra informar a opção de dados de Pix. Sendo 1 - chave aleatória, 2 - cpf/cnpj, 3 - telefone e 4 - email
    private boolean statusConta;//pra verificar se está ativa ou inativa. Uma conta é desativada quando o cliente é desativado
    @OneToMany (mappedBy="contaOrigem", targetEntity=Transacao.class)
    @JsonIgnore
    private List <Transacao> historicoOrigem;

    @OneToMany (mappedBy="contaDestino", targetEntity=Transacao.class)
    @JsonIgnore
    private List <Transacao> historicoDestino;
    //Descidimos que uma maneira de criar um banco de dados claro e objetivo, seria utilizar a relação OneToMany e acrescentar dois campos de conta em transação.
    //Assim seria possóvel consultar o Histórico de Transação por conta, e registrar as contas envolvidas na transação.

    public ContaBancaria(){
        //construtor vazio pra teste, ao criar objeto utilizar set
    }
    public ContaBancaria(Long idConta, String conta, String agencia, double saldo, double limite, boolean chequeEspecial, String chavePix, int tipoChavePix, List historicoOrigem, List historicoDestino, boolean statusConta) {
        this.idConta = idConta;
        this.conta = conta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.limite = limite;
        this.chequeEspecial = chequeEspecial;
        this.chavePix = chavePix;
        this.tipoChavePix = tipoChavePix;
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

    public boolean getChequeEspecial() {
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

    public int getTipoChavePix() {
        return tipoChavePix;
    }

    public void setTipoChavePix(int tipoChavePix) {
        this.tipoChavePix = tipoChavePix;
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

    public boolean getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(boolean statusConta) {
        this.statusConta = statusConta;
    }

    @Override
    public String toString() {
		return this.conta + "/" + this.agencia + "/" + this.saldo + "/" + this.limite + "/" + this.chequeEspecial + "/" + this.chavePix + "/" + this.statusConta;
    }
}
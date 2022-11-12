package codingDreams.model;

public class ContaBancaria {
    private String conta;
    private String agencia;
    private double saldo;
    private double limite;
    private boolean tipoConta; // se for tipo false, não é conta especial, então o limite é zero. Se for tipo true, é especial e tem limite
    private String chavePix; // decidimos colocar essa opção por ser bem atual, prática e usada. Ele vai receber o dado (cpf/cnpj, telefone, email) juntamento com o cadastro do cliente.

// private list <transacao> historicoDeTransacao;

    public ContaBancaria(){
        //construtor vazio pra teste, ao criar objeto utilizar set
    }
    public ContaBancaria(String conta, String agencia, double saldo, double limite, boolean tipoConta, String chavePix) {
        this.conta = conta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.limite = limite;
        this.tipoConta = tipoConta;
        this.chavePix = chavePix;
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

    @Override
    public String toString() {
		return this.conta + "/" + this.agencia + "/" + this.saldo + "/" + this.limite;
    
    }


    public String consultarConta() {
        return this.toString(); //vamos falar com a Cami
    }

    public void cadastrarConta(){

    }    

    public void excluirConta(){

    }

    public double consultaSaldo(){
        return this.saldo;
    }

    public void alterarSaldo(){

    }
}
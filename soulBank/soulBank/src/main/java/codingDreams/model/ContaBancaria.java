package codingDreams.model;

public class ContaBancaria {
    
    private String conta;
    private String agencia;
    private double saldo;
    private double limite;

    public ContaBancaria(String conta, String agencia, double saldo, double limite) {
        this.conta = conta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.limite = limite;
        
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
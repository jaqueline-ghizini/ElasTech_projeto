package codingDreams.model;

public class Transacao {

    private int idTransacao;
    private double valor;
    private ContaBancaria contaOrigem, contaDestino; // como o relacionamento entre contaBancaria e transação é 2:N , sendo que contaBancaria realiza varias transações e transação recebe duas contas (Origem/Destino), decidimos importar objetos do tipo contaBancaria na transação

    public Transacao(int idTransacao, double valor, ContaBancaria contaOrigem, ContaBancaria contaDestino) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
    }

    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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
		return this.idTransacao + "/" + this.valor + "/" + contaOrigem.toString()+"/" + contaDestino.toString();

    }

    public void realizarTransferencia(){

    }

    public void realizarDeposito(){

    }

    public void realizarSaque(){

    }

    //public String consultarHistorico(){
       // return this.toString(); //puxar e exibir todos os registros de transações do banco
  //  }


}
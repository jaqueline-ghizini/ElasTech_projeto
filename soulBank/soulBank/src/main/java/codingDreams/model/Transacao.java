package codingDreams.model;

public class Transacao {

    private int idTransacao;
    private double valor;
    private ContaBancaria contaBancaria;

    public Transacao(int idTransacao, double valor, ContaBancaria contaBancaria) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.contaBancaria = contaBancaria;
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

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }


    @Override
    public String toString() {
		return this.idTransacao + "/" + this.valor + "/" + contaBancaria.toString();

    }

    public void realizarTransferencia(){

    }

    public void realizarDeposito(){

    }

    public void realizarSaque(){

    }

    public String consultarHistorico(){
        return this.toString(); //puxar e exibir todos os registros de transações do banco
    }


}
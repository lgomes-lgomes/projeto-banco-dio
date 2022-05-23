package contas;

import cliente.Cliente;

public abstract class Conta implements IConta{

    private static int AGENCIA_PADRAO = 1;
    private static int NUMERO_SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    Cliente cliente;

    Conta(Cliente cliente){
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = NUMERO_SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(IConta destino, double valor) { 
        this.sacar(valor);
        destino.depositar(valor);
    }

    protected String imprimirInfosComuns() {
        String aux = "Agência: "+ agencia + "\n";
        aux += "Número: "+ numero + "\n";
        aux += "Saldo: " + saldo + "\n";
        return aux;
    }

    
}

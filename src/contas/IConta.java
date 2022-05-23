package contas;

public interface IConta{
    public void sacar(double valor);

    public void depositar(double valor);

    public void transferir(IConta destino, double valor);

    public String imprimirExtrato();
}
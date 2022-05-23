package contas;

import cliente.Cliente;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public String imprimirExtrato() {
        String aux = "=== Extrato Conta Poupança === \n";
        aux += super.imprimirInfosComuns();
        return aux;
    }

}

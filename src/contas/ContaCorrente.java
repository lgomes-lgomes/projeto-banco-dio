package contas;

import cliente.Cliente;

public class ContaCorrente extends Conta{

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public String imprimirExtrato() {
        String aux = "=== Extrato Conta Corrente === \n";
        aux += super.imprimirInfosComuns();
        return aux;
    }
   
}

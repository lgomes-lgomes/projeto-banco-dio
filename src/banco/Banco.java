package banco;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

import java.util.LinkedList;
import java.util.List;

import cliente.Cliente;
import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;

public class Banco {
    private List<Conta> contas = new LinkedList<>();

    public void abrirMenu() {
        String menu = "1 - Criar conta \n";
        menu += "2 - Remover conta \n";
        menu += "3 - Pesquisar conta \n";
        menu += "4 - Listar contas \n";
        menu += "5 - Login usuario \n";
        menu += "6 - Finalizar \n";
        int escolha;

        do{
            do {
                escolha = parseInt(showInputDialog(menu));
            } while (escolha > 6 || escolha < 1);

            switch (escolha) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    removeConta();
                    break;
                case 3:
                    pesquisar();
                    break;
                case 4:
                    listarContas();
                    break;
                case 5:
                    loginUsuario();
                    break;
                case 6:
                    showMessageDialog(null, "Sessão finalizada!");
                    break;
            }
        }while(escolha != 6);
    }

    private void loginUsuario() {
        String cpf = showInputDialog("Informe seu CPF");

        if(pesquisarBool(cpf)){
            String menu = "1 - Sacar \n";
            menu += "2 - Depositar \n";
            menu += "3 - Transferir \n";
            menu += "4 - Checar dados \n";
            menu += "5 - Voltar \n";

            Conta conta = null;
            for (Conta c : contas) {
                if (c.getCliente().getCpf().equals(cpf)){
                    conta = c;
                }
            }
            int escolha = 0;

            do{
                escolha = parseInt(showInputDialog(menu));

                double valor = 0;

                switch(escolha){
                    case 1:
                        valor = parseDouble(showInputDialog("Informe o valor que deseja sacar"));
                        conta.sacar(valor);
                        break;
                    case 2:
                        valor = parseDouble(showInputDialog("Informe o valor que deseja depositar"));
                        conta.depositar(valor);
                        break;
                    case 3:
                        String cpfContaAlvo = showInputDialog("Informe o CPF do proprietário da conta que deseja tranferir");
                        
                        Conta contaAlvo = null;

                        boolean achou = false;
                        for (Conta c : contas) {
                            if (c.getCliente().getCpf().equals(cpfContaAlvo)) {
                                contaAlvo = c;
                                achou = true;
                                valor = parseDouble(showInputDialog("Informe o valor que deseja transferir"));
                            }
                        }

                        if(achou)
                            conta.transferir(contaAlvo, valor);
                        else
                            showMessageDialog(null, "A conta para a qual você deseja transferir não existe!!");

                        break;
                    case 4:
                        checharDados(conta);
                        break;
                    case 5:
                        break;
                }

            }while(escolha != 5);
        } else{
            showMessageDialog(null, "O usuário não existe!!");
        }
    }

    private void checharDados(Conta conta) {
        showMessageDialog(null, conta.imprimirExtrato() + conta.getCliente().getDados());
    }

    private void listarContas() {
        String aux = "";
        for(Conta conta : contas){
            aux += conta.imprimirExtrato() + "\n";
        }
        showMessageDialog(null, aux);
    }

    private void criarConta(){

        String nome = showInputDialog("Informe seu nome: ");
        String cpf = showInputDialog("Informe seu cpf");
        String sexo = showInputDialog("Informe seu sexo: ");
        Cliente cliente = new Cliente(nome, cpf, sexo);

        String menuTipoConta = "Selecione o tipo de conta \n";
        menuTipoConta += "1 - conta corrente \n";
        menuTipoConta += "2 - conta poupança \n";
        
        int escolha;
        do{
            escolha = parseInt(showInputDialog(menuTipoConta));
        }while(escolha > 2 || escolha < 1);

        switch(escolha){
            case 1:
                Conta cc = new ContaCorrente(cliente);

                if (pesquisarBool(cc.getCliente().getCpf()))
                    showMessageDialog(null, "A conta já existe!!");
                else
                    contas.add(cc);

                break;
            case 2:
                Conta cp = new ContaPoupanca(cliente);

                if (pesquisarBool(cp.getCliente().getCpf()))
                    showMessageDialog(null, "A conta já existe!!");
                else
                    contas.add(cp);

                break;
        }
    } 

    private boolean pesquisarBool(String cpf){
        
        boolean achou = false;
        
        for(Conta c : contas)
            if(c.getCliente().getCpf().equals(cpf))
                achou = true;

        return achou;
    }

    private void pesquisar(){

        String cpf = showInputDialog("Informe o CPF");
        Conta conta;
        boolean achou = false;

        for (Conta c : contas){
            if (c.getCliente().getCpf().equals(cpf)){
                conta = c;
                achou = true;
                showMessageDialog(null, conta.imprimirExtrato());
            }

            if(achou == true){
                break;
            } else{
                showMessageDialog(null, "Conta não encontrada");
            }
        }
    }

    private void removeConta(){
        String cpf = showInputDialog("Informe o CPF");

        if(pesquisarBool(cpf)){
            String escolha = showInputDialog("Deseja mesmo remover a conta do cliente com CPF " + cpf + "? (s/n)");
            if(escolha.equals("s")){
                contas.removeIf((conta) -> conta.getCliente().getCpf().equals(cpf));
            }else{
                showMessageDialog(null, "Remoção cancelada!");
            }
        }
    }
}

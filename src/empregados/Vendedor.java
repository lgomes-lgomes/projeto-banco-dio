package empregados;

public class Vendedor extends Empregado{

    private double comissao;

    public Vendedor(String nome, String cpf, String sexo, int matricula, double salario, double comissao) {
        super(nome, cpf, sexo, matricula, salario);
        this.comissao = comissao;
    }

    public String getDados() {
        String dados = "=== Informações do Vendedor === \n";
        dados += "Nome: " + super.nome + "\n";
        dados += "CPF: " + super.cpf + "\n";
        dados += "Sexo: " + super.sexo + "\n";
        dados += "Matrícula: " + super.matricula + "\n";
        dados += "Salário" + super.salario + "\n";
        dados += "Bonus: " + this.comissao + "\n";

        return dados;
    }
}

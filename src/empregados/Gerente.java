package empregados;

public class Gerente extends Empregado{

    private double bonus;

    public Gerente(String nome, String cpf, String sexo, int matricula, double salario, double bonus) {
        super(nome, cpf, sexo, matricula, salario);
        this.bonus = bonus;
    }

    public String getDados(){
        String dados = "=== Informações do Gerente === \n";
        dados += "Nome: " + super.nome + "\n";
        dados += "CPF: " + super.cpf + "\n";
        dados += "Sexo: " + super.sexo + "\n";
        dados += "Matrícula: " + super.matricula + "\n";
        dados += "Salário" + super.salario + "\n";
        dados += "Bonus: " + this.bonus + "\n";

        return dados;
    }
}

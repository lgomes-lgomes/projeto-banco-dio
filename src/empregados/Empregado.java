package empregados;

import lombok.Getter;
import lombok.Setter;
import pessoa.Pessoa;

@Getter
public class Empregado extends Pessoa{
    protected int matricula;
    @Setter protected double salario;


    public Empregado(String nome, String cpf, String sexo, int matricula, double salario) {
        super(nome, cpf, sexo);
        this.matricula = matricula;
        this.salario = salario;
    }
    
}

package cliente;

import pessoa.Pessoa;

public class Cliente extends Pessoa{

    public Cliente(String nome, String cpf, String sexo) {
        super(nome, cpf, sexo);
    }

    public String getDados() {
        String dados = "=== Informações do Cliente === \n";
        dados += "Nome: " + super.nome + "\n";
        dados += "CPF: " + super.cpf + "\n";
        dados += "Sexo: " + super.sexo + "\n";

        return dados;
    }
}

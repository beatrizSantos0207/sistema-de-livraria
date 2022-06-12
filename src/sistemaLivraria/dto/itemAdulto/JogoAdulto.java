package sistemaLivraria.dto.itemAdulto;

import sistemaLivraria.dto.item.Jogos;
import sistemaLivraria.enums.Rotulo;

public class JogoAdulto extends Jogos {

    private String rotulo;
    public JogoAdulto(String nome, double preco, String genero, String studio, String distribuidora) {
        super(nome, preco, genero, studio, distribuidora);
        this.rotulo = Rotulo.ROTULO_ADULTO.label;
    }

    public String getRotulo() {
        return rotulo;
    }

    @Override
    public String toString() {
        return "Jogos-> " + "Nome: " + nome + ", Id: " + id + ", Genero: " + getGenero() +
                ", Studio: " + getStudio() + ", Distribuidora: " + getDistribuidora() +
                ", Rotulo: " + rotulo + "\n";

    }
}

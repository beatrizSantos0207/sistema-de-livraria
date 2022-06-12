package sistemaLivraria.dto.itemAdulto;

import sistemaLivraria.dto.item.AlbunsMusicais;
import sistemaLivraria.enums.Rotulo;

import java.util.List;

public class AlbunsMusicaisAdulto extends AlbunsMusicais {
    private String rotulo;

    public AlbunsMusicaisAdulto(String nome, double preco, List<String> generos, List<String> selos, List<String> musicos) {
        super(nome, preco, generos, selos, musicos);
        this.rotulo = Rotulo.ROTULO_ADULTO.label;
    }

    public String getRotulo() {
        return rotulo;
    }

    @Override
    public String toString() {
        return "AlbunsMusicais-> " + "Nome: " + nome + ", Id: " + id + ", Generos: " + getGeneros() + ", Selos: " + getSelos() +
                ", Musicos: " + getMusicos() + ", Rótulo: " + rotulo + "\n";
    }

}


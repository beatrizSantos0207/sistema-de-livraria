package sistemaLivraria.dto.itemAdulto;

import sistemaLivraria.dto.item.Livros;
import sistemaLivraria.enums.Rotulo;

import java.util.List;

public class LivroAdulto extends Livros {
    private String rotulo;

    public LivroAdulto(String nome, double preco, String editora, List<String> generos, List<String> autores) {
        super(nome, preco, editora, generos, autores);
        this.rotulo = Rotulo.ROTULO_ADULTO.label;
    }

    public String getRotulo() {
        return rotulo;
    }

    @Override
    public String toString() {
        return "Livros-> " +"Nome: " + nome + ", Id: " + id + ", Editora: " + getEditora() +
                ", Generos: " + getGeneros() + ", Autores: " + getAutores() +
                ", Rotulo: " + rotulo + "\n";
    }
}

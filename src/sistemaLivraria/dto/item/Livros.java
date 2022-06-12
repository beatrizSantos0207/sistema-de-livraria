package sistemaLivraria.dto.item;

import lombok.Builder;
import sistemaLivraria.dto.Item;
import sistemaLivraria.interfaces.IArtisticos;

import java.util.List;

public class Livros extends Item implements IArtisticos {

    private String editora;
    private List<String> generos;
    private List<String> autores;


@Builder
    public Livros(String nome, double preco, String editora, List<String> generos, List<String> autores) {
        super(nome, preco);
        this.editora = editora;
        this.generos = generos;
        this.autores = autores;
    }

    @Override
    public List<String> getGeneros() {
        return generos;
    }

    public List<String> getAutores() {
        return autores;
    }

    public String getEditora() {
        return editora;
    }

    @Override
    public <T extends Item> void atualizarItem(T item) {
        if(item instanceof Livros livros) {
            this.nome = item.getNome();
            this.preco = item.getPreco();
            this.generos = livros.getGeneros();
            this.editora = livros.getEditora();
            this.autores = livros.getAutores();
        }
    }

    @Override
    public String toString() {
        return "Livros-> " +"Nome: " + nome + ", Id: " + id + ", Editora: " + editora +
                ", Generos: " + generos + ", Autores: " + autores + "\n";
    }
}

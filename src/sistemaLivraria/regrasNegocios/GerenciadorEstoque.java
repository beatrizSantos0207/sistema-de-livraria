package sistemaLivraria.regrasNegocios;

import sistemaLivraria.dto.Item;
import sistemaLivraria.dto.item.*;
import sistemaLivraria.enums.Categoria;
import sistemaLivraria.interfaces.IGerenciadorEstoque;

import java.util.ArrayList;
import java.util.List;
public class GerenciadorEstoque implements IGerenciadorEstoque {

    List<Item> itens = new ArrayList<>();

    public GerenciadorEstoque(List<Item> itens) {
        this.itens = itens;
    }

    public int quantificarEstoquePorCategoria(Categoria categoria) {
        List<Item> items = listarItensPorCategoria(categoria);
        return items.size();
    }

    public List<Item> listarEstoque(){
        return this.itens;
    }

    public List<Item> listarItensPorCategoria(Categoria categoria) {
        return this.itens.stream().filter(item -> isCategoriaOf(item, categoria)).toList();
    }

    private Boolean isCategoriaOf(Item item, Categoria categoria) {
        return switch (categoria) {
            case FILMES -> item instanceof Filmes;
            case JOGOS -> item instanceof Jogos;
            case ALBUNS_MUSICAIS -> item instanceof AlbunsMusicais;
            case BRINQUEDOS -> item instanceof Brinquedos;
            case LIVROS -> item instanceof Livros;
        };
    }
}

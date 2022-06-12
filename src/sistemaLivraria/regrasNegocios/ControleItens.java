package sistemaLivraria.regrasNegocios;

import lombok.Getter;
import sistemaLivraria.dto.Item;
import sistemaLivraria.dto.item.*;
import sistemaLivraria.enums.Categoria;
import sistemaLivraria.interfaces.IControleItens;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Getter
public class ControleItens implements IControleItens {
    private List<Item> itens = new ArrayList<>();

    @Override
    public Item mostrarItem(String id) {
        Item itemEncontrado = itens.stream().filter(item -> id.equals(item.getId())).findAny().orElse(null);
        if (itemEncontrado == null) {
            System.out.println("Produto inexistente.");
        }
        return itemEncontrado;
    }

    @Override
    public void adicionarProduto(Item novoItem) {
            itens.add(novoItem);
    }

    @Override
    public <T> void alterarItem(int index, T itemAlterado) {
        if(itemAlterado instanceof Item item){
            Item itemOriginal = itens.get(index);
            itemOriginal.atualizarItem(item);
        }
    }

    @Override
    public void removerItem(String id) {
        this.itens = this.itens.stream().filter(item ->
                        !id.equals(item.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public Categoria getCategoriaOfItem(Item item) {
        if (item instanceof Filmes) {
            return Categoria.FILMES;
        } else if (item instanceof Jogos) {
            return Categoria.JOGOS;
        } else if (item instanceof AlbunsMusicais) {
            return Categoria.ALBUNS_MUSICAIS;
        } else if (item instanceof Brinquedos) {
            return Categoria.BRINQUEDOS;
        } else if (item instanceof Livros) {
            return Categoria.LIVROS;
        }
        return null;
    }
}

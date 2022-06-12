package sistemaLivraria.regrasNegocios;

import sistemaLivraria.dto.Item;
import sistemaLivraria.interfaces.ICaixa;
import sistemaLivraria.interfaces.IControleItens;
import sistemaLivraria.interfaces.IGerenciadorEstoque;

import java.util.List;

public class Caixa implements ICaixa {

    IGerenciadorEstoque gerenciadorEstoque;
    IControleItens controleItens;
    double dinheiroCaixa;

    public Caixa(IGerenciadorEstoque gerenciadorEstoque, IControleItens controleItens) {
        this.gerenciadorEstoque = gerenciadorEstoque;
        this.controleItens = controleItens;
    }

    @Override
    public void realizarCompra(List<Item> compras) {
        compras.forEach(this::realizarCompraItem);
    }

    private void realizarCompraItem(Item item) {
        if (gerenciadorEstoque.quantificarEstoquePorCategoria(controleItens.getCategoriaOfItem(item)) != 0) {
            dinheiroCaixa += item.getPreco();
            controleItens.removerItem(item.getId());
        } else {
            System.out.println("Não foi possível realizar compra, estoque insuficiente!");

        }
    }

    @Override
    public double getCaixa() {
        return dinheiroCaixa;
    }
}
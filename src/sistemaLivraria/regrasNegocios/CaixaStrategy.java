package sistemaLivraria.regrasNegocios;

import sistemaLivraria.dto.Consumidor;
import sistemaLivraria.dto.Item;
import sistemaLivraria.dto.item.Livros;
import sistemaLivraria.interfaces.ICaixa;
import sistemaLivraria.interfaces.IControleItens;
import sistemaLivraria.interfaces.IGerenciadorEstoque;

import java.util.List;

public class CaixaStrategy implements ICaixa {

    public static final double DESCONTO_LIVROS_ACIMA_200 = 0.15;
    IGerenciadorEstoque gerenciadorEstoque;
    IControleItens controleItens;
    double dinheiroCaixa;

    public CaixaStrategy(IGerenciadorEstoque gerenciadorEstoque, IControleItens controleItens) {
        this.gerenciadorEstoque = gerenciadorEstoque;
        this.controleItens = controleItens;
    }

    @Override
    public double getCaixa() {
        return dinheiroCaixa;
    }

    @Override
    public void realizarCompra(List<Item> compras) {
        Caixa caixa = new Caixa(gerenciadorEstoque, controleItens);
        caixa.realizarCompra(compras);
        getDinheiroCaixaDesconto(caixa.getCaixa(), compras);
    }

    public void realizarCompra(List<Item> compras, Consumidor consumidor) {
        CaixaAdulto caixa = new CaixaAdulto(gerenciadorEstoque, controleItens);
        caixa.realizarCompra(compras, consumidor);
        getDinheiroCaixaDesconto(caixa.getCaixa(), compras);
    }

    private void getDinheiroCaixaDesconto(double caixa, List<Item> compras) {
        dinheiroCaixa = dinheiroCaixa + (caixa - getDescontoPorLivros(compras));
    }

    private double getDescontoPorLivros(List<Item> compras) {
        List<Item> items = compras.stream().filter(this::isLivro).toList();
        double totalValorLivros = items.stream().mapToDouble(Item::getPreco).sum();
        if (totalValorLivros >= 200) {
            return totalValorLivros * DESCONTO_LIVROS_ACIMA_200;
        }
        return 0;
    }

    private boolean isLivro(Item item) {
        return item instanceof Livros;
    }
}

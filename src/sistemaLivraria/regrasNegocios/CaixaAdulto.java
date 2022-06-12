package sistemaLivraria.regrasNegocios;

import sistemaLivraria.dto.Consumidor;
import sistemaLivraria.dto.Item;
import sistemaLivraria.interfaces.ICaixaAdulto;
import sistemaLivraria.interfaces.IControleItens;
import sistemaLivraria.interfaces.IGerenciadorEstoque;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class CaixaAdulto implements ICaixaAdulto {

    IGerenciadorEstoque gerenciadorEstoque;
    IControleItens controleItens;
    double dinheiroCaixa;

    public CaixaAdulto(IGerenciadorEstoque gerenciadorEstoque, IControleItens controleItens) {
        this.gerenciadorEstoque = gerenciadorEstoque;
        this.controleItens = controleItens;
    }

    @Override
    public double getCaixa() {
        return dinheiroCaixa;
    }

    @Override
    public void realizarCompra(List<Item> compras, Consumidor consumidor) {
        compras.forEach(item -> realizarCompraItemAdulto(item, consumidor));
    }

    private void realizarCompraItemAdulto(Item item, Consumidor consumidor) {
        if (isMaioridade(consumidor.getDataNascimento())) {
            if (gerenciadorEstoque.quantificarEstoquePorCategoria(controleItens.getCategoriaOfItem(item)) != 0) {
                dinheiroCaixa += item.getPreco();
                controleItens.removerItem(item.getId());
            } else {
                System.out.println("Não foi possível realizar compra, estoque insuficiente!");
            }
        } else {
            System.out.println("Necessário maioridade para realizar essa compra!");
        }
    }

    private boolean isMaioridade(LocalDate dataNascimento) {
        Period period = dataNascimento.until(LocalDate.now());
        return period.getYears() >= 18;
    }
}

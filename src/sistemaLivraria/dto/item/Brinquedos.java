package sistemaLivraria.dto.item;

import lombok.Builder;
import sistemaLivraria.dto.Item;

public class Brinquedos extends Item {
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Builder
    public Brinquedos(String nome, double preco, String tipo) {
        super(nome, preco);
        this.tipo = tipo;
    }

    @Override
    public <T extends Item> void atualizarItem(T item) {
        if(item instanceof Brinquedos brinquedos) {
            this.nome = item.getNome();
            this.preco = item.getPreco();
            this.tipo = brinquedos.getTipo();
        }
    }

    @Override
    public String toString() {
        return "Brinquedo-> "+  "Nome: "+ nome + ", Id: "+ id +
                ", Preço: " + preco +
                ", tipo: " + tipo +"\n";
    }
}

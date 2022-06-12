package sistemaLivraria.dto.itemAdulto;

import sistemaLivraria.dto.item.Brinquedos;
import sistemaLivraria.enums.Rotulo;

public class BrinquedoAdulto extends Brinquedos {
    private String rotulo;

    public BrinquedoAdulto(String nome, double preco, String tipo) {

        super(nome, preco, tipo);
        this.rotulo = Rotulo.ROTULO_ADULTO.label;

    }

    public String getRotulo() {
        return rotulo;
    }

    @Override
    public String toString() {
        return "BrinquedoAdulto -> " + "Nome: " + nome + ", Id: " + id +
                ", Tipo: " + getTipo() +
                ", Preço: " + preco +
                " Rotulo: " + rotulo +  "\n";
    }


}

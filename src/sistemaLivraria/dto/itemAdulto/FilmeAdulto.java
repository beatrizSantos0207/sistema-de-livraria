package sistemaLivraria.dto.itemAdulto;

import sistemaLivraria.dto.item.Filmes;
import sistemaLivraria.enums.Rotulo;

import java.util.List;

public class FilmeAdulto extends Filmes {
    private final String rotulo;

    public FilmeAdulto(String nome, double preco, List<String> generos, String studio, List<String> diretores, List<String> produtores) {
        super(nome, preco, generos, studio, diretores, produtores);
        this.rotulo = Rotulo.ROTULO_ADULTO.label;
    }

    public String getRotulo() {
        return rotulo;
    }


    @Override
    public String toString() {
        return "Filme-> " + "Nome: "+ nome + ", Id: "+ id + "Generos:" + getGeneros() + ", Studio:" + getStudio() +
                ", Diretores:" + getDiretores() + ", Produtores:" + getDiretores()+
                " Rotulo: " + rotulo + '\n';
    }

}
package sistemaLivraria.dto.item;

import lombok.Builder;
import sistemaLivraria.dto.Item;
import sistemaLivraria.interfaces.IArtisticos;

import java.util.List;

public class AlbunsMusicais extends Item implements IArtisticos {
    private List<String> generos;
    private List<String> selos;
    private List<String> musicos;

    @Builder
    public AlbunsMusicais(String nome, double preco, List<String> generos,
                          List<String> selos, List<String> musicos) {
        super(nome, preco);
        this.generos = generos;
        this.selos = selos;
        this.musicos = musicos;
    }

    @Override
    public List<String> getGeneros() {
        return generos;
    }

    public List<String> getSelos() {
        return selos;
    }

    public List<String> getMusicos() {
        return musicos;
    }

    @Override
    public String toString() {
        return "AlbunsMusicais-> " + "Nome: " + nome + ", Id: " + id + ", Generos: " + generos + ", Selos: " + selos +
                ", Musicos: " + musicos + "\n";
    }

    @Override
    public <T extends Item> void atualizarItem(T item) {
        if (item instanceof AlbunsMusicais albunsMusicais) {
            this.nome = item.getNome();
            this.preco = item.getPreco();
            this.generos = albunsMusicais.getGeneros();
            this.selos = albunsMusicais.getSelos();
            this.musicos = albunsMusicais.getMusicos();
        }
    }
}

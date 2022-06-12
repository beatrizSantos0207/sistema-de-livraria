package sistemaLivraria.dto.item;

import lombok.Builder;
import sistemaLivraria.dto.Item;
import sistemaLivraria.interfaces.IArtisticos;
import sistemaLivraria.interfaces.IAudiovisuais;

import java.util.List;

public class Filmes extends Item implements IArtisticos, IAudiovisuais {
    private List<String> generos;
    private String studio;
    private List<String> diretores;
    private List<String> produtores;

    @Builder
    public Filmes(String nome, double preco,
                  List<String> generos, String studio,
                  List<String> diretores, List<String> produtores) {

        super(nome, preco);
        this.generos = generos;
        this.studio = studio;
        this.diretores = diretores;
        this.produtores = produtores;
    }

    @Override
    public List<String> getGeneros() {
        return generos;
    }

    @Override
    public String getStudio() {
        return studio;
    }

    public List<String> getDiretores() {
        return diretores;
    }

    public List<String> getProdutores() {
        return produtores;
    }

    @Override
    public String toString() {
        return "Filme-> " + "Nome: "+ nome + ", Id: "+ id + "Generos:" + generos + ", Studio:" + studio +
                ", Diretores:" + diretores + ", Produtores:" + produtores + '\n';
    }

    @Override
    public <T extends Item> void atualizarItem(T item) {
        if(item instanceof Filmes filmes) {
            this.nome = item.getNome();
            this.preco = item.getPreco();
            this.generos = filmes.getGeneros();
            this.studio = filmes.getStudio();
            this.diretores = filmes.getDiretores();
            this.produtores = filmes.getProdutores();
        }
    }
}



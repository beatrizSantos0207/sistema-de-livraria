package sistemaLivraria.dto.item;

import lombok.Builder;
import sistemaLivraria.dto.Item;
import sistemaLivraria.interfaces.IAudiovisuais;

public class Jogos extends Item implements IAudiovisuais {
    private String genero;
    private String studio;
    private String distribuidora;


    public String getGenero() {
        return genero;
    }


    @Builder
    public Jogos(String nome, double preco, String genero, String studio, String distribuidora) {
        super(nome, preco);
        this.genero = genero;
        this.studio = studio;
        this.distribuidora = distribuidora;
    }

    @Override
    public String getStudio() {
        return studio;

    }
    public String getDistribuidora() {
        return distribuidora;
    }

    @Override
    public <T extends Item> void atualizarItem(T item) {
        if(item instanceof Jogos jogos) {
            this.nome = item.getNome();
            this.preco = item.getPreco();
            this.genero = jogos.getGenero();
            this.genero = jogos.getDistribuidora();
            this.genero = jogos.getStudio();
        }
    }

    @Override
    public String toString() {
        return "Jogos-> " + "Nome: " + nome + ", Id: " + id + ", Genero: " + genero +
                ", Studio: " + studio + ", Distribuidora: " + distribuidora + "\n";

    }
}

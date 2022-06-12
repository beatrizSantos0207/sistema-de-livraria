package sistemaLivraria.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import sistemaLivraria.interfaces.IItem;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
public abstract class Item implements IItem {
    public String nome;
    protected String id;

    private static Long idGenerator;
    public double preco;

    protected Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        id = UUID.randomUUID().toString();
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Item ->" + nome + ", id:" + id + ", valor:" + preco + '\n';
    }
}


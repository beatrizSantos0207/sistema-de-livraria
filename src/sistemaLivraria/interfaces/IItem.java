package sistemaLivraria.interfaces;

import sistemaLivraria.dto.Item;

public interface IItem {
     String getNome();
     void setNome(String nome);
     String getId();
     double getPreco();
     void setPreco(double preco);

     <T extends Item> void atualizarItem(T item);

}

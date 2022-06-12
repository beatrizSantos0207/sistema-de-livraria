package sistemaLivraria;

import lombok.RequiredArgsConstructor;
import sistemaLivraria.dto.*;
import sistemaLivraria.dto.item.*;
import sistemaLivraria.dto.itemAdulto.BrinquedoAdulto;
import sistemaLivraria.dto.itemAdulto.FilmeAdulto;
import sistemaLivraria.enums.Categoria;
import sistemaLivraria.regrasNegocios.*;

import java.util.Arrays;
import java.util.Collections;

@RequiredArgsConstructor
public class Teste {

    public static void main(String[] args) {


        Item filme = Filmes.builder().nome("Alien").preco(12.99).build();
        Item livro2 = Livros.builder().nome("O astro").preco(200.00).build();
        Item livro = Livros.builder().nome("Codigo limpo").preco(70.00).build();
        Item jogo = Jogos.builder().nome("Mortal Combate").genero("luta").build();
        Item cantor = AlbunsMusicais.builder().nome("Klb").preco(2.0).generos(Collections.singletonList("pop")).build();
        Item brinquedo = Brinquedos.builder().nome("Boneca").preco(500.00).tipo("ifantil").build();
        Item filmePorno = FilmeAdulto.builder().nome("Bruna Surfistinha").preco(12.99).build();




        ControleItens controladoriaProdutos = new ControleItens();
        controladoriaProdutos.adicionarProduto(filme);
        controladoriaProdutos.adicionarProduto(livro);
        controladoriaProdutos.adicionarProduto(jogo);
        controladoriaProdutos.adicionarProduto(cantor);
        controladoriaProdutos.adicionarProduto(brinquedo);
        controladoriaProdutos.adicionarProduto(livro2);
        controladoriaProdutos.adicionarProduto(filmePorno);


        controladoriaProdutos.mostrarItem(filme.getId());

        GerenciadorEstoque gereciadorEstoque = new GerenciadorEstoque(controladoriaProdutos.getItens());

        System.out.println(gereciadorEstoque.quantificarEstoquePorCategoria(Categoria.LIVROS));
        System.out.println(gereciadorEstoque.listarEstoque());
        System.out.println(brinquedo.toString());

        Consumidor consumidor = Consumidor.builder().nome("Robbert").cpf(3434343L).rg(24243L).dataNascimento("12/06/1997").build();

        CaixaStrategy caixa = new CaixaStrategy(gereciadorEstoque, controladoriaProdutos);
        caixa.realizarCompra(Arrays.asList(brinquedo, cantor));
        System.out.println("valor caixa " + caixa.getCaixa());
        caixa.realizarCompra(Collections.singletonList(livro2), consumidor);
        System.out.println("valor caixa " + caixa.getCaixa());



        CaixaStrategy caixaAdulto = new CaixaStrategy(gereciadorEstoque, controladoriaProdutos);
        caixaAdulto.realizarCompra(Collections.singletonList(livro2), consumidor);
        System.out.println("valor caixa " + caixaAdulto.getCaixa());





    }
}

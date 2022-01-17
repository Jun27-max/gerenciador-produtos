package model.controlador;

import java.util.Optional;

import model.buscar.Buscador;
import model.entities.Produto;

public class GerenciadorProduto {

	private Produto[] produtos;
	private int cont;
	private Buscador busca;

	public GerenciadorProduto(Buscador buscador) {
		produtos = new Produto[10];
		this.busca = buscador;
	}

	public void addProdutos(Produto produto) {
		Optional<Produto> prod = busca.buscar(aumentaEspaco(), produto.getCodigo());
		prod.ifPresentOrElse(this::exibirErro, () -> inserirProduto(produto));

	}
	
	private void exibirErro(Produto p) {
		System.out.println("Erro: produto encontrado");
	}
	
	private void inserirProduto(Produto p) {
		produtos[cont++] = p;
		System.out.println("Produto inserido");
		
	}

	public boolean venderProduto(int codigo, int quantidade) {
		Optional<Produto> prod = busca.buscar(aumentaEspaco(), codigo);
		boolean vendeu = prod.map(p -> p.vender(quantidade)).orElse(false);
		return vendeu;
		//return prod.filter( p-> p.vender(quantidade)).isPresent();
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < cont; i++) {
			Produto p = produtos[i];
			builder.append("Nome:").append(p.getNome()).append(" Estoque:").append(p.getUnidEstoque()).append("\n");
		}
		return builder.toString();
	}

	private Produto[] aumentaEspaco() {
		Produto[] nuevoArray = new Produto[cont];
		System.arraycopy(produtos, 0, nuevoArray, 0, cont);

		return nuevoArray;

	}

}
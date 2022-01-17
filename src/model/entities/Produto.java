package model.entities;

public class Produto {

	private int codigo;
	private String nome;
	private int unidEstoque;

	public Produto(int codigo, String nome, int unidEstoque) {
		this.codigo = codigo;
		this.nome = nome;
		this.unidEstoque = unidEstoque;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public int getUnidEstoque() {
		return unidEstoque;
	}

	public boolean vender(int quantidade) {
		if (unidEstoque >= quantidade) {
			unidEstoque -= quantidade;
			return true;
		}
		return false;
	}

}
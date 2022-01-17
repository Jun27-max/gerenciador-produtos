package model.buscar;

import java.util.Optional;

import model.entities.Produto;

public class FimInicio implements Buscador {

	@Override
	public Optional<Produto> buscar(Produto[] produtos, int cod) {
		Produto produto = null;
		for (int i = produtos.length - 1; i >= 0; i--) {
			Produto prod = produtos[i];
			if (produto.getCodigo() == cod) {
				produto = prod;
				return Optional.of(produto);
			}
		}
		return Optional.empty();
	}

}
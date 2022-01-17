package model.buscar;

import java.util.Optional;

import model.entities.Produto;

public class InicioFim implements Buscador {

	@Override
	public Optional<Produto> buscar(Produto[] produtos, int cod) {
		Produto produto = null;
		for(Produto prod: produtos) { 
			if (prod.getCodigo() == cod) {
				produto = prod;
				return Optional.of(produto);
			}
		}
		
		return Optional.empty();
	}

}
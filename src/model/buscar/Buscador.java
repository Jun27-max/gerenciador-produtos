package model.buscar;

import java.util.Optional;

import model.entities.Produto;

public interface Buscador {
	
	public abstract Optional<Produto> buscar (Produto[] produtos, int cod);


}

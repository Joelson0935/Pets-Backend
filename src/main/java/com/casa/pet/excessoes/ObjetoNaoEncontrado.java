package com.casa.pet.excessoes;

public class ObjetoNaoEncontrado extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjetoNaoEncontrado(String message) {
		super(message);
	}

}

package com.casa.pet.excessoes;

public class PetNaoEncontrado extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PetNaoEncontrado(String message) {
		super(message);
	}

}

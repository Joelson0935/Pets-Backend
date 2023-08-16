package com.casa.pet.excessoes;

import java.io.Serializable;

public class Campo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String erro;

	public Campo() {
		super();
	}

	public Campo(String nome, String erro) {
		super();
		this.nome = nome;
		this.erro = erro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

}

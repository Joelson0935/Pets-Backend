package com.casa.pet.modelos.dto;

import java.io.Serializable;

import com.casa.pet.modelos.enums.Sexo;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PetDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotNull(message = "Foto é obrigatória")
	private String foto;
	@Size(min = 2, max = 15, message = "mínimo {min} e máximo {max} caracteres")
	private String nome;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	@Size(min = 2, max = 15, message = "mínimo {min} e máximo {max} caracteres")
	private String cor;
	@Size(min = 2, max = 15, message = "mínimo {min} e máximo {max} caracteres")
	private String raca;

	public PetDTO() {
		super();
	}

	public PetDTO(Integer id, String foto, String nome, Sexo sexo, String cor, String raca) {
		super();
		this.id = id;
		this.foto = foto;
		this.nome = nome;
		this.sexo = sexo;
		this.cor = cor;
		this.raca = raca;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

}

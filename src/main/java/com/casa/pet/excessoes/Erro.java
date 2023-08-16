package com.casa.pet.excessoes;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Erro implements Serializable {

	private static final long serialVersionUID = 1L;

	private String erro;
	private Integer codigo;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;
	private String path;
	private List<Campo> campos = new ArrayList<>();

	public Erro() {
		super();
	}

	public Erro(String erro, Integer codigo, LocalDate data, String path) {
		super();
		this.erro = erro;
		this.codigo = codigo;
		this.data = data;
		this.path = path;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<Campo> getCampos() {
		return campos;
	}

	public void setCampos(String nome, String erro) {
		campos.add(new Campo(nome, erro));
	}

}

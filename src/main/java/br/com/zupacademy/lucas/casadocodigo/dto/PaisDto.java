package br.com.zupacademy.lucas.casadocodigo.dto;

import br.com.zupacademy.lucas.casadocodigo.model.Pais;

public class PaisDto {

	// Atributos
	private String nome;

	// Construtores
	@Deprecated
	public PaisDto() {
	}

	public PaisDto(Pais pais) {
		this.nome = pais.getNome();
	}

	// Getters
	public String getNome() {
		return nome;
	}
}

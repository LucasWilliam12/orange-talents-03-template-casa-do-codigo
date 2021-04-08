package br.com.zupacademy.lucas.casadocodigo.dto;

import br.com.zupacademy.lucas.casadocodigo.model.Estado;

public class EstadoDto {

	// Atributos
	private String nome;

	// Construtores
	@Deprecated
	public EstadoDto() {
	}

	public EstadoDto(Estado estado) {
		this.nome = estado.getNome();
	}

	// Getters
	public String getNome() {
		return nome;
	}
}

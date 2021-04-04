package br.com.zupacademy.lucas.casadocodigo.dto;

import br.com.zupacademy.lucas.casadocodigo.model.Categoria;

public class CategoriaDto {

	// Atributos
	private String nome;

	// Construtores
	public CategoriaDto() {
	}

	public CategoriaDto(Categoria cat) {
			this.nome = cat.getNome();
	}

	// Getters
	public String getNome() {
		return nome;
	}


}

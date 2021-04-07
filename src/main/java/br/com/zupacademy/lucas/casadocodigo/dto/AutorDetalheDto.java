package br.com.zupacademy.lucas.casadocodigo.dto;

import br.com.zupacademy.lucas.casadocodigo.model.Autor;

public class AutorDetalheDto {

	// Atributos
	private String nome;
	private String descricao;

	// Construtores
	@Deprecated
	public AutorDetalheDto() {
	}

	public AutorDetalheDto(Autor autor) {
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
	}

	// Getters
	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
}

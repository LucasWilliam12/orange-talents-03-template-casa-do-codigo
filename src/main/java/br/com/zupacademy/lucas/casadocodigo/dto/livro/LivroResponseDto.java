package br.com.zupacademy.lucas.casadocodigo.dto.livro;

import br.com.zupacademy.lucas.casadocodigo.model.Livro;

public class LivroResponseDto {
	
	// Atributos
	private Long id;
	private String titulo;
	
	// Construtor
	public LivroResponseDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	// Getters
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
	
}

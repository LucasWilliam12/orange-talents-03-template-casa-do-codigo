package br.com.zupacademy.lucas.casadocodigo.dto.autor;

import br.com.zupacademy.lucas.casadocodigo.model.Autor;

public class AutorDto {

	// Atributos
	private String nome;
	private String email;
	private String descricao;
	
	// Construtor 
	public AutorDto(Autor autor) {
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
	}

	// Getters
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getDescricao() {
		return descricao;
	}
	
}

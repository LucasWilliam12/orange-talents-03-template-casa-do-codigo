package br.com.zupacademy.lucas.casadocodigo.form;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.lucas.casadocodigo.controllers.validations.NomeExistsValidator;
import br.com.zupacademy.lucas.casadocodigo.model.Categoria;

public class CategoriaForm {
	
	// Atributos
	@NotBlank(message = "O nome não pode ser vazio.")
	@NomeExistsValidator
	private String nome;

	// Construtores
	public CategoriaForm() {
	}

	public CategoriaForm(@NotBlank(message = "O nome não pode ser vazio.") @NomeExistsValidator String nome) {
		this.nome = nome;
	}

	// Getters
	public String getNome() {
		return nome;
	}
	
	// Métodos auxiliares
	public Categoria toModel() {
		return new Categoria(this.nome);
	}
	
}

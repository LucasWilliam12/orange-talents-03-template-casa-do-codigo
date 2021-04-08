package br.com.zupacademy.lucas.casadocodigo.form;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.lucas.casadocodigo.controllers.validations.UniqueData;
import br.com.zupacademy.lucas.casadocodigo.model.Pais;

public class PaisForm {
	
	// Atributos
	@NotBlank(message = "O nome não pode ser vazio")
	@UniqueData(domainClass = Pais.class, fildName = "nome", message = "Nome já cadastrado")
	private String nome;
	
	// Construtores
	@Deprecated
	public PaisForm() {
	}
	
	public PaisForm(@NotBlank(message = "O nome não pode ser vazio") String nome) {
		this.nome = nome;
	}

	// Getters
	public String getNome() {
		return nome;
	}
	
	// Métodos auxiliares
	public Pais toModel() {
		return new Pais(this.nome);
	}

}

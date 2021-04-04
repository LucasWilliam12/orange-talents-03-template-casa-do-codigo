package br.com.zupacademy.lucas.casadocodigo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.lucas.casadocodigo.controllers.validations.EmailExistsValidator;
import br.com.zupacademy.lucas.casadocodigo.model.Autor;

public class AutorForm {
	
	// Atributos
	@NotBlank(message = "O nome não pode ser vazio")
	private String nome;
	@NotBlank(message = "O email não pode ser vazio")
	@Email(message = "Digite um email valido")
	@EmailExistsValidator
	private String email;
	@NotBlank(message = "A descriçao não pode ser vazio")
	@Size(max = 400, message = "A descrição tem que ter no máximo 400 caracteres")
	private String descricao;
	
	// Construtores
	public AutorForm(@NotBlank(message = "O nome não pode ser vazio") String nome,
			@NotBlank(message = "O email não pode ser vazio") @Email(message = "Digite um email valido") String email,
			@NotBlank(message = "A descriçao não pode ser vazio") @Size(max = 400, message = "A descrição tem que ter no máximo 400 caracteres") String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
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

	// Metodos auxiliares
	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}
	
	
}

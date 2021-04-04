package br.com.zupacademy.lucas.casadocodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.lucas.casadocodigo.controllers.validations.NomeExistsValidator;

@Entity
@Table(name = "categorias")
public class Categoria {
	
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "O nome não pode ser vazio.")
	@Column(unique = true, nullable = false)
	private String nome;
	
	
	// Construtores
	public Categoria() {
		
	}

	public Categoria(@NotBlank(message = "O nome não pode ser vazio.") @NomeExistsValidator String nome) {
		this.nome = nome;
	}
	
	// Getters
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
		
}

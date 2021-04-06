package br.com.zupacademy.lucas.casadocodigo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.zupacademy.lucas.casadocodigo.controllers.validations.UniqueData;

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
	
	@JsonIgnore
	@OneToMany(mappedBy = "categoria")
	List<Livro> livros = new ArrayList<>();
	
	// Construtores
	public Categoria() {
		
	}

	public Categoria(@NotBlank(message = "O nome não pode ser vazio.") @UniqueData(domainClass = Categoria.class, fildName = "nome", message="Nome já cadastrado.") String nome) {
		this.nome = nome;
	}
	
	// Getters
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
		
	// Setter
	public void addLivro(Livro livro) {
		this.livros.add(livro);
	}
}

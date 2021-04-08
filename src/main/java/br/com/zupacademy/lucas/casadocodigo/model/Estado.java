package br.com.zupacademy.lucas.casadocodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "estados")
public class Estado {
	
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	@NotBlank(message = "O nome não pode ser vazio")
	private String nome;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "pais_id")
	private Pais pais;
	
	// Construtores
	@Deprecated
	public Estado() {
	}
	
	public Estado(@NotBlank(message = "O nome não pode ser vazio") String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

	// Getters
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}

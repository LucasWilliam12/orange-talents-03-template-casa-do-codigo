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

@Entity
@Table(name = "paises")
public class Pais {
	
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	@NotBlank(message = "O nome não pode ser vazio")
	private String nome;
	
	@OneToMany(mappedBy = "pais")
	private List<Estado> estados = new ArrayList<>();
	
	// Construtores
	@Deprecated
	public Pais() {
	}
	
	public Pais(@NotBlank(message = "O nome não pode ser vazio") String nome) {
		this.nome = nome;
	}

	// Getters
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public void addEstado(Estado estado) {
		this.estados.add(estado);
	}
	
}

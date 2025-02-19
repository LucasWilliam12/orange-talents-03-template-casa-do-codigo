package br.com.zupacademy.lucas.casadocodigo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.zupacademy.lucas.casadocodigo.controllers.validations.UniqueData;

@Entity
@Table(name = "autores")
public class Autor {
	
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "O nome não pode ser vazio")
	private String nome;
	@NotBlank(message = "O email não pode ser vazio")
	@Email(message = "Digite um email valido")
	@Column(unique = true)
	private String email;
	@NotBlank(message = "A descriçao não pode ser vazio")
	@Size(max = 400, message = "A descrição tem que ter no máximo 400 caracteres")
	private String descricao;
	private LocalDate instante = LocalDate.now();
	
	@JsonIgnore
	@OneToMany(mappedBy = "autor")
	List<Livro> livros = new ArrayList<>();
	
	// Construtores e sobrecargas
	public Autor() {
	}

	public Autor(@NotBlank String nome, @NotBlank @Email @UniqueData(domainClass = Autor.class, fildName = "email", message="Email já cadastrado.") String email,@NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	// Getters
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDate getInstante() {
		return instante;
	}
	
	
	// Setters
	public void addLivro(Livro livro) {
		this.livros.add(livro);
	}
}

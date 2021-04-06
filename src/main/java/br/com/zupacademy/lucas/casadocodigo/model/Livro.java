package br.com.zupacademy.lucas.casadocodigo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.lucas.casadocodigo.controllers.validations.UniqueData;

@Entity
@Table(name = "livros")
public class Livro {
	
	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "O titulo não pode ser vazio")
	@Column(unique = true)
	private String titulo;
	@NotBlank(message = "O resumo não pode ser vazio")
	@Length(max = 500, message = "O titulo tem que ter no máximo 500 caracteres")
	private String resumo;
	@NotNull(message = "O preço não pode ser vazio")
	@DecimalMin(value = "20.0", message = "O preço tem que ser maior que R$ 20.00")
	private Double preco;
	@NotNull(message = "O preço não pode ser vazio")
	@Min(value = 100, message = "As páginas tem que ser maior que 100")
	private Integer paginas;
	@NotBlank(message = "O ISBN não pode ser vazio")
	@Column(unique = true)
	private String isbn;
	@Future(message = "A data de publicação tem que ser no futuro")
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate publicacao;

	@NotNull(message = "O autor não pode ser vazia")
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;
	@NotNull(message = "A categoria não pode ser vazia")
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	// Construtores
	public Livro() {
	}

	public Livro(@NotBlank(message = "O titulo não pode ser vazio") @UniqueData(domainClass = Livro.class, fildName = "titulo", message="Titulo já cadastrado.") String titulo,
			@NotBlank(message = "O resumo não pode ser vazio") @Length(max = 500, message = "O titulo tem que ter no máximo 500 caracteres") String resumo,
			@NotNull(message = "O preço não pode ser vazio") @DecimalMin(value = "20.0", message = "O preço tem que ser maior que R$ 20.00") Double preco,
			@NotNull(message = "O preço não pode ser vazio") @Min(value = 100, message = "As páginas tem que ser maior que 100") Integer paginas,
			@NotBlank(message = "O ISBN não pode ser vazio") @UniqueData(domainClass = Livro.class, fildName = "isbn", message="ISBN já cadastrado.") String isbn,
			@Future(message = "A data de publicação tem que ser no futuro") LocalDate publicacao, @NotNull(message = "O autor não pode ser vazio") Autor autor,
			@NotNull(message = "A categoria não pode ser vazia") Categoria categoria) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.publicacao = publicacao;
		this.autor = autor;
		this.categoria = categoria;
	}



	// Getters
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public Double getPreco() {
		return preco;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getPublicacao() {
		return publicacao;
	}

	public Autor getAutor() {
		return autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
}

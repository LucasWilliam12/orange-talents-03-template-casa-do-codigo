package br.com.zupacademy.lucas.casadocodigo.form;

import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.lucas.casadocodigo.controllers.exceptions.NotFoundException;
import br.com.zupacademy.lucas.casadocodigo.controllers.validations.UniqueData;
import br.com.zupacademy.lucas.casadocodigo.model.Autor;
import br.com.zupacademy.lucas.casadocodigo.model.Categoria;
import br.com.zupacademy.lucas.casadocodigo.model.Livro;
import br.com.zupacademy.lucas.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.lucas.casadocodigo.repository.CategoriaRepository;

public class LivroForm {
	
	// Atributos
	@NotBlank(message = "O titulo não pode ser vazio")
	@UniqueData(domainClass = Livro.class, fildName = "titulo", message = "Titulo já cadastrado.")
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
	@UniqueData(domainClass = Livro.class, fildName = "isbn", message = "ISBN já cadastrado.")
	private String isbn;
	@Future(message = "A data de publicação tem que ser no futuro")
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate publicacao;
	@NotNull(message = "O autor não pode ser vazio")
	private Long idAutor;
	@NotNull(message = "A categoria não pode ser vazia")
	private Long idCategoria;
	
	// Construtores
	public LivroForm(@NotBlank(message = "O titulo não pode ser vazio") String titulo,
			@NotBlank(message = "O resumo não pode ser vazio") @Length(max = 500, message = "O titulo tem que ter no máximo 500 caracteres") String resumo,
			@NotNull(message = "O preço não pode ser vazio") @DecimalMin(value = "20.0", message = "O preço tem que ser maior que R$ 20.00") Double preco,
			@NotNull(message = "O preço não pode ser vazio") @Min(value = 100, message = "As páginas tem que ser maior que 100") Integer paginas,
			@NotBlank(message = "O ISBN não pode ser vazio") String isbn,
			@NotNull(message = "O autor não pode ser vazio") Long idAutor,
			@NotNull(message = "A categoria não pode ser vazia") Long idCategoria) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.idAutor = idAutor;
		this.idCategoria = idCategoria;
	}
	
	// Getters
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

	public Long getIdAutor() {
		return idAutor;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}
	
	public void setPublicacao(LocalDate publicacao) {
		this.publicacao = publicacao;
	}

	// Metodos Auxiliares
	public Livro toModel(CategoriaRepository categoriaRepo, AutorRepository autorRepo) {
		
		Categoria categoria = categoriaRepo.findById(this.idCategoria)
				.orElseThrow(() -> new NotFoundException("Categoria informada não encontrada!"));
		
		Autor autor = autorRepo.findById(this.idAutor)
				.orElseThrow(() -> new NotFoundException("Autor informado não encontrado!"));
		
		Livro livro = new Livro(this.titulo, this.resumo, this.preco, this.paginas, this.isbn, this.publicacao, autor, categoria);
		
		categoria.addLivro(livro);
		autor.addLivro(livro);
		
		return livro;
	}
}

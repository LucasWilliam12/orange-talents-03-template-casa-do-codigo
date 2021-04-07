package br.com.zupacademy.lucas.casadocodigo.dto;

import java.time.LocalDate;

import br.com.zupacademy.lucas.casadocodigo.model.Livro;

public class LivroDetalhadoDto {

	// Atributos
	private String titulo;
	private String resumo;
	private Double preco;
	private Integer paginas;
	private String isbn;
	private LocalDate publicacao;
	private AutorDetalheDto autorDetalheDto;
	private CategoriaDto categoriaDto;

	@Deprecated
	public LivroDetalhadoDto() {
	}

	public LivroDetalhadoDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.preco = livro.getPreco();
		this.paginas = livro.getPaginas();
		this.isbn = livro.getIsbn();
		this.publicacao = livro.getPublicacao();
		this.autorDetalheDto = new AutorDetalheDto(livro.getAutor());
		this.categoriaDto = new CategoriaDto(livro.getCategoria());
	}

	// getters
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

	public AutorDetalheDto getAutorDetalheDto() {
		return autorDetalheDto;
	}

	public CategoriaDto getCategoriaDto() {
		return categoriaDto;
	}
	
}

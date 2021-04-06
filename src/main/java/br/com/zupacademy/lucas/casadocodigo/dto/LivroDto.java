package br.com.zupacademy.lucas.casadocodigo.dto;

import java.time.LocalDate;

import br.com.zupacademy.lucas.casadocodigo.model.Livro;

public class LivroDto {
	// Atributos
	private String titulo;
	private String resumo;
	private Double preco;
	private Integer paginas;
	private String isbn;
	private LocalDate publicacao;
	private AutorDto autorDto;
	private CategoriaDto categoriaDto;
	
	// Construtures
	public LivroDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.preco = livro.getPreco();
		this.paginas = livro.getPaginas();
		this.isbn = livro.getIsbn();
		this.publicacao = livro.getPublicacao();
		this.autorDto = new AutorDto(livro.getAutor());
		this.categoriaDto = new CategoriaDto(livro.getCategoria());
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

	public AutorDto getAutorDto() {
		return autorDto;
	}

	public CategoriaDto getCategoriaDto() {
		return categoriaDto;
	}
	
}

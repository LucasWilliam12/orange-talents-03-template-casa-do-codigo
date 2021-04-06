package br.com.zupacademy.lucas.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import br.com.zupacademy.lucas.casadocodigo.controllers.exceptions.NotFoundException;
import br.com.zupacademy.lucas.casadocodigo.dto.LivroDto;
import br.com.zupacademy.lucas.casadocodigo.form.LivroForm;
import br.com.zupacademy.lucas.casadocodigo.model.Autor;
import br.com.zupacademy.lucas.casadocodigo.model.Categoria;
import br.com.zupacademy.lucas.casadocodigo.model.Livro;
import br.com.zupacademy.lucas.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.lucas.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.lucas.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {
	
	// Repositories
	@Autowired
	private LivroRepository livroRepo;
	@Autowired
	private AutorRepository autorRepo;
	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@PostMapping
	public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid LivroForm form){
		Categoria categoria = categoriaRepo.findById(form.getIdCategoria()).orElseThrow(() -> new NotFoundException("Nenhuma categoria encontrada!"));
		Autor autor = autorRepo.findById(form.getIdCategoria()).orElseThrow(() -> new NotFoundException("Nenhum autor encontrado!"));
		
		Livro livro = livroRepo.save(form.toModel(form, categoria, autor));
		autorRepo.save(autor);
		categoriaRepo.save(categoria);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).body(new LivroDto(livro));
	}
	
}

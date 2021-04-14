package br.com.zupacademy.lucas.casadocodigo.controllers.livro;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zupacademy.lucas.casadocodigo.dto.livro.LivroDto;
import br.com.zupacademy.lucas.casadocodigo.form.LivroForm;
import br.com.zupacademy.lucas.casadocodigo.model.Livro;
import br.com.zupacademy.lucas.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.lucas.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.lucas.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping(value = "livros")
// Carga intrínseca = 6
// Controller 100% coeso
public class CadastrarLivroController {

	// Repositories
	@Autowired
	private LivroRepository livroRepo;
	@Autowired
	private AutorRepository autorRepo;
	@Autowired
	private CategoriaRepository categoriaRepo;

	@PostMapping
	// 1 - LivroDto
	// 2 - LivroForm
	// 3 - Livro
	// 4 - ServletUriComponentsBuilder
	// 5 - AutorRepository
	// 6 - CategoriaRepository
	// total carga intrínseca = 6
	public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid LivroForm form) {

		Livro livro = livroRepo.save(form.toModel(categoriaRepo, autorRepo));

		autorRepo.save(livro.getAutor());
		categoriaRepo.save(livro.getCategoria());

		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(livro.getId())
				.toUri();
		return ResponseEntity.created(uri).body(new LivroDto(livro));
	}

}

package br.com.zupacademy.lucas.casadocodigo.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zupacademy.lucas.casadocodigo.dto.autor.AutorDto;
import br.com.zupacademy.lucas.casadocodigo.form.AutorForm;
import br.com.zupacademy.lucas.casadocodigo.model.Autor;
import br.com.zupacademy.lucas.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping(value = "/autores")
// carga intrínseca = 4
// Controller 100% coeso
public class AutorController {

	// Repositories
	@Autowired
	private AutorRepository repo;
	
	// EndPoints
	@PostMapping
	// 1 - AutorDto
	// 2 - AutorForm
	// 3 - Autor
	// 4 - ServletUriComponentsBuilder
	// total carga intrínseca = 4
	public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm form){

		Autor autor = repo.save(form.toModel());

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autor.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new AutorDto(autor));
	}
	
}

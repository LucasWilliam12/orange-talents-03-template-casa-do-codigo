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

import br.com.zupacademy.lucas.casadocodigo.dto.PaisDto;
import br.com.zupacademy.lucas.casadocodigo.form.PaisForm;
import br.com.zupacademy.lucas.casadocodigo.model.Pais;
import br.com.zupacademy.lucas.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping(value = "/paises")
// Carga Intrínseca = 4
// Controller 100% coeso
public class PaisController {

	@Autowired
	private PaisRepository repo;

	@PostMapping
	// 1 - PaisDto
	// 2 - PaisForm
	// 3 - Pais
	// 4 - ServletUriComponentsBuilder
	// total carga intrínseca = 4
	public ResponseEntity<PaisDto> cadastrar(@RequestBody @Valid PaisForm form) {
		Pais pais = repo.save(form.toModel());

		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(pais.getId())
				.toUri();

		return ResponseEntity.created(uri).body(new PaisDto(pais));
	}

}

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

import br.com.zupacademy.lucas.casadocodigo.dto.CategoriaDto;
import br.com.zupacademy.lucas.casadocodigo.form.CategoriaForm;
import br.com.zupacademy.lucas.casadocodigo.model.Categoria;
import br.com.zupacademy.lucas.casadocodigo.repository.CategoriaRepository;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repo;
	
	@PostMapping
	public ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid CategoriaForm form){
		Categoria cat = repo.save(form.toModel());
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(cat.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new CategoriaDto(cat));
	}
}

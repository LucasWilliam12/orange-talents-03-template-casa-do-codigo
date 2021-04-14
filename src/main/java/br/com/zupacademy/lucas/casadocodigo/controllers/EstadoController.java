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

import br.com.zupacademy.lucas.casadocodigo.controllers.exceptions.ObjectExistsException;
import br.com.zupacademy.lucas.casadocodigo.dto.EstadoDto;
import br.com.zupacademy.lucas.casadocodigo.form.EstadoForm;
import br.com.zupacademy.lucas.casadocodigo.model.Estado;
import br.com.zupacademy.lucas.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.lucas.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping(value = "/estados")
// carga intrínseca = 5
// Controller 100% coeso
public class EstadoController {

	// Repositories
	@Autowired
	private PaisRepository paisRepo;
	@Autowired
	private EstadoRepository estadoRepo;

	@PostMapping
	// 1 - EstadoDto
	// 2 - EstadoForm
	// 3 - Estado
	// 4 - ServletUriComponentsBuilder
	// 5 - PaisRepository
	// 6 - If/else
	// total carga intrínseca = 5
	public ResponseEntity<EstadoDto> cadastrar(@RequestBody @Valid EstadoForm form) {

		if (!paisRepo.findByEstadosNome(form.getNome(), form.getIdPais()).isEmpty()) {
			throw new ObjectExistsException("O país informado já possui um estado com o mesmo nome");
		} else {

			Estado estado = estadoRepo.save(form.toModel(paisRepo));

			paisRepo.save(estado.getPais());

			URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(estado.getId())
					.toUri();

			return ResponseEntity.created(uri).body(new EstadoDto(estado));
		}

	}
}

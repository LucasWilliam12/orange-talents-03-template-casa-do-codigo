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

import br.com.zupacademy.lucas.casadocodigo.controllers.exceptions.NotFoundException;
import br.com.zupacademy.lucas.casadocodigo.dto.ClienteDto;
import br.com.zupacademy.lucas.casadocodigo.form.ClienteForm;
import br.com.zupacademy.lucas.casadocodigo.model.Cliente;
import br.com.zupacademy.lucas.casadocodigo.model.Estado;
import br.com.zupacademy.lucas.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.lucas.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.lucas.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepo;

	@Autowired
	private PaisRepository paisRepo;

	@Autowired
	private EstadoRepository estadoRepo;

	// 1 - PaisRepository
	// 2 - EstadoRepository
	// 3 - ServletUriComponentsBuilder
	// 4 - ClienteForm
	// 5 - ClienteDto
	// 6 - Estado
	// 7 - Cliente
	// total carga intrínseca = 7
	@PostMapping
	public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteForm form) {

		Estado estado = null;

		if (form.getIdEstado() != null) {
			estado = estadoRepo.findById(form.getIdEstado())
					.orElseThrow(() -> new NotFoundException("Estado não encontrado"));
		}
		
		Cliente cliente = form.toModel(paisRepo, estado);
		cliente = clienteRepo.save(cliente);

		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(cliente.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));

	}

}

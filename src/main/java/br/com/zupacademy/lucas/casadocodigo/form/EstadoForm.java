package br.com.zupacademy.lucas.casadocodigo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.lucas.casadocodigo.controllers.exceptions.NotFoundException;
import br.com.zupacademy.lucas.casadocodigo.model.Estado;
import br.com.zupacademy.lucas.casadocodigo.model.Pais;
import br.com.zupacademy.lucas.casadocodigo.repository.PaisRepository;

public class EstadoForm {
	
	// Atributos
	@NotBlank(message = "O nome não pode ser vazio")
	private String nome;
	@NotNull(message = "O pais não pode ser vazio")
	private Long idPais;
	
	// Construtores
	@Deprecated
	public EstadoForm() {
	}
	
	
	public EstadoForm(@NotBlank(message = "O nome não pode ser vazio") String nome,
			@NotNull(message = "O pais não pode ser vazio") Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}


	// Getters
	public String getNome() {
		return nome;
	}
	
	public Long getIdPais() {
		return idPais;
	}

	// Métodos auxiliares
	public Estado toModel(PaisRepository paisRepository) {
		
		Pais pais = paisRepository.findById(this.idPais).orElseThrow(() -> new NotFoundException("O país com o id informado não foi encontrado"));
		
		Estado estado = new Estado(this.nome, pais);
		pais.addEstado(estado);
		
		return estado;
	}

}

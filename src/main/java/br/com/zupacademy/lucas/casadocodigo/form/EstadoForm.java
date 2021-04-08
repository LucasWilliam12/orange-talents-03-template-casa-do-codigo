package br.com.zupacademy.lucas.casadocodigo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.lucas.casadocodigo.model.Estado;
import br.com.zupacademy.lucas.casadocodigo.model.Pais;

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
	public Estado toModel(Pais pais) {
		Estado estado = new Estado(this.nome, pais);
		pais.addEstado(estado);
		return estado;
	}

}

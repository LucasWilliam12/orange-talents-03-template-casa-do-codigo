package br.com.zupacademy.lucas.casadocodigo.dto;

import br.com.zupacademy.lucas.casadocodigo.model.Cliente;

public class ClienteDto {
	
	// Atributos
	private String nome;
	private String sobrenome;
	private String email;
	private String documento;
	private String telefone;
	private String endereco;
	private String complemento;
	private String cep;
	private PaisDto pais;
	private EstadoDto estado;
	private String cidade;
	
	// Construtores
	public ClienteDto() {
	}
	
	public ClienteDto(Cliente cliente) {
		this.nome = cliente.getNome();
		this.sobrenome = cliente.getSobrenome();
		this.email = cliente.getEmail();
		this.documento = cliente.getDocumento();
		this.telefone = cliente.getTelefone();
		this.endereco = cliente.getEndereco();
		this.complemento = cliente.getComplemento();
		this.cep = cliente.getCep();
		this.pais = new PaisDto(cliente.getPais());
		this.estado = cliente.getEstado() != null ? new EstadoDto(cliente.getEstado()) : null;
		this.cidade = cliente.getCidade();
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public String getDocumento() {
		return documento;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCep() {
		return cep;
	}

	public PaisDto getPais() {
		return pais;
	}

	public EstadoDto getEstado() {
		return estado;
	}

	public String getCidade() {
		return cidade;
	}
	
}

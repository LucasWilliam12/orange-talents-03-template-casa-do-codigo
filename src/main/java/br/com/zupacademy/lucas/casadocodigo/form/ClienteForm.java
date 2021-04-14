package br.com.zupacademy.lucas.casadocodigo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.lucas.casadocodigo.controllers.exceptions.NotFoundException;
import br.com.zupacademy.lucas.casadocodigo.controllers.validations.CpfCnpj;
import br.com.zupacademy.lucas.casadocodigo.controllers.validations.UniqueData;
import br.com.zupacademy.lucas.casadocodigo.controllers.validations.ValidEstadoPorPais;
import br.com.zupacademy.lucas.casadocodigo.model.Cliente;
import br.com.zupacademy.lucas.casadocodigo.model.Estado;
import br.com.zupacademy.lucas.casadocodigo.model.Pais;
import br.com.zupacademy.lucas.casadocodigo.repository.PaisRepository;

@ValidEstadoPorPais(message = "O estado informado não pertence ao país informado.")
public class ClienteForm {
	// Atributos para Cliente
	@NotBlank(message = "O nome não pode ser vazio")
	private String nome;
	@NotBlank(message = "O sobrenome não pode ser vazio")
	private String sobrenome;
	@Email(message = "Digite um email válido.")
	@NotBlank(message = "O email não pode ser vazio")
	@UniqueData(domainClass = Cliente.class, fildName = "email")
	private String email;
	@NotBlank(message = "O documento não pode ser vazio")
	@CpfCnpj
	@UniqueData(domainClass = Cliente.class, fildName = "documento")
	private String documento;
	@NotBlank(message = "O telefone não pode ser vazio")
	private String telefone;
	
	
	// Atributos para Endereço
	@NotBlank(message = "O endereço não pode ser vazio.")
	private String endereco;
	@NotBlank(message = "O complemento não pode ser vazio.")
	private String complemento;
	@NotBlank(message = "A cidade não pode ser vazia.")
	private String cidade;
	@NotBlank(message = "O cep não pode ser vazio.")
	private String cep;
	@NotNull(message = "O id do país não pode ser vazio.")
	private Long idPais;
	private Long idEstado;
	
	// Construtores
	@Deprecated
	public ClienteForm() {
	}
	
	public ClienteForm(@NotBlank(message = "O nome não pode ser vazio") String nome,
			@NotBlank(message = "O sobrenome não pode ser vazio") String sobrenome,
			@Email(message = "Digite um email válido.") @NotBlank(message = "O email não pode ser vazio") String email,
			@NotBlank(message = "O documento não pode ser vazio") String documento,
			@NotBlank(message = "O telefone não pode ser vazio") String telefone,
			@NotBlank(message = "O endereço não pode ser vazio.") String endereco,
			@NotBlank(message = "O complemento não pode ser vazio.") String complemento,
			@NotBlank(message = "A cidade não pode ser vazia.") String cidade,
			@NotBlank(message = "O cep não pode ser vazio.") String cep,
			@NotNull(message = "O id do país não pode ser vazio.") Long idPais, Long idEstado) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.documento = documento;
		this.telefone = telefone;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.cep = cep;
		this.idPais = idPais;
		this.idEstado = idEstado;
	}



	// Getters
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

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}


	public String getCidade() {
		return cidade;
	}

	

	// Métodos auxiliares
	public Cliente toModel(PaisRepository paisRepo, Estado estado) {
		Pais pais = paisRepo.findById(this.idPais).orElseThrow(() -> new NotFoundException("Pais não encontrado"));
		
		if(!pais.getEstados().isEmpty() && this.idEstado == null) {
			throw new IllegalArgumentException("O id do estado deve ser informado para este país");
		}
		
		Cliente cliente = new Cliente(this.nome, this.sobrenome, this.email, this.documento, this.telefone, this.endereco, this.complemento, this.cidade, this.cep, pais, estado);
		return cliente;
		
	}
}

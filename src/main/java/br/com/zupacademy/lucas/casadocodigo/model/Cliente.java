package br.com.zupacademy.lucas.casadocodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "clientes")
public class Cliente {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "O nome não pode ser vazio")
	private String nome;
	@NotBlank(message = "O sobrenome não pode ser vazio")
	private String sobrenome;
	@Email(message = "Digite um email válido.")
	@NotBlank(message = "O email não pode ser vazio")
	@Column(unique = true)
	private String email;
	@NotBlank(message = "O documento não pode ser vazio")
	@Column(unique = true)
	private String documento;
	@NotBlank(message = "O telefone não pode ser vazio")
	private String telefone;
	
	// Atributos de endereço
	@NotBlank(message = "O endereço não pode ser vazio.")
	private String endereco;
	@NotBlank(message = "O complemento não pode ser vazio.")
	private String complemento;
	@NotBlank(message = "A cidade não pode ser vazia.")
	private String cidade;
	@NotBlank(message = "O cep não pode ser vazio.")
	private String cep;
	
	@ManyToOne
	@JoinColumn(name = "pais_id")
	private Pais pais;
	@ManyToOne
	@JoinColumn(name = "estado_id")
	private Estado estado;

	// Construtores
	@Deprecated
	public Cliente() {
	}

	public Cliente(@NotBlank(message = "O nome não pode ser vazio") String nome,
			@NotBlank(message = "O sobrenome não pode ser vazio") String sobrenome,
			@Email(message = "Digite um email válido.") @NotBlank(message = "O email não pode ser vazio") String email,
			@NotBlank(message = "O documento não pode ser vazio") String documento,
			@NotBlank(message = "O telefone não pode ser vazio") String telefone,
			@NotBlank(message = "O endereço não pode ser vazio.") String endereco,
			@NotBlank(message = "O complemento não pode ser vazio.") String complemento,
			@NotBlank(message = "A cidade não pode ser vazia.") String cidade,
			@NotBlank(message = "O cep não pode ser vazio.") String cep, Pais pais, Estado estado) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.documento = documento;
		this.telefone = telefone;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.cep = cep;
		this.pais = pais;
		this.estado = estado;
	}

	// Getters
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSobrenome() {
		return sobrenome;
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

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public String getCidade() {
		return cidade;
	}
	
	

}

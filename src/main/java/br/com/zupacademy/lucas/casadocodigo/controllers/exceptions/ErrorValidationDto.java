package br.com.zupacademy.lucas.casadocodigo.controllers.exceptions;

public class ErrorValidationDto {
	
	// Atributos
	private String campo;
	private String erro;

	
	// Construtor
	public ErrorValidationDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	// Getters
	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
}

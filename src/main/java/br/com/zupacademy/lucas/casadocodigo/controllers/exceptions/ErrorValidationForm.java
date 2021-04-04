package br.com.zupacademy.lucas.casadocodigo.controllers.exceptions;

public class ErrorValidationForm {
	
	// Atributos
	private String campo;
	private String erro;

	
	// Construtor
	public ErrorValidationForm(String campo, String erro) {
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

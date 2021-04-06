package br.com.zupacademy.lucas.casadocodigo.controllers.exceptions;

public class StandardError {
	
	// Atributos
	private String message;
	private Integer status;
	private Long timestamp;
	
	// Construtor
	public StandardError(String message, Integer status, Long timestamp) {
		this.message = message;
		this.status = status;
		this.timestamp = timestamp;
	}

	// Getters
	public String getMessage() {
		return message;
	}

	public Integer getStatus() {
		return status;
	}

	public Long getTimestamp() {
		return timestamp;
	}
	
}

package br.com.zupacademy.lucas.casadocodigo.controllers.exceptions;

public class ObjectExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjectExistsException(String msg) {
		super(msg);
	}
	
}

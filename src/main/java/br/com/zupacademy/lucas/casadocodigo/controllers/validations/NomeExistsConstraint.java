package br.com.zupacademy.lucas.casadocodigo.controllers.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.lucas.casadocodigo.repository.CategoriaRepository;

public class NomeExistsConstraint implements ConstraintValidator<NomeExistsValidator, String>{

	@Autowired
	private CategoriaRepository repo;
	
	@Override
	public void initialize(NomeExistsValidator ann) {
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(repo.findByNome(value) != null) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Nome já cadastrado.").addConstraintViolation();
			return false;
		}
		
		return true;
	}
	
	
	
}

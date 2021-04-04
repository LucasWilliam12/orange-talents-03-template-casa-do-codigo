package br.com.zupacademy.lucas.casadocodigo.controllers.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.lucas.casadocodigo.repository.AutorRepository;

public class EmailExistsConstraint implements ConstraintValidator<EmailExistsValidator, String> {
	
	@Autowired
	private AutorRepository repo;
	
	@Override
	public void initialize(EmailExistsValidator ann) {
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(repo.findByEmail(value) != null) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Email já cadastrado.").addConstraintViolation();
			return false;
		}
		
		return true;
	}

}

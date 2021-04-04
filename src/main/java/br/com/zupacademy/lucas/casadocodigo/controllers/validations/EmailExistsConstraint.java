package br.com.zupacademy.lucas.casadocodigo.controllers.validations;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.lucas.casadocodigo.controllers.exceptions.ErrorValidationForm;
import br.com.zupacademy.lucas.casadocodigo.model.Autor;
import br.com.zupacademy.lucas.casadocodigo.repository.AutorRepository;

public class EmailExistsConstraint implements ConstraintValidator<EmailExistsValidator, String>{

	@Autowired
	private AutorRepository repo;
	
	@Override
	public void initialize(EmailExistsValidator value) {
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		List<ErrorValidationForm> list = new ArrayList<>();
		
		Autor autor = repo.findByEmail(value);
		
		if(autor != null) {
			list.add(new ErrorValidationForm("email", "Email já cadastrado"));
		}
		
		
		for(ErrorValidationForm e: list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getErro())
					.addConstraintViolation();
		}
		
		return list.isEmpty();
	}
	
}

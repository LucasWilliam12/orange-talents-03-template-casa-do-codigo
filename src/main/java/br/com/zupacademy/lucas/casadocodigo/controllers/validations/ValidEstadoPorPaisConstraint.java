package br.com.zupacademy.lucas.casadocodigo.controllers.validations;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.lucas.casadocodigo.form.ClienteForm;
import br.com.zupacademy.lucas.casadocodigo.model.Pais;
import br.com.zupacademy.lucas.casadocodigo.repository.PaisRepository;

public class ValidEstadoPorPaisConstraint implements ConstraintValidator<ValidEstadoPorPais, ClienteForm>{

	@Autowired
	private PaisRepository paisRepo;
	
	private String message;
	
	@Override
	public void initialize(ValidEstadoPorPais ann) {
		this.message = ann.message();
	}
	
	@Override
	public boolean isValid(ClienteForm value, ConstraintValidatorContext context) {
		
		Optional<Pais> pais = null;
		
		if(value.getIdEstado() != null) {
			pais = paisRepo.findByEstadoAndPaisId(value.getIdEstado(),value.getIdPais()); 

			if (pais.isEmpty()) {
				System.out.println(message);
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(message).addPropertyNode("idEstado").addConstraintViolation();
			}
			
			return !pais.isEmpty();
			
		}else {
			return pais == null;
		}
		
	}
	
}

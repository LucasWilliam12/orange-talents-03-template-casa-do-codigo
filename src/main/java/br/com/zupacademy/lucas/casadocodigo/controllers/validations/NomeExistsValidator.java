package br.com.zupacademy.lucas.casadocodigo.controllers.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = NomeExistsConstraint.class)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NomeExistsValidator {
	
	String message () default "Nome já cadastrado";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
}

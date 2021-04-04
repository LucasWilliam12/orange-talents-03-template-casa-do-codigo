package br.com.zupacademy.lucas.casadocodigo.controllers.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = EmailExistsConstraint.class)
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailExistsValidator {
	
	String message () default "Email já cadastrado";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}

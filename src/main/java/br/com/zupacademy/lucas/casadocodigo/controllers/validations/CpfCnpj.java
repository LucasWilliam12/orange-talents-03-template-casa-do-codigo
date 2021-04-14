package br.com.zupacademy.lucas.casadocodigo.controllers.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CpfCnpjConstraint.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfCnpj {

	String message () default "CPF/CNPJ inválidos.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
}

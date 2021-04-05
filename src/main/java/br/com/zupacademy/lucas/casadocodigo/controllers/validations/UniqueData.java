package br.com.zupacademy.lucas.casadocodigo.controllers.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = UniqueDateConstraint.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueData {

	String message () default "Dado já cadastrado.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	String fildName();
	Class<?> domainClass();
}

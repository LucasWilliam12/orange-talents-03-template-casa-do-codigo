package br.com.zupacademy.lucas.casadocodigo.controllers.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ValidEstadoPorPaisConstraint.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEstadoPorPais {

	String message () default "O estado informado não faz parte do pais informado.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}

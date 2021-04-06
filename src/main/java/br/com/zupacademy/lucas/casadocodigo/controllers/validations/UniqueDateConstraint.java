package br.com.zupacademy.lucas.casadocodigo.controllers.validations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class UniqueDateConstraint implements ConstraintValidator<UniqueData, String>{

	private String message;
	private String field;
	private Class<?> klass;
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void initialize(UniqueData ann) {
		this.field = ann.fildName();
		this.message = ann.message();
		this.klass = ann.domainClass();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Query query = em.createQuery("SELECT 1 FROM "+ klass.getSimpleName() +" WHERE "+field+"=:value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		
		Assert.state(list.size() <= 1, "Foi encontrado mais de um(a) "+klass.getName()+"com o mesmo atributo "+field);
		
		if(list.size() >= 1) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
		}
		
		return list.isEmpty();
		
	}
	
}

package br.com.zupacademy.lucas.casadocodigo.controllers.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CpfCnpjConstraint implements ConstraintValidator<CpfCnpj, String> {

	private String message;

	// CPF
	private static final int[] weightSsn = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };

	// CNPJ
	private static final int[] weightTin = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

	@Override
	public void initialize(CpfCnpj ann) {
		this.message = ann.message();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		String valorLimpo = value.replaceAll("[^0-9]+", "");

		boolean valid = true;
		
		if(!isValidCpf(valorLimpo)) {
			if(!isValidCNPJ(valorLimpo)) {
				valid = false;
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(message)
						.addConstraintViolation();
			}
		}
		
		return valid;

	}

	public boolean isValidCpf(String cpf) {
		if ((cpf == null) || (cpf.length() != 11) || cpf.matches(cpf.charAt(0) + "{11}"))
			return false;

		final Integer digit1 = calculate(cpf.substring(0, 9), weightSsn);
		final Integer digit2 = calculate(cpf.substring(0, 9) + digit1, weightSsn);
		return cpf.equals(cpf.substring(0, 9) + digit1.toString() + digit2.toString());
	}
	
	public boolean isValidCNPJ(String cnpj) {
		if ((cnpj == null) || (cnpj.length() != 14) || cnpj.matches(cnpj.charAt(0) + "{14}"))
			return false;

		final Integer digit1 = calculate(cnpj.substring(0, 12), weightTin);
		final Integer digit2 = calculate(cnpj.substring(0, 12) + digit1, weightTin);
		return cnpj.equals(cnpj.substring(0, 12) + digit1.toString() + digit2.toString());
	}

	private static int calculate(final String str, final int[] weight) {
		int sum = 0;
		for (int i = str.length() - 1, digit; i >= 0; i--) {
			digit = Integer.parseInt(str.substring(i, i + 1));
			sum += digit * weight[weight.length - str.length() + i];
		}
		sum = 11 - sum % 11;
		return sum > 9 ? 0 : sum;
	}

}

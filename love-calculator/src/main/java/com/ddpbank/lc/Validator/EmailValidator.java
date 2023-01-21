package com.ddpbank.lc.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ddbbank.lc.api.RegistrationInfoDTO;

@Component
public class EmailValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return RegistrationInfoDTO.class.equals(clazz);
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		System.out.println("Inside email validation");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "comDto.email", "email.anyempty");
		String emailValidator = ((RegistrationInfoDTO)target).getComDto().getEmail();
		if(!emailValidator.endsWith("seleniumexpress.com"))
		{
			errors.rejectValue("comDto.email", "email.anyinvalid");
		}
		
	}

}

package com.ddpbank.lc.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ddbbank.lc.api.RegistrationInfoDTO;

public class UsernameValidator implements Validator{

	//check if the Usernamevalidator supports the given object
	@Override
	public boolean supports(Class<?> clazz) {
		
		return RegistrationInfoDTO.class.equals(clazz);
	}

	//we need to write our custom validation logic
	@Override
	public void validate(Object object, Errors errors) {
		
		System.out.println("Inside username validation");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.isEmpty", "Username cannot be empty");
		
		String userName = ((RegistrationInfoDTO)object).getUsername();
		if(!userName.contains("_"))
		{
			errors.rejectValue("username", "username.invalidInput", "Invalid input");
		}
		
	}

}

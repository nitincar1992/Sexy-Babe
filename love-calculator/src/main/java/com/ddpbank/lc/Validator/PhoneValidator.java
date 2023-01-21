package com.ddpbank.lc.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ddbbank.lc.api.CommunicationDTO;

public class PhoneValidator implements ConstraintValidator<Phone, CommunicationDTO> {

	private int numberOfDigits;

	@Override
	public void initialize(Phone phone) {

		this.numberOfDigits = phone.numberOfDigits();

	}

	@Override
	public boolean isValid(CommunicationDTO comDto, ConstraintValidatorContext context) {
		
		System.out.println("Inside Phone validator isValid method");
		int count = 0;
		try
		{
			for(int i=0;i<comDto.getPhone().getUserNumber().length();i++)
			{
				if(comDto.getPhone().getUserNumber().charAt(i) >= '0' && comDto.getPhone().getUserNumber().charAt(i) <= '9')
				{	
					count++;
				}
			}
		}
		catch(Exception e)
		{
			if(count == 0)
			{
				return false;
			}
		}
		if(count != numberOfDigits)
		{	
			return false;
		}
		return true;
	}

}

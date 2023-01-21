package com.ddpbank.lc.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer>{

	private int upper;
	private int lower;
	
	@Override
	public void initialize(Age age) {
		//I can write post construct work here
		this.upper = age.upper();
		this.lower = age.lower();
	}
	
	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		//My logic for age annotation
		System.out.println("Inside Age validator isValid method");
		if(age == null)
		{
			return false;
		}
		if(age < lower || age > upper)
		{
			return false;
		}
		return true;
	}

}

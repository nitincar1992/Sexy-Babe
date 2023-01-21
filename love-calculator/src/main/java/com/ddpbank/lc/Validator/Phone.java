package com.ddpbank.lc.Validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {

	int numberOfDigits() default 10;
	
	String message() default "{errorPhoneMessage}";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
}

package com.ddpbank.lc.controllers;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ddbbank.lc.api.AmountDTO;
import com.ddbbank.lc.api.CommunicationDTO;
import com.ddbbank.lc.api.CreditCardDTO;
import com.ddbbank.lc.api.PhoneDTO;
import com.ddbbank.lc.api.RegistrationInfoDTO;
import com.ddpbank.lc.Validator.EmailValidator;
import com.ddpbank.lc.Validator.UsernameValidator;
import com.ddpbank.lc.propertyEditor.CreditCardPropertyEditor;
import com.ddpbank.lc.propertyEditor.CurrencyPropertyEditor;
import com.ddpbank.lc.propertyEditor.NamePropertyEditor;

@Controller
public class RegistrationAppController {
	
	@Autowired
	EmailValidator emailValidator;

	@RequestMapping("/register")
	public String registerPage(@ModelAttribute("regInfo") RegistrationInfoDTO regInfoDto) {
		System.out.println("User Registration page called");
		CreditCardDTO creditCard = new CreditCardDTO();
		creditCard.setFirstFourDigits(1111);
		creditCard.setSecondFourDigits(2222);
		creditCard.setThirdFourDigits(3333);
		creditCard.setLastFourDigits(4444);
		regInfoDto.setName("Mr XYZ");
		regInfoDto.setUsername("XYZ");
		PhoneDTO phone = new PhoneDTO();
		phone.setCountryCode("91");
		phone.setUserNumber("2233445566");
		AmountDTO amount = new AmountDTO();
		amount.setCurrency(new BigDecimal(2000));
		CommunicationDTO comDto = new CommunicationDTO();
		comDto.setPhone(phone);
		regInfoDto.setComDto(comDto);
		regInfoDto.setCreditCard(creditCard);
		regInfoDto.setAmount(amount);
		return "register-page";
	}

	@RequestMapping("/result")
	public String resultPage(@Valid @ModelAttribute("regInfo") RegistrationInfoDTO regInfoDto, BindingResult result) {
		
		//Logic for validation of email
		
		emailValidator.validate(regInfoDto, result);
		
		System.out.println("User Result page called");
		if(result.hasErrors())
		{
			System.out.println("Errors detected");
			List<ObjectError> allErrors = result.getAllErrors();
			for(ObjectError errors:allErrors)
			{
				System.out.println(errors);
			}
			return "register-page";
		}
		return "result-page";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		System.out.println("Inside RegistrationAppController Init binder method");
		
		//Name white spaces trimming logic
		
		//binder.setDisallowedFields("name");
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, "name", editor);
		
		//Date format logic
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		CustomDateEditor customEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, "date", customEditor);
	
		//Name uppercase logic
		
		NamePropertyEditor nameEditor = new NamePropertyEditor();
		binder.registerCustomEditor(String.class, "name", nameEditor);
		
		//Logic for CreditCardDTO using custom editor
		
		CreditCardPropertyEditor creditCardEditor = new CreditCardPropertyEditor();
		binder.registerCustomEditor(CreditCardDTO.class, "creditCard", creditCardEditor);
		
		//Decimal editor logic for money
		
		NumberFormat number = new DecimalFormat("##,###.00");
		CustomNumberEditor cEditor = new CustomNumberEditor(BigDecimal.class, number, true);
		binder.registerCustomEditor(BigDecimal.class, "money", cEditor);
		
		//Logic for currency using customeditor
		
		CurrencyPropertyEditor pEditor = new CurrencyPropertyEditor();
		binder.registerCustomEditor(Currency.class, "currencyFormat", pEditor);

		//Logic for username validation in RegistrationInfoDTO
		
		UsernameValidator userName = new UsernameValidator();
		binder.addValidators(userName);
		
	}
}

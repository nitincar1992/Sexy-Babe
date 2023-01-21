package com.ddpbank.lc.propertyEditor;

import java.beans.PropertyEditorSupport;

import com.ddbbank.lc.api.CreditCardDTO;

public class CreditCardPropertyEditor extends PropertyEditorSupport{

	CreditCardDTO creditCard = new CreditCardDTO();
	
	@Override
	public String getAsText() {
		
		System.out.println("Inside Credit card custom property editor getAsText method");
		CreditCardDTO creditCard = (CreditCardDTO)getValue();
		return "Sample is "+creditCard;
		
	}
	
	@Override
	public void setAsText(String creditCardFormat) throws IllegalArgumentException {
	
		System.out.println("Inside Credit card custom property editor setAsText method");
		String[] creditCardArray = creditCardFormat.split("-");
		
		creditCard.setFirstFourDigits(Integer.valueOf(creditCardArray[0]));
		creditCard.setSecondFourDigits(Integer.valueOf(creditCardArray[1]));
		creditCard.setThirdFourDigits(Integer.valueOf(creditCardArray[2]));
		creditCard.setLastFourDigits(Integer.valueOf(creditCardArray[3]));

		setValue(creditCard);
	}
	
}

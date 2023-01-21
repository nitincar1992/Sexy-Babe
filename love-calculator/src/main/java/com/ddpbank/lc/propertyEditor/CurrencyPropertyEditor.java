package com.ddpbank.lc.propertyEditor;

import java.beans.PropertyEditorSupport;
import java.util.Currency;

public class CurrencyPropertyEditor extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		System.out.println("Inside Currency custom property editor");
		Currency currencyFormat = Currency.getInstance(text.toUpperCase());
		setValue(currencyFormat);
		
	}
	
}

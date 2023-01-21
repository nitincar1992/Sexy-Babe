package com.ddpbank.lc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.ddbbank.lc.api.PhoneDTO;

public class PhoneFormatter implements Formatter<PhoneDTO>{

	PhoneDTO phone = new PhoneDTO();
	
	@Override
	public String print(PhoneDTO phone, Locale locale) {
		
		System.out.println("Inside PhoneFormatter print method");
		 
		return phone.getCountryCode()+"-"+phone.getUserNumber();
	}

	@Override
	public PhoneDTO parse(String completePhoneNumber, Locale locale) throws ParseException {
		
		System.out.println("Inside PhoneFormatter Parse Method");
		
		//splitting the country code and user number 
		String[] partsOfPhoneNumber = completePhoneNumber.split("-");
		
		int index = completePhoneNumber.indexOf("-");
		if(index == -1 || completePhoneNumber.startsWith("-"))
		{
			//add country code as 91
			phone.setCountryCode("91");
			if(completePhoneNumber.startsWith("-"))
			{
				phone.setUserNumber(partsOfPhoneNumber[1]);
			}
			else
			{
				phone.setUserNumber(partsOfPhoneNumber[0]);
			}
		}
		else
		{
			// setting the PhoneDTO properties using the array
			phone.setCountryCode(partsOfPhoneNumber[0]);
			phone.setUserNumber(partsOfPhoneNumber[1]);
		}
		return phone;
	}

}

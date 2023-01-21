package com.ddpbank.lc.converter;

import org.springframework.core.convert.converter.Converter;

import com.ddbbank.lc.api.AmountDTO;

public class AmountStringConverter implements Converter<AmountDTO, String>{

	@Override
	public String convert(AmountDTO source) {
		
		return "Amount is :"+source.getCurrency();
	}
	
}

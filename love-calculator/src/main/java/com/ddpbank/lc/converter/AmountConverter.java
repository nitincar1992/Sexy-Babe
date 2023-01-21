package com.ddpbank.lc.converter;

import java.math.BigDecimal;

import org.springframework.core.convert.converter.Converter;

import com.ddbbank.lc.api.AmountDTO;

public class AmountConverter implements Converter<String, AmountDTO>{

	AmountDTO amount = new AmountDTO();
	
	@Override
	public AmountDTO convert(String source) {
	
		BigDecimal big = new BigDecimal(source);
		amount.setCurrency(big);
		return amount;
	}
	
}

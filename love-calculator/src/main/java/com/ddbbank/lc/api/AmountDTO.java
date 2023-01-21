package com.ddbbank.lc.api;

import java.math.BigDecimal;

public class AmountDTO {

	private BigDecimal currency;
	
	public BigDecimal getCurrency() {
		return currency;
	}
	public void setCurrency(BigDecimal currency) {
		this.currency = currency;
	}
	
	@Override
	public String toString() {
		return currency+" ";
	}
	
}

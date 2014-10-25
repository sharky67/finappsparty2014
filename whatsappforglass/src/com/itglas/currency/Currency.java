package com.itglas.currency;

public class Currency {
	private String currency_code;
	private float rate;
	
	public Currency(String currency_code, float rate) {
		this.currency_code = currency_code;
		this.rate = rate;
	}

	public String getCurrencyCode() {
		return currency_code;
	}

	public void setCurrencyCode(String currency_code) {
		this.currency_code = currency_code;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

}

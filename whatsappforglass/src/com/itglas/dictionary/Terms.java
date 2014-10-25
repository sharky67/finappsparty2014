package com.itglas.dictionary;

public class Terms {
	public String term;
	public String currency_code;
	
	public Terms(String term, String currency_code) {
		this.term = term;
		this.currency_code = currency_code;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getCurrencyCode() {
		return currency_code;
	}

	public void setCurrencyCode(String currency_code) {
		this.currency_code = currency_code;
	}

}

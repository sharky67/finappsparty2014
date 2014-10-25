package com.itglas.currency;

import com.itglas.constants.Constants;

import android.content.Context;

public class Converter {
	public static Double rate;
	public static Double amount;
	public static Double result;
	
	/**
	 * 
	 * @param amount
	 * @param initial_currency
	 * @param final_currency
	 * @return amount * rate or null if rate could not be found
	 */
	public static Float convert(Float amount, String initial_currency, String final_currency, Context context) {
		Float rate = FileRates.getRate(initial_currency, final_currency, context);
		if (rate != null) {
			return (Float)((float)amount * (float)rate);
		}
		else return null;
	}
	
	/**
	 * 
	 * @param amount
	 * @param initial_currency
	 * @param final_currency
	 * @return amount * rate or null if rate could not be found
	 */
	public static Float convert(String amount, String initial_currency, String final_currency, Context context) {
		Float rate = FileRates.getRate(initial_currency, final_currency, context);
		
		// If the amount is in format 1,200.5 then must be transformed into 1200.5
		if (amount.indexOf(Constants.CURRENCY_MILES_SEPARATOR) != -1) {
			amount = amount.replace(",", "");
		}
		
		if (rate != null) {
			return (Float)(Float.valueOf(amount) * (float)rate);
		}
		else return null;
	}
	
}
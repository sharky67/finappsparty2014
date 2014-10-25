package com.itglas.dictionary;

import java.math.BigDecimal;

import com.itglas.constants.Constants;

import android.annotation.SuppressLint;


/**
 * Class to indicate the items to be searched when looking for a specific currency
 *
 * @author Antonio
 *
 */
@SuppressLint("DefaultLocale")
public class Dictionary {
	
	public static Amount[] amounts = {
		new Amount("one", new BigDecimal(1)), new Amount("two", new BigDecimal(2)),
		new Amount("three", new BigDecimal(3)), new Amount("four", new BigDecimal(2)),
		new Amount("three", new BigDecimal(3)), new Amount("four", new BigDecimal(4)),
		new Amount("five", new BigDecimal(5)), new Amount("six", new BigDecimal(6)),
		new Amount("seven", new BigDecimal(7)), new Amount("eight", new BigDecimal(8)),
		new Amount("nine", new BigDecimal(9)), new Amount("ten", new BigDecimal(10)),
		new Amount("eleven", new BigDecimal(11)), new Amount("twelve", new BigDecimal(12)),
		new Amount("thirteen", new BigDecimal(13)), new Amount("fourteen", new BigDecimal(14)),
		new Amount("fifteen", new BigDecimal(15)), new Amount("sixteen", new BigDecimal(16)),
		new Amount("seventeen", new BigDecimal(17)), new Amount("eighteen", new BigDecimal(18)),
		new Amount("ninteen", new BigDecimal(19)), new Amount("twenty", new BigDecimal(20)),
		new Amount("thirty", new BigDecimal(30)), new Amount("forty", new BigDecimal(40)),
		new Amount("fifty", new BigDecimal(50)), new Amount("sixty", new BigDecimal(60)),
		new Amount("seventy", new BigDecimal(70)), new Amount("eighty", new BigDecimal(80)),
		new Amount("ninety", new BigDecimal(90)),
		new Amount("hundred", new BigDecimal(100)), new Amount("hundreds", new BigDecimal(100)),
		new Amount("thousand", new BigDecimal(1000)), new Amount("thousands", new BigDecimal(1000)),
		new Amount("million", new BigDecimal(1000000)), new Amount("millions", new BigDecimal(1000000))
	};

	/**
	 * It always returns the first value, so the next list must be in order or importance
	 */
	public static Terms[] terms = {
			//Dollars
			new Terms("USA","USD"), new Terms("US dollars","USD"), new Terms("American dollars","USD"), new Terms("US","USD"), 
			
			new Terms("Australia","AUD"), new Terms("Australian dollar","AUD"), new Terms("Australian","AUD"), new Terms("Christmas Island","AUD"), 
			new Terms("Cocos Islands","AUD"), new Terms("Norfolk Island","AUD"), new Terms("Kiribati","AUD"), new Terms("Nauru","AUD"), new Terms("Tuvalu","AUD"),
			
			new Terms("Canada","CAD"), new Terms("Canadian dollar","CAD"), new Terms("Canadian","CAD"),
			
			new Terms("Hong Kong","HKD"), new Terms("Hong Kong dollar","HKD"),
			
			new Terms("New Zealand","NZD"), new Terms("New Zealand dollar","NZD"),
			
			new Terms("Singapore","SGD"), new Terms("Singapore dollar","SGD"),
			
			new Terms("Dollars","USD"), new Terms("Dollar","USD"),
			
			//Pounds
			new Terms("United Kingdom","GBP"), new Terms("Pound sterling","GBP"), new Terms("Sterling","GBP"),
			
			new Terms("Cyprus","CYP"), new Terms("Cyprus pound","CYP"), 
			
			new Terms("Pound","GBP"), new Terms("Pounds","GBP"),

			//Krone
			new Terms("Denmark","DKK"), new Terms("Danish krone","DKK"), new Terms("Danish","DKK"), 
			
			new Terms("Norway","NOK"), new Terms("Norwegian krone","NOK"), new Terms("Norwegian","NOK"),
			
			new Terms("Krone","DKK"), new Terms("Krones","DKK"),
			
			//Euros
			new Terms("Austria","EUR"), new Terms("Belgium","EUR"), new Terms("Estonia","EUR"), new Terms("Finland","EUR"), new Terms("Finland","EUR"), new Terms("France","EUR"),
			new Terms("Germany","EUR"), new Terms("Greece","EUR"), new Terms("Ireland","EUR"), new Terms("Italy","EUR"), new Terms("Latvia","EUR"), new Terms("Luxembourg","EUR"),
			new Terms("Malta","EUR"), new Terms("Netherlands","EUR"), new Terms("Portugal","EUR"), new Terms("Slovakia","EUR"), new Terms("Slovenia","EUR"), new Terms("Spain","EUR"),
			new Terms("Euro","EUR"), new Terms("Euros","EUR"),

			//Pesos
			new Terms("Mexico","MXN"), new Terms("Mejico","MXN"), new Terms("Mexican peso","MXN"), new Terms("Mexican","MXN"), 
			
			new Terms("Philippines","PHP"), new Terms("Philippine peso","PHP"), new Terms("Philippine pesos","PHP"), new Terms("Philippine","PHP"),
			
			new Terms("Peso","MXN"), new Terms("Pesos","MXN"),
			
			
			new Terms("Japan","JPY"), new Terms("Japanese yens","JPY"), new Terms("Japanese","JPY"), new Terms("Yens","JPY"), new Terms("Yen","JPY"), 
			
			new Terms("Bulgaria","BGN"), new Terms("Bulgarian lev","BGN"), new Terms("Lev","BGN"), new Terms("Levs","BGN"), new Terms("Bulgarian","BGN"),
			
			new Terms("Czech Republic","CZK"), new Terms("Czech koruna","CZK"), new Terms("Koruna","CZK"), new Terms("Czech","CZK"), new Terms("Czech crown","CZK"),
			
			new Terms("Hungary","HUF"), new Terms("Hungarian forint","HUF"), new Terms("Hungarian","HUF"), new Terms("Forint","HUF"),
			
			new Terms("Lithuania","LTL"), new Terms("Lithuanian litas","LTL"), new Terms("Lithuanian","LTL"), new Terms("Litas","LTL"),
			
			new Terms("Poland","PLN"), new Terms("Polish zloty","PLN"), new Terms("Polish","PLN"), new Terms("Zloty","PLN"),
			
			new Terms("Romania","RON"), new Terms("New Romanian leu","RON"), new Terms("Romanian leu","RON"), new Terms("Romanian","RON"), new Terms("Leu","RON"),
			
			new Terms("Sweden","SEK"), new Terms("Swedish krona","SEK"), new Terms("Swedish","SEK"), new Terms("Krona","SEK"), new Terms("Swedish crown","SEK"), new Terms("Crown","SEK"),
			
			new Terms("Switzerland","CHF"), new Terms("Swiss franc","CHF"), new Terms("Swiss","CHF"), new Terms("Franc","CHF"), new Terms("Liechtenstein","CHF"),
			
			new Terms("Croatia","HRK"), new Terms("Croatian kuna","HRK"), new Terms("Croatian","HRK"), new Terms("Kuna","HRK"),
			
			new Terms("Turkey","TRY"), new Terms("Turkish lira","TRY"), new Terms("Turkish","TRY"), new Terms("Lira","TRY"),
			
			new Terms("Russia","RUB"), new Terms("Russian rouble","RUB"), new Terms("Russian","RUB"), new Terms("Rouble","RUB"), new Terms("Belarus","RUB"), new Terms("Abkhazia","RUB"), 
			new Terms("South Ossetia","RUB"), new Terms("South Ossetia","RUB"), new Terms("Transnistria","RUB"),
			
			new Terms("Brazil","BRL"), new Terms("Brazilian real","BRL"), new Terms("Brazilian","BRL"), new Terms("Real","BRL"), new Terms("Brazilian real","BRL"),
			
			new Terms("China","CNY"), new Terms("Chinese yuan renminbi","CNY"), new Terms("Chinese","CNY"), new Terms("Yuan","CNY"), new Terms("Renminbi","CNY"),
			
			new Terms("Indonesia","IDR"), new Terms("Indonesian rupiah","IDR"), new Terms("Indonesian","IDR"), new Terms("Rupiah","IDR"),
			
			new Terms("Israel","ILS"), new Terms("Israeli shekel","ILS"), new Terms("Israeli","ILS"), new Terms("Shekel","ILS"), new Terms("Israeli new shekel","ILS"),
			
			new Terms("India","INR"), new Terms("Indian rupee","INR"), new Terms("Indian","INR"), new Terms("Rupee","INR"),
			
			new Terms("South Korea","KRW"), new Terms("South Korean won","KRW"), new Terms("Korean won","KRW"), new Terms("South Korean","KRW"), new Terms("Won","KRW"),
			
			new Terms("Malaysia","MYR"), new Terms("Malaysian ringgit","MYR"), new Terms("Malaysian","MYR"), new Terms("Ringgit","MYR"),
			
			new Terms("Thailand","THB"), new Terms("Thai baht","THB"), new Terms("Thai","THB"), new Terms("Baht","THB"),
			
			new Terms("South Africa","ZAR"), new Terms("South African rand","ZAR"), new Terms("South African","ZAR"), new Terms("Rand","ZAR")			
	};
	
	public static String findCurrency(String cadena, boolean setDefault) {
		String currency_code=null;
		
		if (cadena != null && cadena.length() > 0) {
			if (cadena.indexOf(Constants.DOLLAR_SYMBOL) != -1) {
				return Constants.US_DOLLAR_CODE;
			}
			else {
				int size = terms.length;
				Terms term;
				
				for (int i=0; i < size; i++) {
					term = terms[i];
					if (cadena.toLowerCase().contains(term.getTerm().toLowerCase())) {
						currency_code = term.getCurrencyCode();
						break;
					}
				}
			}
		}
		
		if (currency_code == null && setDefault) {
			currency_code = Constants.EURO_CODE;
		}
		
		return currency_code;
	}
	
	public static String findAmount(String cadena) {
		String amount="";
		Float damount=1F;
		int lastpos=-1;
		boolean next=true;
		
		if (cadena != null && !cadena.isEmpty()) {
			do {
				int posSpace = cadena.indexOf(' ', lastpos+1);
				String word;
				if (posSpace == -1) {
					next = false;
					word = cadena.substring(lastpos+1);
				}
				else {
					word = cadena.substring(lastpos+1, posSpace);
				}
				
				Float amountWord = getAmountFromWord(word);
				if (amountWord != null) {
					damount = damount*getAmountFromWord(word);
				}
				
				lastpos = posSpace;
			}
			while (next);
			
			amount = String.format("%.2f", damount);
		}
		
		return amount;
	}

	private static Float getAmountFromWord(String word) {
		Float amount = null;
		
		//Search for amount in letters
		for (Amount am: amounts) {
			if (word.toLowerCase().contains(am.getName())) {
				return am.getValue().floatValue();
			}
		}
		
		//Search for amount in numbers
		String quantity="";
        for(char c : word.toCharArray()){
            if(Character.isDigit(c)) {
            	quantity = quantity + String.valueOf(c);
            }
            else if (c == Constants.CURRENCY_DECIMALS_SEPARATOR) {
            	quantity = quantity + c;
            }
        }
        
        if (!quantity.isEmpty()) {
        	amount = Float.valueOf(quantity);
        }
		
		return amount;
	}
	
}

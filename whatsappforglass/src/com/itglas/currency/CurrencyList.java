package com.itglas.currency;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import android.os.Environment;

import com.itglas.constants.Constants;

public class CurrencyList {

	private static List<Currency> list;
	private static Date rates_file_date;
	
	public CurrencyList() {
		list = new Vector<Currency>();
		rates_file_date = Calendar.getInstance().getTime(); 
	}
	
	public void addCurrency(Currency currency) {
		list.add(currency);
	}

	public void addCurrency(String currency_code, float rate) {
		Currency rate_aux = new Currency(currency_code, rate);
		list.add(rate_aux);
	}

	public float getRate(String currency_code) {
		if (list != null && !list.isEmpty()) {
			for (Currency currency: list) {
				if (currency.getCurrencyCode().equalsIgnoreCase(currency_code)) {
					return currency.getRate();
				}
			}
		}
		
		return Constants.RATE_ERROR;
	}

	public String getCurrencyCode(float rate) {
		if (list != null && !list.isEmpty()) {
			for (Currency currency: list) {
				if (currency.getRate() == rate) {
					return currency.getCurrencyCode();
				}
			}
		}
		
		return null;
	}
	
	public static List<Currency> getList() {
	   try {
		   if (list == null) {
			   list = new Vector<Currency>(); 
			   
			   //We get the full file into xmlfile string
			   String xmlfile = FileRates.readFile(Environment.getExternalStorageDirectory() + File.separator + Constants.CURRENCY_FILE_NAME);
			   
			   //We get the date of the file in format yyyy-MM-dd
			   int pos = xmlfile.indexOf(Constants.XML_TIME_LABEL);
			   if (pos == -1)
				   return null; //Error in xml file
			   
			   String sdate = xmlfile.substring(pos+Constants.XML_TIME_LABEL.length(), pos+Constants.XML_TIME_LABEL.length()+Constants.XML_DATE_LENGTH);
			   
			   setRatesFileDate(new SimpleDateFormat(Constants.XML_DATE_FORMAT, Locale.ENGLISH).parse(sdate)); 
			   
			   //We get the currency rates
			   String currency_code;
			   String srate;
			   boolean thereismore=true;
			   
			   do {
				   //Position of the first label <Cube currency="
				   pos = xmlfile.indexOf(Constants.XML_CURRENCY_LABEL);
				   
				   if (pos != -1) {
					   //We eliminate the begining of the xmlfile until that label
					   xmlfile = xmlfile.substring(pos);
					   
					   currency_code = xmlfile.substring(Constants.XML_CURRENCY_LABEL.length(), 
							   			 				 Constants.XML_CURRENCY_LABEL.length()+Constants.CURRENCY_CODE_LENGTH);
					   
					   //Position of the first label rate="
					   pos = xmlfile.indexOf(Constants.XML_RATE_LABEL);
					   
					   //We eliminate the begining of the xmlfile until that label
					   xmlfile = xmlfile.substring(pos);
					   
					   srate = xmlfile.substring(Constants.XML_RATE_LABEL.length(),
							                     xmlfile.indexOf(Constants.XML_END_LABEL));
					   
					   Currency curr = new Currency(currency_code, Float.parseFloat(srate));
					   list.add(curr);
				   }
				   else thereismore = false;
			   }
			   while (thereismore);
			   
			   //We add euros to the list
			   if (list != null && !list.isEmpty()) {
				   Currency curr = new Currency(Constants.EURO_CODE, 1f);
				   list.add(curr);
			   }
		   }
	   } catch (IOException e) {
			e.printStackTrace();
	   } catch (ParseException e) {
		e.printStackTrace();
	   }
	   
	   return list;
	}

	public static Date getRatesFileDate() {
		return rates_file_date;
	}

	public static void setRatesFileDate(Date rates_file_date) {
		CurrencyList.rates_file_date = rates_file_date;
	}
}

package com.itglas.currency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;

import com.itglas.constants.Constants;

@SuppressLint("UseValueOf")
public class FileRates {
	private static File file;
	private static Context context;

	/**
	 * Get rate from file
	 * 
	 * @param initial_currency
	 * @param final_currency
	 * @return rate
	 */
	public static Float getRate(String initial_currency, String final_currency, Context c) {
		Float rate=null;
		context=c;
		
		//Initialize file
		initializeFile();
		
		//Findout if the rates file is downloaded, otherwise create it
		if (!isRatesFileAvailable()) {
			updateFileRates(context);
		}
		
		List<Currency> list = CurrencyList.getList();
		
		if (list != null && !list.isEmpty()) {
			float initial_rate = Constants.RATE_ERROR;
			float final_rate = Constants.RATE_ERROR;
			
			//We get the initial and final rates
			for (Currency curr: list) {
				if (curr.getCurrencyCode().equalsIgnoreCase(initial_currency)) {
					initial_rate = curr.getRate();
				}
				
				if (curr.getCurrencyCode().equalsIgnoreCase(final_currency)) {
					final_rate = curr.getRate();
				}
				
				if ((initial_rate != Constants.RATE_ERROR) && (final_rate != Constants.RATE_ERROR || final_currency.equalsIgnoreCase(Constants.EURO_CODE))) {
					if (final_currency.equalsIgnoreCase(Constants.EURO_CODE)) {
						final_rate = 1f;
					}
					if (initial_currency.equalsIgnoreCase(Constants.EURO_CODE)) {
						rate = new Float(final_rate);
					}
					else rate = new Float((float)final_rate / (float)initial_rate);
					break;
				}
			}
		}
		
		return rate;
	}
    
	private static void initializeFile() {
		if (file == null) {
			file = new File(Environment.getExternalStorageDirectory() + File.separator + Constants.CURRENCY_FILE_NAME);
		}
	}
		
	private static boolean isRatesFileAvailable() {
		initializeFile();
		
		if (isEmpty(file)) {
			return false;
		}
		
		if (!file.canRead()) {
			return false;
		}
		
		return true;
	}
	
	public static void updateFileRates(Context context) {
		initializeFile();
		deleteFile();
		DownloadXML.DownloadAndSaveXMLFile(file, context);
	}
	
	public static void deleteFile() {
		if (file.exists()) {
			if (file.isFile()) {
				file.delete();
			}
		}
	}

	public static boolean isEmpty(File file) {
		if (file == null) {
			return true;
		}
		
		if (file.length() == 0) {
			return true;
		}
		
		if (!file.exists()) {
			return true;
		}
		
		return false;
	}
	
	public static String readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}

}

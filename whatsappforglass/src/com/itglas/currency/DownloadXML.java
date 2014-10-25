package com.itglas.currency;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.itglas.constants.Constants;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

@SuppressLint("DefaultLocale")
public class DownloadXML {
	public static InputStream is = null;
	public static OutputStream fo = null;
	public static List<Currency> listNews;
	static ProgressDialog progressDialog;
	private static String xml_file;
	private static Context context;
	private static File file;
	private static String contentEncoding;
	
    public static void DownloadAndSaveXMLFile(File f, Context c) {
    	file = f;
    	context = c;
         
		new Thread() {
			public void run() {
				InputStream in = null;
				Message msg = Message.obtain();
				try {
					in = openHttpConnection(Constants.url);

					InputStreamReader isr = new InputStreamReader(in, contentEncoding);
					int charRead;
					xml_file = "";
					char[] inputBuffer = new char[Constants.bufferSize];

					//Open file in glasses to write in it
					openFile(file);
					
					while ((charRead = isr.read(inputBuffer)) > 0) {
						// ---convert the chars to a String---
						String readString = String.copyValueOf(inputBuffer, 0,
								charRead);
						xml_file += readString;
						
						//Write to file in glasses
						writeToFile(file, readString);
						
						inputBuffer = new char[Constants.bufferSize];
					}
					Bundle b = new Bundle();
					b.putString(Constants.ID_XMLFile, xml_file);
					msg.setData(b);
					in.close();
					
					//Close file in glasses
					closeFile(file);

				} catch (IOException e) {
					e.printStackTrace();
					msg.what = Constants.ERROR_WRITING;
					messageHandler.sendMessage(msg);
				}
				msg.what = Constants.OK;
				messageHandler.sendMessage(msg);
			}
		}.start();
           
    }
    
    private static Handler messageHandler = new Handler() {
        
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == Constants.ERROR_WRITING) {
				if (context != null) {
			    	Intent i = new Intent("android.intent.action.MAIN").putExtra(Constants.ID_MSG, Constants.ID_ERROR);
			        context.sendBroadcast(i);
					//Toast.makeText(context, ConstantsReader.MSG_ERROR_WRITING, Toast.LENGTH_LONG).show();
				}
            }
            if (msg.what == Constants.OK) {
				if (context != null) {
			    	Intent i = new Intent("android.intent.action.MAIN").putExtra(Constants.ID_MSG, Constants.ID_OK);
			        context.sendBroadcast(i);
					//Toast.makeText(context, ConstantsReader.MSG_OK, Toast.LENGTH_LONG).show();
				}
            }
        }
    };
   
    private static InputStream openHttpConnection(String urlStr) {
        InputStream in = null;
        int resCode = -1;
         
        try {
            URL url = new URL(urlStr);
            URLConnection urlConn = url.openConnection();
             
            if (!(urlConn instanceof HttpURLConnection)) {
                throw new IOException ("URL is not an Http URL");
            }
             
            HttpURLConnection httpConn = (HttpURLConnection)urlConn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect();
 
            resCode = httpConn.getResponseCode();                
            if (resCode == HttpURLConnection.HTTP_OK) {
            	contentEncoding = getEncoding(httpConn);
                in = httpConn.getInputStream();
            }        
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return in;
    }    
	
    @SuppressLint("DefaultLocale")
	public static String getEncoding(HttpURLConnection httpConn) {
    	String contentType = httpConn.getContentType();
    	String[] values = contentType.split(";");
    	String charset = "";

    	for (String value : values) {
    	    value = value.trim();

    	    if (value.toLowerCase().startsWith("charset=")) {
    	        charset = new String(value.substring("charset=".length()));
    	    }
    	    if (value.toLowerCase().startsWith("charset =")) {
    	        charset = new String(value.substring("charset =".length()));
    	    }
    	}

    	if (charset.equals("")) {
    	    charset = new String(Constants.defaultEnconding);
    	}    	
    	
    	return charset;
    }
    
	public static void closeFile(File file) 
			throws IOException {
		if (fo != null) {
			fo.close();
		}
	}
	
	public static void openFile(File file) 
			throws IOException {
		closeFile(file);
		fo = new FileOutputStream(file);
	}
	
	public static void writeToFile(File file, String buffer) 
			throws IOException {
	   fo.write(buffer.getBytes());
	}
	
}
package com.itglas.whatsappforglass;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.google.android.glass.media.Sounds;
import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.touchpad.GestureDetector;
import com.google.android.glass.touchpad.GestureDetector.BaseListener;
import com.google.android.glass.widget.CardBuilder;
import com.itglas.constants.Constants;
import com.itglas.dictionary.Dictionary;

public class RecordAmountActivity extends Activity {
	String amount = null;
	private int userid = Constants.VICTOR;
	private boolean isResult = false;
	private String type_send;
	private GestureDetector mGestureDetector;
	private static final int SPEECH_REQUEST = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		configureGestureDetector();

		userid = Integer.parseInt((String)getIntent().getExtras().get(Constants.ID_CONTACT));
		type_send = (String)getIntent().getExtras().get(Constants.ID_TYPE_SEND);
		
		displaySpeechRecognizer();
	}
   
	private void configureGestureDetector()
	{
		mGestureDetector = new GestureDetector(this);
		mGestureDetector.setBaseListener(new BaseListener() {
			
			@Override
			public boolean onGesture(Gesture gesture) 
			{
				AudioManager audio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
				
				switch (gesture) {
				case TAP:
				case LONG_PRESS:
					// Play sound
					if (isResult) {
						audio.playSoundEffect(Sounds.TAP);
						launchMakingTransactionActivity();
					}
					return true;
					
				default:
					return false;
				}
			}
		});
	}
    
	private void launchMakingTransactionActivity() {
		Intent intent = new Intent(this, MakingTransactionActivity.class);
		intent.putExtra(Constants.ID_AMOUNT, amount);
		intent.putExtra(Constants.ID_CONTACT, String.valueOf(userid));
		intent.putExtra(Constants.ID_TYPE_SEND, type_send);
		startActivity(intent);
		finish();
	}
	
	@Override
	public boolean onGenericMotionEvent(MotionEvent event) 
	{
		if (mGestureDetector != null)
	        return mGestureDetector.onMotionEvent(event);

	    return false;
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{	
		if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) 
		{
			//includeCharacter();
			
			return true;
		}
		
		return super.onKeyDown(keyCode, event);
	}

	private void displaySpeechRecognizer() {
	    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	    startActivityForResult(intent, SPEECH_REQUEST);
	}

	@SuppressLint("SimpleDateFormat")
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	        Intent data) {
	    if (requestCode == SPEECH_REQUEST && resultCode == RESULT_OK) {
	        List<String> results = data.getStringArrayListExtra(
	                RecognizerIntent.EXTRA_RESULTS);
	        String spokenText = results.get(0);
	        
	        if (spokenText != null && spokenText.length() > 0 && isValid(spokenText)) {
	        	//Amount
	        	showResult();
	        	/*
	        	Intent intent = new Intent(this, AskConfirmationActivity.class);
	        	intent.putExtra(Constants.ID_AMOUNT, amount);
	        	startActivity(intent);
	        	finish();*/
	        }
	        else showViewError();
	    }
	    super.onActivityResult(requestCode, resultCode, data);
	}

	/**
	 * Format the amount 12345.34 in 12,345.34 
	 * 
	 * @param amount
	 * @return
	 */
	public String formatAmount(String amount){
		String numberFormatted = "";
		int posdecimal = amount.indexOf(',');
		
		if (posdecimal != -1) {
			numberFormatted = amount;
		}
		else {
			posdecimal = amount.indexOf('.');
			if (posdecimal != -1) {
				if (posdecimal > 3) {
					//There is a decimal amount
					
					//Calculate the number of miles ","
					int numberofmiles = posdecimal / 3;
					int rest = posdecimal % 3;
					if (rest == 0) {
						numberofmiles--;
					}
					
					int lastpos = posdecimal;
					for (int i=numberofmiles; i > 0; i-- ) {
						numberFormatted = "," + amount.substring(lastpos-3, lastpos) + numberFormatted;
						lastpos = lastpos -3;
					}
					numberFormatted = amount.substring(0, lastpos) + numberFormatted;
					numberFormatted = numberFormatted + "." + amount.substring(amount.indexOf('.')+1);
				}
				else {
					numberFormatted = amount;
				}
			}
			else {
				//There is no decimal
				int numberofmiles = amount.length() / 3;
				int lastpos = amount.length();
				
				if (lastpos < 4) {
					numberFormatted = amount;
				}
				else {
					for (int i=numberofmiles; i > 0; i-- ) {
						numberFormatted = "," + amount.substring(lastpos-3, lastpos) + numberFormatted;
						lastpos = lastpos -3;
					}
					numberFormatted = amount.substring(0, lastpos) + numberFormatted;
				}
			}
		}
		
		return numberFormatted;
	}
	
	/**
	 * Check if the spokenText has the pattern: 
	 *  "quantity" "initial-currency" to "final-currency" 
	 * 
	 * @return true is valid, false otherwise
	 */
	public boolean isValid(String spokenText) {
		boolean isvalid = false;

		//Find amount
		amount = Dictionary.findAmount(spokenText);
				
		if (amount != null && !amount.isEmpty()) {
			isvalid = true;
		}
		
		return isvalid;
	}
	
	private void showResult() {
        CardBuilder card;

        isResult = true;
        
        card = new CardBuilder(this, CardBuilder.Layout.CAPTION);
        switch(userid) {
        case Constants.JORDI:
        	if (type_send.equalsIgnoreCase(Constants.TYPE_DIRECT)) {
        		card.setText("Do you want to send "+amount+"€ to Jordi by Direct Money?");
        	}
        	else {
        		card.setText("Do you want to send "+amount+"€ to Jordi by Money Transfer?");
        	}
        	break;
        case Constants.GERARD:
        	if (type_send.equalsIgnoreCase(Constants.TYPE_DIRECT)) {
        		card.setText("Do you want to send "+amount+"€ to Gerard by Direct Money?");
        	}
        	else {
        		card.setText("Do you want to send "+amount+"€ to Gerard by Money Transfer?");
        	}
        	break;
        case Constants.VICTOR:
        	if (type_send.equalsIgnoreCase(Constants.TYPE_DIRECT)) {
        		card.setText("Do you want to send "+amount+"€ to Victor by Direct Money?");
        	}
        	else {
        		card.setText("Do you want to send "+amount+"€ to Victor by Money Transfer?");
        	}
        	break;
        }
        card.setFootnote("Tap to accept or Swipe down to cancel");
        switch(userid) {
        case Constants.JORDI:
        	card.addImage(R.drawable.jordi);
        	break;
        case Constants.GERARD:
        	card.addImage(R.drawable.gerard);
        	break;
        case Constants.VICTOR:
        	card.addImage(R.drawable.victor);
        	break;
        }
		setContentView(card.getView());
	}		

	
	private void showViewError() {
        CardBuilder card;

        card = new CardBuilder(this, CardBuilder.Layout.CAPTION);
        card.setText("Sorry. I could not understand that");
        card.setFootnote("Please, try it again");
        card.addImage(R.drawable.error);
		setContentView(card.getView());
	}		
		
}

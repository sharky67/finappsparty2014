package com.itglas.whatsappforglass;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.google.android.glass.widget.CardBuilder;
import com.google.glass.widget.SliderView;
import com.itglas.constants.Constants;

public class MakingTransactionActivity extends Activity {
	String amount = null;
	private int userid = Constants.VICTOR;
	private String type_send;
    private SliderView mIndeterm;

	@SuppressLint("InflateParams")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		userid = Integer.parseInt((String)getIntent().getExtras().get(Constants.ID_CONTACT));
		type_send = (String)getIntent().getExtras().get(Constants.ID_TYPE_SEND);
		amount = (String)getIntent().getExtras().get(Constants.ID_AMOUNT);
		
    	// Start a timer to stop activity
		View layout = (View)getLayoutInflater().inflate(R.layout.progress_window, null);
        switch(userid) {
        case Constants.JORDI:
    		/*layout.setBackgroundResource(R.drawable.making_transaction);
        	if (type_send.equalsIgnoreCase(Constants.TYPE_DIRECT)) {
        		card.setText(amount+"€ has been sent to Jordi by Direct Money");
        	}
        	else {
        		card.setText(amount+"€ has been sent to Jordi by Money Transfer");
        	}*/
        	break;
        case Constants.GERARD:
    		/*layout.setBackgroundResource(R.drawable.making_transaction);
        	if (type_send.equalsIgnoreCase(Constants.TYPE_DIRECT)) {
        		card.setText(amount+"€ has been sent to Gerard by Direct Money");
        	}
        	else {
        		card.setText(amount+"€ has been sent to Gerard by Money Transfer");
        	}*/
        	break;
        case Constants.VICTOR:
    		layout.setBackgroundResource(R.drawable.making_transaction);
        	break;
        }
		
    	//setContentView(R.layout.progress_window);
    	setContentView(layout);
		 
    	mIndeterm = (SliderView) findViewById(R.id.indeterm_slider);
    	mIndeterm.startIndeterminate();
	}
   
	@Override
	protected void onResume() {
		super.onResume();
		
    	final Handler handler = new Handler();
    	
    	handler.postDelayed(new Runnable() 
    	{
            @Override
            public void run() 
            {
    			configureView();
            }
          }, Constants.DELAY_SHOW_INFO_USER);
		
	}
	private void configureView() {
        CardBuilder card;

        card = new CardBuilder(this, CardBuilder.Layout.CAPTION);
        switch(userid) {
        case Constants.JORDI:
        	if (type_send.equalsIgnoreCase(Constants.TYPE_DIRECT)) {
        		card.setText(amount+"€ has been sent to Jordi by Direct Money");
        	}
        	else {
        		card.setText(amount+"€ has been sent to Jordi by Money Transfer");
        	}
        	break;
        case Constants.GERARD:
        	if (type_send.equalsIgnoreCase(Constants.TYPE_DIRECT)) {
        		card.setText(amount+"€ has been sent to Gerard by Direct Money");
        	}
        	else {
        		card.setText(amount+"€ has been sent to Gerard by Money Transfer");
        	}
        	break;
        case Constants.VICTOR:
        	if (type_send.equalsIgnoreCase(Constants.TYPE_DIRECT)) {
        		card.setText(amount+"€ has been sent to Victor by Direct Money");
        	}
        	else {
        		card.setText(amount+"€ has been sent to Victor by Money Transfer");
        	}
        	break;
        }
        card.setFootnote("Swipe down to go to chat");
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
		GeneralCardScrollActivity.moneySent = true; 
	}		

}

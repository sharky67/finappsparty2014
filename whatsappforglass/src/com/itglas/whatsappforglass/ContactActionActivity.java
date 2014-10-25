package com.itglas.whatsappforglass;

import com.google.android.glass.widget.CardBuilder;
import com.itglas.constants.Constants;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

public class ContactActionActivity extends Activity {

	/**
	 * Indicates if a menu option has been selected
	 */
	private Boolean isAttached = false;
	private int userid = Constants.VICTOR;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		userid = Integer.parseInt((String)getIntent().getExtras().get(Constants.ID_CONTACT));
		
		// Configure view
		configureView();
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.contact_action_menu, menu);
        return true;
    }

    @Override
    protected void onStart() 
    {
    	super.onStart();
    }

	@Override
    protected void onResume() 
    {
    	super.onResume();
    	
    	displayOptionsMenu();
    }
	
	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
        case R.id.chat:
        	startChatActivity();
            return true;
        case R.id.send_money:
        	startSendMoneyActivity();
            return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

    @Override
    public void onOptionsMenuClosed(Menu menu) 
    {
    	super.onOptionsMenuClosed(menu);
    	
		finish();
    }
    
    public void startMoneyTransferActivity() {
    	Intent intent = new Intent(this, RecordAmountActivity.class);
    	intent.putExtra(Constants.ID_CONTACT, String.valueOf(userid));
    	startActivity(intent);
    }
    
    public void startInstantMoneyActivity() {
    	Intent intent = new Intent(this, RecordAmountActivity.class);
    	intent.putExtra(Constants.ID_CONTACT, String.valueOf(userid));
    	startActivity(intent);
    }
    
    public void startSendMoneyActivity() {
    	Intent intent = new Intent(this, SendMoneyActivity.class);
    	intent.putExtra(Constants.ID_CONTACT, String.valueOf(userid));
    	startActivity(intent);
    }
    
    public void startChatActivity() {
    	Intent intent = new Intent(this, RecordAmountActivity.class);
    	intent.putExtra(Constants.ID_CONTACT, String.valueOf(userid));
    	startActivity(intent);
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) 
		{
			displayOptionsMenu();
			return true;
		}

		return super.onKeyDown(keyCode, event);
    }
    
	@Override
	public void onAttachedToWindow() {
	  super.onAttachedToWindow();
	  this.isAttached = true;
	  openOptionsMenu();
	}

	/**
	 * Configures the activity view
	 */
	private void configureView()
	{
		// Create a card with some simple text and a footer.
		CardBuilder cardLayout = new CardBuilder(this, CardBuilder.Layout.CAPTION);
		switch(userid) {
		case Constants.JORDI:
			cardLayout.addImage(R.drawable.jordi);
			break;
		case Constants.GERARD:
			cardLayout.addImage(R.drawable.gerard);
			break;
		case Constants.VICTOR:
			cardLayout.addImage(R.drawable.victor);
			break;
		}
		
		setContentView(cardLayout.getView());
	}

    private void displayOptionsMenu()
    {
    	if (isAttached) {
	    	openOptionsMenu();
    	}
    }	
}

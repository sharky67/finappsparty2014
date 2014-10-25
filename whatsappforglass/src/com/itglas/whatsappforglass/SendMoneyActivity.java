package com.itglas.whatsappforglass;

import com.google.android.glass.widget.CardBuilder;
import com.itglas.constants.Constants;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class SendMoneyActivity extends Activity {

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
	public void onAttachedToWindow() {
	  super.onAttachedToWindow();
	  this.isAttached = true;
	  openOptionsMenu();
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.send_money_menu, menu);
        return true;
    }
    
    @Override
    protected void onStart() {
    	super.onStart();
    }
    
	@Override
	protected void onStop() {
		super.onStop();
	}
	
	@Override
    protected void onResume() {
    	super.onResume();
    	
		displayOptionsMenu();
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) 
    {
		if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) 
		{
			displayOptionsMenu();
			return true;
		}

		return super.onKeyDown(keyCode, event);
    }
    
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
        case R.id.money_transfer:
        	startMoneyTransferActivity();
            return true;
        case R.id.direct_money:
        	startInstantMoneyActivity();
            return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

    public void startMoneyTransferActivity() {
    	Intent intent = new Intent(this, RecordAmountActivity.class);
    	intent.putExtra(Constants.ID_CONTACT, String.valueOf(userid));
    	intent.putExtra(Constants.ID_TYPE_SEND, Constants.TYPE_TRANSFER);
    	startActivity(intent);
    }
    
    public void startInstantMoneyActivity() {
    	Intent intent = new Intent(this, RecordAmountActivity.class);
    	intent.putExtra(Constants.ID_CONTACT, String.valueOf(userid));
    	intent.putExtra(Constants.ID_TYPE_SEND, Constants.TYPE_DIRECT);
    	startActivity(intent);
    }
    
	
	@Override
	public void onOptionsMenuClosed(Menu menu) {
    	super.onOptionsMenuClosed(menu);
    	
		finish();
	}
	
    public void startRecentChatActivity() {
    	Intent intent = new Intent(this, GeneralCardScrollActivity.class);
    	intent.putExtra(Constants.ID_CARD_SCROLL, String.valueOf(Constants.VICTOR));
    	startActivity(intent);
    }
    
    public void startContactsActivity() {
    	Intent intent = new Intent(this, ContactsActivity.class);
    	startActivity(intent);
    }
    
	/**
	 * Configures the activity view
	 */
	private void configureView()
	{
		// Create a card with some simple text and a footer.
		CardBuilder cardLayout = new CardBuilder(this, CardBuilder.Layout.CAPTION);
		cardLayout.addImage(R.drawable.portada);
		
		setContentView(cardLayout.getView());
	}
    /**
     * Displays the options menu
     */
    private void displayOptionsMenu()
    {
    	if (isAttached) {
	    	openOptionsMenu();
    	}
    }	


}

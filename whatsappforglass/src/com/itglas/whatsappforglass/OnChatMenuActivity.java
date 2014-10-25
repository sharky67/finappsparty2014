package com.itglas.whatsappforglass;

import com.google.android.glass.widget.CardBuilder;
import com.itglas.constants.Constants;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class OnChatMenuActivity extends Activity {

	/**
	 * Indicates if a menu option has been selected
	 */
	private Boolean isAttached = false;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Configure view
		configureView();
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.on_chat_menu, menu);
        return true;
    }

	@Override
	public void onAttachedToWindow() {
	  super.onAttachedToWindow();
	  this.isAttached = true;
	  openOptionsMenu();
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
    	
    	// Start a timer for displaying options
    	final Handler handler = new Handler();
    	
    	handler.postDelayed(new Runnable() 
    	{
            @Override
            public void run() 
            {
    			displayOptionsMenu();
            }
          }, Constants.DELAY_UNTIL_DISPLAY_MENU);
    }
    
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
        case R.id.new_message:
        	startNewMessageActivity();
            return true;
        case R.id.send_money:
        	startSendMoneyActivity();
            return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

    public void startNewMessageActivity() {
    	/*Intent intent = new Intent(this, NewMessageActivity.class);
    	intent.putExtra(Constants.ID_CONTACT, String.valueOf(Constants.VICTOR));
    	startActivity(intent);*/
    }
    
    public void startSendMoneyActivity() {
    	Intent intent = new Intent(this, SendMoneyActivity.class);
    	intent.putExtra(Constants.ID_CONTACT, String.valueOf(Constants.VICTOR));
    	startActivity(intent);
    }
	
	@Override
	public void onOptionsMenuClosed(Menu menu) {
    	super.onOptionsMenuClosed(menu);
    	
		finish();
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

package com.itglas.whatsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.*;

public class SelectTransferTypeActivity extends Activity {
	private Button button1;
	private final int DELAY_UNTIL_DISPLAY_MENU = 3000;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        setContentView(R.layout.select_transfer_type);

        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {
            public void onClick(View v)
            {
                launchSendMoneyActivity();
            } 
        });
    }
    
    @Override
    protected void onStart() 
    {
    	super.onStart();
    }
    
	@Override
	protected void onStop() {
		super.onStop();
	}
	
	@Override
    protected void onResume() 
    {
    	super.onResume();
    }
    
    private void launchSendMoneyActivity() {    	
    	final Handler handler = new Handler();
    	
    	Intent intent = new Intent(this, SendMoneyActivity.class);
    	startActivity(intent);
    	
    	
    	handler.postDelayed(new Runnable() 
    	{
            @Override
            public void run() 
            {
            	finish();
            }
        }, DELAY_UNTIL_DISPLAY_MENU);
    }
    
}

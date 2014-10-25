package com.itglas.whatsapp2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.*;

public class ReceiveMoneyActivity extends Activity {
	private Button buttonAccept;
	private Button buttonDecline;
	private ProgressDialog progressDialog;
	private final int DELAY_UNTIL_DISPLAY_MENU = 3000;
	private Context context;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        setContentView(R.layout.receive_money);

        @SuppressWarnings("unused")
		GridLayout grid=(GridLayout)findViewById(R.id.gridlayout1);
        buttonAccept = (Button)findViewById(R.id.buttonAccept);
        buttonAccept.setOnClickListener(new OnClickListener() {
            public void onClick(View v)
            {
                launchReceivingMoneyActivity();
            } 
        });
        
        buttonDecline = (Button)findViewById(R.id.buttonDecline);
        buttonDecline.setOnClickListener(new OnClickListener() {
            public void onClick(View v)
            {
                launchDecliningMoneyActivity();
            } 
        });
        
        
        
        context = this;
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
    
    private void launchDecliningMoneyActivity() {
    	final Handler handler = new Handler();
    	progressDialog = ProgressDialog.show(ReceiveMoneyActivity.this, "","Declining money...");
    	MainMenuActivity.acceptdecline = true;
    	
    	handler.postDelayed(new Runnable() 
    	{
            @Override
            public void run() 
            {
            	progressDialog.dismiss();
            	Toast.makeText(context, "You decline 50€ from Antonio", Toast.LENGTH_LONG).show();
            	//startActivity();
            }
        }, DELAY_UNTIL_DISPLAY_MENU);
    	
    	
    	handler.postDelayed(new Runnable() 
    	{
            @Override
            public void run() 
            {
            	finish();
            }
        }, DELAY_UNTIL_DISPLAY_MENU);
    }
    
    private void launchReceivingMoneyActivity() {
    	final Handler handler = new Handler();
    	progressDialog = ProgressDialog.show(ReceiveMoneyActivity.this, "","Accepting money...");
    	MainMenuActivity.acceptdecline = true;
    	
    	handler.postDelayed(new Runnable() 
    	{
            @Override
            public void run() 
            {
            	progressDialog.dismiss();
            	Toast.makeText(context, "You accepted 50€ from Antonio", Toast.LENGTH_LONG).show();
            	
            	//startActivity();
            }
        }, DELAY_UNTIL_DISPLAY_MENU);
    	
    	
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

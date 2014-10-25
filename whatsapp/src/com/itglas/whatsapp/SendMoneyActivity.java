package com.itglas.whatsapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.*;

public class SendMoneyActivity extends Activity {
	private EditText editText1;
	private Button button1;
	private ProgressDialog progressDialog;
	private final int DELAY_UNTIL_DISPLAY_MENU = 3000;
	private Context context;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        setContentView(R.layout.send_money);

        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {
            public void onClick(View v)
            {
                launchWaitingActivity();
            } 
        });
        editText1 = (EditText)findViewById(R.id.editText1);
        
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
    
    private void launchWaitingActivity() {
    	final Handler handler = new Handler();
    	final String money = editText1.getText().toString();
    	progressDialog = ProgressDialog.show(SendMoneyActivity.this, "","Sending...");

    	handler.postDelayed(new Runnable() 
    	{
            @Override
            public void run() 
            {
            	progressDialog.dismiss();
            	Toast.makeText(context, money + "€ has been sent to Victor", Toast.LENGTH_LONG).show();
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

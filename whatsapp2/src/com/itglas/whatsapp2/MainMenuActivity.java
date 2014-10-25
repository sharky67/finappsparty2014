package com.itglas.whatsapp2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.*;


public class MainMenuActivity extends Activity {

    private Button button1;
    private Button button2;
    public static boolean acceptdecline = false;
    private final int DELAY_UNTIL_DISPLAY_MENU = 6000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Handler handler = new Handler();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {
            @SuppressWarnings("deprecation")
			public void onClick(View v)
            {
            	showMessage("Antonio sent money to you");
            	button2.setBackgroundDrawable(getResources().getDrawable(R.drawable.name_background2));
                //button2.setBackground(getResources().getDrawable(R.drawable.name_background2));
            }
        });

        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View v)
            {
                launchReceiveMoneyActivity();
                //setBackgroundDrawable(getResources().getDrawable(R.drawable.background_money_received));
            	
            	handler.postDelayed(new Runnable() 
            	{
                    @Override
                    public void run() 
                    {
                    	setContentView(R.layout.activity_main_money_received);
                    	//startActivity();
                    }
                }, DELAY_UNTIL_DISPLAY_MENU);
                
                
            } 
        });

    }
    
	@SuppressWarnings("deprecation")
	@Override
    protected void onResume() 
    {
    	super.onResume();
    	
    	if (acceptdecline) {
    		button2.setBackgroundDrawable(getResources().getDrawable(R.drawable.name_background));
    		//button2.setBackground(getResources().getDrawable(R.drawable.name_background));
    	}
    }

    private void showMessage(String mensaje) {
    	Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    private void launchReceiveMoneyActivity() {
    	Intent intent = new Intent(this, ReceiveMoneyActivity.class);
    	startActivity(intent);
    }

}
package com.itglas.whatsapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;


public class MainMenuActivity extends ListActivity {

    MessageAdapter adapter;

    List<MessageData> msgs;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        setContentView(R.layout.activity_main);

        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View v)
            {
                launchSelectTransferTypeActivity();
            } 
        });

        msgs =  new ArrayList<MessageData>();
        adapter = new MessageAdapter(this, msgs);
        setListAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    private void launchSelectTransferTypeActivity() {
    	Intent intent = new Intent(this, SelectTransferTypeActivity.class);
    	//finish();
    	//Intent intent = new Intent(this, DummyActivity.class);
    	startActivity(intent);
    	
    	/*Intent intent = new Intent(Intent.ACTION_SEND);

    	// Always use string resources for UI text.
    	// This says something like "Share this photo with"
    	String title = "Elige la aplicacion";//getResources().getString("");
    	// Create intent to show chooser
    	Intent chooser = Intent.createChooser(intent, title);

    	// Verify the intent will resolve to at least one activity
    	//if (intent.resolveActivity(getPackageManager()) != null) {
    	    startActivity(chooser);
    	//}*/
    }
    
    public void sendMessage(View view) {    
        EditText message = (EditText) findViewById(R.id.enter_message);
        String mText = message.getText().toString();

        msgs.add(new MessageData(mText));
        adapter.notifyDataSetChanged();
        message.setText("");
    }

}
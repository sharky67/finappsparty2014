package com.itglas.whatsappforglass;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.glass.media.Sounds;
import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.touchpad.GestureDetector;
import com.google.android.glass.touchpad.GestureDetector.BaseListener;
import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;
import com.itglas.constants.Constants;

public class GeneralCardScrollActivity extends Activity {

    private List<CardBuilder> mCards;
    private CardScrollView mCardScrollView;
	private GestureDetector mGestureDetector;
    private int cardScrollIdentifier;
    public static boolean moneySent = false;
    private CardScrollImageAdapter adapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        configureGestureDetector();
        
        cardScrollIdentifier = Integer.parseInt(getIntent().getExtras().getString(Constants.ID_CARD_SCROLL));

        createCards();
        
        mCardScrollView = new CardScrollView(this);
        adapter = new CardScrollImageAdapter();
        mCardScrollView.setAdapter(adapter);
        mCardScrollView.activate();
        setContentView(mCardScrollView);
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
					audio.playSoundEffect(Sounds.TAP);
					launchOnChatMenuActivity();
					return true;
					
				default:
					return false;
				}
			}
		});
	}
    
    private void launchOnChatMenuActivity() {
		Intent intent = new Intent(this, OnChatMenuActivity.class);
		startActivity(intent);
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
	
    private void createCards() {
        mCards = new ArrayList<CardBuilder>();
        CardBuilder card;

        switch (cardScrollIdentifier) {
        case Constants.VICTOR:
            card = new CardBuilder(this, CardBuilder.Layout.TEXT);
            card.setText(R.string.victor1);
            card.addImage(R.drawable.victor_receive);
            mCards.add(card);
            
            card = new CardBuilder(this, CardBuilder.Layout.TEXT);
            card.setText(R.string.victor2);
            card.addImage(R.drawable.victor_send);
            mCards.add(card);
            
            card = new CardBuilder(this, CardBuilder.Layout.TEXT);
            card.setText(R.string.victor3);
            card.addImage(R.drawable.victor_receive);
            mCards.add(card);
            
            card = new CardBuilder(this, CardBuilder.Layout.TEXT);
            card.setText(R.string.victor4);
            card.addImage(R.drawable.victor_send);
            mCards.add(card);
            
            card = new CardBuilder(this, CardBuilder.Layout.TEXT);
            card.setText(R.string.victor5);
            card.addImage(R.drawable.victor_receive);
            mCards.add(card);
            
            card = new CardBuilder(this, CardBuilder.Layout.TEXT);
            card.setText(R.string.victor6);
            card.addImage(R.drawable.victor_receive);
            mCards.add(card);
            
            card = new CardBuilder(this, CardBuilder.Layout.TEXT);
            card.setText(R.string.victor7);
            card.addImage(R.drawable.victor_send);
            mCards.add(card);
            
        	break;
        	
        case Constants.GERARD:
            
        	break;
        	
        case Constants.JORDI:

        	break;
        	
        }
    }

 	@Override
    protected void onResume() {
    	super.onResume();
    	
    	if (moneySent) {
            CardBuilder card = new CardBuilder(this, CardBuilder.Layout.TEXT);
            card.setText(R.string.caixabank);
            card.addImage(R.drawable.victor_send);
            mCards.add(card);
            
            adapter.notifyDataSetChanged();
    	}
   	}
    	
    private class CardScrollImageAdapter extends CardScrollAdapter {

        @Override
        public int getCount() {
            return mCards.size();
        }

        @Override
        public Object getItem(int position) {
            return mCards.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return mCards.get(position).getView();
        }

		@Override
		public int getPosition(Object arg0) {
			// TODO Auto-generated method stub
			return 0;
		}
    }
    
    public void onClick(DialogInterface dialog, int which) {
        // TODO Auto-generated method stub
    }
    
}

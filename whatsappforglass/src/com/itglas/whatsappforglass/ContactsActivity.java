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

public class ContactsActivity extends Activity {
    private List<CardBuilder> mCards;
    private CardScrollView mCardScrollView;
	private GestureDetector mGestureDetector;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        configureGestureDetector();
        
        createCards();
        
        mCardScrollView = new CardScrollView(this);
        CardScrollImageAdapter adapter = new CardScrollImageAdapter();
        mCardScrollView.setAdapter(adapter);
        mCardScrollView.activate();
        setContentView(mCardScrollView);
    }

    private void createCards() {
        mCards = new ArrayList<CardBuilder>();
        CardBuilder card;

        card = new CardBuilder(this, CardBuilder.Layout.TITLE);
        card.setText(R.string.jordi);
        card.addImage(R.drawable.jordi);
        mCards.add(card);
        
        card = new CardBuilder(this, CardBuilder.Layout.TITLE);
        card.setText(R.string.gerard);
        card.addImage(R.drawable.gerard);
        mCards.add(card);
        
        card = new CardBuilder(this, CardBuilder.Layout.TITLE);
        card.setText(R.string.victor);
        card.addImage(R.drawable.victor);
        mCards.add(card);
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

	/**
	 * Configures the gesture detector
	 */
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
					int pos = mCardScrollView.getSelectedItemPosition();
					launchContactActionActivity(pos);
					
					return true;
					
				default:
					return false;
				}
			}
		});
	}
    
	public void launchContactActionActivity(int pos) {
		Intent intent = new Intent(this, ContactActionActivity.class);
		intent.putExtra(Constants.ID_CONTACT, String.valueOf(pos));
		startActivity(intent);
	}
}

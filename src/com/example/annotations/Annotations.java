package com.example.annotations;


import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import android.app.Activity;
import android.util.Log;

@Fullscreen
@EActivity(R.layout.activity_annotations)
public class Annotations extends Activity {
	
	public final static String TAG = "Annotations";
	
	@Bean
	MainActions mainActions;
	
	@AfterViews
	void afterViews(){
		doSomething();
	}

	private void doSomething() {
		// TODO Auto-generated method stub
		mainActions.doActionsInThread(20, new UiCallback() {
			
			@Override
			public void onBackgroundEnd() {
				// TODO Auto-generated method stub
				Log.i(TAG, "the backgroudn thread end...");
			}
		});
	}
	
}

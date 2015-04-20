package com.example.annotations;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

@EBean
public class MainActions {
	@RootContext
	Context context;

	@ViewById(R.id.textView1)
	TextView tv1;
	
	@RootContext
	Annotations mActivity;
	
	@Background
	void doActionsInThread(int params, UiCallback uiCallback) {
		int result = 0;
		for (int i = 0; i < params; i++) {
			result = result + i;
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Log.i(mActivity.TAG, "test the tread is run in the background...");
			System.out.print("test the thread is run in the background...");
		}
		runInUiThread(result, uiCallback);
	}
	
	@UiThread
	void runInUiThread(int result, UiCallback uiCallback){
		Toast.makeText(context, result+",just a text", Toast.LENGTH_LONG).show();
		Log.i(mActivity.TAG, "you can write the ui code...");
		System.out.print("you can write the ui code ...");
		tv1.setText("²âÊÔ");
		uiCallback.onBackgroundEnd();
	}
}

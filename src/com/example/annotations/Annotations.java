package com.example.annotations;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.NoTitle;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.StringRes;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

@NoTitle
@Fullscreen
@EActivity(R.layout.activity_annotations)
public class Annotations extends Activity {
	
	@ViewById
	TextView textView1;
	
	@ViewById
	Button btn;
	
	@StringRes(R.string.text)
	String text;
	
	@Click(R.id.btn)
	void btnClicked(){
		textView1.setText(text);
	}
}

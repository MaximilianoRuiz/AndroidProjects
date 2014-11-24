package com.example.myfirstapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MyTimePicker extends Activity {
	
	private AutoCompleteTextView autoComplete;
	private ArrayAdapter<String> adapter;
	private String[] colors = {"Blue", "Red", "Green", "Black", "White", "Purpure", "Yellow", "Pink", "Orange", "Brown"};
	private TimePicker timePicker;
	private String textTimePicker;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_time_picker);
		
		timePicker = (TimePicker) findViewById(R.id.timePicker1);
		
		autoComplete = (AutoCompleteTextView) findViewById(R.id.autoComplete);
		adapter = new ArrayAdapter<String>(this, R.layout.activity_time_picker, colors);
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, colors);
		autoComplete = (AutoCompleteTextView) findViewById(R.id.autoComplete);
		
		autoComplete.setAdapter(adapter);
		autoComplete.setThreshold(1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.time_picker, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void setTime(View v){
		textTimePicker = "Time Set is: " + timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute();
		//textTimePicker ="nada";
		Toast.makeText(getApplicationContext(), textTimePicker, Toast.LENGTH_LONG).show();
	}
	
	
}

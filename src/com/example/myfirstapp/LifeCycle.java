package com.example.myfirstapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class LifeCycle extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_life_cycle);
		showStatus("onCreate");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.life_cycle, menu);
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
	
	public void onStart() {
		super.onStart();
		showStatus("onStart");
	}
	
	public void onResume() {
		super.onResume();
		showStatus("onResume");
	}
	
	public void onPause() {
		super.onPause();
		showStatus("onPause");
	}
	
	public void onStop() {
		super.onStop();
		showStatus("onStop");
	}
	
	public void onDestroy() {
		super.onDestroy();
		showStatus("onDestroy");
	}
	
	public void showStatus(String str) {
		Toast toast;
		toast= Toast.makeText(this, str, Toast.LENGTH_SHORT);
		toast.show();
		
	}
}

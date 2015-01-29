package com.example.myfirstapp;

import com.example.myfirstapp.R.id;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LenguajeActivity extends Activity {

	EditText firstN, lastN;
	Button save, load;
	String name, last;
	SharedPreferences preferences;
	private SharedPreferences.Editor editor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lenguaje);
		
		firstN = (EditText) findViewById(id.firstName);
		lastN = (EditText) findViewById(id.lastName);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lenguaje, menu);
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
	
	public void saveData(View v){
		name = firstN.getText().toString();
		last = lastN.getText().toString();
		
		preferences = getSharedPreferences("my_details", MODE_PRIVATE);
		editor = preferences.edit();
		
		editor.putString("FKey", name);
		editor.putString("LKey", last);
		editor.commit();
		
		firstN.setText("");
		lastN.setText("");
		
		Toast.makeText(getBaseContext(), "Save Successful", Toast.LENGTH_LONG).show();
	}
	
	public void loadData(View v){
		preferences = getSharedPreferences("my_details", MODE_PRIVATE);
		String lName, fName;
		
		fName = preferences.getString("FKey", "");
		lName = preferences.getString("LKey", "");
		
		firstN.setText(fName);
		lastN.setText(lName);
		
		Toast.makeText(getBaseContext(), "Name: "+fName+" and Last Name: "+lName, Toast.LENGTH_LONG).show();
	}
}

package com.example.myfirstapp;

import com.example.myfirstapp.R.id;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class SelectButtons extends Activity {
	
	CheckBox check1, check2, check3;
	RadioButton rbdButton1,rbdButton2, rbdButton3;
	String text1, text2;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_buttons);
		
		check1 = (CheckBox) findViewById(id.checkBox1);
		check2 = (CheckBox) findViewById(id.checkBox2);
		check3 = (CheckBox) findViewById(id.checkBox3);
		
		rbdButton1 = (RadioButton) findViewById(id.radio1);
		rbdButton2 = (RadioButton) findViewById(id.radio2);
		rbdButton3 = (RadioButton) findViewById(id.radio3);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select_buttons, menu);
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
	
	public void checked(View v) {
		text1 = "Checked : ";
		if(check1.isChecked()) {
			text1 = text1 + check1.getText() + "  ";
		}else {
			text1.replaceAll((String) check1.getText(), "");
		}
		if(check2.isChecked()) {
			text1 = text1 + check2.getText() + "  ";
		}else {
			text1.replaceAll((String) check2.getText(), "");
		}
		if(check3.isChecked()) {
			text1 = text1 + check3.getText() + "  ";
		}else {
			text1.replaceAll((String) check3.getText(), "");
		}
		
		Toast simpleToast =Toast.makeText(getApplicationContext(),text1, Toast.LENGTH_SHORT);
		
		if(!(text1 == "Checked : ")){
			simpleToast.show();
		}
	}
	
	public void onRadioButtonClicked(View view) {
	    text2 = "Checked : ";
	    if(rbdButton1.isChecked()){
	    	text2 = text2 + rbdButton1.getText();
	    }else{
	    	text2.replaceAll((String) rbdButton1.getText(), "");
	    }
	    if(rbdButton2.isChecked()){
	    	text2 = text2 + rbdButton2.getText();
	    }else{
	    	text2.replaceAll((String) rbdButton2.getText(), "");
	    }
	    if(rbdButton3.isChecked()){
	    	text2 = text2 + rbdButton3.getText();
	    }else{
	    	text2.replaceAll((String) rbdButton3.getText(), "");
	    }
	    
	    Toast simpleToast =Toast.makeText(getApplicationContext(),text2, Toast.LENGTH_SHORT);
		
		if(!(text2 == "Checked : ")){
			simpleToast.show();
		}
	}
}

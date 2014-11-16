package com.example.myfirstapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toast);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.toast, menu);
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
	
	public void showSimpleToast(View v) {
		Toast simpleToast =Toast.makeText(getApplicationContext(),"Simple Toast", Toast.LENGTH_SHORT);
		simpleToast.show();
	}
	
	public void showGravityToast(View v) {
		Toast gravityToast =Toast.makeText(getApplicationContext(),"Gravity Toast", Toast.LENGTH_SHORT);
		gravityToast.setGravity(Gravity.CENTER|Gravity.LEFT, 0, 0);
		gravityToast.show();
	}
	
	public void showLayoutToast(View v) {
		Toast layoutToast = new Toast(getApplicationContext());
		 
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,
                        (ViewGroup) findViewById(R.id.lytLayout));
 
        TextView txtMsg = (TextView)layout.findViewById(R.id.txtMensaje);
        txtMsg.setText("Layout Toast");
 
        layoutToast.setDuration(Toast.LENGTH_SHORT);
        layoutToast.setView(layout);
        layoutToast.show();
	}
}

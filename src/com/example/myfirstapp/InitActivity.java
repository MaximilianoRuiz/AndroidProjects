package com.example.myfirstapp;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class InitActivity extends Activity {
	int notificationID = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_init);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.init, menu);
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
	
	public void callMainActivity(View view) {
    	Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
	
	public void callLenguajeActivity(View view) {
		Intent intent = new Intent(this, LenguajeActivity.class);
		startActivity(intent);
	}
	
	public void callToastActivity(View view) {
		Intent intent = new Intent(this, ToastActivity.class);
		startActivity(intent);
	}
	
	public void callLifeCycleActivity(View view) {
		Intent intent = new Intent(this, LifeCycle.class);
		startActivity(intent);
	}
	
	public void callBuiltActivity(View view) {
		Intent intent = new Intent(this, BuiltApp.class);
		startActivity(intent);
	}
	
	public void callNotification(View v) {
		Intent i = new Intent(this, NotificationActivity.class);
		i.putExtra("notificationID", notificationID);
		PendingIntent pIntent = PendingIntent.getActivity(this, 0, i, 0);
		Uri sonido = RingtoneManager.getDefaultUri(Notification.DEFAULT_SOUND);
		
		Notification noti = new Notification.Builder(this)
							.setWhen(System.currentTimeMillis())
							.setTicker("Tienes una Notificación")
							.setContentTitle("Notificación")
							.setContentText("Click para ver la Notificación")
							.setContentInfo("Noti")
							.setSmallIcon(R.drawable.ic_launcher)
							.setSound(sonido)
							.addAction(R.drawable.ic_launcher, "Titulo de Accion", pIntent)
							.setVibrate(new long[] {100,250,100,500})
							.setContentIntent(pIntent).build();
		
		noti.flags = Notification.FLAG_AUTO_CANCEL;
    	
    	NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    	manager.notify(notificationID, noti);
	}
	
	public void callSelectBtns(View view) {
		Intent intent = new Intent(this, SelectButtons.class);
		startActivity(intent);
	}
	
	public void callTimePicker(View view) {
		Intent intent = new Intent(this, MyTimePicker.class);
		startActivity(intent);
	}
	
	public void callSimpleList(View v) {
		Intent intent = new Intent(this, SimpleList.class);
		startActivity(intent);
	}
}

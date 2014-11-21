package com.example.myfirstapp;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class NotificationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification);
		
		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		 
        nm.cancel(getIntent().getExtras().getInt("notificationID"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.notification, menu);
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

	public void bigText(View v) {
		Intent intent = new Intent();
		PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
		
		NotificationCompat.BigTextStyle style = new NotificationCompat.BigTextStyle();
		style.setSummaryText("Summary");
		style.setBigContentTitle("Big Content Title");
		style.bigText("Bueno, esto es un poco problematico de explicar. Cada vez que compilo este código, y si el dispositivo esta conecado, no se ven los cambios de estilo. Pero al desconectar eld ispositivo y correr la app, los cambio se ven perfectamente.");
		
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setAutoCancel(true);
		builder.setTicker("Big Text");
		builder.setContentTitle("Big Test Reduced");
		builder.setContentText("Reduced Text");
		builder.setSmallIcon(R.drawable.ic_launcher);
		builder.setStyle(style);
		
		Notification notification = builder.setContentIntent(pIntent).build();
		
		notification.flags = Notification.FLAG_AUTO_CANCEL;
		NotificationManager manager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
		manager.notify(63612, notification);
	}
	
	public void bigPicture(View v) {
		Intent intent = new Intent();
		PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
		Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		
		NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle();
		style.setSummaryText("Summary");
		style.setBigContentTitle("Big Picure Title");
		style.bigPicture(bmp);
		
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setAutoCancel(true);
		builder.setTicker("Big Picture");
		builder.setContentTitle("Big Picture Notification");
		builder.setContentText("Text of Picture");
		builder.setSmallIcon(R.drawable.ic_launcher);
		builder.setStyle(style);
		
		Notification notification = builder.setContentIntent(pIntent).build();
		
		notification.flags = Notification.FLAG_AUTO_CANCEL;
		NotificationManager manager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
		manager.notify(63612, notification);
	}
	
	public void inBox(View v) {
		Intent intent = new Intent();
		PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
		Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		
		NotificationCompat.InboxStyle style = new NotificationCompat.InboxStyle();
		style.setSummaryText("Summary");
		style.setBigContentTitle("In Box Title");
		style.addLine("Linea 1");
		style.addLine("Linea 2");
		style.addLine("Linea 3");
		style.addLine("Linea 4");
		style.addLine("Linea 5");
		
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setAutoCancel(true);
		builder.setTicker("In Box Text");
		builder.setContentTitle("In Box Notification Reduced");
		builder.setContentText("In Box Text Reduced");
		builder.setSmallIcon(R.drawable.ic_launcher);
		builder.setStyle(style);
		
		Notification notification = builder.setContentIntent(pIntent).build();
		
		notification.flags = Notification.FLAG_AUTO_CANCEL;
		NotificationManager manager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
		manager.notify(63612, notification);
	}

}

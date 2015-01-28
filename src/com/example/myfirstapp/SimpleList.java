package com.example.myfirstapp;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SimpleList extends ListActivity {
	ArrayAdapter<String> adapter;
	String[] values;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_simple_list);
		
		ListView listView = getListView();
		listView.setChoiceMode(2);
		listView.setTextFilterEnabled(true);
		
		values = new String[] { "Android List View", 
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android", 
                "Android Example", 
                "List View Source Code", 
                "List View Array Adapter", 
                "Android Example List View" 
               };
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, values);
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.simple_list, menu);
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
	
	public void onListItemClick(ListView l, View v, int position, long id) {
	      
		l.setItemChecked(position, l.isItemChecked(position));
		String  itemValue  = values[position];
		Toast.makeText(this, itemValue, Toast.LENGTH_LONG).show();
	}
	
	
}

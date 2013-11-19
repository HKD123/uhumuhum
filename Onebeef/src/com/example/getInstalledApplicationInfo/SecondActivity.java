package com.example.getInstalledApplicationInfo;

import com.example.onebeef2.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Toast;

public class SecondActivity extends Activity {
	
	DataListView list;
	IconTextListAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,ViewGroup.LayoutParams.FILL_PARENT);
		list = new DataListView(this);
		
		adapter = new IconTextListAdapter(this);
		
		Resources res = getResources();

		list.setAdapter(adapter);
		list.setOnDataSelectionListener(new OnDataSelectionListener(){

			@Override
			public void onDataSelected(AdapterView parent, View v,
					int position, long id) {
				// TODO Auto-generated method stub
				IconTextItem curItem = (IconTextItem) adapter.getItem(position);
				String[] curData = curItem.getData();
				Toast.makeText(getApplicationContext(), "selected"+curData[0],Toast.LENGTH_SHORT).show();
				
			}
		});
		
		
		setContentView(list,params);
		
	}

	

}

package com.example.onebeef2;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class SelectedApp extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selectedapp);
		PackageManager pm = this.getPackageManager();
		
		
	}

}

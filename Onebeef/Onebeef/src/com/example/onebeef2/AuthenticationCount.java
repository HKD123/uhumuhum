package com.example.onebeef2;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class AuthenticationCount extends Activity implements OnItemSelectedListener{
	
	ArrayList<String> arrayList;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.authentication_count);
		Spinner spinner = (Spinner)findViewById(R.id.spinner);
		
		spinner.setPrompt("회수를 선택하시오.");
		
		arrayList = new ArrayList<String>();
		arrayList.add("1");
		arrayList.add("2");
		arrayList.add("3");
		arrayList.add("4");
		arrayList.add("5");
		arrayList.add("6");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,arrayList);
		Spinner sp = (Spinner)this.findViewById(R.id.spinner);
		sp.setPrompt("인증시도 회수를 설정하시오");
		
		sp.setAdapter(adapter);
		sp.setOnItemSelectedListener((OnItemSelectedListener) this);
		
		
		
		
		

	}
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		Toast.makeText(this, arrayList.get(arg2), Toast.LENGTH_SHORT).show();
		
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

}

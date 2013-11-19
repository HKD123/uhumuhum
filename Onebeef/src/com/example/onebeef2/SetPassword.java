package com.example.onebeef2;

import java.sql.PreparedStatement;
import java.util.zip.Inflater;

import com.example.onebeef2.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SetPassword extends Activity {
	protected static final String TAG = null;
	EditText prePWD;
	Button prebtn;
	TextView tv;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.setpassword, null);

		
		prePWD = (EditText)layout.findViewById(R.id.prePassword);
		prebtn = (Button)layout.findViewById(R.id.prePasswordBtn);
		tv = (TextView)layout.findViewById(R.id.sibal);
		
		prebtn.setOnClickListener(new View.OnClickListener() {
			String s;
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String getEdit = prePWD.getText().toString();
				
				if(getEdit.getBytes().length<=0){
					tv.setText("나오라좀");
				}else{
					s = "입력내용 : " + getEdit;
					tv.setText(s);
					
					
				}
			}
		});
		setContentView(R.layout.setpassword);

	}


}

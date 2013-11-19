package com.example.onebeef2;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment03 extends Fragment {


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		RelativeLayout r = (RelativeLayout)inflater.inflate(R.layout.frag03, container,false);
		ListView list = (ListView)r.findViewById(R.id.settingListView);
		String str[] ={"사진촬영모드","인증시도회수설정","패턴설정","패턴변경","패턴해제","비밀번호설정","비밀번호변경","비밀번호해제",""};
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,str);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v,int position, long id){
				String toastMessage = ((TextView)v).getText().toString();
				
				switch(position){
				
				case  0 : 
					Intent ableCameraActivity = new Intent(getActivity(), AbleCamera.class);
					startActivity(ableCameraActivity);
					break;
				case  1 : 
					Intent authenticationCountActivity = new Intent(getActivity(),AthenticationCount.class);
					startActivity(authenticationCountActivity);
					break;
				case  2 : 
					Toast.makeText(getActivity(), toastMessage, Toast.LENGTH_SHORT).show();
					break;
				case  3 : 
					Toast.makeText(getActivity(), toastMessage, Toast.LENGTH_SHORT).show();
					break;
				case  4 : 
					Toast.makeText(getActivity(), toastMessage, Toast.LENGTH_SHORT).show();
					break;
				case  5 : 
					Intent setPasswordActivity = new Intent(getActivity(),SetPassword.class);
					startActivity(setPasswordActivity);
					
					break;
				case  6 : 
					Toast.makeText(getActivity(), toastMessage, Toast.LENGTH_SHORT).show();
					break;
				case  7 : 
					Toast.makeText(getActivity(), toastMessage, Toast.LENGTH_SHORT).show();
					break;
					
				
				}
				//Toast.makeText(getActivity(), toastMessage, Toast.LENGTH_SHORT).show();
				
				// TODO Auto-generated method stub
				
			}
			
			
		});
		return r;
	}
}

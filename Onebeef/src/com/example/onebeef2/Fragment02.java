package com.example.onebeef2;


import java.util.List;

import com.example.getInstalledApplicationInfo.*;

import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class Fragment02 extends Fragment{
	PackageManager pm;
	DataListView list;
	IconTextListAdapter adapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
	

		Intent intent = new Intent(getActivity(),SecondActivity.class);
		startActivity(intent);
//		list = new DataListView(getActivity());		
//		adapter = new IconTextListAdapter(getActivity());
//
//		PackageManager manager = this.getActivity().getPackageManager();
//		List<PackageInfo> appInfoList = manager.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
//		
//		
//		//for(int i =0;i<appInfoList.size();i++){
//		for(int i =0; i<10; i++){
//			PackageInfo p = appInfoList.get(i);
//			Drawable icon = p.applicationInfo.loadIcon(pm);
//			String appName = p.applicationInfo.loadLabel(pm).toString();
//			String description = p.applicationInfo.loadDescription(pm).toString();
//			adapter.addItem(new IconTextItem(icon,appName,description));
//		}
//		list.setAdapter(adapter);
//		
//		list = new DataListView(this);
//
//		adapter = new IconTextListAdapter(this);
//
//		Resources res = getResources();
//
//		adapter.addItem(new IconTextItem(res
//				.getDrawable(R.drawable.ic_launcher), "하하하", "헤헤헤"));
//
//		list.setAdapter(adapter);
//		list.setOnDataSelectionListener(new OnDataSelectionListener() {
//
//			@Override
//			public void onDataSelected(AdapterView parent, View v,
//					int position, long id) {
//				// TODO Auto-generated method stub
//				IconTextItem curItem = (IconTextItem) adapter.getItem(position);
//				String[] curData = curItem.getData();
//				Toast.makeText(getApplicationContext(),
//						"selected" + curData[0], Toast.LENGTH_SHORT).show();
//
//			}
//		});

		return inflater.inflate(R.layout.frag02, container,false);
	}

}

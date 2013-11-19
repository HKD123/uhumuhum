package com.example.onebeef2;


import java.util.List;
import android.app.Fragment;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;


public class Fragment02 extends Fragment{
	PackageManager pm;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
	

		RelativeLayout r = (RelativeLayout)inflater.inflate(R.layout.frag02, container,false);
		ListView list = (ListView)r.findViewById(R.id.allAppListView);
		
		PackageManager manager = this.getActivity().getPackageManager();
		List<PackageInfo> appInfoList = manager.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
		String [] appNameList = new String[appInfoList.size()];
		for(int i =0;i<appInfoList.size();i++){
			PackageInfo pi = appInfoList.get(i);
			appNameList[i] = pi.packageName;
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,appNameList);
		list.setAdapter(adapter);
		
		return r;
//		PackageManager manager = this.getActivity().getPackageManager();
//		List<PackageInfo> appInfoList = manager.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
//		LinearLayout l = (LinearLayout)inflater.inflate(R.layout.frag02, container,false);
//		for (int j = 0, jend = appInfoList.size(); j < jend ; j++) {
//		   PackageInfo pi = appInfoList.get(j);
//		   TextView tv = new TextView(container.getContext());
//		   String appname = pi.packageName;
//		   tv.setText(appname);
//		   tv.setTextSize(30);
//		   l.addView(tv);
//		}
//		
//		return l;
//		
//		
	}

}

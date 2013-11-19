package com.example.getInstalledApplicationInfo;


import com.example.onebeef2.R;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class IconTextView extends LinearLayout {

	private ImageView mIcon;
	private TextView mText01;
	private TextView mText02;
	
	
	public IconTextView(Context context, IconTextItem aItem) {
		// TODO Auto-generated constructor stub
		super(context);
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		RelativeLayout r = (RelativeLayout) inflater.inflate(R.layout.frag02, this,true);
		
		mIcon = (ImageView)r.findViewById(R.id.iconItem);
		mIcon.setImageDrawable(aItem.getIcon());
		
		mText01 = (TextView)r.findViewById(R.id.dataItem01);
		mText01.setText(aItem.getData(0));
		
		mText02 = (TextView)r.findViewById(R.id.dataItem02);
		mText02.setText(aItem.getData(1));
		
	}
	public void setText(int index, String data){
		
		switch(index){
		case 0:
			mText01.setText(data);
			break;
		case 1:
			mText02.setText(data);
			break;
		}
		
	
	}
	public void setIcon(Drawable icon){
		mIcon.setImageDrawable(icon);
	}

}

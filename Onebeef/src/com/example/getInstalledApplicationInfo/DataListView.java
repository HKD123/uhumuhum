package com.example.getInstalledApplicationInfo;



import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class DataListView extends ListView{
	private IconTextListAdapter adapter;
	private OnDataSelectionListener selectionListener;
	
	
	public DataListView(Context context){
		super(context);
		init();
	}
	
	
	public DataListView(Context context, AttributeSet attrs){
		super(context,attrs);
		init();
	}
	
	
	
	public void init(){
		setOnItemClickListener(new OnItemClickAdapter());
		
	}
	
	
	public void setAdapter(BaseAdapter adapter){
		super.setAdapter(adapter);
	}
	
	
	
	public BaseAdapter getAdapter(){
		return (BaseAdapter)super.getAdapter();
	}
	
	
	public void setOnDataSelectionListener(OnDataSelectionListener listener){
		this.selectionListener = listener;
	}
	
	
	
	
	public OnDataSelectionListener getOnDataSelectionListener(){
		return selectionListener;
		
	}
	
	
	
	
	
	class OnItemClickAdapter implements OnItemClickListener{
		public OnItemClickAdapter(){
			
		}

		@Override
		public void onItemClick(AdapterView<?> parent, View v, int position,
				long id) {
			// TODO Auto-generated method stub
			if(selectionListener == null){
				return;
				
			}
			selectionListener.onDataSelected(parent,v,position,id);
		}
	}
	
}
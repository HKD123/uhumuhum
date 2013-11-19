package com.example.onebeef2;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText edit01;
	@Override
	//여기는 탭관련 사항들입니다.!!
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar abar = getActionBar();
		abar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		//잠금기능 선택된 어플리케이션들!
		
		Tab tab01 = abar.newTab();
		tab01.setText("Selected");
		tab01.setTabListener(new ProductTabListener(this, Fragment01.class.getName()));
		abar.addTab(tab01);
		//전체 어플리케이션들!!
		Tab tab02 = abar.newTab();
		tab02.setText("All app");
		tab02.setTabListener(new ProductTabListener(this, Fragment02.class.getName()));
		abar.addTab(tab02);
		//환경설정 버튼
		Tab tab03 = abar.newTab();
		tab03.setText("setting");
		tab03.setTabListener(new ProductTabListener(this, Fragment03.class.getName()));
		abar.addTab(tab03);
		
	}
	private class ProductTabListener implements ActionBar.TabListener{

		private Fragment mFragment;
		private final Activity mActivity;
		private final String mFragName;
		
		public ProductTabListener(Activity activity, String fragName){
			
			mActivity = activity;
			mFragName = fragName;
		}
		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
			
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			mFragment = Fragment.instantiate(mActivity, mFragName);
			ft.add(android.R.id.content, mFragment);
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			ft.remove(mFragment);
			mFragment = null;
		}
		
		private void search(){
			
		}
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		View v = menu.findItem(R.id.menu_serarch).getActionView();
		edit01 = (EditText) v.findViewById(R.id.edit01);
		
		if(edit01 != null){
			
			edit01.setOnEditorActionListener(onSearchListener);
		
		}
		
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case R.id.menu_refresh:
			Toast.makeText(this, "새로고침 메뉴를 선택했습니다.", Toast.LENGTH_SHORT).show();
			return true;
			
		case R.id.menu_serarch:
			Toast.makeText(this, "검색 메뉴를 선택했습니다.",  Toast.LENGTH_SHORT).show();
			return true;
		case R.id.menu_settings:
			Toast.makeText(this,"설정 메뉴를 선해갛셨습니다.",Toast.LENGTH_SHORT).show();
			return true;
			
		}
		return super.onOptionsItemSelected(item);
	}

	private TextView.OnEditorActionListener onSearchListener = new TextView.OnEditorActionListener() {
		
		@Override
		public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
			if(event == null || event.getAction()==KeyEvent.ACTION_UP){
				search();
				
				InputMethodManager inputManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
				inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
			}
			// TODO Auto-generated method stub
			return false;
		}
	};
	private void search(){
		String searchString = edit01.getEditableText().toString();
		Toast.makeText(this, "검색어"+searchString, Toast.LENGTH_SHORT).show();
		edit01.setText(null);
	}
}

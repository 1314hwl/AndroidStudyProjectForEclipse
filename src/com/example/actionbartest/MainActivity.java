package com.example.actionbartest;

import com.example.actionbartest.view.ShadowActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

/**
 * 
 * @Description
 * @author henry
 * @date 2016年5月26日 下午6:03:50
 */
public class MainActivity extends Activity {
	private ActionBar mActionBar;
	private ActionBar.Tab mDayTab;
	private ActionBar.Tab mWeekTab;
	private ActionBar.Tab mMonthTab;
	private ActionBar.Tab mAgendaTab;
	private SearchView mSearchView;
	private MenuItem mSearchMenu;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mActionBar = this.getActionBar();
		mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME
				| ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_USE_LOGO | mActionBar.DISPLAY_SHOW_TITLE);
		mActionBar.setHomeButtonEnabled(false);
		mActionBar.setDisplayHomeAsUpEnabled(false);
		mActionBar.setDisplayShowHomeEnabled(false);
		getActionBar().setIcon(android.R.color.transparent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.action_menu, menu);
		MenuItem mi = menu.findItem(R.id.action_search);
		mSearchView = (SearchView) mi.getActionView();
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		System.out.println("itemId:" + item.getItemId());
		Intent it = new Intent();
		switch (item.getItemId()) {
		case R.id.view_shadow:
			it.setClass(MainActivity.this, ShadowActivity.class);
			startActivity(it);
			break;
		}

		return super.onOptionsItemSelected(item);
	}
}

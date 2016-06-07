package com.example.actionbartest;

import java.lang.reflect.Field;

import com.example.actionbartest.view.AlphaBitmapActivity;
import com.example.actionbartest.view.ShadowActivity;
import com.example.actionbartest.view.grid.GridLayoutActivity;
import com.example.actionbartest.view.rect.MyRectActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

/**
 * @Description
 * @author henry
 * @date 2016年6月7日 下午3:49:13
 */
public class MainActivity extends Activity implements OnClickListener {
	private ActionBar mActionBar;
	private ActionBar.Tab mDayTab;
	private ActionBar.Tab mWeekTab;
	private ActionBar.Tab mMonthTab;
	private ActionBar.Tab mAgendaTab;
	private SearchView mSearchView;
	private MenuItem mSearchMenu;

	private Button mGridLayoutBtn;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mActionBar = this.getActionBar();
		mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME
				| ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_USE_LOGO | mActionBar.DISPLAY_SHOW_TITLE);
		// 设置ActionBar中AppLogo不显示
		mActionBar.setHomeButtonEnabled(false);
		mActionBar.setDisplayHomeAsUpEnabled(false);
		mActionBar.setDisplayShowHomeEnabled(false);
		// 去掉searchView中AppLogo
		getActionBar().setIcon(android.R.color.transparent);
		mGridLayoutBtn = (Button) findViewById(R.id.grid_layout);
		mGridLayoutBtn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.action_menu, menu);
		MenuItem mi = menu.findItem(R.id.action_search);
		mSearchView = (SearchView) mi.getActionView();
		try {
			int searchEditBgId = mSearchView.getContext().getResources().getIdentifier("android:id/search_plate", null,
					null);
			int searchClearId = mSearchView.getContext().getResources().getIdentifier("android:id/search_close_btn",
					null, null);
			int searchTextViewId = mSearchView.getContext().getResources().getIdentifier("android:id/search_src_text",
					null, null);
			// 设置搜索框背景
			mSearchView.findViewById(searchEditBgId).setBackgroundResource(R.drawable.ic_eben_search_box_n);
			ImageView mClearIv = (ImageView) mSearchView.findViewById(searchClearId);
			mClearIv.setImageResource(R.drawable.searchview_clean_select);
			// 设置光标的颜色,以及搜素框中字体的颜色
			AutoCompleteTextView mTv = (AutoCompleteTextView) mSearchView.findViewById(searchTextViewId);
			mTv.setTextColor(getResources().getColor(R.color.e_ben_searchview_text_color));
			mTv.setTextSize(16);
			Field mCursorDrawableRes = TextView.class.getDeclaredField("mCursorDrawableRes");
			mCursorDrawableRes.setAccessible(true);
			mCursorDrawableRes.set(mTv, R.drawable.cursor_color);
			// 设置放大镜logo图标
			Class<?> argClass = mSearchView.getClass();
			Field mSearchHintIconField = argClass.getDeclaredField("mSearchHintIcon");
			mSearchHintIconField.setAccessible(true);
			mSearchHintIconField.set(mSearchView, getDrawable(R.drawable.ic_eben_menu_search_holo_light));

		} catch (Exception e) {
			e.printStackTrace();
		}

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
		case R.id.my_view_rect:
			it.setClass(MainActivity.this, MyRectActivity.class);
			startActivity(it);
			break;
		case R.id.alphabitmap_action:
			it.setClass(MainActivity.this, AlphaBitmapActivity.class);
			startActivity(it);
			break;
		}

		return super.onOptionsItemSelected(item);
	}

	public void onClick(View v) {
		Intent it = new Intent();
		switch (v.getId()) {
		case R.id.grid_layout:
			it.setClass(MainActivity.this, GridLayoutActivity.class);
			startActivity(it);
			break;
		}

	}
}

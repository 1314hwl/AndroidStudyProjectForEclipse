package com.example.actionbartest;

import java.lang.reflect.Field;

import com.example.actionbartest.actionBar.ActionBar001Activity;
import com.example.actionbartest.view.grid.GridLayoutActivity;
import com.example.actionbartest.view.switcher.SwitcherActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;

/**
 * @Description
 * @author henry
 * @date 2016年6月7日 下午3:49:13
 */
public class MainActivity extends Activity implements OnClickListener {

	private Button mGridLayoutBtn;
	private DisplayMetrics metric;
	public static int SCREEN_WIDTH, SCREEN_HIGHT;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		metric = new DisplayMetrics();
		WindowManager manager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
		Display display = manager.getDefaultDisplay();
		display.getMetrics(metric);
		SCREEN_WIDTH = metric.widthPixels; // 屏幕宽度（像素）
		SCREEN_HIGHT = metric.heightPixels; // 屏幕高度（像素）
		float density = metric.density; // 屏幕密度（0.75 / 1.0 / 1.5）
		int densityDpi = metric.densityDpi; // 屏幕密度DPI（120 / 160 / 240）
		System.out.println("---width-->>" + SCREEN_WIDTH);
		System.out.println("---height-->>" + SCREEN_HIGHT);
		System.out.println("---density-->>" + density);
		System.out.println("---densityDpi-->>" + densityDpi);
		System.out.println("---statusBarHigh-->>" + getStatusBarHeight());

		System.out.println("---display.getHeight-->>" + display.getHeight());
		System.out.println("---display.getWidth-->>" + display.getWidth());
		mGridLayoutBtn = (Button) findViewById(R.id.grid_layout);
		mGridLayoutBtn.setOnClickListener(this);

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

	private int getStatusBarHeight() {
		Class<?> c = null;

		Object obj = null;

		Field field = null;

		int x = 0, sbar = 0;

		try {

			c = Class.forName("com.android.internal.R$dimen");

			obj = c.newInstance();

			field = c.getField("status_bar_height");

			x = Integer.parseInt(field.get(obj).toString());

			sbar = this.getResources().getDimensionPixelSize(x);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return sbar;
	}

	public void actionBarClick(View v) {
		Intent toAcitonBar = new Intent();
		toAcitonBar.setClass(MainActivity.this, ActionBar001Activity.class);
		startActivity(toAcitonBar);
	}

	public void switcherClick(View v) {
		Intent toSwitcher = new Intent();
		toSwitcher.setClass(MainActivity.this, SwitcherActivity.class);
		startActivity(toSwitcher);
	}
}

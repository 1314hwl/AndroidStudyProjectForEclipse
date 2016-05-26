package com.example.actionbartest.view;

import com.example.actionbartest.R;

import android.app.Activity;
import android.os.Bundle;

/**
 * <title>shadow 的使用</title>
 * <p>
 * android:shadowColor="#ff000000" 设置阴影的颜色 <br>
 * android:shadowDx="5" 设置x上的偏移,阴影取相反方向,x>0阴影在左边,x<0阴影在右边 <br>
 * android:shadowDy="0" 设置y上的偏移,阴影取相反方向,y>0阴影在上边,y<0阴影在下边 <br>
 * android:shadowRadius="1" Radius辐射光线<br>
 * </p>
 * 
 * @Description
 * @author henry
 * @date 2016年5月26日 下午6:04:07
 */
public class ShadowActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shadow);
	}
}

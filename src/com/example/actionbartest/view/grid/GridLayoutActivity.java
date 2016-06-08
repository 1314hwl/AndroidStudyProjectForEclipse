package com.example.actionbartest.view.grid;

import com.example.actionbartest.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * <title>GridLayout参数介绍</title>
 * <p>
 * android:columnCount setColumCount(int) 设置布局的最大列数<br>
 * android:rowCount setRowCount(int) 设置布局的最大行数<br>
 * android:alignmentMode setAilgnmentMode(int)
 * 设置布局的对其方式(alignBounds:对齐子视图边界；alignMargins： 对齐子视图边距；) <br>
 * android:columnOrderPeserved setColumOrderPreserved(boolean) 设置容器是否保留列序号<br>
 * android:rowOrderPeserved setRowOrderPeserved(boolean) 设置容器是否保留行序号<br>
 * android：useDefaultMargins setUseDefaultMargins(boolean)设置容器是否使用默认的页边距<br>
 * </p>
 * <title>GridLayout子组件的参数介绍</title>
 * <p>
 * android:layout_Gravity setGravity(int) 设置组件如何占据其所属网格的空间 <br>
 * android:layout_column 设置组件在容器的第几列 <br>
 * android:layout_row 设置组件在容器的第几行<br>
 * android:layout_columnSpan 设置组件占据了几列<br>
 * android:layout_rowSpan 设置组件占据了几行
 * </p>
 * 
 * @Description
 * @author henry
 * @date 2016年5月27日 下午5:12:39
 */
public class GridLayoutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid_layout);
		findViewById(R.id.simple_form).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent it = new Intent();
				it.setClass(GridLayoutActivity.this, GridLayout001Activity.class);
				startActivity(it);
			}
		});
		findViewById(R.id.from_xml).setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent it = new Intent();
				it.setClass(GridLayoutActivity.this, GridLayout002Activity.class);
				startActivity(it);
			}
		});
		findViewById(R.id.from_java).setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent it = new Intent();
				it.setClass(GridLayoutActivity.this, GridLayout004Activity.class);
				startActivity(it);
			}
		});
	}
}

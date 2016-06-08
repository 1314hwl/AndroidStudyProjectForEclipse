package com.example.actionbartest.view.grid;

import com.example.actionbartest.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * <title>GridLayout��������</title>
 * <p>
 * android:columnCount setColumCount(int) ���ò��ֵ��������<br>
 * android:rowCount setRowCount(int) ���ò��ֵ��������<br>
 * android:alignmentMode setAilgnmentMode(int)
 * ���ò��ֵĶ��䷽ʽ(alignBounds:��������ͼ�߽磻alignMargins�� ��������ͼ�߾ࣻ) <br>
 * android:columnOrderPeserved setColumOrderPreserved(boolean) ���������Ƿ��������<br>
 * android:rowOrderPeserved setRowOrderPeserved(boolean) ���������Ƿ��������<br>
 * android��useDefaultMargins setUseDefaultMargins(boolean)���������Ƿ�ʹ��Ĭ�ϵ�ҳ�߾�<br>
 * </p>
 * <title>GridLayout������Ĳ�������</title>
 * <p>
 * android:layout_Gravity setGravity(int) ����������ռ������������Ŀռ� <br>
 * android:layout_column ��������������ĵڼ��� <br>
 * android:layout_row ��������������ĵڼ���<br>
 * android:layout_columnSpan �������ռ���˼���<br>
 * android:layout_rowSpan �������ռ���˼���
 * </p>
 * 
 * @Description
 * @author henry
 * @date 2016��5��27�� ����5:12:39
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

package com.example.actionbartest.view;

import com.example.actionbartest.R;

import android.app.Activity;
import android.os.Bundle;

/**
 * <title>shadow ��ʹ��</title>
 * <p>
 * android:shadowColor="#ff000000" ������Ӱ����ɫ <br>
 * android:shadowDx="5" ����x�ϵ�ƫ��,��Ӱȡ�෴����,x>0��Ӱ�����,x<0��Ӱ���ұ� <br>
 * android:shadowDy="0" ����y�ϵ�ƫ��,��Ӱȡ�෴����,y>0��Ӱ���ϱ�,y<0��Ӱ���±� <br>
 * android:shadowRadius="1" Radius�������<br>
 * </p>
 * 
 * @Description
 * @author henry
 * @date 2016��5��26�� ����6:04:07
 */
public class ShadowActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shadow);
	}
}

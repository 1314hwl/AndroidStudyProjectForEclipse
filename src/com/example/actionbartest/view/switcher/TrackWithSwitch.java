package com.example.actionbartest.view.switcher;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Switch;

import java.lang.reflect.Field;

/**
 * @Description 处理switch宽度异常的bug
 * @author henry
 * @date 2016年6月8日 上午11:21:04
 */
public class TrackWithSwitch extends Switch {

	public TrackWithSwitch(Context context) {
		this(context, null);
	}

	public TrackWithSwitch(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		hackSwitchWidthField();
	}

	@Override
	public int getCompoundPaddingLeft() {
		Drawable trackDrawable = getTrackDrawable();
		if (trackDrawable == null) {
			return super.getCompoundPaddingLeft();
		}
		return trackDrawable.getIntrinsicWidth();
	}

	@Override
	public int getCompoundPaddingRight() {
		Drawable trackDrawable = getTrackDrawable();
		if (trackDrawable == null) {
			return super.getCompoundPaddingRight();
		}
		return trackDrawable.getIntrinsicWidth();
	}

	private void hackSwitchWidthField() {
		Drawable trackDrawable = getTrackDrawable();
		if (trackDrawable == null) {
			return;
		}
		try {
			Field mSwitchWidth = Switch.class.getDeclaredField("mSwitchWidth");
			if (!mSwitchWidth.isAccessible()) {
				mSwitchWidth.setAccessible(true);
			}
			mSwitchWidth.set(this, trackDrawable.getIntrinsicWidth());
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}

package com.example.actionbartest.view.rect;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class MyScreenView extends View {

	private Paint mRectPain;
	private RectF mScreenRectF;
	private Rect mScreenRect;
	private int screenWidth, screenHeight;

	public MyScreenView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		mRectPain = new Paint();
		mRectPain.setColor(0xff00ff00);
		DisplayMetrics metric = new DisplayMetrics();
		WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = manager.getDefaultDisplay();
		display.getMetrics(metric);
		Point outSize = new Point();
		display.getSize(outSize);
		screenWidth = outSize.x;
		screenHeight = outSize.y;
		System.out.println("--11---screenWidth:" + screenWidth);
		System.out.println("--11---screenHeight:" + screenHeight);
		mScreenRect = new Rect(0, 0, screenWidth, screenHeight);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		System.out.println("############");
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		drawRect(canvas);
	}

	private void drawRect(Canvas c) {
		c.drawRect(mScreenRect, mRectPain);
	}

}

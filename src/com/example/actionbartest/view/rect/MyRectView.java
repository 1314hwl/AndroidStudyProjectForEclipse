package com.example.actionbartest.view.rect;

import com.example.actionbartest.MainActivity;
import com.example.actionbartest.R;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MyRectView extends View {

	private Paint mRectPaint, mTextPaint;
	private Rect mTextRect, mTextRect2, mTextRect3;
	private RectF mTextRectF;
	private Resources res;
	private float mRectW, mRectH;
	private int mRectColor;
	private static Bitmap mFontBitmap;
	private int mBitMapW, mBitmapH;

	public MyRectView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyRectView);
		mRectColor = a.getColor(R.styleable.MyRectView_rectBg, 0X88FFFF00);
		mRectW = a.getDimension(R.styleable.MyRectView_rectW, 36);
		mRectH = a.getDimension(R.styleable.MyRectView_rectH, 36);
		mTextRect = new Rect(0, 0, MainActivity.SCREEN_WIDTH, MainActivity.SCREEN_HIGHT >> 2);
		mTextRect2 = new Rect(mTextRect.left, mTextRect.bottom, mTextRect.right, MainActivity.SCREEN_HIGHT >> 2);
		mRectPaint = new Paint();
		mRectPaint.setColor(mRectColor);
		mTextPaint = new Paint();
		mTextPaint.setColor(0xff000000);
		mTextPaint.setTextSize(80f);
		mTextPaint.setTextAlign(Align.LEFT); // 文字的左边和坐标点对齐
		mTextPaint.setTextAlign(Align.RIGHT);// 文字的右边和坐标点对齐
		mTextPaint.setTextAlign(Align.CENTER);// 文字的中间和坐标点对齐
		a.recycle();
		res = context.getResources();
		mFontBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.font);
		mBitMapW = mFontBitmap.getWidth();
		mBitmapH = mFontBitmap.getHeight();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		drawRect(canvas);
	}

	private void drawRect(Canvas c) {

		c.drawRect(mTextRect, mRectPaint);
		mRectPaint.setColor(0xff908765);
		c.drawRect(mTextRect2, mRectPaint);
		c.drawLine(0, mTextRect.height() >> 1, mTextRect.width(), mTextRect.height() >> 1, mTextPaint);

		// mRectPaint.setColor(res.getColor(R.color.abc_color_highlight_material));
		// c.drawRect(mTextRectF, mRectPaint);
		FontMetrics fm = mTextPaint.getFontMetrics();
		// 以baseLine为基准
		float topY = fm.top;// -84.49219
		float ascentY = fm.ascent;// -74/21875
		float descentY = fm.descent;// 19.53125
		float bottomY = fm.bottom;// 21.279688
		float leading = fm.leading;

		System.out.println("-------topY-----:" + topY);
		System.out.println("-------ascentY-----:" + ascentY);
		System.out.println("-------descentY-----:" + descentY);
		System.out.println("-------bottomY-----:" + bottomY);
		System.out.println("-------leading-----:" + leading);
		// y坐标计算的理解:rect总高度的一半+文字总高度的一半+descent(有偏差)
		int y = (int) (mTextRect.top + mTextRect.height() / 2 + (fm.bottom - fm.top) / 2 - fm.descent);
		// y1坐标计算的理解:rect总高度的一半+文字总高度的一半(更精确)
		int y1 = (int) (mTextRect.top + mTextRect.height() / 2 + (-topY - bottomY) / 2);
		System.out.println("-------y-----:" + y);
		System.out.println("-------y1-----:" + y1);
		c.drawText("yellowworld中国人", mTextRect.width() >> 1, y1, mTextPaint);
		c.drawBitmap(mFontBitmap, mTextRect.left, mTextRect.bottom, null);

	}

}

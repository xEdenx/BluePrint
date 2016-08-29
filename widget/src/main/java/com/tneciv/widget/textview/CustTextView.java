package com.tneciv.widget.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.tneciv.widget.R;

/**
 * Created by Tneciv
 * on 2016-08-28 17:54 .
 */

public class CustTextView extends View {
    private int mTextSize;
    private String mText;
    private int mTextColor;
    private Paint mPaint;
    private Rect mRect;

    private static final int DEFAULT_TEXT_SIZE = 60;
    private static final String DEFAULT_TEXT = "Hello world";
    private static final int DEFAULT_TEXT_COLOR = Color.RED;

    public CustTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    public CustTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustTextView(Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        final TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.CustTextView);
        mTextSize = (int) attributes.getDimension(R.styleable.CustTextView_custTextSize, mTextSize);
        mTextColor = attributes.getColor(R.styleable.CustTextView_custTextColor, mTextColor);
        mText = attributes.getString(R.styleable.CustTextView_custText);
        setCustColor(mTextColor);
        setSize(mTextSize);
        setText(mText);
        attributes.recycle();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mRect = new Rect();
    }

    public void setText(String text) {
        this.mText = TextUtils.isEmpty(text) ? DEFAULT_TEXT : text;
    }


    public void setSize(int textSize) {
        this.mTextSize = textSize == 0 ? DEFAULT_TEXT_SIZE : textSize;
    }

    public void setCustColor(int color) {
        this.mTextColor = color == 0 ? DEFAULT_TEXT_COLOR : color;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setTextSize(mTextSize);
        mPaint.getTextBounds(mText, 0, mText.length(), mRect);

        mPaint.setColor(Color.CYAN);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);

        mPaint.setColor(mTextColor);
        canvas.drawText(mText, getWidth() / 2 - mRect.width() / 2, getHeight() / 2 + mRect.height() / 2, mPaint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width, height;

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            mPaint.setTextSize(mTextSize);
            mPaint.getTextBounds(mText, 0, mText.length(), mRect);
            width = getPaddingLeft() + mRect.width() + getPaddingRight();
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            mPaint.setTextSize(mTextSize);
            mPaint.getTextBounds(mText, 0, mText.length(), mRect);
            height = getPaddingTop() + mRect.height() + getPaddingBottom();
        }

        setMeasuredDimension(width, height);
    }

}

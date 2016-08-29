package com.tneciv.widget.tagview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.tneciv.widget.R;

import java.util.List;

import static com.tneciv.widget.R.styleable.TagView;
import static com.tneciv.widget.Tool.dp2px;
import static com.tneciv.widget.Tool.sp2px;

/**
 * Created by Tneciv
 * on 2016-08-28 10:56 .
 * https://github.com/whilu/TagView
 */

public class TagContainerLayout extends ViewGroup {

    /**
     * Vertical interval, default 5(dp)
     */
    private int mVerticalInterval;

    /**
     * Horizontal interval, default 5(dp)
     */
    private int mHorizontalInterval;

    /**
     * TagContainerLayout border width(default 0.5dp)
     */
    private float mBorderWidth = 0.5f;

    /**
     * TagContainerLayout border radius(default 10.0dp)
     */
    private float mBorderRadius = 10.0f;

    /**
     * The sensitive of the ViewDragHelper(default 1.0f, normal)
     */
    private float mSensitivity = 1.0f;

    /**
     * TagView average height
     */
    private int mChildHeight;

    /**
     * TagContainerLayout border color(default #22FF0000)
     */
    private int mBorderColor = Color.parseColor("#22FF0000");

    /**
     * TagContainerLayout background color(default #11FF0000)
     */
    private int mBackgroundColor = Color.parseColor("#11FF0000");

    /**
     * The container layout gravity(default left)
     */
    private int mGravity = Gravity.LEFT;

    /**
     * The max line count of TagContainerLayout
     */
    private int mMaxLines = 0;

    /**
     * The max length for TagView(default max length 23)
     */
    private int mTagMaxLength = 23;

    /**
     * TagView Border width(default 0.5dp)
     */
    private float mTagBorderWidth = 0.5f;

    /**
     * TagView Border radius(default 15.0dp)
     */
    private float mTagBorderRadius = 15.0f;

    /**
     * TagView Text size(default 14sp)
     */
    private float mTagTextSize = 14;

    /**
     * Text direction(support:TEXT_DIRECTION_RTL & TEXT_DIRECTION_LTR, default TEXT_DIRECTION_LTR)
     */
    private int mTagTextDirection = View.TEXT_DIRECTION_LTR;

    /**
     * Horizontal padding for TagView, include left & right padding(left & right padding are equal, default 20px)
     */
    private int mTagHorizontalPadding = 20;

    /**
     * Vertical padding for TagView, include top & bottom padding(top & bottom padding are equal, default 17px)
     */
    private int mTagVerticalPadding = 17;

    /**
     * TagView border color(default #88F44336)
     */
    private int mTagBorderColor = Color.parseColor("#88F44336");

    /**
     * TagView background color(default #33F44336)
     */
    private int mTagBackgroundColor = Color.parseColor("#33F44336");

    /**
     * TagView text color(default #FF666666)
     */
    private int mTagTextColor = Color.parseColor("#FF666666");

    /**
     * TagView typeface
     */
    private Typeface mTagTypeface = Typeface.DEFAULT;

    /**
     * Whether TagView can clickable(default unclickable)
     */
    private boolean isTagViewClickable;

    /**
     * Tags
     */
    private List<String> mTags;

    /**
     * Can drag TagView(default false)
     */
    private boolean mDragEnable;

    ///**
    // * TagView drag state(default STATE_IDLE)
    // */
    //private int mTagViewState = ViewDragHelper.STATE_IDLE;
    //
    ///**
    // * The distance between baseline and descent(default 5.5px)
    // */
    //private float mTagBdDistance = 5.5f;
    //
    ///**
    // * OnTagClickListener for TagView
    // */
    //private TagView.OnTagClickListener mOnTagClickListener;
    //
    //private Paint mPaint;
    //
    //private RectF mRectF;
    //
    //private ViewDragHelper mViewDragHelper;

    private List<View> mChildViews;

    private int[] mViewPos;

    /**
     * View theme(default PURE_CYAN)
     */
    private int mTheme = ColorFactory.PURE_CYAN;

    /**
     * Default interval(dp)
     */
    private static final float DEFAULT_INTERVAL = 5;

    /**
     * Default tag min length
     */
    private static final int TAG_MIN_LENGTH = 3;


    public TagContainerLayout(Context context) {
        this(context, null);
    }

    public TagContainerLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TagContainerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray attributes = context.obtainStyledAttributes(attrs, TagView);
        mVerticalInterval = (int) attributes.getDimension(R.styleable.TagView_vertical_interval, dp2px(context, DEFAULT_INTERVAL));

        mHorizontalInterval = (int) attributes.getDimension(R.styleable.TagView_horizontal_interval,
                dp2px(context, DEFAULT_INTERVAL));
        mBorderWidth = attributes.getDimension(R.styleable.TagView_container_border_width,
                dp2px(context, mBorderWidth));
        mBorderRadius = attributes.getDimension(R.styleable.TagView_container_border_radius,
                dp2px(context, mBorderRadius));
        //mTagBdDistance = attributes.getDimension(R.styleable.TagView_tag_bd_distance,
        //        mTagBdDistance);
        mBorderColor = attributes.getColor(R.styleable.TagView_container_border_color,
                mBorderColor);
        mBackgroundColor = attributes.getColor(R.styleable.TagView_container_background_color,
                mBackgroundColor);
        mDragEnable = attributes.getBoolean(R.styleable.TagView_container_enable_drag, false);
        mSensitivity = attributes.getFloat(R.styleable.TagView_container_drag_sensitivity,
                mSensitivity);
        mGravity = attributes.getInt(R.styleable.TagView_container_gravity, mGravity);
        mMaxLines = attributes.getInt(R.styleable.TagView_container_max_lines, mMaxLines);
        mTagMaxLength = attributes.getInt(R.styleable.TagView_tag_max_length, mTagMaxLength);
        mTheme = attributes.getInt(R.styleable.TagView_tag_theme, mTheme);
        mTagBorderWidth = attributes.getDimension(R.styleable.TagView_tag_border_width,
                dp2px(context, mTagBorderWidth));
        mTagBorderRadius = attributes.getDimension(
                R.styleable.TagView_tag_corner_radius, dp2px(context, mTagBorderRadius));
        mTagHorizontalPadding = (int) attributes.getDimension(
                R.styleable.TagView_tag_horizontal_padding, mTagHorizontalPadding);
        mTagVerticalPadding = (int) attributes.getDimension(
                R.styleable.TagView_tag_vertical_padding, mTagVerticalPadding);
        mTagTextSize = attributes.getDimension(R.styleable.TagView_tag_text_size,
                sp2px(context, mTagTextSize));
        mTagBorderColor = attributes.getColor(R.styleable.TagView_tag_border_color,
                mTagBorderColor);
        mTagBackgroundColor = attributes.getColor(R.styleable.TagView_tag_background_color,
                mTagBackgroundColor);
        mTagTextColor = attributes.getColor(R.styleable.TagView_tag_text_color, mTagTextColor);
        mTagTextDirection = attributes.getInt(R.styleable.TagView_tag_text_direction, mTagTextDirection);
        isTagViewClickable = attributes.getBoolean(R.styleable.TagView_tag_clickable, false);
        attributes.recycle();



    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }

}

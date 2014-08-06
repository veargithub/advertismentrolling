package com.advtest;


import com.example.advtest.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;


public class PointTips extends LinearLayout{
	private int resPointNormal;//default point's resource id
	private int resPointSelected;//default selected point's resource id
	private int pointSize;//the count of point
	private int current;//the current selected point's index
	private View[] pointViews;
	private int pointHeight;//point's diameter
	private int pointMargin;//the margin of points

	public PointTips(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public PointTips(Context context) {
		super(context);
		init();
	}
	
	private void init() {
		resPointNormal = R.drawable.point_normal;
		resPointSelected = R.drawable.point_selected;
		pointSize = 0;
		current = 0;
		pointHeight = 20;
		pointMargin = 25;
	}
	/**
	 * 设置总共有多少个圆圈
	 * @param number
	 */
	public void setPointSize(int number) {
		if (number < 0) return;
		this.pointSize = number;
		this.removeAllViews();
		pointViews = new View[number];
		for (int i = 0; i < number; i++) {
			View view = new View(this.getContext());
			view.setBackgroundResource(resPointNormal);
			LayoutParams lp = new LayoutParams(pointHeight, pointHeight);
			lp.leftMargin = pointMargin;
			view.setLayoutParams(lp);
			pointViews[i] = view;
			this.addView(view);
		}
	}
	/**
	 * set which point is selected
	 * @param index
	 */
	public void setCurrent(int index) {
		if (index > pointSize || index < 0) return;
		pointViews[current].setBackgroundResource(resPointNormal);
		current = index;
		pointViews[current].setBackgroundResource(resPointSelected);
	}

	public void setResPointNormal(int resPointNormal) {
		this.resPointNormal = resPointNormal;
	}

	public void setResPointSelected(int resPointSelected) {
		this.resPointSelected = resPointSelected;
	}

	public void setPointHeight(int pointHeight) {
		this.pointHeight = pointHeight;
	}

	public void setPointMargin(int pointMargin) {
		this.pointMargin = pointMargin;
	}
	
}

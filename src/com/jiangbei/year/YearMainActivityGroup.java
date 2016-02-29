package com.jiangbei.year;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
/**
 * 年度数据模块界面管理
 * */
public class YearMainActivityGroup extends ActivityGroup {
	public static ActivityGroup yeargroup; // 一个静态的ActivityGroup变量，用于管理本Group中的Activity

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		yeargroup = this;
		//第一个显示的界面
		Intent intent = new Intent(this, YearMainActivity.class)
				.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		// 把一个Activity转换成一个View
		Window w = yeargroup.getLocalActivityManager().startActivity(
				"YearMainActivity", intent);
		View view = w.getDecorView();
		// 把View添加大ActivityGroup中
		yeargroup.setContentView(view);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed(); // 把后退事件交给子Activity处理
		yeargroup.getLocalActivityManager().getCurrentActivity().onBackPressed();
	}

	@Override
	protected void onResume() {

		super.onResume();
		// 把界面切换放到onResume方法中是因为，从其他选项卡切换回来时，
		// 调用搞得是onResume方法

		// 要跳转的界面
//		Intent intent = new Intent(this, YearMainActivity.class)
//				.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//		// 把一个Activity转换成一个View
//		Window w = yeargroup.getLocalActivityManager().startActivity(
//				"YearMainActivity", intent);
//		View view = w.getDecorView();
//		// 把View添加大ActivityGroup中
//		yeargroup.setContentView(view);
	}



}

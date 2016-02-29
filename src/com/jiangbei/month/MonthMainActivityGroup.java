package com.jiangbei.month;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
/**
 * 进度数据模块界面管理
 * */
public class MonthMainActivityGroup extends ActivityGroup {
	public static ActivityGroup monthgroup; // 一个静态的ActivityGroup变量，用于管理本Group中的Activity

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		monthgroup = this;
		
		//第一个显示的界面
		Intent intent = new Intent(this, MonthMainActivity.class)
				.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		// 把一个Activity转换成一个View
		Window w = monthgroup.getLocalActivityManager().startActivity(
				"MonthMainActivity", intent);
		View view = w.getDecorView();
		// 把View添加大ActivityGroup中
		monthgroup.setContentView(view);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed(); // 把后退事件交给子Activity处理
		monthgroup.getLocalActivityManager().getCurrentActivity().onBackPressed();
	}

	@Override
	protected void onResume() {

		super.onResume();
		// 把界面切换放到onResume方法中是因为，从其他选项卡切换回来时，
		// 调用搞得是onResume方法

		// 要跳转的界面
//		Intent intent = new Intent(this, MonthMainActivity.class)
//				.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//		// 把一个Activity转换成一个View
//		Window w = monthgroup.getLocalActivityManager().startActivity(
//				"MonthMainActivity", intent);
//		View view = w.getDecorView();
//		// 把View添加大ActivityGroup中
//		monthgroup.setContentView(view);
	}
	
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN ) {
			Intent intent = new Intent(MonthMainActivityGroup.this,
					MonthMainActivity.class)
			.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			// 把一个Activity转换成一个View
			Window w = MonthMainActivityGroup.monthgroup.getLocalActivityManager()
					.startActivity("MonthMainActivity", intent);
			View monthView = w.getDecorView();
			// 把View添加大ActivityGroup中
			MonthMainActivityGroup.monthgroup.setContentView(monthView);
			return false;
		}
		return super.dispatchKeyEvent(event);
	}


}

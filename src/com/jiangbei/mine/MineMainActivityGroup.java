package com.jiangbei.mine;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
/**
 * 我的数据模块界面管理
 * */
public class MineMainActivityGroup extends ActivityGroup {
	public static ActivityGroup minegroup; // 一个静态的ActivityGroup变量，用于管理本Group中的Activity

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		minegroup = this;
		//第一个显示的界面
		Intent intent = new Intent(this, MineMainActivity.class)
				.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		// 把一个Activity转换成一个View
		Window w = minegroup.getLocalActivityManager().startActivity(
				"MineMainActivity", intent);
		View view = w.getDecorView();
		// 把View添加大ActivityGroup中
		minegroup.setContentView(view);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed(); // 把后退事件交给子Activity处理
		minegroup.getLocalActivityManager().getCurrentActivity().onBackPressed();
	}

	@Override
	protected void onResume() {

		super.onResume();
		// 把界面切换放到onResume方法中是因为，从其他选项卡切换回来时，
		// 调用搞得是onResume方法

		// 要跳转的界面
//		Intent intent = new Intent(this, MineMainActivity.class)
//				.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//		// 把一个Activity转换成一个View
//		Window w = minegroup.getLocalActivityManager().startActivity(
//				"MineMainActivity", intent);
//		View view = w.getDecorView();
//		// 把View添加大ActivityGroup中
//		minegroup.setContentView(view);
	}



}

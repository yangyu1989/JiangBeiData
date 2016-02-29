package com.jiangbei.month;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
/**
 * ��������ģ��������
 * */
public class MonthMainActivityGroup extends ActivityGroup {
	public static ActivityGroup monthgroup; // һ����̬��ActivityGroup���������ڹ���Group�е�Activity

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		monthgroup = this;
		
		//��һ����ʾ�Ľ���
		Intent intent = new Intent(this, MonthMainActivity.class)
				.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		// ��һ��Activityת����һ��View
		Window w = monthgroup.getLocalActivityManager().startActivity(
				"MonthMainActivity", intent);
		View view = w.getDecorView();
		// ��View��Ӵ�ActivityGroup��
		monthgroup.setContentView(view);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed(); // �Ѻ����¼�������Activity����
		monthgroup.getLocalActivityManager().getCurrentActivity().onBackPressed();
	}

	@Override
	protected void onResume() {

		super.onResume();
		// �ѽ����л��ŵ�onResume����������Ϊ��������ѡ��л�����ʱ��
		// ���ø����onResume����

		// Ҫ��ת�Ľ���
//		Intent intent = new Intent(this, MonthMainActivity.class)
//				.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//		// ��һ��Activityת����һ��View
//		Window w = monthgroup.getLocalActivityManager().startActivity(
//				"MonthMainActivity", intent);
//		View view = w.getDecorView();
//		// ��View��Ӵ�ActivityGroup��
//		monthgroup.setContentView(view);
	}
	
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN ) {
			Intent intent = new Intent(MonthMainActivityGroup.this,
					MonthMainActivity.class)
			.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			// ��һ��Activityת����һ��View
			Window w = MonthMainActivityGroup.monthgroup.getLocalActivityManager()
					.startActivity("MonthMainActivity", intent);
			View monthView = w.getDecorView();
			// ��View��Ӵ�ActivityGroup��
			MonthMainActivityGroup.monthgroup.setContentView(monthView);
			return false;
		}
		return super.dispatchKeyEvent(event);
	}


}

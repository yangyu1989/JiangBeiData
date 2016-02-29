package com.jiangbei.year;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
/**
 * �������ģ��������
 * */
public class YearMainActivityGroup extends ActivityGroup {
	public static ActivityGroup yeargroup; // һ����̬��ActivityGroup���������ڹ���Group�е�Activity

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		yeargroup = this;
		//��һ����ʾ�Ľ���
		Intent intent = new Intent(this, YearMainActivity.class)
				.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		// ��һ��Activityת����һ��View
		Window w = yeargroup.getLocalActivityManager().startActivity(
				"YearMainActivity", intent);
		View view = w.getDecorView();
		// ��View��Ӵ�ActivityGroup��
		yeargroup.setContentView(view);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed(); // �Ѻ����¼�������Activity����
		yeargroup.getLocalActivityManager().getCurrentActivity().onBackPressed();
	}

	@Override
	protected void onResume() {

		super.onResume();
		// �ѽ����л��ŵ�onResume����������Ϊ��������ѡ��л�����ʱ��
		// ���ø����onResume����

		// Ҫ��ת�Ľ���
//		Intent intent = new Intent(this, YearMainActivity.class)
//				.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//		// ��һ��Activityת����һ��View
//		Window w = yeargroup.getLocalActivityManager().startActivity(
//				"YearMainActivity", intent);
//		View view = w.getDecorView();
//		// ��View��Ӵ�ActivityGroup��
//		yeargroup.setContentView(view);
	}



}

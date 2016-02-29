package com.jiangbei.news;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
/**
 * ���·���ģ��������
 * */
public class NewMainActivityGroup extends ActivityGroup {

	public static ActivityGroup newgroup; // һ����̬��ActivityGroup���������ڹ���Group�е�Activity

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stubo
		super.onCreate(savedInstanceState);
		newgroup = this;
		
		// Ҫ��ת�Ľ���
		Intent intent = new Intent(this, NewMainActivity.class)
		.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		// ��һ��Activityת����һ��View
		Window w = newgroup.getLocalActivityManager().startActivity(
				"NewMainActivity", intent);
		View view = w.getDecorView();
		// ��View��Ӵ�ActivityGroup��
		newgroup.setContentView(view);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed(); // �Ѻ����¼�������Activity����
		newgroup.getLocalActivityManager().getCurrentActivity().onBackPressed();
	}

	@Override
	protected void onResume() {

		super.onResume();
		// �ѽ����л��ŵ�onResume����������Ϊ��������ѡ��л�����ʱ��
		// ���ø����onResume����
		
		// Ҫ��ת�Ľ���
//		Intent intent = new Intent(this, NewMainActivity.class)
//		.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//		// ��һ��Activityת����һ��View
//		Window w = newgroup.getLocalActivityManager().startActivity(
//				"NewMainActivity", intent);
//		View view = w.getDecorView();
//		// ��View��Ӵ�ActivityGroup��
//		newgroup.setContentView(view);
		
	}
	

}

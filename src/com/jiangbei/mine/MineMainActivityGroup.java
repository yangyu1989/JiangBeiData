package com.jiangbei.mine;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
/**
 * �ҵ�����ģ��������
 * */
public class MineMainActivityGroup extends ActivityGroup {
	public static ActivityGroup minegroup; // һ����̬��ActivityGroup���������ڹ���Group�е�Activity

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		minegroup = this;
		//��һ����ʾ�Ľ���
		Intent intent = new Intent(this, MineMainActivity.class)
				.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		// ��һ��Activityת����һ��View
		Window w = minegroup.getLocalActivityManager().startActivity(
				"MineMainActivity", intent);
		View view = w.getDecorView();
		// ��View��Ӵ�ActivityGroup��
		minegroup.setContentView(view);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed(); // �Ѻ����¼�������Activity����
		minegroup.getLocalActivityManager().getCurrentActivity().onBackPressed();
	}

	@Override
	protected void onResume() {

		super.onResume();
		// �ѽ����л��ŵ�onResume����������Ϊ��������ѡ��л�����ʱ��
		// ���ø����onResume����

		// Ҫ��ת�Ľ���
//		Intent intent = new Intent(this, MineMainActivity.class)
//				.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//		// ��һ��Activityת����һ��View
//		Window w = minegroup.getLocalActivityManager().startActivity(
//				"MineMainActivity", intent);
//		View view = w.getDecorView();
//		// ��View��Ӵ�ActivityGroup��
//		minegroup.setContentView(view);
	}



}

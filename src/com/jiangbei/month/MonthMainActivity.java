package com.jiangbei.month;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;

import com.jiangbei.R;
import com.jiangbei.search.SearchMainActivity;

/**
 * ��������ģ��������
 * */
public class MonthMainActivity extends Activity {
	private ImageButton searchButton;
	private ListView listView_month;

	String[] titles = { "����������ֵ", "ũҵ", "��ҵ", "����ҵ", "��ͨ�����ʵ�ҵ", "��Դ����",
			"�̶��ʲ�Ͷ��", "���ز��г�", "����ó��", "���⾭��", "����", "����", "����������֧��",
			"���о������Ѽ۸�", "��ҵ�����߼۸�" };
	int[] resIds = { R.drawable.zt_dqsczz, R.drawable.zt_ny,
			R.drawable.zt_gsgy, R.drawable.zt_jzy, R.drawable.zt_jtysydy,
			R.drawable.zt_nyxf, R.drawable.zt_gdzctz, R.drawable.zt_fdcsc,
			R.drawable.zt_gnmy, R.drawable.zt_dwmy, R.drawable.zt_cz,
			R.drawable.zt_jr, R.drawable.zt_jmsr, R.drawable.zt_csjmxfjg,
			R.drawable.zt_gysczjg };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.month_activity);
		searchButton = (ImageButton) findViewById(R.id.month_title_SearchButton);
		listView_month = (ListView) findViewById(R.id.month_listView);

		MonthListViewAdapter adapter = new MonthListViewAdapter(this, titles,
				resIds);
		listView_month.setAdapter(adapter);

		setClickListener();// ���ü����¼�

	}

	/**
	 * �����¼�����
	 * */
	private void setClickListener() {
		// ������ť
		searchButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				// ���������ܽ���
				Intent intent = new Intent(MonthMainActivity.this,
						SearchMainActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// ��һ��Activityת����һ��View
				Window w = MonthMainActivityGroup.monthgroup
						.getLocalActivityManager().startActivity(
								"SearchActivity", intent);
				View searchView = w.getDecorView();
				// ��View��Ӵ�ActivityGroup��
				MonthMainActivityGroup.monthgroup.setContentView(searchView);

			}
		});
		// �������б�����Ӧ����������б�
		listView_month.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> partner, View view,
					int position, long id) {
				// �򿪶����б����
				Intent intent = new Intent(MonthMainActivity.this,
						MonthSecondActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// ��һ��Activityת����һ��View
				Window w = MonthMainActivityGroup.monthgroup
						.getLocalActivityManager().startActivity(
								"MonthSecondActivity", intent);
				View monthSecondView = w.getDecorView();
				// ��View��Ӵ�ActivityGroup��
				MonthMainActivityGroup.monthgroup
						.setContentView(monthSecondView);
			}
		});

	}

}

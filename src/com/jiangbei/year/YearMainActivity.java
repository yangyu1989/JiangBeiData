package com.jiangbei.year;

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
 * �������ģ��������
 * */
public class YearMainActivity extends Activity {
	private ImageButton searchButton;
	private ListView listView_year;
	String[] titles = { "����������ֵ(GDP)", "ũҵ", "��ҵ", "�̶��ʲ�Ͷ��", "���ز��г�", "����ó��",
			"���⾭��", "����", "����", "����������֧��", "���о������Ѽ۸�", "��ҵ�����߼۸�", "С��", "�˿�" };
	int[] resIds = { R.drawable.zt_dqsczz, R.drawable.zt_ny,
			R.drawable.zt_gsgy, R.drawable.zt_gdzctz, R.drawable.zt_fdcsc,
			R.drawable.zt_gnmy, R.drawable.zt_dwmy, R.drawable.zt_cz,
			R.drawable.zt_jr, R.drawable.zt_jmsr, R.drawable.zt_csjmxfjg,
			R.drawable.zt_gysczjg, R.drawable.zt_xk, R.drawable.zt_rk };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.year_activity);
		searchButton = (ImageButton) findViewById(R.id.year_title_SearchButton);
		listView_year = (ListView) findViewById(R.id.year_listView);
		YearListViewAdapter adapter = new YearListViewAdapter(this, titles,
				resIds);
		listView_year.setAdapter(adapter);
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
				Intent intent = new Intent(YearMainActivity.this,
						SearchMainActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// ��һ��Activityת����һ��View
				Window w = YearMainActivityGroup.yeargroup
						.getLocalActivityManager().startActivity(
								"SearchActivity", intent);
				View searchView = w.getDecorView();
				// ��View��Ӵ�ActivityGroup��
				YearMainActivityGroup.yeargroup.setContentView(searchView);

			}
		});
		// ��������б�ť
		listView_year.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> partner, View view,
					int position, long id) {

				// TODO Auto-generated method stub
				// �򿪶����б����
				Intent intent = new Intent(YearMainActivity.this,
						YearSecondActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// ��һ��Activityת����һ��View
				Window w = YearMainActivityGroup.yeargroup
						.getLocalActivityManager().startActivity(
								"YearSecondActivity", intent);
				View yearSecondView = w.getDecorView();
				// ��View��Ӵ�ActivityGroup��
				YearMainActivityGroup.yeargroup.setContentView(yearSecondView);

			}
		});

	}
}

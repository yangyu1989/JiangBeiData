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
 * 进度数据模块主界面
 * */
public class MonthMainActivity extends Activity {
	private ImageButton searchButton;
	private ListView listView_month;

	String[] titles = { "地区生产总值", "农业", "工业", "建筑业", "交通运输邮电业", "能源消费",
			"固定资产投资", "房地产市场", "国内贸易", "对外经济", "财政", "金融", "居民收入与支出",
			"城市居民消费价格", "工业生产者价格" };
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

		setClickListener();// 设置监听事件

	}

	/**
	 * 监听事件集合
	 * */
	private void setClickListener() {
		// 搜索按钮
		searchButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				// 打开搜索功能界面
				Intent intent = new Intent(MonthMainActivity.this,
						SearchMainActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// 把一个Activity转换成一个View
				Window w = MonthMainActivityGroup.monthgroup
						.getLocalActivityManager().startActivity(
								"SearchActivity", intent);
				View searchView = w.getDecorView();
				// 把View添加大ActivityGroup中
				MonthMainActivityGroup.monthgroup.setContentView(searchView);

			}
		});
		// 分类类列表点击响应，进入二级列表
		listView_month.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> partner, View view,
					int position, long id) {
				// 打开二级列表界面
				Intent intent = new Intent(MonthMainActivity.this,
						MonthSecondActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// 把一个Activity转换成一个View
				Window w = MonthMainActivityGroup.monthgroup
						.getLocalActivityManager().startActivity(
								"MonthSecondActivity", intent);
				View monthSecondView = w.getDecorView();
				// 把View添加大ActivityGroup中
				MonthMainActivityGroup.monthgroup
						.setContentView(monthSecondView);
			}
		});

	}

}

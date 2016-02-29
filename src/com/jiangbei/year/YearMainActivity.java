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
 * 年度数据模块主界面
 * */
public class YearMainActivity extends Activity {
	private ImageButton searchButton;
	private ListView listView_year;
	String[] titles = { "地区生产总值(GDP)", "农业", "工业", "固定资产投资", "房地产市场", "国内贸易",
			"对外经济", "财政", "金融", "居民收入与支出", "城市居民消费价格", "工业生产者价格", "小康", "人口" };
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
				Intent intent = new Intent(YearMainActivity.this,
						SearchMainActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// 把一个Activity转换成一个View
				Window w = YearMainActivityGroup.yeargroup
						.getLocalActivityManager().startActivity(
								"SearchActivity", intent);
				View searchView = w.getDecorView();
				// 把View添加大ActivityGroup中
				YearMainActivityGroup.yeargroup.setContentView(searchView);

			}
		});
		// 进入二级列表按钮
		listView_year.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> partner, View view,
					int position, long id) {

				// TODO Auto-generated method stub
				// 打开二级列表界面
				Intent intent = new Intent(YearMainActivity.this,
						YearSecondActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// 把一个Activity转换成一个View
				Window w = YearMainActivityGroup.yeargroup
						.getLocalActivityManager().startActivity(
								"YearSecondActivity", intent);
				View yearSecondView = w.getDecorView();
				// 把View添加大ActivityGroup中
				YearMainActivityGroup.yeargroup.setContentView(yearSecondView);

			}
		});

	}
}

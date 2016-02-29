package com.jiangbei.mine;

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
import com.jiangbei.detail.DetailMainActivity;
import com.jiangbei.search.SearchMainActivity;
/**
 * 我的数据模块主界面
 * */
public class MineMainActivity extends Activity {
	private ImageButton searchButton;
	private String[][] ss =new String[][]{
			{"地区生产总值","地区生产总值 >地区生产总值"},{"煤炭消费量","能源消费 >煤炭"},{"第一产业","地区生产总值 >按产业分"},{"施工面积","房地产市场 >施工面积"}
	};

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_activity);
        searchButton = (ImageButton) findViewById(R.id.mine_title_SearchButton);
        setClickListener();// 设置监听事件
     
		ListView listView =(ListView) findViewById(R.id.mine_listView);
//		ArrayAdapter<String> adapter =new ArrayAdapter<String>(
//				this, android.R.layout.simple_list_item_1, ss);
		
		MineMainAdapter  adapter =new MineMainAdapter(this,ss);
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent();
				intent.setClass(MineMainActivity.this, DetailMainActivity.class);
				startActivity(intent);
			}
		});
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
				Intent intent = new Intent(MineMainActivity.this,
						SearchMainActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// 把一个Activity转换成一个View
				Window w = MineMainActivityGroup.minegroup.getLocalActivityManager()
						.startActivity("SearchActivity", intent);
				View searchView = w.getDecorView();
				// 把View添加大ActivityGroup中
				MineMainActivityGroup.minegroup.setContentView(searchView);
				
			}
		});
	}
	
}

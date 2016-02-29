package com.jiangbei.year;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageButton;

import com.jiangbei.R;
import com.jiangbei.detail.DetailMainActivity;
import com.jiangbei.search.SearchMainActivity;
/**
 * 年度数据模块二级列表界面
 * */
public class YearSecondActivity extends Activity {
	private ImageButton searchButton,rebackButton;
	private ExpandableListView yearSecondListView;
	private YearSecondAdapter yearSecondAdapter;
	private List<String> group_list;
	private List<List<String>> item_list;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.year_second_activity);
        rebackButton = (ImageButton) findViewById(R.id.year_second_title_RebackButton);
        searchButton = (ImageButton) findViewById(R.id.year_second_title_SearchButton);
        yearSecondListView = (ExpandableListView) findViewById(R.id.year_seconde_expendList);
        
      //测试数据父表
        group_list = new ArrayList<String>();
        group_list.add("地区生产总值");
        group_list.add("按产业分");
        group_list.add("按行业分");
        group_list.add("按行业分占比");
        group_list.add("人均GDP");
        group_list.add("非公经济");
      //测试数据子表
        item_list = new ArrayList<List<String>>();
        List<String> oneList = new ArrayList<String>();
        oneList.add("地区生产总值(GDP)");
        item_list.add(oneList);
        List<String> twoList = new ArrayList<String>();
        twoList.add("第一产业");
        twoList.add("第二产业");
        twoList.add("第三产业");
        item_list.add(twoList);
        List<String> threeList = new ArrayList<String>();
        threeList.add("工业");
        threeList.add("建筑业");
        threeList.add("交通运输、仓储和邮政业");
        threeList.add("批发和零售业");
        threeList.add("住宿和餐饮业");
        threeList.add("金融业");
        threeList.add("房地产业");
        threeList.add("其他服务业");
        item_list.add(threeList);
        List<String> fourList = new ArrayList<String>();
        fourList.add("第一产业");
        fourList.add("第二产业");
        fourList.add("第三产业");
        item_list.add(fourList);
        List<String> fiveList = new ArrayList<String>();
        fiveList.add("人均GDP");
        fiveList.add("人均GDP(美元)");
        item_list.add(fiveList);
        List<String> sixeList = new ArrayList<String>();
        sixeList.add("非公经济增加值");
        sixeList.add("#民营经济");
        sixeList.add("#外商、港澳台经济");
        sixeList.add("非公经济占比");
        item_list.add(sixeList);
        //二级列表适配
        yearSecondListView.setGroupIndicator(null);//去掉列表左边自带的箭头
        yearSecondAdapter = new YearSecondAdapter(this, group_list, item_list);
        yearSecondListView.setAdapter(yearSecondAdapter);
        
		setClickListener();// 设置监听事件
    } 
	
	/** 
	 * 监听事件集合
	 * */
	private void setClickListener() {
		// 回退按钮
		rebackButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				// 打开打开上一级界面
				Intent intent = new Intent(YearSecondActivity.this,
						YearMainActivity.class)
				.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// 把一个Activity转换成一个View
				Window w = YearMainActivityGroup.yeargroup.getLocalActivityManager()
						.startActivity("YearMainActivity", intent);
				View yearView = w.getDecorView();
				// 把View添加大ActivityGroup中
				YearMainActivityGroup.yeargroup.setContentView(yearView);
			}
		});
		// 搜索按钮
		searchButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				// 打开搜索功能界面
				Intent intent = new Intent(YearSecondActivity.this,
						SearchMainActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// 把一个Activity转换成一个View
				Window w = YearMainActivityGroup.yeargroup.getLocalActivityManager()
						.startActivity("SearchActivity", intent);
				View searchView = w.getDecorView();
				// 把View添加大ActivityGroup中
				YearMainActivityGroup.yeargroup.setContentView(searchView);
			}
		});
		//二级列表界面子item响应
		yearSecondListView.setOnChildClickListener(new OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView partner, View view,
					int groupPosition, int childPosition, long id) {
				// 打开详细信息界面 
				Intent intent = new Intent(YearSecondActivity.this, DetailMainActivity.class);
				startActivity(intent);
				return false;
			}
		});
		
	}
	

}

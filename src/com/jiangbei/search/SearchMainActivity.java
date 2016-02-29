package com.jiangbei.search;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.jiangbei.R;
import com.jiangbei.detail.DetailMainActivity;
import com.jiangbei.main.MainActivity;
/**
 * 查询功能界面
 * */
public class SearchMainActivity extends Activity {
	
	private String[] ss =new String[]{
			"地区生产总值(GDP)","地区生产总值","全劳动生产率","生产量","生产资料" 
	};
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
     
        
        //初始化底部标签栏
        MainActivity.clearBar();
         
        ListView listView =(ListView) findViewById(R.id.search_title_listView1);
//        ArrayAdapter<String> adapter =new ArrayAdapter<String>(
//        		this,android.R.layout.simple_list_item_1,ss);
        SearchMainAdapter  adapter =new SearchMainAdapter(this,ss);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				Intent intent= new Intent();
				intent.setClass(SearchMainActivity.this, DetailMainActivity.class);
				startActivity(intent);
				
			}
		});
    }
}

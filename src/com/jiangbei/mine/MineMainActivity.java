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
 * �ҵ�����ģ��������
 * */
public class MineMainActivity extends Activity {
	private ImageButton searchButton;
	private String[][] ss =new String[][]{
			{"����������ֵ","����������ֵ >����������ֵ"},{"ú̿������","��Դ���� >ú̿"},{"��һ��ҵ","����������ֵ >����ҵ��"},{"ʩ�����","���ز��г� >ʩ�����"}
	};

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_activity);
        searchButton = (ImageButton) findViewById(R.id.mine_title_SearchButton);
        setClickListener();// ���ü����¼�
     
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
	 * �����¼�����
	 * */
	private void setClickListener() {
		// ������ť
		searchButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				// ���������ܽ���
				Intent intent = new Intent(MineMainActivity.this,
						SearchMainActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// ��һ��Activityת����һ��View
				Window w = MineMainActivityGroup.minegroup.getLocalActivityManager()
						.startActivity("SearchActivity", intent);
				View searchView = w.getDecorView();
				// ��View��Ӵ�ActivityGroup��
				MineMainActivityGroup.minegroup.setContentView(searchView);
				
			}
		});
	}
	
}

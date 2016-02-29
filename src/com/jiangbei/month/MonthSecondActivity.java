package com.jiangbei.month;

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
 * ��������ģ������б����
 * */
public class MonthSecondActivity extends Activity {
	private ImageButton searchButton,rebackButton;
	private ExpandableListView monthSecondListView;
	private MonthSecondAdapter monthSecondAdapter;
	private List<String> group_list;
	private List<List<String>> item_list;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.month_second_activity);
        rebackButton = (ImageButton) findViewById(R.id.month_second_title_RebackButton);
        searchButton = (ImageButton) findViewById(R.id.month_second_title_SearchButton);
        monthSecondListView = (ExpandableListView) findViewById(R.id.month_seconde_expendList);
        
      //�������ݸ���
        group_list = new ArrayList<String>();
        group_list.add("����������ֵ");
        group_list.add("����ҵ��");
        group_list.add("����ҵ��");
        group_list.add("�������Ʒ�");
      //���������ӱ�
        item_list = new ArrayList<List<String>>();
        List<String> oneList = new ArrayList<String>();
        oneList.add("����������ֵ");
        item_list.add(oneList);
        List<String> twoList = new ArrayList<String>();
        twoList.add("��һ��ҵ");
        twoList.add("�ڶ���ҵ");
        twoList.add("������ҵ");
        item_list.add(twoList);
        List<String> threeList = new ArrayList<String>();
        threeList.add("��ҵ");
        threeList.add("����ҵ");
        threeList.add("��ͨ���䡢�ִ�������ҵ");
        threeList.add("����������ҵ");
        threeList.add("ס�޺Ͳ���ҵ");
        threeList.add("����ҵ");
        threeList.add("���ز�ҵ");
        threeList.add("��������ҵ");
        threeList.add("ũ���������ҵ");
        item_list.add(threeList);
        List<String> fourList = new ArrayList<String>();
        fourList.add("���о���");
        fourList.add("�ǹ��о���");
        fourList.add("���⾭��");
        fourList.add("���̸۰�̨����");
        item_list.add(fourList);
        //�����б�����
        monthSecondListView.setGroupIndicator(null);//ȥ���б�����Դ��ļ�ͷ
        monthSecondAdapter = new MonthSecondAdapter(this, group_list, item_list);
        monthSecondListView.setAdapter(monthSecondAdapter);
        
		setClickListener();// ���ü����¼�
    } 
	
	/** 
	 * �����¼�����
	 * */
	private void setClickListener() {
		// ���˰�ť
		rebackButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				// ����һ������
				Intent intent = new Intent(MonthSecondActivity.this,
						MonthMainActivity.class)
				.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// ��һ��Activityת����һ��View
				Window w = MonthMainActivityGroup.monthgroup.getLocalActivityManager()
						.startActivity("MonthMainActivity", intent);
				View monthView = w.getDecorView();
				// ��View��Ӵ�ActivityGroup��
				MonthMainActivityGroup.monthgroup.setContentView(monthView);
			}
		});
		// ������ť
		searchButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				// ���������ܽ���
				Intent intent = new Intent(MonthSecondActivity.this,
						SearchMainActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// ��һ��Activityת����һ��View
				Window w = MonthMainActivityGroup.monthgroup.getLocalActivityManager()
						.startActivity("SearchActivity", intent);
				View searchView = w.getDecorView();
				// ��View��Ӵ�ActivityGroup��
				MonthMainActivityGroup.monthgroup.setContentView(searchView);
			}
		});
		//�����б������item��Ӧ
		monthSecondListView.setOnChildClickListener(new OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView partner, View view,
					int groupPosition, int childPosition, long id) {
				// ����ϸ��Ϣ���� 
				Intent intent = new Intent(MonthSecondActivity.this, DetailMainActivity.class);
				startActivity(intent);
				return false;
			}
		});
		
	}
	

}

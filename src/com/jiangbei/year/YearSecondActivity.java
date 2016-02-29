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
 * �������ģ������б����
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
        
      //�������ݸ���
        group_list = new ArrayList<String>();
        group_list.add("����������ֵ");
        group_list.add("����ҵ��");
        group_list.add("����ҵ��");
        group_list.add("����ҵ��ռ��");
        group_list.add("�˾�GDP");
        group_list.add("�ǹ�����");
      //���������ӱ�
        item_list = new ArrayList<List<String>>();
        List<String> oneList = new ArrayList<String>();
        oneList.add("����������ֵ(GDP)");
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
        item_list.add(threeList);
        List<String> fourList = new ArrayList<String>();
        fourList.add("��һ��ҵ");
        fourList.add("�ڶ���ҵ");
        fourList.add("������ҵ");
        item_list.add(fourList);
        List<String> fiveList = new ArrayList<String>();
        fiveList.add("�˾�GDP");
        fiveList.add("�˾�GDP(��Ԫ)");
        item_list.add(fiveList);
        List<String> sixeList = new ArrayList<String>();
        sixeList.add("�ǹ���������ֵ");
        sixeList.add("#��Ӫ����");
        sixeList.add("#���̡��۰�̨����");
        sixeList.add("�ǹ�����ռ��");
        item_list.add(sixeList);
        //�����б�����
        yearSecondListView.setGroupIndicator(null);//ȥ���б�����Դ��ļ�ͷ
        yearSecondAdapter = new YearSecondAdapter(this, group_list, item_list);
        yearSecondListView.setAdapter(yearSecondAdapter);
        
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
				// �򿪴���һ������
				Intent intent = new Intent(YearSecondActivity.this,
						YearMainActivity.class)
				.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// ��һ��Activityת����һ��View
				Window w = YearMainActivityGroup.yeargroup.getLocalActivityManager()
						.startActivity("YearMainActivity", intent);
				View yearView = w.getDecorView();
				// ��View��Ӵ�ActivityGroup��
				YearMainActivityGroup.yeargroup.setContentView(yearView);
			}
		});
		// ������ť
		searchButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				// ���������ܽ���
				Intent intent = new Intent(YearSecondActivity.this,
						SearchMainActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// ��һ��Activityת����һ��View
				Window w = YearMainActivityGroup.yeargroup.getLocalActivityManager()
						.startActivity("SearchActivity", intent);
				View searchView = w.getDecorView();
				// ��View��Ӵ�ActivityGroup��
				YearMainActivityGroup.yeargroup.setContentView(searchView);
			}
		});
		//�����б������item��Ӧ
		yearSecondListView.setOnChildClickListener(new OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView partner, View view,
					int groupPosition, int childPosition, long id) {
				// ����ϸ��Ϣ���� 
				Intent intent = new Intent(YearSecondActivity.this, DetailMainActivity.class);
				startActivity(intent);
				return false;
			}
		});
		
	}
	

}

package com.jiangbei.news;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.jiangbei.R;
import com.jiangbei.search.SearchMainActivity;
import com.jiangbei.util.HttpThread;
import com.jiangbei.util.JBAddress.HttpHandleAddress;
import com.jiangbei.util.JBAddress.HttpHandleType;
import com.jiangbei.util.JBReadJSON;
import com.jiangbei.vo.IndicatorVO;

/**
 * ���·���ģ��������
 * */
public class NewMainActivity extends Activity {
	private ImageButton searchButton;
	private ListView newsListView;
	private NewListViewAdapter newListViewAdapter;
	private List<IndicatorVO> newsList;
	private String ss[] ={
			"��ҵͶ�ʶ��Ԫ��",			"���ز�����Ͷ�ʶ��Ԫ��",
			"�������Ʒ�����ܶ��Ԫ��",	"ʵ���������ʽ���Ԫ��",
			"��������Ԥ�����루��Ԫ��",		"˰�����루��Ԫ��",
			"��������Ԥ��֧������Ԫ��",		"��һ��ҵ����ֵ����Ԫ��",
			"�ڶ���ҵ����ֵ����Ԫ��",		"��ҵ����ֵ����Ԫ��",
	};
	
	private String[] dd={
			"865.3",	"16.35",
			"125.34",	"46.45",
			"45.46",	"22.11",
			"33.1",		"898.3",
			"11.3",		"22.5",
	};
	private String[]count ={
			"11.34%",	"24%",
			"13.5%",	"123%",
			"14.3%",	"354.5%",
			"253%",		"144%",
			"123%",		"13.89%"
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_activity);
		searchButton = (ImageButton) findViewById(R.id.new_title_SearchButton);
		setClickListener();// ���ü����¼�
		
		newsListView =(ListView) findViewById(R.id.new_title_listView);
		//���ݲ���
		//�򿪷����������߳�
		NewsListRefreshHandler newsListRefreshHandler = new NewsListRefreshHandler(NewMainActivity.this);
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("username", ""));
		params.add(new BasicNameValuePair("password", ""));
		HttpThread httpThread = new HttpThread(newsListRefreshHandler,
				HttpHandleType.NEWSLIST, params, NewMainActivity.this.getParent());
		String URL = HttpHandleAddress.IP_PORT + HttpHandleAddress.NEWS_LIST;
		httpThread.doStart(URL);
		
		/*newsList = new ArrayList<IndicatorVO>();
		for(int i=0;i<ss.length;i++){
			IndicatorVO oneVO = new IndicatorVO();
			oneVO.setName(ss[i]);
			oneVO.setValue(dd[i]);
			oneVO.setPercent(count[i]);
			newsList.add(oneVO);
		}
		//���·����б���ʾ
		newListViewAdapter = new NewListViewAdapter(this, newsList);
		newsListView.setAdapter(newListViewAdapter);
		*/
		
		
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
				Intent intent = new Intent(NewMainActivity.this,
						SearchMainActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.putExtra("Group", "New");
				// ��һ��Activityת����һ��View
				Window w = NewMainActivityGroup.newgroup.getLocalActivityManager()
						.startActivity("SearchActivity", intent);
				View searchView = w.getDecorView();
				// ��View��Ӵ�ActivityGroup��
				NewMainActivityGroup.newgroup.setContentView(searchView);
				
			}
		});
	}
	
	/**
	 * ˢ�¼��ع����м��߳�
	 * */
	public class NewsListRefreshHandler extends Handler {
		Context mContext;
		String result;
		public NewsListRefreshHandler(Context mContext ) {
			this.mContext = mContext;
		}
		
		@Override
		public void handleMessage(Message message) {
			result = message.getData().getString("result");
			if(result== null || result.equals("") ){
				Toast.makeText(mContext, "�������ӳ���", Toast.LENGTH_LONG).show();
			}else{
				System.out.println("NewsListRefreshHandler:"+result);
				//��������
				Vector vector = JBReadJSON.readJSON(result, new IndicatorVO());
				newsList = new ArrayList<IndicatorVO>();
				if(vector.size() >0){
					for(int i=0;i<vector.size();i++){
						newsList.add((IndicatorVO)vector.get(i));
					}
				}
				//�����б���ʾ
				newListViewAdapter = new NewListViewAdapter(mContext, newsList);
				newsListView.setAdapter(newListViewAdapter);
			}
		} 
	}

}

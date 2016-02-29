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
 * 最新发布模块主界面
 * */
public class NewMainActivity extends Activity {
	private ImageButton searchButton;
	private ListView newsListView;
	private NewListViewAdapter newListViewAdapter;
	private List<IndicatorVO> newsList;
	private String ss[] ={
			"工业投资额（亿元）",			"房地产开发投资额（亿元）",
			"社会消费品零售总额（亿元）",	"实际利用内资金额（亿元）",
			"公共财政预算收入（亿元）",		"税收收入（亿元）",
			"公共财政预算支出（亿元）",		"第一产业增加值（亿元）",
			"第二产业增加值（亿元）",		"工业增加值（亿元）",
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
		setClickListener();// 设置监听事件
		
		newsListView =(ListView) findViewById(R.id.new_title_listView);
		//数据操作
		//打开服务器交互线程
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
		//最新发布列表显示
		newListViewAdapter = new NewListViewAdapter(this, newsList);
		newsListView.setAdapter(newListViewAdapter);
		*/
		
		
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
				Intent intent = new Intent(NewMainActivity.this,
						SearchMainActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.putExtra("Group", "New");
				// 把一个Activity转换成一个View
				Window w = NewMainActivityGroup.newgroup.getLocalActivityManager()
						.startActivity("SearchActivity", intent);
				View searchView = w.getDecorView();
				// 把View添加大ActivityGroup中
				NewMainActivityGroup.newgroup.setContentView(searchView);
				
			}
		});
	}
	
	/**
	 * 刷新加载功能中间线程
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
				Toast.makeText(mContext, "网络连接出错！", Toast.LENGTH_LONG).show();
			}else{
				System.out.println("NewsListRefreshHandler:"+result);
				//解析参数
				Vector vector = JBReadJSON.readJSON(result, new IndicatorVO());
				newsList = new ArrayList<IndicatorVO>();
				if(vector.size() >0){
					for(int i=0;i<vector.size();i++){
						newsList.add((IndicatorVO)vector.get(i));
					}
				}
				//需求列表显示
				newListViewAdapter = new NewListViewAdapter(mContext, newsList);
				newsListView.setAdapter(newListViewAdapter);
			}
		} 
	}

}

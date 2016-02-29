package com.jiangbei.news;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jiangbei.R;
import com.jiangbei.vo.IndicatorVO;

public class NewListViewAdapter extends BaseAdapter{
			
	private List<IndicatorVO> newsLis;
	private LayoutInflater mInflater;
	
	public NewListViewAdapter(Context context,List<IndicatorVO> mNewsList){
		mInflater = LayoutInflater.from(context);   //创建视图容器并设置上下文   
        this.newsLis = mNewsList;   
	}

	@Override
	public int getCount() {
		return newsLis.size();
	}

	@Override
	public Object getItem(int position) {
		return newsLis.get(position);
	} 

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		NewsItem newsItem;
		if (convertView==null || convertView.getTag(R.id.news_list_item_layout) == null) {
			 newsItem=new NewsItem();
			 convertView = mInflater.inflate(R.layout.new_activity_item, null);
			 newsItem.itemName =  (TextView) convertView.findViewById(R.id.new_list_item_name);
			 newsItem.itemValue =  (TextView) convertView.findViewById(R.id.new_list_item_num);
			 newsItem.itemPercent =  (TextView) convertView.findViewById(R.id.new_list_item_count);
		}else{
			newsItem = (NewsItem) convertView.getTag(R.id.news_list_item_layout);
		}
		newsItem.itemName.setText(newsLis.get(position).getName());
		newsItem.itemValue.setText(newsLis.get(position).getValue());
		newsItem.itemPercent.setText("+"+newsLis.get(position).getPercent());
		
		return convertView;
	}

	private class NewsItem{
		TextView itemName,itemValue,itemPercent;
	}
	
}

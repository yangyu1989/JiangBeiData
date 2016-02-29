package com.jiangbei.year;

import com.jiangbei.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class YearListViewAdapter extends BaseAdapter {
	
	private String[] titles;
	private int[] resIds;
	private LayoutInflater mInflater;
	
	public YearListViewAdapter(Context context,String[] titles,int[] resIds){
		           
		mInflater = LayoutInflater.from(context);   //创建视图容器并设置上下文   
        this.titles = titles;   
        this.resIds = resIds; 
	}

	@Override
	public int getCount() {
		return titles.length;
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		YearItem yearItem=null;
		if (convertView==null) {
			convertView=mInflater.inflate(R.layout.year_list_item, null);
			yearItem=new YearItem();
			yearItem.itemImage=(ImageView) convertView.findViewById(R.id.year_list_resIds);
			yearItem.itemName=(TextView) convertView.findViewById(R.id.yeaer_list_titles);
			convertView.setTag(yearItem);
		}else {
			yearItem=(YearItem) convertView.getTag();
		}
		
		yearItem.itemImage.setImageResource(resIds[position]); 
		yearItem.itemName.setText(titles[position]);
		return convertView;
	}
	
	public class YearItem{
		TextView itemName;
		ImageView itemImage;
	}
}

package com.jiangbei.month;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiangbei.R;

public class MonthListViewAdapter extends BaseAdapter{
			
	private String[] titles;
	private int[] resIds;
	private LayoutInflater mInflater;
	
	public MonthListViewAdapter(Context context,String[] titles,int[] resIds){
		           
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
		
		MonthItem monthItem=null;
		if (convertView==null) {
			 convertView = mInflater.inflate(R.layout.month_list_item, null);
			 monthItem=new MonthItem();
			 monthItem.itemImage =  (ImageView) convertView.findViewById(R.id.month_list_resIds); 
			 monthItem.itemName =  (TextView) convertView.findViewById(R.id.month_list_titles);
			 convertView.setTag(monthItem);  
		}else{
			monthItem = (MonthItem) convertView.getTag();
		}
		monthItem.itemImage.setImageResource(resIds[position]); 
		monthItem.itemName.setText(titles[position]);
		return convertView;
	}

	public class MonthItem{
		TextView itemName;
		ImageView itemImage;
	}
	
}

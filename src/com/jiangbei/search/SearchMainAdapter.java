package com.jiangbei.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jiangbei.R;

public class SearchMainAdapter extends BaseAdapter {
	private Context context;
	private String ss[];
	private LayoutInflater mInflater;
	
	public SearchMainAdapter(Context context, String[] ss) {
		super();
		this.ss = ss;
		this.context = context;
		mInflater = LayoutInflater.from(context);   //创建视图容器并设置上下文
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return ss.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		MineItem mineItem=null;
		if (convertView==null) {
			 convertView = mInflater.inflate(R.layout.search_list_item, null);
			 mineItem=new MineItem();
			 mineItem.itemName =  (TextView) convertView.findViewById(R.id.search_list_item_name); 
			 convertView.setTag(mineItem);  
		}else{
			mineItem = (MineItem) convertView.getTag();
		}
		mineItem.itemName.setText(ss[position]); 
		return convertView;
		
	}
	
	public class MineItem{
		TextView itemName;
	}
}

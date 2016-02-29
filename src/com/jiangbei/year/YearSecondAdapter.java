package com.jiangbei.year;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiangbei.R;

public class YearSecondAdapter extends BaseExpandableListAdapter {
	private Context context;
	private LayoutInflater mInflater;
	private List<String> group_list;
	private List<List<String>> item_list;

	public YearSecondAdapter(Context mcontext,List<String> mgroup_list,List<List<String>> mitem_list) {
		this.context = mcontext;
		this.group_list = mgroup_list;
		this.item_list = mitem_list;
		this.mInflater = LayoutInflater.from(context);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return item_list.get(groupPosition).get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return item_list.get(groupPosition).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return group_list.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return group_list.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
		    View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		GroupHolder groupHolder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.year_second_list_item_group, null);
			groupHolder = new GroupHolder();
			groupHolder.groupName = (TextView) convertView.findViewById(R.id.year_second_list_item_group_name);
			groupHolder.groupImg = (ImageView) convertView .findViewById(R.id.year_second_list_item_group_image);
			convertView.setTag(groupHolder);
		} else {
			groupHolder = (GroupHolder) convertView.getTag();
		}
		groupHolder.groupName.setText(group_list.get(groupPosition));
		//右边箭头控制
		if(!isExpanded){ //是否点击
			groupHolder.groupImg.setBackgroundResource(R.drawable.expandlist_normal);
		}else{
			groupHolder.groupImg.setBackgroundResource(R.drawable.expandlist_press);
		}
		return convertView;
	}
	
	@Override
	public View getChildView(int groupPosition, int childPosition,
		    boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		SonHolder sonHolder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.year_second_list_item_son, null);
			sonHolder = new SonHolder();
			sonHolder.sonName = (TextView) convertView.findViewById(R.id.year_second_list_item_son_name);
			convertView.setTag(sonHolder);
		} else {
			sonHolder = (SonHolder) convertView.getTag();
		}
		sonHolder.sonName.setText(item_list.get(groupPosition).get(childPosition));
		return convertView;
	}
	
	private class GroupHolder {
		public TextView groupName;
		public ImageView groupImg;
	}
	
	private class SonHolder {
		public TextView sonName;
	}

}

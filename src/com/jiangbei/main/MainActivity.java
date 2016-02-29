package com.jiangbei.main;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabWidget;

import com.jiangbei.R;
import com.jiangbei.mine.MineMainActivity;
import com.jiangbei.mine.MineMainActivityGroup;
import com.jiangbei.month.MonthMainActivity;
import com.jiangbei.month.MonthMainActivityGroup;
import com.jiangbei.more.MoreMainActivity;
import com.jiangbei.news.NewMainActivity;
import com.jiangbei.news.NewMainActivityGroup;
import com.jiangbei.year.YearMainActivity;
import com.jiangbei.year.YearMainActivityGroup;
/**
 * 系统主框架Tab界面
 * */

public class MainActivity extends TabActivity {
	private TabHost mTabHost;
	public static TabWidget mTabWidget;
	public static MainActivity mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        mainActivity = this;
        initTabView();// 设置Tab界面
    }

	/**
     * Tab标签界面设置
     * */
    private void initTabView() {
    	mTabHost = getTabHost();
    	//最新发布标签界面
    	mTabHost.addTab(mTabHost.newTabSpec("new_tab")
				.setIndicator("",getResources().getDrawable(R.drawable.main_one_normal))
				.setContent(new Intent(MainActivity.this,NewMainActivityGroup.class)));
    	//进度数据标签界面
    	mTabHost.addTab(mTabHost.newTabSpec("month_tab")
				.setIndicator("",getResources().getDrawable(R.drawable.main_two_normal))
				.setContent(new Intent(MainActivity.this,MonthMainActivityGroup.class)));
    	//年度数据标签界面
    	mTabHost.addTab(mTabHost.newTabSpec("year_tab")
				.setIndicator("",getResources().getDrawable(R.drawable.main_three_normal))
				.setContent(new Intent(MainActivity.this,YearMainActivityGroup.class)));
    	//我的数据标签界面
    	mTabHost.addTab(mTabHost.newTabSpec("mine_tab")
				.setIndicator("",getResources().getDrawable(R.drawable.main_four_normal))
				.setContent(new Intent(MainActivity.this,MineMainActivityGroup.class)));
    	//更多标签界面
    	mTabHost.addTab(mTabHost.newTabSpec("more_tab")
				.setIndicator("",getResources().getDrawable(R.drawable.main_five_normal))
				.setContent(new Intent(MainActivity.this,MoreMainActivity.class)));
    	//标签栏特效设置
    	mTabWidget =  mTabHost.getTabWidget();
		mTabWidget.setStripEnabled(false);//标签栏底部的分隔线是否绘制
//		mTabWidget.getLayoutParams().height = 80;
		for(int i=0;i<mTabWidget.getChildCount();i++){
//			mTabWidget.getChildAt(i).getLayoutParams().height = 80;
			mTabWidget.getChildAt(i).setBackgroundResource(R.drawable.tab_button_back);
//			final TextView tv = (TextView) mTabWidget.getChildAt(i).findViewById(android.R.id.title);
//			tv.setTextColor(getResources().getColorStateList(android.R.color.black));
//			tv.setTextSize(15);
		}
		// 设置当前显示哪个标签
	    mTabHost.setCurrentTab(0);
	    ImageView oneImage = (ImageView)mTabWidget.getChildAt(0).findViewById(android.R.id.icon);//获取控件imageView 
		oneImage .setImageDrawable(getResources().getDrawable(R.drawable.main_one_press)); //改变我们需要的图标
		
	    // 标签切换事件处理，setOnTabChangedListener
	    mTabHost.setOnTabChangedListener(new OnTabChangeListener() {
	    	
	    	public void onTabChanged(String tabSpec) {
	    		//初始化标签图片
	    		ImageView oneImage = (ImageView)mTabWidget.getChildAt(0).findViewById(android.R.id.icon);//获取控件imageView 
	    		oneImage .setImageDrawable(getResources().getDrawable(R.drawable.main_one_normal)); //改变我们需要的图标
	    		ImageView twoImage = (ImageView)mTabWidget.getChildAt(1).findViewById(android.R.id.icon);//获取控件imageView 
	    		twoImage .setImageDrawable(getResources().getDrawable(R.drawable.main_two_normal)); //改变我们需要的图标
	    		ImageView threeImage = (ImageView)mTabWidget.getChildAt(2).findViewById(android.R.id.icon);//获取控件imageView 
	    		threeImage .setImageDrawable(getResources().getDrawable(R.drawable.main_three_normal)); //改变我们需要的图标
	    		ImageView fourImage = (ImageView)mTabWidget.getChildAt(3).findViewById(android.R.id.icon);//获取控件imageView 
	    		fourImage .setImageDrawable(getResources().getDrawable(R.drawable.main_four_normal)); //改变我们需要的图标
	    		ImageView fiveImage = (ImageView)mTabWidget.getChildAt(4).findViewById(android.R.id.icon);//获取控件imageView 
	    		fiveImage .setImageDrawable(getResources().getDrawable(R.drawable.main_five_normal)); //改变我们需要的图标
	    		//点击切换标签图片
	    		if(tabSpec.equals("new_tab")){
	    			ImageView imageView = (ImageView)mTabWidget.getChildAt(0).findViewById(android.R.id.icon);//获取控件imageView 
	    			imageView .setImageDrawable(getResources().getDrawable(R.drawable.main_one_press)); //改变我们需要的图标
	    		}
	    		else if(tabSpec.equals("month_tab")){
	    			ImageView imageView = (ImageView)mTabWidget.getChildAt(1).findViewById(android.R.id.icon);//获取控件imageView 
	    			imageView .setImageDrawable(getResources().getDrawable(R.drawable.main_two_press)); //改变我们需要的图标
	    		}
	    		else if(tabSpec.equals("year_tab")){
	    			ImageView imageView = (ImageView)mTabWidget.getChildAt(2).findViewById(android.R.id.icon);//获取控件imageView 
	    			imageView .setImageDrawable(getResources().getDrawable(R.drawable.main_three_press)); //改变我们需要的图标
	    		}
	    		else if(tabSpec.equals("mine_tab")){
	    			ImageView imageView = (ImageView)mTabWidget.getChildAt(3).findViewById(android.R.id.icon);//获取控件imageView 
	    			imageView .setImageDrawable(getResources().getDrawable(R.drawable.main_four_press)); //改变我们需要的图标
	    		}
	    		else if(tabSpec.equals("more_tab")){
	    			ImageView imageView = (ImageView)mTabWidget.getChildAt(4).findViewById(android.R.id.icon);//获取控件imageView 
	    			imageView .setImageDrawable(getResources().getDrawable(R.drawable.main_five_press)); //改变我们需要的图标
	    		}
	    		
	    	}
	    });
	    
	 // 标签多次点击处理，已选中的标签，再次单击选中标签的响应
	    //最新发布点击响应
	    mTabWidget.getChildAt(0).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//显示标签页
				mTabHost.setCurrentTab(0);
			    ImageView oneImage = (ImageView)mTabWidget.getChildAt(0).findViewById(android.R.id.icon);//获取控件imageView 
				oneImage .setImageDrawable(getResources().getDrawable(R.drawable.main_one_press)); //改变我们需要的图标
				//更新到当前标签页的第一页
				if(NewMainActivityGroup.newgroup !=null){
					Intent intent = new Intent(MainActivity.this,
							NewMainActivity.class)
					.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					// 把一个Activity转换成一个View
					Window w = NewMainActivityGroup.newgroup.getLocalActivityManager()
							.startActivity("NewMainActivity", intent);
					View searchView = w.getDecorView();
					// 把View添加大ActivityGroup中
					NewMainActivityGroup.newgroup.setContentView(searchView);
				} 
			}
		});
	  //进度数据点击响应
	    mTabWidget.getChildAt(1).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//显示标签页
				mTabHost.setCurrentTab(1);
			    ImageView oneImage = (ImageView)mTabWidget.getChildAt(1).findViewById(android.R.id.icon);//获取控件imageView 
				oneImage .setImageDrawable(getResources().getDrawable(R.drawable.main_two_press)); //改变我们需要的图标
				//更新到当前标签页的第一页
				if(MonthMainActivityGroup.monthgroup !=null){
					Intent intent = new Intent(MainActivity.this,
							MonthMainActivity.class)
					.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					// 把一个Activity转换成一个View
					Window w = MonthMainActivityGroup.monthgroup.getLocalActivityManager()
							.startActivity("MonthMainActivity", intent);
					View searchView = w.getDecorView();
					// 把View添加大ActivityGroup中
					MonthMainActivityGroup.monthgroup.setContentView(searchView);
				} 
			}
		});
	  //年度数据点击响应
	    mTabWidget.getChildAt(2).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//显示标签页
				mTabHost.setCurrentTab(2);
			    ImageView oneImage = (ImageView)mTabWidget.getChildAt(2).findViewById(android.R.id.icon);//获取控件imageView 
				oneImage .setImageDrawable(getResources().getDrawable(R.drawable.main_three_press)); //改变我们需要的图标
				//更新到当前标签页的第一页
				if(YearMainActivityGroup.yeargroup !=null){
					Intent intent = new Intent(MainActivity.this,
							YearMainActivity.class)
					.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					// 把一个Activity转换成一个View
					Window w = YearMainActivityGroup.yeargroup.getLocalActivityManager()
							.startActivity("YearMainActivity", intent);
					View searchView = w.getDecorView();
					// 把View添加大ActivityGroup中
					YearMainActivityGroup.yeargroup.setContentView(searchView);
				} 
			}
		});
	  //我的数据点击响应
	    mTabWidget.getChildAt(3).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//显示标签页
				mTabHost.setCurrentTab(3);
			    ImageView oneImage = (ImageView)mTabWidget.getChildAt(3).findViewById(android.R.id.icon);//获取控件imageView 
				oneImage .setImageDrawable(getResources().getDrawable(R.drawable.main_four_press)); //改变我们需要的图标
				//更新到当前标签页的第一页
				if(MineMainActivityGroup.minegroup !=null){
					Intent intent = new Intent(MainActivity.this,
							MineMainActivity.class)
					.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					// 把一个Activity转换成一个View
					Window w = MineMainActivityGroup.minegroup.getLocalActivityManager()
							.startActivity("MineMainActivity", intent);
					View searchView = w.getDecorView();
					// 把View添加大ActivityGroup中
					MineMainActivityGroup.minegroup.setContentView(searchView);
				} 
			}
		});
	    
    }
    /**
     * 更新底部功能栏图标
     * */
    public static void clearBar(){
    	//初始化标签图片
		ImageView oneImage = (ImageView)mTabWidget.getChildAt(0).findViewById(android.R.id.icon);//获取控件imageView 
		oneImage .setImageDrawable(mainActivity.getResources().getDrawable(R.drawable.main_one_normal)); //改变我们需要的图标
		ImageView twoImage = (ImageView)mTabWidget.getChildAt(1).findViewById(android.R.id.icon);//获取控件imageView 
		twoImage .setImageDrawable(mainActivity.getResources().getDrawable(R.drawable.main_two_normal)); //改变我们需要的图标
		ImageView threeImage = (ImageView)mTabWidget.getChildAt(2).findViewById(android.R.id.icon);//获取控件imageView 
		threeImage .setImageDrawable(mainActivity.getResources().getDrawable(R.drawable.main_three_normal)); //改变我们需要的图标
		ImageView fourImage = (ImageView)mTabWidget.getChildAt(3).findViewById(android.R.id.icon);//获取控件imageView 
		fourImage .setImageDrawable(mainActivity.getResources().getDrawable(R.drawable.main_four_normal)); //改变我们需要的图标
		ImageView fiveImage = (ImageView)mTabWidget.getChildAt(4).findViewById(android.R.id.icon);//获取控件imageView 
		fiveImage .setImageDrawable(mainActivity.getResources().getDrawable(R.drawable.main_five_normal)); //改变我们需要的图标
		
    }
    
    /**
     * 系统退出提示框
     * */
    @Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN ) {
			//进度数据回退
			if(MonthMainActivityGroup.monthgroup !=null && MonthMainActivityGroup.monthgroup.getLocalActivityManager().getCurrentActivity().getLocalClassName().contains("MonthSecondActivity")){
				// 打开上一级界面
				Intent intent = new Intent(MainActivity.this,
						MonthMainActivity.class)
				.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// 把一个Activity转换成一个View
				Window w = MonthMainActivityGroup.monthgroup.getLocalActivityManager()
						.startActivity("MonthMainActivity", intent);
				View monthView = w.getDecorView();
				// 把View添加大ActivityGroup中
				MonthMainActivityGroup.monthgroup.setContentView(monthView);
			}else if(YearMainActivityGroup.yeargroup !=null && YearMainActivityGroup.yeargroup.getLocalActivityManager().getCurrentActivity().getLocalClassName().contains("YearSecondActivity")){
				//年度数据回退
				// 打开打开上一级界面
				Intent intent = new Intent(MainActivity.this,
						YearMainActivity.class)
				.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// 把一个Activity转换成一个View
				Window w = YearMainActivityGroup.yeargroup.getLocalActivityManager()
						.startActivity("YearMainActivity", intent);
				View yearView = w.getDecorView();
				// 把View添加大ActivityGroup中
				YearMainActivityGroup.yeargroup.setContentView(yearView);
			}else{
				// 需要监听的事件
				AlertDialog isExit = new AlertDialog.Builder(this).create();
				// 设置对话框标题 
				isExit.setTitle("系统提示");
				// 设置对话框消息
				isExit.setMessage("确定要现在退出吗");
				// 添加选择按钮并注册监听
				isExit.setButton("确定", listener);
				isExit.setButton2("取消", listener);
				isExit.show();
			}
			return false;
		}
		return super.dispatchKeyEvent(event);
	}
	/** 监听对话框里面的button点击事件 */
	DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int which) {
			switch (which) {
			case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序
//				finish();//退出当前界面
				 System.exit(0);//退出整个APP
				break;
			case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
				break;
			default:
				break;
			}
		}
	};
    
}

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
 * ϵͳ�����Tab����
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
        initTabView();// ����Tab����
    }

	/**
     * Tab��ǩ��������
     * */
    private void initTabView() {
    	mTabHost = getTabHost();
    	//���·�����ǩ����
    	mTabHost.addTab(mTabHost.newTabSpec("new_tab")
				.setIndicator("",getResources().getDrawable(R.drawable.main_one_normal))
				.setContent(new Intent(MainActivity.this,NewMainActivityGroup.class)));
    	//�������ݱ�ǩ����
    	mTabHost.addTab(mTabHost.newTabSpec("month_tab")
				.setIndicator("",getResources().getDrawable(R.drawable.main_two_normal))
				.setContent(new Intent(MainActivity.this,MonthMainActivityGroup.class)));
    	//������ݱ�ǩ����
    	mTabHost.addTab(mTabHost.newTabSpec("year_tab")
				.setIndicator("",getResources().getDrawable(R.drawable.main_three_normal))
				.setContent(new Intent(MainActivity.this,YearMainActivityGroup.class)));
    	//�ҵ����ݱ�ǩ����
    	mTabHost.addTab(mTabHost.newTabSpec("mine_tab")
				.setIndicator("",getResources().getDrawable(R.drawable.main_four_normal))
				.setContent(new Intent(MainActivity.this,MineMainActivityGroup.class)));
    	//�����ǩ����
    	mTabHost.addTab(mTabHost.newTabSpec("more_tab")
				.setIndicator("",getResources().getDrawable(R.drawable.main_five_normal))
				.setContent(new Intent(MainActivity.this,MoreMainActivity.class)));
    	//��ǩ����Ч����
    	mTabWidget =  mTabHost.getTabWidget();
		mTabWidget.setStripEnabled(false);//��ǩ���ײ��ķָ����Ƿ����
//		mTabWidget.getLayoutParams().height = 80;
		for(int i=0;i<mTabWidget.getChildCount();i++){
//			mTabWidget.getChildAt(i).getLayoutParams().height = 80;
			mTabWidget.getChildAt(i).setBackgroundResource(R.drawable.tab_button_back);
//			final TextView tv = (TextView) mTabWidget.getChildAt(i).findViewById(android.R.id.title);
//			tv.setTextColor(getResources().getColorStateList(android.R.color.black));
//			tv.setTextSize(15);
		}
		// ���õ�ǰ��ʾ�ĸ���ǩ
	    mTabHost.setCurrentTab(0);
	    ImageView oneImage = (ImageView)mTabWidget.getChildAt(0).findViewById(android.R.id.icon);//��ȡ�ؼ�imageView 
		oneImage .setImageDrawable(getResources().getDrawable(R.drawable.main_one_press)); //�ı�������Ҫ��ͼ��
		
	    // ��ǩ�л��¼�����setOnTabChangedListener
	    mTabHost.setOnTabChangedListener(new OnTabChangeListener() {
	    	
	    	public void onTabChanged(String tabSpec) {
	    		//��ʼ����ǩͼƬ
	    		ImageView oneImage = (ImageView)mTabWidget.getChildAt(0).findViewById(android.R.id.icon);//��ȡ�ؼ�imageView 
	    		oneImage .setImageDrawable(getResources().getDrawable(R.drawable.main_one_normal)); //�ı�������Ҫ��ͼ��
	    		ImageView twoImage = (ImageView)mTabWidget.getChildAt(1).findViewById(android.R.id.icon);//��ȡ�ؼ�imageView 
	    		twoImage .setImageDrawable(getResources().getDrawable(R.drawable.main_two_normal)); //�ı�������Ҫ��ͼ��
	    		ImageView threeImage = (ImageView)mTabWidget.getChildAt(2).findViewById(android.R.id.icon);//��ȡ�ؼ�imageView 
	    		threeImage .setImageDrawable(getResources().getDrawable(R.drawable.main_three_normal)); //�ı�������Ҫ��ͼ��
	    		ImageView fourImage = (ImageView)mTabWidget.getChildAt(3).findViewById(android.R.id.icon);//��ȡ�ؼ�imageView 
	    		fourImage .setImageDrawable(getResources().getDrawable(R.drawable.main_four_normal)); //�ı�������Ҫ��ͼ��
	    		ImageView fiveImage = (ImageView)mTabWidget.getChildAt(4).findViewById(android.R.id.icon);//��ȡ�ؼ�imageView 
	    		fiveImage .setImageDrawable(getResources().getDrawable(R.drawable.main_five_normal)); //�ı�������Ҫ��ͼ��
	    		//����л���ǩͼƬ
	    		if(tabSpec.equals("new_tab")){
	    			ImageView imageView = (ImageView)mTabWidget.getChildAt(0).findViewById(android.R.id.icon);//��ȡ�ؼ�imageView 
	    			imageView .setImageDrawable(getResources().getDrawable(R.drawable.main_one_press)); //�ı�������Ҫ��ͼ��
	    		}
	    		else if(tabSpec.equals("month_tab")){
	    			ImageView imageView = (ImageView)mTabWidget.getChildAt(1).findViewById(android.R.id.icon);//��ȡ�ؼ�imageView 
	    			imageView .setImageDrawable(getResources().getDrawable(R.drawable.main_two_press)); //�ı�������Ҫ��ͼ��
	    		}
	    		else if(tabSpec.equals("year_tab")){
	    			ImageView imageView = (ImageView)mTabWidget.getChildAt(2).findViewById(android.R.id.icon);//��ȡ�ؼ�imageView 
	    			imageView .setImageDrawable(getResources().getDrawable(R.drawable.main_three_press)); //�ı�������Ҫ��ͼ��
	    		}
	    		else if(tabSpec.equals("mine_tab")){
	    			ImageView imageView = (ImageView)mTabWidget.getChildAt(3).findViewById(android.R.id.icon);//��ȡ�ؼ�imageView 
	    			imageView .setImageDrawable(getResources().getDrawable(R.drawable.main_four_press)); //�ı�������Ҫ��ͼ��
	    		}
	    		else if(tabSpec.equals("more_tab")){
	    			ImageView imageView = (ImageView)mTabWidget.getChildAt(4).findViewById(android.R.id.icon);//��ȡ�ؼ�imageView 
	    			imageView .setImageDrawable(getResources().getDrawable(R.drawable.main_five_press)); //�ı�������Ҫ��ͼ��
	    		}
	    		
	    	}
	    });
	    
	 // ��ǩ��ε��������ѡ�еı�ǩ���ٴε���ѡ�б�ǩ����Ӧ
	    //���·��������Ӧ
	    mTabWidget.getChildAt(0).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//��ʾ��ǩҳ
				mTabHost.setCurrentTab(0);
			    ImageView oneImage = (ImageView)mTabWidget.getChildAt(0).findViewById(android.R.id.icon);//��ȡ�ؼ�imageView 
				oneImage .setImageDrawable(getResources().getDrawable(R.drawable.main_one_press)); //�ı�������Ҫ��ͼ��
				//���µ���ǰ��ǩҳ�ĵ�һҳ
				if(NewMainActivityGroup.newgroup !=null){
					Intent intent = new Intent(MainActivity.this,
							NewMainActivity.class)
					.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					// ��һ��Activityת����һ��View
					Window w = NewMainActivityGroup.newgroup.getLocalActivityManager()
							.startActivity("NewMainActivity", intent);
					View searchView = w.getDecorView();
					// ��View��Ӵ�ActivityGroup��
					NewMainActivityGroup.newgroup.setContentView(searchView);
				} 
			}
		});
	  //�������ݵ����Ӧ
	    mTabWidget.getChildAt(1).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//��ʾ��ǩҳ
				mTabHost.setCurrentTab(1);
			    ImageView oneImage = (ImageView)mTabWidget.getChildAt(1).findViewById(android.R.id.icon);//��ȡ�ؼ�imageView 
				oneImage .setImageDrawable(getResources().getDrawable(R.drawable.main_two_press)); //�ı�������Ҫ��ͼ��
				//���µ���ǰ��ǩҳ�ĵ�һҳ
				if(MonthMainActivityGroup.monthgroup !=null){
					Intent intent = new Intent(MainActivity.this,
							MonthMainActivity.class)
					.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					// ��һ��Activityת����һ��View
					Window w = MonthMainActivityGroup.monthgroup.getLocalActivityManager()
							.startActivity("MonthMainActivity", intent);
					View searchView = w.getDecorView();
					// ��View��Ӵ�ActivityGroup��
					MonthMainActivityGroup.monthgroup.setContentView(searchView);
				} 
			}
		});
	  //������ݵ����Ӧ
	    mTabWidget.getChildAt(2).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//��ʾ��ǩҳ
				mTabHost.setCurrentTab(2);
			    ImageView oneImage = (ImageView)mTabWidget.getChildAt(2).findViewById(android.R.id.icon);//��ȡ�ؼ�imageView 
				oneImage .setImageDrawable(getResources().getDrawable(R.drawable.main_three_press)); //�ı�������Ҫ��ͼ��
				//���µ���ǰ��ǩҳ�ĵ�һҳ
				if(YearMainActivityGroup.yeargroup !=null){
					Intent intent = new Intent(MainActivity.this,
							YearMainActivity.class)
					.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					// ��һ��Activityת����һ��View
					Window w = YearMainActivityGroup.yeargroup.getLocalActivityManager()
							.startActivity("YearMainActivity", intent);
					View searchView = w.getDecorView();
					// ��View��Ӵ�ActivityGroup��
					YearMainActivityGroup.yeargroup.setContentView(searchView);
				} 
			}
		});
	  //�ҵ����ݵ����Ӧ
	    mTabWidget.getChildAt(3).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//��ʾ��ǩҳ
				mTabHost.setCurrentTab(3);
			    ImageView oneImage = (ImageView)mTabWidget.getChildAt(3).findViewById(android.R.id.icon);//��ȡ�ؼ�imageView 
				oneImage .setImageDrawable(getResources().getDrawable(R.drawable.main_four_press)); //�ı�������Ҫ��ͼ��
				//���µ���ǰ��ǩҳ�ĵ�һҳ
				if(MineMainActivityGroup.minegroup !=null){
					Intent intent = new Intent(MainActivity.this,
							MineMainActivity.class)
					.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					// ��һ��Activityת����һ��View
					Window w = MineMainActivityGroup.minegroup.getLocalActivityManager()
							.startActivity("MineMainActivity", intent);
					View searchView = w.getDecorView();
					// ��View��Ӵ�ActivityGroup��
					MineMainActivityGroup.minegroup.setContentView(searchView);
				} 
			}
		});
	    
    }
    /**
     * ���µײ�������ͼ��
     * */
    public static void clearBar(){
    	//��ʼ����ǩͼƬ
		ImageView oneImage = (ImageView)mTabWidget.getChildAt(0).findViewById(android.R.id.icon);//��ȡ�ؼ�imageView 
		oneImage .setImageDrawable(mainActivity.getResources().getDrawable(R.drawable.main_one_normal)); //�ı�������Ҫ��ͼ��
		ImageView twoImage = (ImageView)mTabWidget.getChildAt(1).findViewById(android.R.id.icon);//��ȡ�ؼ�imageView 
		twoImage .setImageDrawable(mainActivity.getResources().getDrawable(R.drawable.main_two_normal)); //�ı�������Ҫ��ͼ��
		ImageView threeImage = (ImageView)mTabWidget.getChildAt(2).findViewById(android.R.id.icon);//��ȡ�ؼ�imageView 
		threeImage .setImageDrawable(mainActivity.getResources().getDrawable(R.drawable.main_three_normal)); //�ı�������Ҫ��ͼ��
		ImageView fourImage = (ImageView)mTabWidget.getChildAt(3).findViewById(android.R.id.icon);//��ȡ�ؼ�imageView 
		fourImage .setImageDrawable(mainActivity.getResources().getDrawable(R.drawable.main_four_normal)); //�ı�������Ҫ��ͼ��
		ImageView fiveImage = (ImageView)mTabWidget.getChildAt(4).findViewById(android.R.id.icon);//��ȡ�ؼ�imageView 
		fiveImage .setImageDrawable(mainActivity.getResources().getDrawable(R.drawable.main_five_normal)); //�ı�������Ҫ��ͼ��
		
    }
    
    /**
     * ϵͳ�˳���ʾ��
     * */
    @Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN ) {
			//�������ݻ���
			if(MonthMainActivityGroup.monthgroup !=null && MonthMainActivityGroup.monthgroup.getLocalActivityManager().getCurrentActivity().getLocalClassName().contains("MonthSecondActivity")){
				// ����һ������
				Intent intent = new Intent(MainActivity.this,
						MonthMainActivity.class)
				.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// ��һ��Activityת����һ��View
				Window w = MonthMainActivityGroup.monthgroup.getLocalActivityManager()
						.startActivity("MonthMainActivity", intent);
				View monthView = w.getDecorView();
				// ��View��Ӵ�ActivityGroup��
				MonthMainActivityGroup.monthgroup.setContentView(monthView);
			}else if(YearMainActivityGroup.yeargroup !=null && YearMainActivityGroup.yeargroup.getLocalActivityManager().getCurrentActivity().getLocalClassName().contains("YearSecondActivity")){
				//������ݻ���
				// �򿪴���һ������
				Intent intent = new Intent(MainActivity.this,
						YearMainActivity.class)
				.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// ��һ��Activityת����һ��View
				Window w = YearMainActivityGroup.yeargroup.getLocalActivityManager()
						.startActivity("YearMainActivity", intent);
				View yearView = w.getDecorView();
				// ��View��Ӵ�ActivityGroup��
				YearMainActivityGroup.yeargroup.setContentView(yearView);
			}else{
				// ��Ҫ�������¼�
				AlertDialog isExit = new AlertDialog.Builder(this).create();
				// ���öԻ������ 
				isExit.setTitle("ϵͳ��ʾ");
				// ���öԻ�����Ϣ
				isExit.setMessage("ȷ��Ҫ�����˳���");
				// ���ѡ��ť��ע�����
				isExit.setButton("ȷ��", listener);
				isExit.setButton2("ȡ��", listener);
				isExit.show();
			}
			return false;
		}
		return super.dispatchKeyEvent(event);
	}
	/** �����Ի��������button����¼� */
	DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int which) {
			switch (which) {
			case AlertDialog.BUTTON_POSITIVE:// "ȷ��"��ť�˳�����
//				finish();//�˳���ǰ����
				 System.exit(0);//�˳�����APP
				break;
			case AlertDialog.BUTTON_NEGATIVE:// "ȡ��"�ڶ�����ťȡ���Ի���
				break;
			default:
				break;
			}
		}
	};
    
}

package com.jiangbei.detail;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.jiangbei.R;
/**
 * 详细信息主界面
 * */
public class DetailMainActivity extends ActivityGroup {
	public static ActivityGroup detailgroup; // 一个静态的ActivityGroup变量，用于管理本Group中的Activity
	private ImageButton rebackButton,changeButton,collectButton,shareButton;
	private ImageButton regionOneButton,regionTwoButton,regionThreeButton,regionFourButton,
	                    regionFiveButton,regionSixButton,regionSevenButton,regionEightButton;
	private View explainView;
	private FrameLayout container;
	private boolean isList = true ;//当前是否是表格形式界面

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_activity);
		detailgroup =this;
		
		explainView = (View) findViewById(R.id.detail_explain_layout);
		rebackButton = (ImageButton) findViewById(R.id.detail_title_RebackButton);
		changeButton = (ImageButton) findViewById(R.id.detail_first_changButton);
		container = (FrameLayout) findViewById(R.id.detail_containerBody);
		collectButton = (ImageButton) findViewById(R.id.detail_buttom_CollectButton);
		shareButton = (ImageButton) findViewById(R.id.detail_buttom_ShareButton);
		
		regionOneButton = (ImageButton) findViewById(R.id.detail_region_OneButton);
		regionTwoButton = (ImageButton) findViewById(R.id.detail_region_TwoButton);
		regionThreeButton = (ImageButton) findViewById(R.id.detail_region_ThreeButton);
		regionFourButton = (ImageButton) findViewById(R.id.detail_region_FourButton);
		regionFiveButton = (ImageButton) findViewById(R.id.detail_region_FiveButton);
		regionSixButton = (ImageButton) findViewById(R.id.detail_region_SixButton);
		regionSevenButton = (ImageButton) findViewById(R.id.detail_region_SevenButton);
		regionEightButton = (ImageButton) findViewById(R.id.detail_region_EightButton);
		
		//初始化为表格界面
		container.removeAllViews();
        container.addView(detailgroup.getLocalActivityManager().startActivity(
                "DetailList",
                new Intent(DetailMainActivity.this, DetailListActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                .getDecorView());
        isList = true;
        changeButton.setBackgroundResource(R.drawable.detail_changebutton_normal);
        //初始化子分区
        regionOneButton.setBackgroundResource(R.drawable.detail_region_one_press);
        
        setClickListener();// 设置监听事件
	} 
	/**
	 * 监听事件集合
	 * */
	private void setClickListener() {
		//回退按钮
		rebackButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				finish();			
			}
		});
		//表格界面与图形界面切换按钮
		changeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				//切换图形界面
				if(isList){
					container.removeAllViews();
					container.addView(detailgroup.getLocalActivityManager().startActivity(
							"DetailImage",
							new Intent(DetailMainActivity.this, DetailImageActivity.class)
							.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
							.getDecorView());
					isList = false;
					changeButton.setBackgroundResource(R.drawable.detail_changebutton_press);
				}else{//切换表格界面
					container.removeAllViews();
					container.addView(detailgroup.getLocalActivityManager().startActivity(
							"DetailList",
							new Intent(DetailMainActivity.this, DetailListActivity.class)
							.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
							.getDecorView());
					isList = true;
					changeButton.setBackgroundResource(R.drawable.detail_changebutton_normal);
				}
			}
		});
		//子分区1按钮
		regionOneButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				refreshRegionButton();
				regionOneButton.setBackgroundResource(R.drawable.detail_region_one_press);
				if(isList){//对表格界面数据操作
					DetailListActivity.detailList.refresh(1);
				}else{//对图形界面数据操作
					DetailImageActivity.detailImage.refresh(1);
				}
			}
		});
		//子分区2按钮
		regionTwoButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				refreshRegionButton();
				regionTwoButton.setBackgroundResource(R.drawable.detail_region_two_press);
				if(isList){//对表格界面数据操作
					DetailListActivity.detailList.refresh(2);
				}else{//对图形界面数据操作
					DetailImageActivity.detailImage.refresh(2);
				}
			}
		});
		//子分区3按钮
		regionThreeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				refreshRegionButton();
				regionThreeButton.setBackgroundResource(R.drawable.detail_region_three_press);
				if(isList){//对表格界面数据操作
					DetailListActivity.detailList.refresh(3);
				}else{//对图形界面数据操作
					DetailImageActivity.detailImage.refresh(3);
				}
			}
		});
		//子分区4按钮
		regionFourButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				refreshRegionButton();
				regionFourButton.setBackgroundResource(R.drawable.detail_region_four_press);
				if(isList){//对表格界面数据操作
					DetailListActivity.detailList.refresh(4);
				}else{//对图形界面数据操作
					DetailImageActivity.detailImage.refresh(4);
				}
			}
		});
		//子分区5按钮
		regionFiveButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				refreshRegionButton();
				regionFiveButton.setBackgroundResource(R.drawable.detail_region_five_press);
				if(isList){//对表格界面数据操作
					DetailListActivity.detailList.refresh(5);
				}else{//对图形界面数据操作
					DetailImageActivity.detailImage.refresh(5);
				}
			}
		});
		//子分区6按钮
		regionSixButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				refreshRegionButton();
				regionSixButton.setBackgroundResource(R.drawable.detail_region_six_press);
				if(isList){//对表格界面数据操作
					DetailListActivity.detailList.refresh(6);
				}else{//对图形界面数据操作
					DetailImageActivity.detailImage.refresh(6);
				}
			}
		});
		//子分区7按钮
		regionSevenButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				refreshRegionButton();
				regionSevenButton.setBackgroundResource(R.drawable.detail_region_seven_press);
				if(isList){//对表格界面数据操作
					DetailListActivity.detailList.refresh(7);
				}else{//对图形界面数据操作
					DetailImageActivity.detailImage.refresh(7);
				}
			}
		});
		//子分区8按钮
		regionEightButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				refreshRegionButton();
				regionEightButton.setBackgroundResource(R.drawable.detail_region_eight_press);
				if(isList){//对表格界面数据操作
					DetailListActivity.detailList.refresh(8);
				}else{//对图形界面数据操作
					DetailImageActivity.detailImage.refresh(8);
				}
			}
		});
		
		//收藏按钮
		collectButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(DetailMainActivity.this, "指标收藏完成",Toast.LENGTH_SHORT ).show();
			}
		});
		
		//分享按钮
		shareButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(DetailMainActivity.this, "指标分享完成",Toast.LENGTH_SHORT ).show();		
			}
		});
		
		//名词解释
		explainView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DetailMainActivity.this, DetailExplainActivity.class);
				startActivity(intent);
				
				DetailMainActivity.this.overridePendingTransition(R.anim.activity_open,0);
			}
		});
		
	}
	
	/**
	 * 子分区按钮初始化
	 * */
	private void refreshRegionButton() {
		regionOneButton.setBackgroundResource(R.drawable.detail_region_one_normal);
		regionTwoButton.setBackgroundResource(R.drawable.detail_region_two_normal);
		regionThreeButton.setBackgroundResource(R.drawable.detail_region_three_normal);
		regionFourButton.setBackgroundResource(R.drawable.detail_region_four_normal);
		regionFiveButton.setBackgroundResource(R.drawable.detail_region_five_normal);
		regionSixButton.setBackgroundResource(R.drawable.detail_region_six_normal);
		regionSevenButton.setBackgroundResource(R.drawable.detail_region_seven_normal);
		regionEightButton.setBackgroundResource(R.drawable.detail_region_eight_normal);
	}

}

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
 * ��ϸ��Ϣ������
 * */
public class DetailMainActivity extends ActivityGroup {
	public static ActivityGroup detailgroup; // һ����̬��ActivityGroup���������ڹ���Group�е�Activity
	private ImageButton rebackButton,changeButton,collectButton,shareButton;
	private ImageButton regionOneButton,regionTwoButton,regionThreeButton,regionFourButton,
	                    regionFiveButton,regionSixButton,regionSevenButton,regionEightButton;
	private View explainView;
	private FrameLayout container;
	private boolean isList = true ;//��ǰ�Ƿ��Ǳ����ʽ����

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
		
		//��ʼ��Ϊ������
		container.removeAllViews();
        container.addView(detailgroup.getLocalActivityManager().startActivity(
                "DetailList",
                new Intent(DetailMainActivity.this, DetailListActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                .getDecorView());
        isList = true;
        changeButton.setBackgroundResource(R.drawable.detail_changebutton_normal);
        //��ʼ���ӷ���
        regionOneButton.setBackgroundResource(R.drawable.detail_region_one_press);
        
        setClickListener();// ���ü����¼�
	} 
	/**
	 * �����¼�����
	 * */
	private void setClickListener() {
		//���˰�ť
		rebackButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				finish();			
			}
		});
		//��������ͼ�ν����л���ť
		changeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				//�л�ͼ�ν���
				if(isList){
					container.removeAllViews();
					container.addView(detailgroup.getLocalActivityManager().startActivity(
							"DetailImage",
							new Intent(DetailMainActivity.this, DetailImageActivity.class)
							.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
							.getDecorView());
					isList = false;
					changeButton.setBackgroundResource(R.drawable.detail_changebutton_press);
				}else{//�л�������
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
		//�ӷ���1��ť
		regionOneButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				refreshRegionButton();
				regionOneButton.setBackgroundResource(R.drawable.detail_region_one_press);
				if(isList){//�Ա��������ݲ���
					DetailListActivity.detailList.refresh(1);
				}else{//��ͼ�ν������ݲ���
					DetailImageActivity.detailImage.refresh(1);
				}
			}
		});
		//�ӷ���2��ť
		regionTwoButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				refreshRegionButton();
				regionTwoButton.setBackgroundResource(R.drawable.detail_region_two_press);
				if(isList){//�Ա��������ݲ���
					DetailListActivity.detailList.refresh(2);
				}else{//��ͼ�ν������ݲ���
					DetailImageActivity.detailImage.refresh(2);
				}
			}
		});
		//�ӷ���3��ť
		regionThreeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				refreshRegionButton();
				regionThreeButton.setBackgroundResource(R.drawable.detail_region_three_press);
				if(isList){//�Ա��������ݲ���
					DetailListActivity.detailList.refresh(3);
				}else{//��ͼ�ν������ݲ���
					DetailImageActivity.detailImage.refresh(3);
				}
			}
		});
		//�ӷ���4��ť
		regionFourButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				refreshRegionButton();
				regionFourButton.setBackgroundResource(R.drawable.detail_region_four_press);
				if(isList){//�Ա��������ݲ���
					DetailListActivity.detailList.refresh(4);
				}else{//��ͼ�ν������ݲ���
					DetailImageActivity.detailImage.refresh(4);
				}
			}
		});
		//�ӷ���5��ť
		regionFiveButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				refreshRegionButton();
				regionFiveButton.setBackgroundResource(R.drawable.detail_region_five_press);
				if(isList){//�Ա��������ݲ���
					DetailListActivity.detailList.refresh(5);
				}else{//��ͼ�ν������ݲ���
					DetailImageActivity.detailImage.refresh(5);
				}
			}
		});
		//�ӷ���6��ť
		regionSixButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				refreshRegionButton();
				regionSixButton.setBackgroundResource(R.drawable.detail_region_six_press);
				if(isList){//�Ա��������ݲ���
					DetailListActivity.detailList.refresh(6);
				}else{//��ͼ�ν������ݲ���
					DetailImageActivity.detailImage.refresh(6);
				}
			}
		});
		//�ӷ���7��ť
		regionSevenButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				refreshRegionButton();
				regionSevenButton.setBackgroundResource(R.drawable.detail_region_seven_press);
				if(isList){//�Ա��������ݲ���
					DetailListActivity.detailList.refresh(7);
				}else{//��ͼ�ν������ݲ���
					DetailImageActivity.detailImage.refresh(7);
				}
			}
		});
		//�ӷ���8��ť
		regionEightButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				refreshRegionButton();
				regionEightButton.setBackgroundResource(R.drawable.detail_region_eight_press);
				if(isList){//�Ա��������ݲ���
					DetailListActivity.detailList.refresh(8);
				}else{//��ͼ�ν������ݲ���
					DetailImageActivity.detailImage.refresh(8);
				}
			}
		});
		
		//�ղذ�ť
		collectButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(DetailMainActivity.this, "ָ���ղ����",Toast.LENGTH_SHORT ).show();
			}
		});
		
		//����ť
		shareButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(DetailMainActivity.this, "ָ��������",Toast.LENGTH_SHORT ).show();		
			}
		});
		
		//���ʽ���
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
	 * �ӷ�����ť��ʼ��
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

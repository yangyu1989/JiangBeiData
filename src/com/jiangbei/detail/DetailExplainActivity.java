package com.jiangbei.detail;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.jiangbei.R;

public class DetailExplainActivity extends Activity {
	private ImageButton rebackButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_explain_activity);
		rebackButton = (ImageButton) findViewById(R.id.detail_explain_RebackButton);
		
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
	}
	@Override
	public void finish() {
		// TODO Auto-generated method stub
		super.finish();
		//关闭窗体动画显示  
	    overridePendingTransition(0, R.anim.activity_close);
	}
	
	

}

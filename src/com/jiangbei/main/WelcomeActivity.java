package com.jiangbei.main;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.jiangbei.R;
/**
 * 系统欢迎界面
 * */
public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_welcome);
		 //跳转到系统主框架界面，关闭欢迎界面
        Timer timer = new Timer();
        TimerTask task = new TimerTask(){
        	
        	@Override
        	public void run() {
        		// TODO Auto-generated method stub
        		Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
        		startActivity(intent);
        		WelcomeActivity.this.finish();
        	}
        };
        timer.schedule(task, 3000); //3秒
	}

}

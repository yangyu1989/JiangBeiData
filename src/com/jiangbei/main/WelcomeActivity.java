package com.jiangbei.main;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.jiangbei.R;
/**
 * ϵͳ��ӭ����
 * */
public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_welcome);
		 //��ת��ϵͳ����ܽ��棬�رջ�ӭ����
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
        timer.schedule(task, 3000); //3��
	}

}

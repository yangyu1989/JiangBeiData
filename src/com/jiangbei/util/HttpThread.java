package com.jiangbei.util;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.jiangbei.util.JBAddress.HttpHandleType;

/**
 * 底层与服务器交互的线程集合类
 */
public class HttpThread extends Thread {
	private static String TAG = "HttpThread";
	private ProgressDialog pdDialog = null;
	private String urlString = null;
	private Handler handler = null;
	private int mHttpHandleType;
	private List<BasicNameValuePair> params;
	private Context mContext;
	
	public HttpThread(Handler handler, int mHttpHandleType,
			List<BasicNameValuePair> params, Context mContext) {
		super();
		this.handler = handler;
		this.mHttpHandleType = mHttpHandleType;
		this.params = params;
		this.mContext = mContext;
	}
	
	private void ShowDialog(String str1, String str2) {
		pdDialog = new ProgressDialog(mContext);
		pdDialog.setTitle(str1);
		pdDialog.setMessage(str2);
		pdDialog.show();
	}
	
	// 进行一些初始化工作然后调用start()让线程运行
	public void doStart(String urlString) {
		this.urlString = urlString;
		switch (mHttpHandleType) {
		case HttpHandleType.NEWSLIST: // 最新发布列表
			ShowDialog("连接服务器...", "正在加载数据...");
			this.start();// 启动线程
			break;
			
		default:
			break;
		}
	}
	// 线程实际操作内容
	@Override
	public void run() {
		Looper.prepare();
		switch (mHttpHandleType) {
		case HttpHandleType.NEWSLIST: // 最新发布列表
			Message msg = new Message();
			Bundle data = new Bundle();
			try {
				String result = webServiceDetailData(params, urlString);// 执行网络服务请求，耗时操作。。。
				Log.e(TAG, "数据加载成功");
				msg.what = 1;
				data.putString("result", result);
				data.putString("status", "normal");
				msg.setData(data);
			} catch (Exception e) {
				msg.what = 2;
				data.putString("result", "");
				data.putString("status", "Error");
				msg.setData(data); 
				e.printStackTrace();
				System.out.println("IOException");
			} finally {
				pdDialog.dismiss();
				handler.sendMessage(msg);
			}
			break;
		default:
			break;
		}
	}
	
	//列表数据查询
	private String webServiceListData(List<BasicNameValuePair> params,
			String URL) throws ParseException, ClientProtocolException,
			IOException {
		HttpPost request = new HttpPost(URL); // 根据内容来源地址创建一个Http请求
		request.setEntity(new UrlEncodedFormEntity(params, "UTF_8")); // 设置参数的编码
		DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
//				//请求超时 
		defaultHttpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);  
//				//读取超时
		defaultHttpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 10000);
		HttpResponse httpResponse = defaultHttpClient.execute(request); // 发送请求并获取反馈
		// 解析返回的内容
		if (httpResponse.getStatusLine().getStatusCode() != 404) {
			String result = EntityUtils.toString(httpResponse.getEntity(), HTTP.UTF_8);
			return result;
		} else {
			return null;
		}
	}
	
	//详细数据查询
	private String webServiceDetailData(List<BasicNameValuePair> params,
			String URL) throws ParseException, ClientProtocolException,
			IOException {
		HttpPost request = new HttpPost(URL); // 根据内容来源地址创建一个Http请求
		request.setEntity(new UrlEncodedFormEntity(params, "UTF_8")); // 设置参数的编码
		DefaultHttpClient defaultHttpClient = new DefaultHttpClient(); 
//				//请求超时 
		defaultHttpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);  
//				//读取超时
		defaultHttpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 10000);
		HttpResponse httpResponse = defaultHttpClient.execute(request); // 发送请求并获取反馈
		// 解析返回的内容
		if (httpResponse.getStatusLine().getStatusCode() != 404) {
			String result = EntityUtils.toString(httpResponse.getEntity(), HTTP.UTF_8);
			return result;
		} else {
			return null;
		}
	}
	
}

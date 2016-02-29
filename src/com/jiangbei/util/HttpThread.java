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
 * �ײ���������������̼߳�����
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
	
	// ����һЩ��ʼ������Ȼ�����start()���߳�����
	public void doStart(String urlString) {
		this.urlString = urlString;
		switch (mHttpHandleType) {
		case HttpHandleType.NEWSLIST: // ���·����б�
			ShowDialog("���ӷ�����...", "���ڼ�������...");
			this.start();// �����߳�
			break;
			
		default:
			break;
		}
	}
	// �߳�ʵ�ʲ�������
	@Override
	public void run() {
		Looper.prepare();
		switch (mHttpHandleType) {
		case HttpHandleType.NEWSLIST: // ���·����б�
			Message msg = new Message();
			Bundle data = new Bundle();
			try {
				String result = webServiceDetailData(params, urlString);// ִ������������󣬺�ʱ����������
				Log.e(TAG, "���ݼ��سɹ�");
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
	
	//�б����ݲ�ѯ
	private String webServiceListData(List<BasicNameValuePair> params,
			String URL) throws ParseException, ClientProtocolException,
			IOException {
		HttpPost request = new HttpPost(URL); // ����������Դ��ַ����һ��Http����
		request.setEntity(new UrlEncodedFormEntity(params, "UTF_8")); // ���ò����ı���
		DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
//				//����ʱ 
		defaultHttpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);  
//				//��ȡ��ʱ
		defaultHttpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 10000);
		HttpResponse httpResponse = defaultHttpClient.execute(request); // �������󲢻�ȡ����
		// �������ص�����
		if (httpResponse.getStatusLine().getStatusCode() != 404) {
			String result = EntityUtils.toString(httpResponse.getEntity(), HTTP.UTF_8);
			return result;
		} else {
			return null;
		}
	}
	
	//��ϸ���ݲ�ѯ
	private String webServiceDetailData(List<BasicNameValuePair> params,
			String URL) throws ParseException, ClientProtocolException,
			IOException {
		HttpPost request = new HttpPost(URL); // ����������Դ��ַ����һ��Http����
		request.setEntity(new UrlEncodedFormEntity(params, "UTF_8")); // ���ò����ı���
		DefaultHttpClient defaultHttpClient = new DefaultHttpClient(); 
//				//����ʱ 
		defaultHttpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);  
//				//��ȡ��ʱ
		defaultHttpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 10000);
		HttpResponse httpResponse = defaultHttpClient.execute(request); // �������󲢻�ȡ����
		// �������ص�����
		if (httpResponse.getStatusLine().getStatusCode() != 404) {
			String result = EntityUtils.toString(httpResponse.getEntity(), HTTP.UTF_8);
			return result;
		} else {
			return null;
		}
	}
	
}

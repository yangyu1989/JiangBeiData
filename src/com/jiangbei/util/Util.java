package com.jiangbei.util;

import android.content.Context;
/**
 * ����������
 * */
public class Util {
	/**
	 * xml�е�dipת��Ϊpx�����أ�,���ڴ����еĿ������
	 * */
	public static int DipToPx(Context context, float dipValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}
	/**
	 * px�����أ�ת��Ϊxml�е�dip 
	 * */
	public static int PxToDip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

}

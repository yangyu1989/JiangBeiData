package com.jiangbei.util;

import android.content.Context;
/**
 * 公共方法类
 * */
public class Util {
	/**
	 * xml中的dip转换为px（像素）,用于代码中的宽高设置
	 * */
	public static int DipToPx(Context context, float dipValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}
	/**
	 * px（像素）转换为xml中的dip 
	 * */
	public static int PxToDip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

}

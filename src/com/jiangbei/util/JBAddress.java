package com.jiangbei.util;
/**
 * 数据交互接口路径声明类
 */
public class JBAddress {
	
	public static class HttpHandleType {
		public static final int NEWSLIST = 1; // 最新发布列表
	}
	 
	public static class HttpHandleAddress {
		public static final String IP_PORT = "http://121.196.236.188:8080/HMIT-CA";// 服务器地址,外网 
//		public static final String IP_PORT = "http://192.168.10.210:8081/SpringMVCTest";// 服务器地址,内网 
		
		public static final String NEWS_LIST = "/getNewsList";//最新发布列表
		
	}

}

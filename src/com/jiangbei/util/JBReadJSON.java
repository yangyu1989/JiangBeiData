package com.jiangbei.util;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * json数据解析方法
 */
public class JBReadJSON {
	/**
	 * 详细信息json数据解析成Object的方法
	 */
	public static Object readDetailJSON(String jsonStr,Object VO)
	{
		try {
			JSONObject voJson = new JSONObject(jsonStr);
			Class cls = VO.getClass();
			// 获取实体类的所有属性，返回Field数组
			Field[] field = VO.getClass().getDeclaredFields();
			//遍历实体类得所有属性
			for(int j=0;j<field.length;j++){
				//属性名称
				String methodName = field[j].getName();
				//从json中获取属性值
				Object val = null;
				if(jsonStr.contains("\""+methodName+"\"")){//json字符串是否包含当前key值
					val = voJson.get(methodName);
//				val = voJson.get(methodName.toUpperCase());
					//赋值到实体类
					if(!val.toString().equals("null")){
						setMethodVal(VO,cls,methodName,val);
					}
				}
			}
		} catch (Exception e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return VO; 
	}
	
	/**
	 * json数据解析成Vector的方法
	 */
	public static Vector readJSON(String jsonStr,Object VO)
	{
		Vector vector = new Vector();
		try {
			JSONArray aJsonArray = new JSONArray(jsonStr);  
			if(aJsonArray.length() >0){
				int length = aJsonArray.length();  
				for (int i = 0; i < length; i++) {  
					JSONObject voJson = aJsonArray.getJSONObject(i); 
					Class cls = VO.getClass();
					 // 获取实体类的所有属性，返回Field数组
			        Field[] field = VO.getClass().getDeclaredFields();
			        //遍历实体类得所有属性
					for(int j=0;j<field.length;j++){
						//属性名称
						String methodName = field[j].getName();
						if(voJson.toString().contains("\""+methodName+"\"")){//json字符串是否包含当前key值
							//从json中获取属性值
							Object val = voJson.get(methodName);
//						Object val = voJson.get(methodName.toUpperCase());
							//赋值到实体类
							if(!val.toString().equals("null")){
								setMethodVal(VO,cls,methodName,val);
							}
						}
					}
					//赋值完的实体类放入vector
					vector.add(VO);
					//创建新的实体类
					cls = Class.forName(VO.getClass().getCanonicalName());
					VO = cls.newInstance();
				}  
				
			}
			    
		} catch (Exception e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return vector; 
	}
	/**
	 * 赋值到Object实体类的方法
	 */
	public static void setMethodVal(Object vo,Class cls,String meName,Object val){
		try{ 
	    	String clsType = cls.getDeclaredField(meName).getType().toString();
	    	Method method = cls.getDeclaredMethod(
					"set"+meName.substring(0,1).toUpperCase()+meName.substring(1,meName.length()),
					cls.getDeclaredField(meName).getType());
	    	if(clsType.indexOf("String")!=-1){
	    		method.invoke(vo, val.toString());
	    	}else if(clsType.indexOf("Date")!=-1) {
	    		Date date = new Date(Long.parseLong(val.toString()));
	    		method.invoke(vo,date); 	 				
	    	}else if(clsType.indexOf("float")!=-1){
	    		method.invoke(vo, Float.valueOf(val.toString()));
	    	}else if(clsType.indexOf("int")!=-1){
	    		method.invoke(vo, Integer.valueOf(val.toString()));
	    	}  
	    	
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		
	}

}

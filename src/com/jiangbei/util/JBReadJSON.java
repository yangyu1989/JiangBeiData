package com.jiangbei.util;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * json���ݽ�������
 */
public class JBReadJSON {
	/**
	 * ��ϸ��Ϣjson���ݽ�����Object�ķ���
	 */
	public static Object readDetailJSON(String jsonStr,Object VO)
	{
		try {
			JSONObject voJson = new JSONObject(jsonStr);
			Class cls = VO.getClass();
			// ��ȡʵ������������ԣ�����Field����
			Field[] field = VO.getClass().getDeclaredFields();
			//����ʵ�������������
			for(int j=0;j<field.length;j++){
				//��������
				String methodName = field[j].getName();
				//��json�л�ȡ����ֵ
				Object val = null;
				if(jsonStr.contains("\""+methodName+"\"")){//json�ַ����Ƿ������ǰkeyֵ
					val = voJson.get(methodName);
//				val = voJson.get(methodName.toUpperCase());
					//��ֵ��ʵ����
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
	 * json���ݽ�����Vector�ķ���
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
					 // ��ȡʵ������������ԣ�����Field����
			        Field[] field = VO.getClass().getDeclaredFields();
			        //����ʵ�������������
					for(int j=0;j<field.length;j++){
						//��������
						String methodName = field[j].getName();
						if(voJson.toString().contains("\""+methodName+"\"")){//json�ַ����Ƿ������ǰkeyֵ
							//��json�л�ȡ����ֵ
							Object val = voJson.get(methodName);
//						Object val = voJson.get(methodName.toUpperCase());
							//��ֵ��ʵ����
							if(!val.toString().equals("null")){
								setMethodVal(VO,cls,methodName,val);
							}
						}
					}
					//��ֵ���ʵ�������vector
					vector.add(VO);
					//�����µ�ʵ����
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
	 * ��ֵ��Objectʵ����ķ���
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

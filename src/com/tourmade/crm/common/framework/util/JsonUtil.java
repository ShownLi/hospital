package com.tourmade.crm.common.framework.util;

import java.net.URLDecoder;
import java.net.URLEncoder;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JsonUtil {
	
	
	public static JsonConfig getEncodeJSONConfig(){
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(String.class,
				new JsonValueProcessor() {

					public Object processArrayValue(Object value,
							JsonConfig arg1) {
						// TODO Auto-generated method stub
						return process(value);
					}

					public Object processObjectValue(String key,
							Object value, JsonConfig arg2) {
						// TODO Auto-generated method stub
						return process(value);   
					}

					public Object process(Object value) {
						try {
							if (value instanceof String) {

								//BASE64Encoder encoder = new BASE64Encoder();
								
								//return encoder.encode(((String) value).getBytes());
								//return new String(((String) value).getBytes(), "UTF-8");
								return    URLEncoder.encode(value.toString(),"UTF-8"); //URLEncodeUtil.encodeURIComponent(value.toString()); // // new String(((String) value).getBytes(), "UTF-8");
								
							}
							return value == null ? "" : value.toString();
						} catch (Exception e) {
							return "";
						}

					}

				});
		
		return jsonConfig;
	}
	
	public static JsonConfig getDecodeJSONConfig(){
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(String.class,
				new JsonValueProcessor() {

					public Object processArrayValue(Object value,
							JsonConfig arg1) {
						// TODO Auto-generated method stub
						return process(value);
					}

					public Object processObjectValue(String key,
							Object value, JsonConfig arg2) {
						// TODO Auto-generated method stub
						
						return process(value);   
					}

					public Object process(Object value) {
						try {
							if (value instanceof String) {
								//BASE64Decoder decode = new BASE64Decoder();
								//return decode.decodeBuffer((String) value);
								return  URLDecoder.decode(value.toString(),"UTF-8"); //URLEncodeUtil.decodeURIComponent(value.toString());//// new String(((String) value).getBytes(), "UTF-8");								
							}
							return value == null ? "" : value.toString();
						} catch (Exception e) {
							return "";
						}

					}

				});
		
		return jsonConfig;
	}
}

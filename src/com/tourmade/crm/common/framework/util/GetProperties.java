package com.tourmade.crm.common.framework.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 获取配置文件内容
 * 
 * @author denggq
 * 
 */
public class GetProperties {
	
	public static final String FILEPATH="FilePath";
	
	public static String STATICFILEPATH;
	
	public static String UPLOADFILE;

	public String read(String key) {
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream("AppConfig.properties");
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return p.getProperty(key);
	}
	
	/**
	 * 获取文件存储路径虚拟路径并保存在内存当中
	 * 
	 * @return
	 */
	public String getFilePath(){
		if(STATICFILEPATH==null){
			STATICFILEPATH=read(FILEPATH);
		}
		return STATICFILEPATH;
	}
	
	/**
	 * 获取文件上传路径
	 * @return
	 */
	public String getUploadFile(){
		if(UPLOADFILE==null){
			UPLOADFILE=read("uploadFile");
		}
		return UPLOADFILE;
	}
}

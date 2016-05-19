package com.tourmade.crm.common.framework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ��Դ�ļ���ȡ���� <code>ResourceProperties</code> �̳���
 * <code>Properties</code> 
 * ���ܣ���ȡproperties�ļ�<br>
 * �÷������췽���д���properties�ļ���·��,getProperty(String key, Object[] args)��args�滻ռλ��{0}...{n},
 * �����÷���ͬ��Properties
 * @author  Konser
 * @version 0.1, 12/23/08
 * @see     java.util.Properties
 * @since   JDK1.0
 */
public class ResourceProperties extends Properties {
	
	protected static Log logger = LogFactory.getLog(ResourceProperties.class);
	
	/** serial version uid */
	private static final long serialVersionUID = -3607677676928827806L;

	
	/**
	 * ��ȡ��ֵ����Object[]�滻��ֵ�е� {0}..{n}ռλ��
	 * @param key  Ҫ��ȡ�ļ�
	 * @param args  �滻���� {0}...{n}
	 * @return args ��ȡ�滻�����Ϣ
	 */
	public String getProperty(String key, Object[] args) {
		// return variable
		String val = "";
		if (key == null)
			return val;
		if (super.getProperty(key) == null)
			return val;
		else
			val = super.getProperty(key);
		val = format(val, args);
		return val;
	}
 
	/**
	 * ��ʽ���ַ���args�滻ռλ��{0}...{n}
	 * @param str Դ�ַ�
	 * @param args �滻�Ĳ���
	 * @return �滻�����Ϣ
	 */
	public String format(String str, Object[] args) {
		String val = "";
		if (str == null)
			return val;
		val = MessageFormat.format(str, args);
		return val;
	}

    /**
     * ��ȡ��ֵ
     *
     * @param   key   ����ļ�ֵ
     * @return  ��Ӧ���ֵ
     * @see     #setProperty
     * @see     #defaults
     */
	public String getProperty(String key){
		String val = "";
		if(key == null)
			return val;
		return super.getProperty(key);
	}
 
	/**
	 * ���췽��
	 * @param propertyFileName properties�ļ�·��
	 */
	public ResourceProperties(String propertyFileName){
		init(propertyFileName);
	}
	
	/**
	 * ��ʼ��properties�ļ�
	 * @param propertyFileName properties�ļ���·��
	 */
	protected void init(String propertyFileName) {
		InputStream inputStream = null;
		try {
			inputStream = ResourceProperties.class.getClassLoader()
					.getResourceAsStream(propertyFileName);
			if (inputStream != null)
				this.load(inputStream);
			else {
				// ����� getResourceAsStream ��ȡ�����ļ�����File���Ի�ȡ
				File file = new File(propertyFileName);
				if (!file.exists() || !file.isFile()) {
					logger.error("load " + propertyFileName
							+ " is not file or is not exists!");
					return;
				}
				inputStream = new FileInputStream(file);
				if (inputStream != null)
					this.load(inputStream);
			}
		} catch (IOException e) {
			logger.error("load " + propertyFileName
							+ " into properties error!");
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.error("close " + propertyFileName + " error!");
				}
			}
		}
	}
	
	/**
	 * ׷��properties�ļ������ݵ������� 
	 * @param propertyFileName properties�ļ�·��
	 */
	public void addProperties(String propertyFileName){
		ResourceProperties addResourceProperties=new ResourceProperties(propertyFileName);
		this.putAll(addResourceProperties);
	}
	
}

package com.tourmade.crm.common.framework.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class CreateStatic {
	
	
	public void outputFile(Map<String, Object> map, String ftlName, String fileName) throws Exception{
		//创建freemarker的配置对象
		Configuration config = new Configuration();
		//设置默认编码格式
		config.setDefaultEncoding("UTF-8");
		//设置模板所在的包路径下
		config.setClassForTemplateLoading(this.getClass(), "/cn/itcast/ecps/ftl");
		//根据模板名称创建模板对象
		Template template = config.getTemplate(ftlName);
		//设置生成文件的路径
		String path = "";
		//定义输出流，注意编码必须指定
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path+fileName)),"UTF-8"));
		//根据模板和数据输出文件
		template.process(map, writer);
	}
}

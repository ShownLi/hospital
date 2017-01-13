package com.tourmade.crm.csv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.tourmade.crm.common.framework.BaseBean;

public class CSVUtil {
	public static void saveCsv(HttpServletResponse response,Map<?, ?> dataMap,String title) throws IOException{
		response.setContentType("application/csv;charset=gbk");
		//获取文件名
		String fileName = (String) dataMap.get("fileName");
		
		//设置响应头
	    response.setHeader("Content-Disposition","attachment;filename="+new String(fileName.getBytes("UTF-8"),"iso8859-1"));
	    //获取输出流
		PrintWriter out =response.getWriter();
		//输出标题头
		out.write(title+"\n");
		
		List<BaseBean<?>> dataList= (List<BaseBean<?>>) dataMap.get("dataList");
		try {
			if(dataList!=null){
				for(BaseBean<?> d:dataList){
					//直接toCSVString方法被重写，各个属性之间用,链接
					out.write(d.toCSVString()+"\n");
				}
			
			}
			out.flush();
		} finally {
			out.close();
		}
	}
}

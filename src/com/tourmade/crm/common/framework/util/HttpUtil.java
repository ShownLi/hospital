package com.tourmade.crm.common.framework.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class HttpUtil {
	public static HttpURLConnection getURL(String wsUrl) throws Exception {
		try{
			URL url = new URL(wsUrl);
			// url.openConnection() 返回的urlConnection对象实际上是根据URL的
			// 请求协议(此处是http)生成的URLConnection类
			// 的子类HttpURLConnection,故此处最好将其转化
			// 为HttpURLConnection类型的对象,以便用到
			// HttpURLConnection更多的API
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestProperty("Accept-Charset", "utf-8");
			// URL请求分为二类,GET与POST请求。二者的区别在于：
			// a:) get请求可以获取静态页面，也可以把参数放在URL字串后面，传递给servlet，
			// b:) post与get的不同之处在于post的参数不是放在URL字串里面，而是放在http请求的正文内。
			httpConn.setRequestMethod("POST");
			// Post 请求不能使用缓存
			httpConn.setUseCaches(false);
			// 设置是否从httpUrlConnection读入，默认情况下是true;
			httpConn.setDoInput(true);
			// 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在
			// http正文内，因此需要设为true, 默认情况下是false;
			httpConn.setDoOutput(true);
			// 设定传送的内容类型是可序列化的java对象
			// (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException)
			// httpConn.setRequestProperty("Content-type", "application/x-java-serialized-object");
			httpConn.setRequestProperty("Content-Type",	"application/x-www-form-urlencoded");
			Charset.availableCharsets();
			httpConn.setInstanceFollowRedirects(true);			
			return httpConn;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public static String sendRequest(HttpURLConnection conn, String data) throws Exception {
		BufferedReader reader = null;  
        OutputStreamWriter wr = null;
		try{			
			if(data != null && data.toString().trim().length() > 0){  
                wr = new OutputStreamWriter(conn.getOutputStream(),"UTF-8");  
                wr.write(data.toString());  
                wr.flush();  
            }
			
			StringBuffer info = new StringBuffer();
			// HttpURLConnection的connect()函数，实际上只是建立了一个与服务器的tcp连接，并没有实际发送http请求。 
			// 无论是post还是get，http请求实际上直到HttpURLConnection的getInputStream()这个函数里面才正式发送出去。
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line = reader.readLine();
			while (line != null) {
				info.append(line);
				line = reader.readLine();
			}
			reader.close();
	
			String ecod = conn.getContentEncoding();
			if (ecod == null) {
				ecod = Charset.defaultCharset().name();
			}
			String resData = new String(java.net.URLDecoder.decode(info.toString(), "UTF-8").getBytes());		
			return resData;
		}catch(Exception e){
			e.printStackTrace();
		}finally{  
            try {  
                if(wr!=null){  
                    wr.close();  
                }  
                if(reader!=null){  
                    reader.close();  
                }  
            } catch (IOException e) { 
                e.printStackTrace();  
            }             
        } 
		return "";
	}
}

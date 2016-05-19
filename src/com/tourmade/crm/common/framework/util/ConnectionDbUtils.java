package com.tourmade.crm.common.framework.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectionDbUtils {
	
	private static Connection getSqlServerConnection(String server,String database,String user_id,String password) throws ClassNotFoundException, SQLException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
        Connection con = DriverManager
        	      .getConnection("jdbc:sqlserver://"+server+":1433;DatabaseName="+database,
        	    		  user_id, password);
        return con;
	}
	
	public static List<Map<String,Object>> querySqlServerData(String server,String database,String user_id,String password,String strSql) throws Exception{
		Connection con = ConnectionDbUtils.getSqlServerConnection(server, database, user_id, password);
        Statement stmt = con.createStatement(); 
        ResultSet rs = stmt.executeQuery(strSql);
		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
		while(rs.next()){
			Map<String,Object> map = new HashMap<String,Object>();
			ResultSetMetaData rsmd =  rs.getMetaData();
			for(int i=1;i<=rsmd.getColumnCount();i++){
				String columnName = rsmd.getColumnName(i);
				Object objValue = rs.getObject(columnName);
				map.put(columnName, objValue);
			}
			listMap.add(map);
		}
		return listMap;
	}
	
}

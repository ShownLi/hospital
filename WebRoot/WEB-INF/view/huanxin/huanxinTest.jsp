<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>环信测试页面</title>
</head>
<!-- 客户端沟通窗口 -->
<script src='//kefu.easemob.com/webim/easemob.js?tenantId=31047&hide=false&sat=false' async='async'></script>
<body>
	环信客服测试页面...<br>
	<%@ page import="javax.naming.*" %>
	<%@ page import="javax.sql.*" %>
	<%@ page import="java.sql.*" %>
	<%@ page import="javax.transaction.*" %>
	CRM Integration Test:<br>
	<%
	    String easemobId = request.getParameter("easemobId");//该参数为环信租户ID
	    /**
	    * visitorImId是环信ID，可通过该ID查询到用户业务ID，进而查询到订单信息，客户详细信息等。
	    * 如果需要额外不能获取的信息，可以借助params里面传递参数来获得。
	    */
	    InitialContext ctx = new InitialContext();
	    
	    String name = "lxy";
	    String phone = "12345678911";
	    String address = "北京特美";
	    
        System.out.println("name :" + name);
        System.out.println("phone :" + phone);
        System.out.println("Address :" + address);
        out.println("easemobId :" + easemobId);
        out.println("<br>");
        out.println("name :" + name);
        out.println("<br>");
        out.println("phone :" + phone);
        out.println("<br>");
        out.println("address :" + address);
        out.println("<br>");
	%>
 	<form action="${rootPath}huaxin/test.do">
		测试name数据:<input type="text" name="name" id="name"><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>










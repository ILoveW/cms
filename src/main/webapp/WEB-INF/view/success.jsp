<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>success</title>
  </head>
  
  <body>
   	 欢迎你${user.name }
   	 <a href="${pageContext.request.contextPath }/BS/logout">退出</a>
  </body>
</html>

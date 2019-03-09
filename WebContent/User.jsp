<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>
<body>
	<jsp:include page="DaoHangLan.jsp" flush="true"/>
	<center>
		<h1>当前用户名称${user.name }</h1>
		<h2>为该商城第${user.id }个注册的用户</h2>
	</center>
</body>
</html>
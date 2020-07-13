<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="DaoHangLan.jsp" flush="true"/>
	<form action="AddType" method="post">
		类型名<input type="text" name="typename"><br>
		<input type="submit" value="添加">
	</form>
</body>
</html>
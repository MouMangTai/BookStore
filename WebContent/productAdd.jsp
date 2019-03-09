<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加图片</title>
</head>

<body>
	<jsp:include page="DaoHangLan.jsp" flush="true"/>
	<form action="AddProduct" method="post">
		书名<input type="text" name="name"><br>
		价格<input type="text" name="jiage"><br>
		库存<input type="text" name="kucun"><br>
		备注<input type="text" name="beizhu"><br>
		图片地址<input type="text" name="tupian"><br>
		<input type="submit" value="添加">
	</form>
</body>
</html>
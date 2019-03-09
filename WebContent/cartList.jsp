<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	.biaoti{
		overflow:hidden;
		position:relative;
		left:100px;
		top:-70px;
		width:600px;
		height:50px;
		
	}
	.danjia{
		position:relative;
		left:100px;
		top:-70px;
	}
	.shuliang{
		position:relative;
		left:200px;
		top:-90px;
	}
	.zongjia{
		position:relative;
		left:300px;
		top:-110px;
	}
	.block:hover{
	}
</style>
<body>
	<jsp:include page="DaoHangLan.jsp" flush="true"/>
		<center>
			<h1>${user.name }的购物车</h1>
		</center>
	<table align="center">
		<tr><td align="center"width="80px">图片</td><td width="500px">商品信息</td><td width="100px">单价(元)</td><td width="100px">数量</td><td width="100px">小计(元)</td><td width="100px">操作</td></tr>
		<c:forEach items="${ois}" var="oi">
			<tr><td><img width="80px" height="80px"src="${oi.product.image_src }"></td><td>${oi.product.name }</td><td>${oi.product.value }</td><td>${oi.number }</td><td>${oi.number*oi.product.value }</td><td><button><a href="deleteOrderItem?product_id=${oi.product.id}&user_id=${user.id}">删除</a></button></td></tr>
		</c:forEach>
	</table>
	
</body>
</html>
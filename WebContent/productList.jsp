<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	
	.product{
		float:left;
		margin-left:30px;
		margin-top:30px;
		width:190px;
	}
	a:link{color:#202020;text-decoration:none;}
	a:visited{color:#202020;text-decoration:none;}
	a:hover{color:#FF6600;}
</style>
<body>
	
	<!--  <table align="center">
		<tr><td>id</td><td>名称</td><td>价格</td><td>剩余数量</td><td>产品信息</td></tr>
		<c:forEach items="${products }" var="product" varStatus="st">
			<tr>
				<td>${product.id }</td><td>${product.name }</td><td>${product.value }</td>
				<td>${product.left_number }</td><td>${product.message }</td>
			</tr>
		</c:forEach>
	</table>-->
	<div id="listProduct"  >
		<c:forEach items="${products }" var="product">
			<div class="product" >
			    <center>
			    <a href="ShowProduct?id=${product.id }"><img src="${product.image_src } " width="100%" style="cursor:pointer;" ></a>
			    </center>
			    <hr color="gray">
			    <div style="float:left;margin-left:-10px;"><font size="3" color="FF6600">￥${product.value }</font></div>
			    <div style="float:right"><font size="1" color="FF6600">剩余${product.left_number }本</font></div>
			    <div style="margin-top:30px;height:34px;overflow: hidden; "><font size="2" ><a style="cursor:pointer;" class="no_underline" href="ShowProduct?id=${product.id }">${ product.name}</a></font></div>
				
				
				
			</div>
			
			
			
		</c:forEach>
	</div>
	
	
</body>
</html>
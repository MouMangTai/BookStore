<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书列表</title>
</head>
<script>
	function judge(){
		return confirm("是否要删除该图书");
	}
</script>
<style>
    .fenye{
    position:absolute;
    top:700px;
    margin-bottom:50px;
    }
	.product{
		float:left;
		margin-left:30px;
		margin-top:10px;
		width:190px;
	}
</style>
<body>
	<jsp:include page="DaoHangLan.jsp" flush="true"/>
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
			    <a href="ShowProduct?product_id=${product.id }"><img src="${product.image_src } " width="100%" style="cursor:pointer;" ></a>
			    </center>
			    <hr color="gray">
			    <div style="float:left;margin-left:-10px;"><font size="3" color="FF6600">￥${product.value }</font></div>
			    <div style="float:right"><font size="1" color="FF6600">剩余${product.left_number }本</font></div>
			    <div style="margin-top:50px;height:34px;overflow: hidden; "><font size="2" ><a style="cursor:pointer;" class="no_underline" href="ShowProduct?product_id=${product.id }">${ product.name}</a></font></div>
				<c:if test="${user.isadmin==1 }"><a href="DeleteProduct?product_id=${product.id }"><button onclick="return judge()">删除</button></a></c:if>
				
				
			</div>
			
			
			
		</c:forEach>
		
		
		
	</div>
	
		<div class="fenye" style="left:500px;"><a href="listProduct?start=0">[首页]</a></div>
		<div class="fenye" style="left:600px;"><a href="listProduct?start=${pre }">[上一页]</a></div>
		<div class="fenye" style="left:700px;"><a href="listProduct?start=${next }">[下一页]</a></div>
		<div class="fenye" style="left:800px;"><a href="listProduct?start=${end }">[尾页]</a></div>
	
	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	img{
		border:1px solid #D8D8D8;
		width:400px;
		height:500px;
		left:100px;
		top:100px;
		position:absolute;
	}
	#name{
		position:absolute;
		left:540px;
		top:100px;
		width:600px;
		height:40px;
		overflow: hidden;
		padding-bottom:10px;
		border-bottom:1px solid #D8D8D8;
	}
	#value{
		position:absolute;
		left:600px;
		top:180px;
		width:600px;
		height:40px;
		overflow: hidden;
		font-size:30px; 
		color:red;
	}
	#dingjia{
		position:absolute;
		left:540px;
		top:190px;
		width:600px;
		height:40px;
		overflow: hidden;
		font-size:20px; 
	}
	#sysl{
		position:absolute;
		left:540px;
		top:250px;
		width:600px;
		height:40px;
		overflow: hidden;
		font-size:20px; 
	}
	#left_number{
		position:absolute;
		left:650px;
		top:247px;
		width:600px;
		height:40px;
		overflow: hidden;
		font-size:25px; 
	}
	#gmsl{
		position:absolute;
		left:540px;
		top:330px;
		width:600px;
		height:40px;
		overflow: hidden;
		font-size:20px; 
	}
	#num{
		position:absolute;
		left:650px;
		top:332px;
		width:600px;
		height:40px;
		overflow: hidden;
		font-size:20px; 
	}
	#buy{
		position:absolute;
		left:550px;
		top:450px;
		width:150px;
		height:40px;
		overflow: hidden;
		font-size:20px; 
	}
	#add{
		position:absolute;
		left:800px;
		top:450px;
		width:150px;
		height:40px;
		overflow: hidden;
		font-size:20px; 
	}
	
	
</style>
<body>
	<div ><img src="${product.image_src }"></div>
	<div id="name">${product.name }</div>
	<div id="dingjia">定价:</div>
	<div id="value"><font size="4" >¥</font>${product.value }</div>
	<div id="sysl">剩余数量:</div>
	<div id="left_number">${product.left_number }</div>
	<div id="gmsl">购买数量:</div>
	<div id="num"> <input size="2px"type="number" value="1"></div>
	<button id="buy">购买 </button>
	<button id="add">加入购物车 </button>
</body>
</html>
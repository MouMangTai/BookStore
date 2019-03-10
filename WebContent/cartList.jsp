<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="http://how2j.cn/study/jquery.min.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
</head>
<script >

function minnum(min){
	var rnumber = $(min).next().val();
	var x = $(min).parent().prev().html();
	if(rnumber>1){
		rnumber --;
		$(min).parent().next().html(rnumber*x);
		
		$.ajax({
			url:"addOrderItem",
			data:{
				product_id:$(min).attr("id"),user_id:${user.id},number:-1,
			},
			success:function(result){
				$(min).next().val(rnumber);

			}
		});
		if($(min).parent().prev().prev().prev().prev().children().prop("checked")){
			var w = parseInt($(min).parent().prev().html());
			var x = parseInt($("#zongjia").html());
			var k = x-w;
			$("#zongjia").html(k.toString());
		}
	}
	
}
function addnum(add){
	var rnumber = $(add).prev().val();
	var x = $(add).parent().prev().html();
	rnumber ++;
	$(add).parent().next().html(rnumber*x);
	$.ajax({
		url:"addOrderItem",
		data:{
			product_id:$(add).attr("id"),user_id:${user.id},number:1,
		},
		success:function(result){
			$(add).prev().val(rnumber);
		}
	});
	if($(add).parent().prev().prev().prev().prev().children().prop("checked")){
		var w = parseInt($(add).parent().prev().html());
		var x = parseInt($("#zongjia").html());
		var k = w+x;
		$("#zongjia").html(k.toString());
	}
	
}
function check(ck){
	if($(ck).prop("checked")){
		var x = $(ck).parent().next().next().next().next().next().html();
		var w = parseFloat(x);
		var y = $("#zongjia").html();
		var z = parseFloat(y);
		var k = w+z;
		$("#zongjia").html(k.toString());
	}else{
		var x = $(ck).parent().next().next().next().next().next().html();
		var w = parseFloat(x);
		var y = $("#zongjia").html();
		var z = parseFloat(y);
		var k = z-w;
		$("#zongjia").html(k.toString());
	}
}
function checkall(ck){
    if($(ck).is(":checked")){
    	$("input[name='box']").each(function(){    
            if($(this).is(":checked"))    
            {    
            }    else{
            	$(this).prop('checked', true);
            	check(this);
            }
        });   
    }else{
    	
    	$("input[name='box']").each(function(){    
            if($(this).is(":checked"))    
            {    
            	$(this).prop('checked', false);
            	check(this);
            }    else{
            	
            }
        }); 
    }
	
}
</script>
<style>
	.biaoti{
		overflow:hidden;
		position:relative;
		left:100px;
		top:-70px;
		width:600px;
		height:50px;
		
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
		<tr><td width="20px"><input type="checkbox" onclick="checkall(this)"></td><td align="center"width="80px">图片</td><td width="500px">商品信息</td><td width="100px">单价(元)</td><td width="100px">数量</td><td width="100px">小计(元)</td><td width="100px">操作</td></tr>
		<c:forEach items="${ois}" var="oi" varStatus="st">
			<tr><td></td></tr>
			<tr>
				<td><input type="checkbox" name="box" onclick="check(this)" ></td>
				<td><img width="80px" height="80px"src="${oi.product.image_src }"></td>
				<td>${oi.product.name }</td>
				<td>${oi.product.value }</td>
				<td><button type="button" style="width:20px;height:30px;"  onclick="minnum(this)" id="${oi.product.id}">-</button>
					<input  disabled="disabled" style="width:30px;height:30px;" type="text" value="${oi.number } "  name="number" >
					<button type="button"style="width:20px;height:30px;"  onclick="addnum(this)" id="${oi.product.id}">+</button></td>
				<td value="1">${oi.number*oi.product.value }</td>
				<td><button><a href="deleteOrderItem?product_id=${oi.product.id}&user_id=${user.id}">删除</a></button></td>
			</tr>
			
		</c:forEach>
		<tr><td colspan="5"></td><td  >总价:<font style="color:red;" size="6" id="zongjia">  0.00</font></td><td><button type="button" >支付</button></td></tr>
	</table>
</body>
</html>
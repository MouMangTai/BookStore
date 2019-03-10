<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
</head>
<script>
	function judge(){
		var a = document.getElementById("mail").value;
		var b = document.getElementById("password").value;
		if(a==""||b==""){
			alert("请输入完整的信息");
			return false;
		}
		return true;
	}
</script>

<body>
	<jsp:include page="DaoHangLan.jsp" flush="true"/>
	<center>
            <h1>用户登录</h1>
    </center>
    <hr>
	<table align="center" >
		<form action="login" method="post">
			<tr><td>邮箱:</td><td><input type="text" name="mail" id="mail" value="${LastLoginMail }" placeholder="输入邮箱" class="form-control"></td></tr>
			<tr><td>密码:</td><td><input type="password" name="password" id="password"  placeholder="输入密码" class="form-control"></td></tr>
			<tr><td colspan="2"><input  class="btn btn-block" type="submit" value="登陆" onclick="return judge();"></td></tr>
			<tr><td colspan="2"><div style="float:right;"><input name="checkadmin"type="checkbox">管理员登陆</div></td></tr>
		</form>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Suncool后台管理</title>
<style>
	#submitBtn{width:200px;height:30px;border-radius:3px;background:orange;border:solid 1px orange;color:white;font-size:15px;cursor:pointer;}	
	#loginForm{margin:0 auto;margin-top:200px;}
</style>
</head>
<body>  
<center>  
  
<form method="POST" name="form" action="admin.action" id="loginForm">  
        用户名 :<input type="text" name="admin.username" style="margin-bottom:5px;"/><br/>
        密&nbsp;&nbsp;&nbsp;码 :<input type="password" name="admin.password" style="margin-bottom:5px;"/><br/>
	<input type="submit" name="btnSubmit" value="登录" id="submitBtn"/>  
</form>  
  
</center>  
</body>  
</html>
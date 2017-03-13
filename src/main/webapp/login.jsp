<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>  
<center>  
  
<form method="POST" name="form" action="admin.action">  
<table>  
    <tr>  
        <td>用户名 : </td>  
        <td><input type="text" name="admin.username" /></td>  
    </tr>  
    <tr>  
        <td>密 码 : </td>  
        <td><input type="password" name="admin.password" /></td>  
    </tr>  
    <tr>  
        <td colspan="2" align="center">  
            <input type="submit" name="btnSubmit" value="登录"/>  
        </td>  
    </tr>  
</table>  
</form>  
  
</center>  
</body>  
</html>
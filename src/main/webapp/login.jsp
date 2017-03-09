<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form class="easyui-form" method="post" action="admin.action">
	    			用户名:<input class="easyui-textbox" type="text" name="username" data-options="required:true"/>
	    			密&nbsp;码:<input class="easyui-textbox" type="password" name="password" data-options="required:true"/>
	    			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">登 录</a>
	    			<input type="submit" value="登 录">
	    	</form>
</body>
</html>
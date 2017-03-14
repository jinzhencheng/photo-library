<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="upload.action" enctype="multipart/form-data"
		method="post">
		<s:textfield name="title" labe="文件标题"></s:textfield>
		<s:file name="upload" labe="choose"></s:file>
		<s:submit value="上传"></s:submit>
	</s:form>
</body>
</html>

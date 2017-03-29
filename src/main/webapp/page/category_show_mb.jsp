<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="jh.studio.entity.Category" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<div class="searchbar">
		<a class="searchbar-cancel">取消</a>
		<div class="search-input">
		  <label class="icon icon-search" for="search"></label>
		  <input type="search" id='search' placeholder='输入标签'/>
		</div>
	</div>
  <div class="list-block media-list">
    <ul id="categoryList">
    	<% 
    		List<Category> list=(List<Category>)request.getAttribute("categories");
			for(Category c:list){
    	%>
		<li>
			<a href="category_photo_mb.html?categoryId=<%=c.getId() %>" class="item-link item-content">
				<div class="item-media"><img src="" style="width:4rem;" /></div>
				<div class="item-inner">
					<div class="item-title-row">
					  <div class="item-title"><%=c.getName() %></div>
					</div>
			  </div>
			</a>
		  </li>
    	<%
			}
    	%>
      
    </ul>
</div>
</body>
</html>
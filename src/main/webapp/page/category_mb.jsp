<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.List" import="jh.studio.entity.Category" %>
<head>
    <link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm.min.css">
	<style type="text/css">
		.category-nav{color:orange;}
		#show-info{font-size:12px;color:orange;}
	</style>
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/photo-library-pub.js"></script>
</head>
<body>
<div class="row no-gutter">
  <div class="col-25">
	  <div class="list-block" style="margin-top:0px;" id="category-nav-div">
		<ul>
		  <li class="item-content">
			  <div class="item-title category-nav" link='thePhoto!fetchYearAndMonth.action'>时间轴</div>
		  </li>
		  <li class="item-content">
			  <div class="item-title" link="category_tag_mb.html">热门标签</div>
		  </li>
		  <%
			  List<Category> list=(List<Category>)request.getAttribute("categories");
			  for(Category c:list){
		  %>
		  <li class="item-content">
			  <div class="item-title" link="theCategory!fetchCategoryByParent.action?categoryId=<%=c.getId() %>"><%=c.getName() %></div>
		  </li>
		  <%
			  }
		  %>
		  </ul>
	  </div>
  </div>
  <div class="col-75" id="category-content">
	  <div id="show-info">正在加载...</div>
	  <div id="show-content">
	  </div>
  </div>
</div>
</body>
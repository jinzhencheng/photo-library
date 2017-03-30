<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="jh.studio.entity.Photo" %>
<%@ page import="jh.studio.entity.Pagination" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>收藏</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="/favicon.ico">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">

	<link href="../css/photoswipe.css" type="text/css" rel="stylesheet" />
	<style type="text/css">
		.gallery { list-style:none; padding:0; margin: 0; }
		.gallery:after { clear:both; content:"."; display: block; height: 0; visibility: hidden; }
		.gallery li { float:left; width:33.33333333%; text-align:center;}
		.gallery li a{ display:block; margin:2px;margin-bottom:-1px; border:1px solid #ccc; }
		.gallery li img { display:block; width:100%; height:5rem;} 
		.btn{width:45%;!important;height:auto;background:orange;border:solid 1px white;color:white;min-height:30px;border-radius:3px;}
		#nextBtn{float:right;}
		#preBtn{float:left;}
	</style>
	<script type="text/javascript" src="../js/klass.min.js"></script>
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="../js/code.photoswipe-3.0.5.js"></script>
	<script type="text/javascript" charset="utf-8" src="../js/jquery.transit.js"></script>
	<script type="text/javascript" charset="utf-8" src="../js/hammer.js"></script>
	<script type="text/javascript" charset="utf-8" src="../js/jquery.hammer.js"></script>
		
	<script type="text/javascript">
	$(function(){
		$("#gallery a").photoSwipe();
		$("#nextBtn").click(function(){
			var pageIndex=$(this).attr("pageIndex");
			++pageIndex;
			$fetchList(pageIndex);
		});	
		$("#preBtn").click(function(){
			var pageIndex=$(this).attr("pageIndex");		
			--pageIndex;
			$fetchList(pageIndex);
		});
		var $fetchList=function(pageIndex){
			console.log(pageIndex);
			window.location.href="theCollection!listByCollect.action?pageIndex="+pageIndex;
		}
	});

	</script>

  </head>
  <body>
  	<div class="content">
  		<ul id="gallery" class="gallery">
		  <% 
			List<Photo> list=(List<Photo>)request.getAttribute("photos"); 
			for(Photo entity:list){
			%>
				<li class="<%=entity.getId()%>"><a href="<%= entity.getPath()%>"><img src="<%= entity.getMinpath() %>" alt="<%= entity.getName() %>"/></a></li>
			<%
				} 
				%>
  		</ul>
	</div>
	<br/><br/>
	<%
		Pagination pager=(Pagination)request.getAttribute("pager");
		int pageIndex=pager.getPage();
		int pageCount=pager.getPageCount();
		String nextDisabled="";
		String preDisabled="";
		String isShow="block";
		if(pageIndex+1==pageCount){
			isShow="none";	
		}
		if(pageCount-pageIndex <= 0){
			nextDisabled="disabled='true'";
		}
		if(pageIndex-1 <=0){
			preDisabled="disabled='true'";
		}
	%>
	<div style="display:<%=isShow %>">
		  <button id="preBtn" class="btn" <%=preDisabled %> pageIndex="<%=pageIndex %>">上一页</button>	
		  <button id="nextBtn" class="btn" <%=nextDisabled %> pageIndex="<%=pageIndex %>">下一页</button>	
	</div>
  	
  </body>
</html>
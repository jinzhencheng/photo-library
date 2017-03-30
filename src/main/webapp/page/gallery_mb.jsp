<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.List" import="jh.studio.entity.Photo" import="jh.studio.entity.Pagination"%>

<link href="../css/photoswipe.css" type="text/css" rel="stylesheet" />
<style type="text/css">
	.gallery { list-style:none; padding:0; margin: 0; }
	.gallery:after { clear:both; content:"."; display: block; height: 0; visibility: hidden; }
	.gallery li { float:left; width:33.33333333%; text-align:center;}
	.gallery li a{ display:block; margin:2px;margin-bottom:-1px; border:1px solid #ccc; }
	.gallery li img { display:block; width:100%; height:5rem;} 
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
});
</script>

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

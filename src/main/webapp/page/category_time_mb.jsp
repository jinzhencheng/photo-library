<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %>
	<style type="text/css">
		.time-month{display:none;}
	</style>
	<script type="text/javascript">
		$(function(){
			$(".time-year").click(function(){
				$("."+$(this).text()).toggle();
			});
			$(".time-month").click(function(){
				var year=$(this).attr("year");
				var month=$(this).find("span").text();
				var gallery=$(this).find(".the-gallery");
				//gallery.toggle();
				if(gallery.css("display")=="none"){
					gallery.load("thePhoto!fetchPictureByDate.action?year="+year+"&month="+month);
					gallery.show();
				}else{
					gallery.hide();
				}
			});
		});
	</script>
	<%
		Map<String,List<String>> map=(Map<String,List<String>>)request.getAttribute("map");
	 	Iterator<String> it=map.keySet().iterator();
	 	while(it.hasNext()){
	 		String key=it.next();
	%>
		<div class='time-year'><%=key %></div>
	<%
		List<String> months=map.get(key);
		for(String month:months){
	%>
		<div class='time-month <%=key%>' year='<%=key %>'>
		<span><%=month %></span>
		<div class='the-gallery' style="display:none"></div>
		</div>
	<% 	
		}
	}
	%>
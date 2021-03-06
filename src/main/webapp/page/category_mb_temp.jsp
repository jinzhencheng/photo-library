<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="jh.studio.entity.Category" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>SunCool图库</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="/favicon.ico">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm.min.css">
    <link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm-extend.min.css">
	<style type="text/css">
		.category-nav{color:orange;}
		.time-year{width:100px;height:auto;}
		.time-month{width:100px;height:auto;display:none;}
		#show-info{font-size:12px;color:orange;}
	</style>
	
  </head>
  <body>
        <div class="page">
            <header class="bar bar-nav">
				<a class="icon icon-left pull-left"></a>
                <a class="icon pull-left">微信</a>
            </header>
            <!-- 工具栏 -->
            <nav class="bar bar-tab">
                <a class="tab-item active" href="#">
                    <span class="icon icon-app"></span>
                    <span class="tab-label">分类</span>
                </a>
                <a class="tab-item external" href="search_mb.html">
                    <span class="icon icon-search"></span>
                    <span class="tab-label">搜索</span>
                </a>
                <a class="tab-item external" href="collection_mb.html">
                    <span class="icon icon-star"></span>
                    <span class="tab-label">收藏</span>
                </a>
                <a class="tab-item external" href="more_mb.html">
                    <span class="icon icon-menu"></span>
                    <span class="tab-label">更多</span>
                </a>
            </nav>

            <!-- 内容区 -->
            <div class="content">
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
					  	<div id="show-content"></div>

					  </div>
					</div>
                </div>
			</div>
    <script type='text/javascript' src='//g.alicdn.com/sj/lib/zepto/zepto.min.js' charset='utf-8'></script>
    <script type='text/javascript' src='//g.alicdn.com/msui/sm/0.6.2/js/sm.min.js' charset='utf-8'></script>
    <script type='text/javascript' src='//g.alicdn.com/msui/sm/0.6.2/js/sm-extend.min.js' charset='utf-8'></script>
	<script type="text/javascript" src="../js/photo-library-pub.js"></script>
  </body>
</html>
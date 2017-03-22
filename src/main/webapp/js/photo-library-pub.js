/**
 * Auhtor:jinzhencheng
 * Date:2017/03/14
 */

$(function(){
	$("#show-content").load("category_time_mb.html");
	$("#category-nav-div ul li div.item-title").click(function(){
		$(".category-nav").removeClass("category-nav")
		$(this).addClass("category-nav");
		$("#show-content").load($(this).attr("link"));
	});

});
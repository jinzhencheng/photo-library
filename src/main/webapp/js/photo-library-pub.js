/**
 * Auhtor:jinzhencheng
 * Date:2017/03/14
 */

$(function(){
	$("#show-content").load("thePhoto!fetchYearAndMonth.action",function(){
		$("#show-info").hide();
	});
	$("#category-nav-div ul li div.item-title").click(function(){
		$(".category-nav").removeClass("category-nav")
		$(this).addClass("category-nav");
		$("#show-info").show();
		$("#show-content").load($(this).attr("link"));
		$("#show-info").hide();
	});
});
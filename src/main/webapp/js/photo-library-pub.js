/**
 * Auhtor:jinzhencheng
 * Date:2017/03/14
 */

$(function(){
	$("#category-content").load("category_time_mb.html");
	$("#category-nav ul li div.item-title").click(function(){
		var linkAddr=$(this).attr("link");
		$("#category-content").load(linkAddr);
	});
});
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
	/*

	//根据年月抓取图片
	$(".month").on("click",function(){
		var current_year=$(this).parent(".year").attr("value");
		var current_month=$(this).attr("value");
		$.ajax({
			url:"photo!getPicture.action",
			data:{"year":current_year,"month":current_month},
			success:function(data){
				var imgs="";
				$.each(data,function(index,item){
					imgs.concat("<img maxPath="+item.path+" src='"+item.minpath+"'/>")
				});
				$(this).html(imgs);
			},
			error:function(){
				$.alert("数据获取失败");
			}
		});
	});
	*/

});
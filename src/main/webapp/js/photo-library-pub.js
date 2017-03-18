/**
 * Auhtor:jinzhencheng
 * Date:2017/03/14
 */

$(function(){
	$("#category-content").load("category_time_mb.html");
	$("#category-nav ul li div.item-title").click(function(){
		$(".category-nav").removeClass("category-nav")
		$(this).addClass("category-nav");
		$("#category-content").load($(this).attr("link"));
	});
	//抓取年份
	$.ajax({
		url:'photo!getYear.action',
		dataType:"json",
		success:function(data){
			var years="";
			$.each(data,function(index,item){
				years.concat("<div class='year' value='"+item+"'>"+item+"</div><br/>")
			})
			$("#category-content").html(years);
		},
		error:function(){
			$.alert("数据获取失败");
		}
	});

	//抓取月份
	$(".year").on("click",function(){
		if($(this).children().length!=0){
			$(this).children().hide();
			return;
		}
		var current_year=$(this).attr("value");
		$.ajax({
			url:"photo!getMonth.action",
			data:{"year":current_year},
			success:function(data){
				var months="";
				$.each(data,function(index,item){
					months.concat("<div class='month' value='"+item+"'>"+item+"</div><br/>");
				});
				$(this).html(months);
			},
			error:function(){
				$.alert("数据获取失败");
			}
		});	
	});
	
	//根据年月抓取图片
	$(".month").on("click",function(){
		if($(this).children().length!=0){
			$(this).children().hide();
			return;
		}
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

});
$(document).ready(function() {
	//发起请求获取商品详情信息
	var str = window.location.href;
	var itemId = str.split("?product_id=")[1];
	//alert(itemId);
	
	getItemDetail(itemId);	
	//getItemDetail();

	$(function() {

		$('.tabs a').click(function() {

			var $this = $(this);
			$('.panel').hide();
			$('.tabs a.active').removeClass('active');
			$this.addClass('active').blur();
			var panel = $this.attr("href");
			$(panel).show();
			return false; //告诉浏览器  不要纸箱这个链接
		}) //end click

		$(".tabs li:first a").click() //web 浏览器，单击第一个标签吧

	}) //end ready

	$(".centerbox li").click(function() {
		$("li").removeClass("now");
		$(this).addClass("now")

	});
	
	getUserName();
});

function getItemDetail(itemId){
	$.ajax({
    	//url :'http://39.107.247.211:8080/CampusFleaPlatform_war/goods/catelog',
    	url :'./goods/findOne?product_id='+itemId,
		//url:'./detail.json',
        type: 'get',
        async:true,
        dataType: 'json',
        //jsonp: 'callback',
        //timeout: 5000,
        data: {
             //"itemId" : itemId
        },
        success: function(data) {
            console.log(data.data);
            var info = data.data;
			//alert(info.name);
			$('.id').html(info.product_id);
			$('.ownerId').html(info.owner_id);
            $('.name').html(info.product_name);
			$('.time').html(info.launch_time.substring(0, 10));
            $('.describle').html(info.product_detail);
            //$('.realPrice').html(info.realPrice);
            $('.newPrice').html(info.product_price);
            $("#addCart").html(itemId);
            //var imgURL = data.data.imgUrl;
            /*var arr = data.data.imgUrl.split(";");
            for (var i = 0; i < arr.length-1; i++) {
				//alert(arr[i]);
				var imgHTML=document.createElement('img');
				imgHTML.src = arr[i];
				imgHTML.width = 400;
				imgHTML.height = 400;
				$("#showbox").append(imgHTML); 	
				
			}*/
			var imgHTML=document.createElement('img');
				imgHTML.src = info.image_url;
				console.log(imgHTML.src);
				imgHTML.width = 400;
				imgHTML.height = 400;
				$("#showbox").append(imgHTML);
            //alert("haaaaaa")
            var showproduct = {
				"boxid": "showbox",
				"sumid": "showsum",
				"boxw": 400,
				"boxh": 400,
				"sumw": 60, //列表每个宽度,该版本中请把宽高填写成一样
				"sumh": 60, //列表每个高度,该版本中请把宽高填写成一样
				"sumi": 7, //列表间隔
				"sums": 5, //列表显示个数
				"sumsel": "sel",
				"sumborder": 1, //列表边框，没有边框填写0，边框在css中修改
				"lastid": "showlast",
				"nextid": "shownext"
			}; //参数定义	 
            $.ljsGlasses.pcGlasses(showproduct); //方法调用，务必在加载完后执行
        },
        error:function(){
            console.log("放大镜error")
        }
    });
	
}
function getUserName(){
	
		$("#username").css("display","inline-block");
		$.ajax({
	    	//url :'http://39.107.247.211:8080/CampusFleaPlatform_war/goods/catelog',
	    	url :'./user/findUser',
			//url:'./user.json',
	        type: 'get',
	        async:true,
	        dataType: 'json',
	        timeout: 5000,
	        
	        success: function(data) {
	            //alert(data);
	           if(data.code!=-1)
				{
					$("#user").html(data.data.user_id);
					$('.undone').css('display','none');
					$('.done').css('display','block');
				}
			   else
				{
					alert('获取用户信息失败');
					$('#username').hide();
					$('.btn-primary').show();

				}
	        },
	        error:function(){
	            $('#username').hide();
				$('.btn-primary').show();
				console.log("error");
	        }
    	});

}

function addToCart(){
   var yesOrNo = confirm("确定要购买么？");
   if(yesOrNo)
{
   var product_id=$('.id').html();
   var buyer_id=$('#user').html();
   if(buyer_id!="null")
	{window.location.href="./buycart.html?product_id="+product_id+"&buyer_id="+buyer_id;}
   else 
	{window.location.href="./denglu.html";}
   //alert(window.location.href);
}
}
$("#userSubmit").click(function(){
	window.location.href="./denglu.html";
});

$("#register").click(function(){
	window.location.href="./zhuce.html";
});

$("#firstbuy").click(function(){
	window.location.href="./buy.html";
});

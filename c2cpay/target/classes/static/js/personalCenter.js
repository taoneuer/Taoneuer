$(function() {
    /*getUserName();*/
	queryZL();
});

//点击左侧列表项的操作
$(".sideBar li").click(function(){
	$('.contTitle').html($(this).text().trim());//更改右侧题头
	$('.sideBar a').removeClass('active');//移除目前<a>的active类
	$(this).children('a').addClass('active');//为当前点击的li项添加具有active类<a>
});

//点击左侧列表个人资料项
$('.ziliao').click(function(){
	queryZL();
});

//点击左侧列表购买项
$('.goumai').click(function(){
	queryGM();
});

//点击左侧列表收藏项
$('.shoucang').click(function(){
	querySC();
});

//点击左侧列表点赞项
$('.dianzan').click(function(){
	queryDZ();
});

//点击左侧列表闲置项
$('.xianzhi').click(function(){
	queryXZ();
});

//个人资料
function queryZL(){
	$.ajax({
		url :'user/findUser',
		type: 'GET',
		async: true,
		dataType: 'json',
		timeout: 5000,
		/*data: {
			"sessionId": typeof($.cookie('sessionId')) == 'string' ? $.cookie('sessionId') : ''
		},*/
		success: function(data) {
			console.log(data);
			//头部信息填充
			$('.head-username').html(data.data.user_id);
			$('.head-account').html(data.data.student_id);
			//个人资料栏填充
			$('.zl_major').html(data.data.major);
			$('.zl_institute').html(data.data.institute);
			$('.zl_address').html(data.data.address);
			$('.zl_certification').html(data.data.certification);
			$('.zl_tradeNum').html(data.data.tradeNum);
			$('.zl_user_id').html(data.data.user_id);
			$('.zl_user_name').html(data.data.user_name);
			$('.zl_student_id').html(data.data.student_id);
		},
		error: function() {
			console.log("请求用户信息error");
		}
	});
}

//我的购买
function queryGM() {

}

//我的收藏
function querySC() {

}

//我的点赞
function queryDZ() {

}

//检验修改密码时两次输入是否相同
$("#inputPassword2").blur(function () {
	if($("#inputPassword1").val() != $("#inputPassword2").val())
	{
		var span = $('#s_password');
		span.html("两次输入密码不一致");
	}
})

//点击修改密码项中提交按钮
$('#sub_password').click(function(){
	changePassWord();
});

//修改密码
function changePassWord() {
	var id = $('.zl_user_id').html();
	var password = $("#inputPassword1").val();
	$.ajax({
		url:'user/updatePassword',
		type:'post',
		data:{"user_id":id,
			"user_password":password},
		success:function (data) {
			$('#s_submit').html("data.msg");

		}
	});
}


/*
//点击我的闲置提交
$('.sub_xianzhi').click(function(){
	queryXZ();
});
*/

//我的闲置
function queryXZ(){
	$.ajax({
		url :'goods/findRelease',
		//url :'../xianzhi.json',
        type: 'GET',
        //async: true,
        //dataType: 'jsonp',
		dataType: 'json',
        //jsonp: 'callback',
        timeout: 5000,
        /*data: {
            "sessionId": typeof($.cookie('sessionId')) == 'string' ? $.cookie('sessionId') : ''
        },*/
		data:{"owner_id":$('.zl_user_id').html()},
        success: function(data) {
            console.log(data);
            //template(定义模板的id,数据)
            //var goods_html = template('my-xianzhi-template', {model: data});
            var goods_html = template('my-xianzhi-template',data);
		    console.log(goods_html);
            $('#xianzhi').html(goods_html);
            //tableMethod()
        },
       /* success:function(){
        	console.log("keyi");
		},*/
        error: function() {
            console.log("error");
        }
    });
}

function getItemDetail(itemId){
	//alert(itemId);
	var itemId = itemId;
	//alert(itemId);
	window.location.href="shopdetail.html?product_id="+itemId;
	//alert(id)
}

/*function getUserName() {
	if(typeof($.cookie('sessionId')) == 'string')
	{
		$("#username").css("display", "inline-block");
		console.log($.cookie('sessionId'));
		$.ajax({
			//url :'http://39.107.247.211:8080/CampusFleaPlatform_war/goods/catelog',
			url: 'http://192.168.43.213:8080/user/getUserName',
			type: 'GET',
			async: true,
			dataType: 'jsonp',
			jsonp: 'callback',
			timeout: 5000,
			data: {
				"sessionId": $.cookie('sessionId')
			},
			success: function(data) {
				//alert(data);
				if(data.code == "true") {
					$("#user").html(data.username);
				}
				$('.undone').css('display', 'none');
				$('.done').css('display', 'block');

			},
			error: function() {
				console.log("error")
			}
		});
	} else {
		$('#username').hide();
		$('.btn-primary').show();
	}
}*/

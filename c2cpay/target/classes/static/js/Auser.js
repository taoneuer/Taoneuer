<!--管理员资料-->

function admin_info(){
	$.ajax({
		//url :'http://39.107.247.211:8080/CampusFleaPlatform_war/user/getUserInfo',
		url: './userinfo.json',
		type: 'post',
		async: true,
		dataType: 'json',
		data: {
			"sessionId": typeof($.cookie('sessionId')) == 'string' ? $.cookie('sessionId') : ''
		},
		success: function(rdata) {
			
			console.log(rdata);
			$("#ID").html(rdata.id);
			$("#username").html(rdata.username);
			
		},
		error: function() {
			
			alert('异常！！');
		}
	});
}

<!--用户列表-->
function user_list(){
		$.ajax({
        type: "get",
        url: './admin/page',
        cache: true,
        async: true,
        dataType: "json",
        success: function(rdata){
			var user_html = template('user-template',rdata);
			$("#user_list").html(user_html);
			var user_list = rdata.list.length;
			$("#user_length").html(user_list+" 条数据");
			
           // var message = rdata.msg;
			//alert(message);
			
        },
		
	   error:function () {      
               
                alert('异常！！！！');
            }
    });
	
	
}

<!--用户查询-->
function search_user() {
    //console.log($(obj).parents().text());
    var userid = $("#username").val();
    //console.log(username);
    $.ajax({
        type : "post",
        url : "./admin/searchUser",
        //url:'.arch.json',
        data : {
            "userID": userid
        },
        cache : true,
        async : true,
        dataType:"json",
        success: function (rdata){
            var ob = rdata.data;
            var user_html = '<td>'+ob.user_id+'</td>'+
                '<td>'+ob.student_id+'</td>'+
                '<td>'+ob.user_name+'</td>'+
                '<td>'+ob.institute+'</td>'+
                '<td>'+ob.major+'</td>'+
                '<td>'+ob.address+'</td>'+
                '<td>'+ob.tradeNum+'</td>'+
                '<td>'+ob.status+'</td>'+
                '<td>'+ob.certification+'</td>'+
                '<td class="td-manage">'+
                '<a title="编辑"  onclick="x_admin_show(\'编辑\',\'member-edit.html\',\'\',600,400)" href="javascript:;">'+
                '<i class="layui-icon">'+'&#xe642;'+'</i></a>'+
                '<a title="重置密码" onclick="reset_pw(userid)"  href="javascript:;">'+
                '<i class="layui-icon">'+'&#xe631;'+'</i>'+
                '</a>'+
                '<a title="删除" onclick="del_user(this)" href="javascript:;">'+
                '<i class="layui-icon">'+'&#xe640;'+'</i>'
            '</a>'+
            '</td>'
            $("#user_list").html(user_html);
        },
        error : function() {
            alert("异常！");
        }
    });
}

<!--添加用户-->
function add_user() {
      var username = $("#L_username").val();
	  //console.log(username);
	  var password = $("#L_repass").val();
      //var sex = $('input[name="sex"]:checked').val();
      var data={
          "user_id":username,
          "user_password":password
      }
      
      $.ajax({
          type : "post",
          url : "admin/adduser",//这是你要请求的接口网址，之后所有接口都是随便写的接口
          data : data,//传输的数据，当然传输的数据也可以在url链接后面打个问号传
          cache : true, // 表示浏览器是否缓存被请求页面,默认是 true
          async : true, // 异步，默认开启，也就是$.ajax后面的代码是不是跟$.ajax里面的代码一起执行
          dataType:"json",   // 返回浏览器的数据类型，指定是json格式，前端这里才可以解析json数据
          success: function (rdata){

                    alert("成功");//cichucharuweigengxin

			  var index = parent.layer.getFrameIndex(window.name);
				  //关闭当前frame
			  parent.layer.close(index);
			 
          },
          error:function () {      
             
              alert("异常！");
          }
          
      });
  }

<!--重置密码-->
function reset_pw(id){
	var yesOrNo = confirm("确定要重置密码么？");
    if(yesOrNo){
		 $.ajax({
          type : "post",
          url : "./admin/resetpassword",//这是你要请求的接口网址，之后所有接口都是随便写的接口
          data : {"userID":id},//传输的数据，当然传输的数据也可以在url链接后面打个问号传
          cache : true, // 表示浏览器是否缓存被请求页面,默认是 true
          async : true, // 异步，默认开启，也就是$.ajax后面的代码是不是跟$.ajax里面的代码一起执行
          dataType:"json",   // 返回浏览器的数据类型，指定是json格式，前端这里才可以解析json数据
          success: function (rdata){
			  rdata.msg="hh";
              alert(rdata.msg);
          },
          error:function () {      
             
              alert("异常！");
          }
          
      });
  }
}
<!--用户删除-->
function del_user(obj){
    var id = $(obj).parents("tr").find("td").first().text();
	//alert(id);
    var yesOrNo = confirm("确定要删除该用户么？");
    if(yesOrNo){
        $.ajax({
            //几个参数需要注意一下
            type: "delete",//方法类型
            dataType: "json",//预期服务器返回的数据类型
			url:"./admin/deleteuser",
            //url: "delete?sid="+sid ,//url
			data:{"userID" : id },
            success: function (rdata) {
                //console.log(rdata.message);//打印服务端返回的数据(调试用)
                alert(rdata.msg);
				$(obj).parents("tr").remove();
            },
            error : function() {
                alert("异常！");
            }
			
        }); 
		
    }
}


<!--用户修改-->
function edit_user(e){
    
    //alert(sid);
    $.ajax({
        //几个参数需要注意一下
        type: "GET",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "edit?sid="+sid ,//url
        success: function (rdata) {
            //console.log(data);//打印服务端返回的数据(调试用)
            if (rdata.result == "success") {
                var stu = rdata.data;
                $("#sid").val(stu.sno);
                $("#sname").val(stu.sname);
                if(stu.isMale){
                    $("#male").prop("checked",true);
                }else{
                    $("#female").prop("checked",true);
                }
                $("#birth").val(stu.birth);
                $("#filePath").val(stu.filePath);
                $("#photo2").attr("src",stu.filePath);
                $("#edit").css("display","block");
            }
        },
        error : function() {
            alert("异常！");
        }
    });
} 




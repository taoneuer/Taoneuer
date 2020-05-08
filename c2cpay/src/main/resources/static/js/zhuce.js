changeRootFont();
 function changeRootFont() {
         document.documentElement.style.fontSize = ((window.innerWidth / 750) * 100) + 'px';
          } 
         window.addEventListener('resize', changeRootFont, false)
//验证手机号是否合规         
var b=true;
/*var m= true;
//手机号未注册
var bm=true;
//邮箱
var by=true;*/
new Vue({
	el:"#vue-form",
	data:{
	},
	methods:{
		check:function(){
            //发送ajax请求
            $.ajax({
         	   type:"get",
         	   url:"user/exists",
         	   dataType:"json",
         	   data:{"username":$("#user_id").val()},
         	   success:function(data){
         		   var span = $("#s_username");
                    if(data.code==-1){
                        //用户名存在
                        span.css("color","red");
                        span.html("  此用户名已存在");
                    }else{
                        //用户名不存在
                        span.css("color","green");
                        span.html("  用户名可用");
                    }
         	   },
         	   error:function(){
    	    		alert("表单请求失败");
    	    	}
            });
		},
		pwd:function(){
			var str=$("#pwd").val();
			var re5=/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z\d]{8,16}$/;
			if(!re5.test(str)||$("#pwd").val().length==0){
					      		$(".pwd").css("display","block");
					      		b=false;
					      		return false;
					      	}else{
				      		    $(".pwd").css("display","none");
				      		    b=true;
					      	}
		},
		psd:function(){
			if($("#pwd").val()==$("#psd").val()&&$("#psd").val().length!=0){
				$(".psd").css("display","none");
				b=true;
			}else{
				$(".psd").css("display","block");
				b=false;
			}
		},
		
	}
})
$("#pwd").focus(function(){
	$(".pwd").css("display","none");
	b=true;
});
$("#psd").focus(function(){
	$(".psd").css("display","none");
	b=true;
});
var timer = null;
var number = 60;
var bOnOff = true;
var sId="";
$("#sub").click(function(){
	if(b==true){
		var tdata={
				"user_id":$("#user_id").val(),
				"user_name":$("#user_name").val(),
				"user_password":$("#pwd").val(),
				"major":$("#major").val(),
				"student_id":$("#student_id").val(),
				"institute":$("#institute").val(),
				"address":$("#address").val()
		}
		alert(JSON.stringify(tdata));
	  $.ajax({
	    	type:"post",
	    	url:"user/register",
	    	dataType:"json",
			jsonp:"callback",
			contentType: 'application/json;charset=utf-8',
	/*data:{"user_name":$("#name").val(),"sessionId":sId,"user_password":$("#pwd").val()},*/
	/*data:{"user_name":$("#user_id").val(),"user_password":$("#pwd").val()},*/
			data:JSON.stringify(tdata),
	    	success:function(data1){
	    		if(data1.code==0){
	    			/*alert(data1.msg);*/
	    			window.location.href="denglu.html";
	    		}else{
	    			alert("请重新注册");
	    		}
	    	},
	    	error:function(){
	    		alert("表单请求失败");
	    	}
	    });
	}
	else{
		alert("表单提交失败");
	}
})

//  var ddlProvince = document.getElementById("province");
//  var ddlCity = document.getElementById("city");
//  for(var i =0;i<list1.length; i++)
//  {
//      var option = document.createElement("option");
//      option.appendChild(document.createTextNode(list1[i]));
//      option.value = list1[i];
//      ddlProvince.appendChild(option);
//      //city initialize
//      var firstprovince = list2[0];
//      for (var j = 0; j < firstprovince.length; j++) {
//          var optioncity = document.createElement("option");
//          optioncity.appendChild(document.createTextNode(firstprovince[j]));
//          optioncity.value = firstprovince[j];
//          ddlCity.appendChild(optioncity);
//      }
//  }
//  function indexof(obj,value)
//  {
//      var k=0;
//      for(;k<obj.length;k++)
//      {
//          if(obj[k] == value)
//          return k;
//      }
//      return k;
//  }
//  function selectprovince(obj) {
//      ddlCity.options.length = 0;//clear
//      var index = indexof(list1,obj.value);
//      var list2element = list2[index];
//      for(var i =0;i<list2element.length; i++)
//      {
//          var option = document.createElement("option");
//          option.appendChild(document.createTextNode(list2element[i]));
//          option.value = list2element[i];
//          ddlCity.appendChild(option);
//      }
//  }

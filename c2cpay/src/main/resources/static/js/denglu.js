/*changeRootFont();

function changeRootFont() {
	document.documentElement.style.fontSize = ((window.innerWidth / 750) * 100) + 'px';
}
window.addEventListener('resize', changeRootFont, false)
window.onload = function() {
                createCode();
                var timeDiv = document.getElementById("time");
                window.setInterval(function(){
                    timeDiv.innerHTML = new Date().toLocaleString();
                }, 1000);
            };*/
var b = true;

var timer = null;
var number = 60;
var bOnOff = true;
var sId = "";
var m = true;
var bm = true;
new Vue({
		el: "#vue-user",
		data: {

		},
		methods: {
			/*onBlur: function() {
				var str = $("#username").val();
				var re = /^[1][3,4,5,7,8][0-9]{9}$/;
				if(!re.test(str)) {
					$("#prompt").css("display", "block");
					b = false;
					return false;
				} else {
					$("#prompt").css("display", "none");
					b = true;
				}
			},*/
			change: function() {
				createCode();
			},
			submit: function() {
				if(check()){
					if($("#username").val().length == 0 || $("#password").val().length == 0) {
						alert("用户名/密码不能为空");
					} else if(b == false) {
						;
					} else {
						$.ajax({
							type: "post",
							url: "user/login",
							/*url: "../json/pl.json",*/
							dataType: "json",
							async: true,
							/*jsonp: "callback",*/
							data: {
								"user_id": $("#username").val().toString(),
								"user_password": $("#password").val().toString()
							},
							success: function(data) {
								/*$.cookie("sessionId",data.sessionId);
								console.log(data);*/
								if(data.code == 0) {
									window.location.href = "homepage.html";
								} else {
									alert("密码和账号不匹配")
								}
								/*console.log(data);
								var f=data.code;
								if(f=="0"){
									window.location.href = "homepage.html";
								}else{
									alert("密码和账号不匹配")
								}*/
							},
							error: function() {
								alert("请求失败");
								createCode();
							}
						});
					}
			  }
			}
		}

	}

);

$("#username").focus(function() {
	$("#prompt").css("display", "none");
	b = true;
});
/*$("#btn-register").click(function() {
	window.location.href = "zhuce.html";
});*/
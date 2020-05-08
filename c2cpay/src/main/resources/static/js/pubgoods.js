(function($){
    $.fn.serializeJson=function(){
        var serializeObj={};
        $(this.serializeArray()).each(function(){
            serializeObj[this.name]=this.value;
        });
        return serializeObj;
    };

})(jQuery);

//点击上传图片按钮
$('#button').click(function () {
    var form=new FormData(document.getElementById("pic_register"));
    $.ajax({
        url:"uploadImg",
        type:"post",
        data: form,
        cache: false,
        /**
         *必须false才会自动加上正确的Content-Type
         */
        contentType: false,
        /**
         * 必须false才会避开jQuery对 formdata 的默认处理
         * XMLHttpRequest会对 formdata 进行正确的处理
         */
        processData: false,
        success:function (data) {
            if(data.code===0){
                alert(data.msg);
                $("#image_url").val(data.data);
            }else {
                alert(data.msg);
            }

        }
    })

    // $.ajax({
    //     url:'/uploadImg',
    //     type: 'post',
    //     data:JSON.stringify($("#pic_register").serializeJson()),
    //     dataType: "json",
    //     success:function (data) {
    //         $("#image_url").val(data.url);
    //     }
    // })

})

//点击发布商品按钮
$('.setting-save').click(function(event){
    var id;
    $.ajax({
        url :'user/findUser',
        type: 'GET',
        async: false,
        dataType: 'json',
        timeout: 5000,
        /*data: {
            "sessionId": typeof($.cookie('sessionId')) == 'string' ? $.cookie('sessionId') : ''
        },*/
        success: function(data) {
            console.log(data);
            id=data.data.user_id;
        },
        error: function() {
            console.log("获取error");
        }
    });
    //var id = $('.zl_user_id').html();
    //var id=$('.zl_user_id').html("111");
    //var id=$.cookie('sessionId');
    $("#owner_id").attr("value",id);
    $.ajax({
        url :'goods/release',
        type: 'POST',
        data:JSON.stringify($("#file-form").serializeJson()),
        dataType: "json",
        contentType: 'application/json;charset=utf-8',
        success: function (data) {
            alert('发布成功！');
            window.location.href="personalCenter.html";
            console.log(data);
        },
        error: function () {
            console.log("上传error")
        }
    });
});
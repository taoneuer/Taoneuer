
<!--订单列表-->
function order_list(){
		$.ajax({
        type: "get",
        url: './admin/orderList',
        cache: true,
        async: true,
        dataType: "json",
        success: function(rdata){
			var order_html = template('order-template',rdata);
			$("#order_list").html(order_html);
			var order_list = rdata.list.length;
			$("#order_length").html(order_list+" 条数据");
			
           // var message = rdata.msg;
			//alert(message);
			
        },
		
	   error:function () {      
               
                alert('异常！！！！');
            }
    });
	
	
}

<!--订单查询-->
function search_order() {
        //console.log($(obj).parents().text());
		var tradeID = $("#tradeID").val();
		//console.log(username);
        $.ajax({
            type : "post",
            url : "./admin/searchTradeID",
            data :{
                "tradeID": tradeID
            },
            cache : true,
            async : true,
            dataType:"json",


            success: function (rdata){
                var ob = rdata.data;
                var order_html = '<td>'+ob.tradeId+'</td>'+
                    '<td>'+ob.tradeTime+'</td>'+
                    '<td>'+ob.tradeTime+'</td>'+
                    '<td>'+ob.product_id+'</td>'+
                    '<td>'+ob.buyer_id+'</td>'+
                    '<td class="td-manage">'+
                    '<a title="删除" onclick="del_order(this)" href="javascript:;">'+
                    '<i class="layui-icon">'+'&#xe640;'+'</i>'
                '</a>'+
                '</td>'

                $("#order_list").html(order_html);
                var order_list = rdata.list.length;
                $("#order_length").html(order_list+" 条数据");
            },


        error : function() {
            alert("异常！");
        }
            
        });
		
                
          
    }


<!--订单删除-->
function del_order(obj){
    var id = $(obj).parents("tr").find("td").first().text();
	//alert(id);
    var yesOrNo = confirm("确定要删除该订单么？");
    if(yesOrNo){
        $.ajax({
            //几个参数需要注意一下
            type: "delete",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            //url: "delete?sid="+sid ,//
            url:"./admin/deletetraderecord",
			data:{"tradeID" : id },
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






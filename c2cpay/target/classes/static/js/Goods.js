
<!--商品列表-->
function goods_list() {
    $.ajax({
        type: "get",
        url: './admin/goodslist',
        cache: true,
        async: true,
        dataType: "json",
        success: function (rdata) {
            var goods_html = template('goods-template', rdata);
            $("#goods_list").html(goods_html);
            var goods_list = rdata.list.length;
            $("#goods_length").html(goods_list + " 条数据");

            // var message = rdata.msg;
            //alert(message);

        },

        error: function () {

            alert('异常！！！！');
        }
    });

}

<!--商品id查询-->
function search_goods_byid() {
        
        //console.log($(obj).parents().text());
		//alert(i);
		var id = $("#goodsid").val();
		//alert(id);
		var n_data={"productID": id};
		var n_url="./admin/searchByProductId";
		//var n_url="./search.json";
		//console.log(username);
        $.ajax({
            type : "post",
            url : n_url,
            data : n_data,
            cache : true,
            async : true,
            dataType:"json",           
            success: function (rdata){
			var ob=rdata.data;
            var goods_html = '<td>'+ob.product_id+'</td>'+
							'<td>'+ob.product_name+'</td>'+
							'<td>'+ob.product_category+'</td>'+
							'<td>'+ob.product_price+'</td>'+
							'<td>'+ob.owner_id+'</td>'+
							'<td>'+ob.productState+'</td>'+
							'<td>'+ob.zanNum+'</td>'+
							'<td>'+ob.launch_time+'</td>'+
							'<td class="td-manage">'+
							'<a title="删除" onclick="del_goods(this)" href="javascript:;">'+
							'<i class="layui-icon">'+'&#xe640;'+'</i>'
							'</a>'+
							'</td>'
			$("#goods_list").html(goods_html);
		  },
        error : function() {
            alert("异常！");
        }
            
        });
       
    }

<!--商品查询-->
function search_goods(i) {
        
        //console.log($(obj).parents().text());
		//alert(i);
		if(i==2)
		{
			var name = $("#goodsname").val();
			var n_data={"productname": name};
			var n_url="./admin/searchProductTrade";
			//var n_url="./user.json";
		}
		else if(i==3)
		{
			var category = $("#goodscategory").val();
			var n_data={"productcate": category};
			var n_url="./admin/searchByProductCategory";
			//var n_url="./user.json";
		}
		//console.log(username);
        $.ajax({
            type : "post",
            url : n_url,
            data : n_data,
            cache : true,
            async : true,
            dataType:"json",
            success: function (rdata){
            var goods_html = template('search-goods-template',rdata);
			$("#goods_list").html(goods_html);
			var goods_list = rdata.data.length;
			$("#goods_length").html(goods_list+" 条数据");
		  },
        error : function() {
            alert("异常！");
        }
            
        });
		
                
          
    }

<!--添加商品-->
function add_goods() {
      var id = $("#ID").val();
	  //console.log(username);
	  var name = $("#name").val();
      //var sex = $('input[name="sex"]:checked').val();
	  var cate = $("#category").val();
	  var ownerID = $("#ownerID").val();
	  var price = $("#price").val();
      var data={  
          "product_id":id,
          "product_name":name,
		  "product_category":cate,
		  "product_price":price,
          "owner_id":ownerID
      }
      
      $.ajax({
          type : "post",
          url : "admin/addProduct",//这是你要请求的接口网址，之后所有接口都是随便写的接口
          data : data,//传输的数据，当然传输的数据也可以在url链接后面打个问号传
          cache : true, // 表示浏览器是否缓存被请求页面,默认是 true
          async : true, // 异步，默认开启，也就是$.ajax后面的代码是不是跟$.ajax里面的代码一起执行
          dataType:"json",   // 返回浏览器的数据类型，指定是json格式，前端这里才可以解析json数据
          success: function (rdata){
              
			  alert(rdata.msg);
			  var index = parent.layer.getFrameIndex(window.name);
				  //关闭当前frame
			  parent.layer.close(index);
			 
          },
          error:function () {      
             
              alert("异常！");
          }
          
      });
  }

<!--商品删除-->
function del_goods(obj){
    var id = $(obj).parents("tr").find("td").first().text();
	//alert(id);
    var yesOrNo = confirm("确定要删除该物品么？");
    if(yesOrNo){
        $.ajax({
            //几个参数需要注意一下
            type: "delete",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            //url: "delete?sid="+sid ,//url
			url:"./admin/deleteProductID",
			data:{"productID" : id },
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






package com.sly.c2cpay.mapper;

import com.sly.c2cpay.pojo.ProductInfo;
import com.sly.c2cpay.pojo.TradeRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TradeMapper {

    /**
     * 添加订单
     * @param tradeRecord
     * @return
     */
    @Insert("insert into trade_record (trade_id,product_id,buyer_id,trade_time) VALUES(#{tradeId},#{productId},#{buyerId},#{tradeTime})")
    Integer addTrade(TradeRecord tradeRecord);


    /**
     * 查询订单
     * @param productId
     * @return
     */
    @Select("select * from trade_record where product_id =#{productId}")
    TradeRecord findProduct(int productId);

    /**
     * 买家查询正在交易中订单
     * @param buyerId
     * @return
     */
    @Select(" select * from product_info t1 where product_id in (SELECT product_id FROM trade_record t2 where buyer_id=#{buyerId} and t2.trade_state=1 ) ORDER BY launch_time desc")
    List<ProductInfo> findTrade(String buyerId);
}

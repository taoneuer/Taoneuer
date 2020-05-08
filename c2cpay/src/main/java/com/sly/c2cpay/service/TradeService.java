package com.sly.c2cpay.service;

import com.sly.c2cpay.mapper.TradeMapper;
import com.sly.c2cpay.pojo.ProductInfo;
import com.sly.c2cpay.pojo.TradeRecord;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface TradeService {

    /**
     * 添加订单
     * @param tradeRecord
     * @return
     */
   TradeRecord addTrade(TradeRecord tradeRecord);




    /**
     * 查询正在交易中的订单
     * @param buyerId
     * @return
     */
    List<ProductInfo> findTrade(String buyerId);

}

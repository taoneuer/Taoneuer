package com.sly.c2cpay.service.imp;

import com.sly.c2cpay.mapper.GoodsMapper;
import com.sly.c2cpay.mapper.TradeMapper;
import com.sly.c2cpay.pojo.ProductInfo;
import com.sly.c2cpay.pojo.TradeRecord;
import com.sly.c2cpay.service.TradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TradeServiceImp implements TradeService {

    @Resource
    TradeMapper tradeMapper;
    @Resource
    GoodsMapper goodsMapper;

    /**
     * 添加商品订单
     * @param tradeRecord
     * @return
     */
    @Override
    public Integer addTrade(TradeRecord tradeRecord) {
        //更新商品状态为正在交易中
        goodsMapper.updateStatus(tradeRecord.getProductId());
        return tradeMapper.addTrade(tradeRecord);
    }

    @Override
    public List<ProductInfo> findTrade(String buyerId) {
        return tradeMapper.findTrade(buyerId);
    }
}

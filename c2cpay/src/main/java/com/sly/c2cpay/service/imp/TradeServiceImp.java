package com.sly.c2cpay.service.imp;

import com.sly.c2cpay.mapper.GoodsMapper;
import com.sly.c2cpay.mapper.TradeMapper;
import com.sly.c2cpay.pojo.ProductInfo;
import com.sly.c2cpay.pojo.TradeRecord;
import com.sly.c2cpay.service.TradeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    @Override
    public TradeRecord addTrade(TradeRecord tradeRecord) {
        //更新商品状态为正在交易中
        TradeRecord trade=null;
        goodsMapper.updateStatus(tradeRecord.getProductId());
        Integer integer = tradeMapper.addTrade(tradeRecord);
        if(integer>=1){
            trade=tradeMapper.findProduct(tradeRecord.getProductId());
        }

        return trade;
    }

    @Override
    public List<ProductInfo> findTrade(String buyerId) {
        return tradeMapper.findTrade(buyerId);
    }
}

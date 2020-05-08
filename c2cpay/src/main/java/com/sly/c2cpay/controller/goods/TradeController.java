package com.sly.c2cpay.controller.goods;

import com.sly.c2cpay.pojo.ProductInfo;
import com.sly.c2cpay.pojo.ResultInfo;
import com.sly.c2cpay.pojo.TradeRecord;
import com.sly.c2cpay.service.TradeService;
import com.sly.c2cpay.utils.CodeUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/trade")
public class TradeController {

    @Resource
    TradeService tradeService;

    /**
     * 添加商品订单
     * @param buyerId
     * @param productId
     * @param request
     * @return
     */
    @PostMapping("/add")
    public ResultInfo addTrade(@RequestParam(value = "buyer_id",required = true) String buyerId,
                               @RequestParam(value = "product_id",required = true) int productId,
                               HttpServletRequest request){
        TradeRecord tradeRecord = new TradeRecord(buyerId, productId);
        tradeRecord.setTradeId(CodeUtils.getTradeId());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        tradeRecord.setTradeTime(Timestamp.valueOf(format));
        TradeRecord trade = tradeService.addTrade(tradeRecord);

        return trade==null? new ResultInfo(-1, null, "失败", request.getRequestURI()):
                                                        new ResultInfo(0, trade, "成功", null);
    }

    /**
     * 查询订单
     * @param buyerId
     * @param request
     * @return
     */
    @GetMapping("/find")
    public  ResultInfo findTrade(@RequestParam(value = "buyer_id",required = true) String buyerId,
                                 HttpServletRequest request){
        List<ProductInfo> trade = tradeService.findTrade(buyerId);
        if (trade!=null&&trade.size()!=0){
            return new ResultInfo(0, trade, "查询成功", null);
        }
            return new ResultInfo(-1, null, "查询订单失败", request.getRequestURI());
    }
}

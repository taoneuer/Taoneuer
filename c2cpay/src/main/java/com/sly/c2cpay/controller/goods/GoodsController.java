package com.sly.c2cpay.controller.goods;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sly.c2cpay.pojo.PageInfo;
import com.sly.c2cpay.pojo.ProductInfo;
import com.sly.c2cpay.pojo.ResultInfo;
import com.sly.c2cpay.service.GoodsService;
import com.sly.c2cpay.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;


    /**
     * 用户发布商品
     * @param productInfo
     * @param request
     * @return
     */
    @PostMapping("/release")
    public  ResultInfo release(@RequestBody ProductInfo productInfo, HttpServletRequest request){
        //生成商品id
        productInfo.setProductId(CodeUtils.getProductId());

        //获取创建时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        productInfo.setLaunchTime(Timestamp.valueOf(format));
        Integer release = goodsService.release(productInfo);
        return release<1?new ResultInfo(-1, null, "发布失败", request.getRequestURI()):
                new ResultInfo(0, null, "发布成功", request.getRequestURI());

    }

    /**
     * 用户下架商品
     * @param goodsId
     * @param request
     * @return
     */
    @PostMapping("/put")
    public  ResultInfo put(@RequestParam(value = "product_id",required = true) int goodsId,
                           HttpServletRequest request){
        Integer put = goodsService.put(goodsId);
        return put<1?new ResultInfo(-1, null, "删除失败", request.getRequestURI()):
                new ResultInfo(0, null, "删除成功", request.getRequestURI());
    }


    /**
     * 用户查询自己发布的商品
     * @param uid
     * @return
     */
    @GetMapping("/find_release")
    public PageInfo findRelease(@RequestParam(value = "owner_id",required = true) int uid,
                                @RequestParam(value = "start_page",defaultValue = "1") int start,
                                @RequestParam(value = "page_size",defaultValue = "3")int size,
                                @RequestParam(value = "key",defaultValue = "") String key){
        Page<Object> objects = PageHelper.startPage(start, size);
        List<ProductInfo> release = goodsService.findRelease(uid,key);
        PageInfo<ProductInfo> pageInfo = new PageInfo<>();
        pageInfo.setTotal((int) objects.getTotal());
        pageInfo.setPageNum(objects.getPageNum());
        pageInfo.setPage(objects.getPages());
        pageInfo.setList(release);
        return pageInfo;
    }


    /**
     * 查询单个商品详情
     * @param goodsId
     * @param request
     * @return
     */
    @GetMapping("/find_one")
    public ResultInfo findOne(@RequestParam(value = "product_id",required = true) int goodsId,
                              HttpServletRequest request){
        ProductInfo goods = goodsService.findById(goodsId);
        return goods==null? new ResultInfo(-1, null, "该商品不存在", request.getRequestURI()):
                new ResultInfo(0, goods, "成功", request.getRequestURI());
    }

    /**
     * 用户收藏商品
     * @param goodsId
     * @param collectUid
     * @param request
     * @return
     */
    @PostMapping("/add_collection")
    public ResultInfo addCollection(@RequestParam(value = "product_id",required = true) int goodsId,
                                    @RequestParam(value = "collect_uid",required = true) String collectUid,
                                    HttpServletRequest request){
        boolean flag = goodsService.addCollection(goodsId, collectUid);
        if  (flag){
            return  new ResultInfo(0, null, "成功", null);
        }
        return new ResultInfo(-1, null, "失败", request.getRequestURI());
    }

    /**
     * 查询商品收藏次数
     * @param goodsId
     * @param request
     * @return
     */
    @GetMapping("/find_collect_count")
    public ResultInfo findCollectionCount(@RequestParam(value = "product_id",required = true) Integer goodsId,HttpServletRequest request){
        Integer count = goodsService.findCollectionCount(goodsId);
        return new ResultInfo(0, count, "收藏次数", request.getRequestURI());
    }

    /**
     * 查询收藏商品
     * @param uid
     * @param key
     * @param request
     * @return
     */
    @GetMapping("/find_collect_goods")
    public ResultInfo findCollectedGoods(@RequestParam(value = "uid",required = true) String uid,
                                         @RequestParam(value = "key",defaultValue = "") String key,
                                         @RequestParam(value = "start_page",defaultValue = "1") int start,
                                         @RequestParam(value = "page_size",defaultValue = "3")int size,
                                         HttpServletRequest request){

        Page<Object> objects = PageHelper.startPage(start, size);
        List<ProductInfo> goods = goodsService.findCollectedGoods(uid, key);
        PageInfo<ProductInfo> pageInfo = new PageInfo<>();
        pageInfo.setTotal((int) objects.getTotal());
        pageInfo.setPageNum(objects.getPageNum());
        pageInfo.setPage(objects.getPages());
        pageInfo.setList(goods);
        if (goods==null)
            return new ResultInfo(-1, null, "失败", request.getRequestURI());
        return  new ResultInfo(0, pageInfo, "成功", request.getRequestURI());


    }

    /**
     * 删除收藏商品
     * @param goodsId
     * @param uid
     * @param request
     * @return
     */
    @PostMapping("/delCollect")
    public ResultInfo delCollect(@RequestParam(value = "goods_id",required = true) int goodsId,
                                 @RequestParam(value = "uid",required = true) int uid,
                                 HttpServletRequest request){
        boolean flag = goodsService.delCollected(goodsId, uid);
        if (flag)
        return new ResultInfo(0, null, "删除成功", request.getRequestURI());
        return new ResultInfo(-1, null, "删除失败", request.getRequestURI());
    }


    /**
     * 商品点赞
     * @param uid
     * @param productId
     * @param request
     * @return
     */
    @PostMapping("/addLike")
    public ResultInfo addLike(@RequestParam(value = "like_uid",required = true)String uid,
                              @RequestParam(value = "product_id",required = true) int productId,
                              HttpServletRequest request){
        Integer integer = goodsService.addLike(uid, productId);
        return integer<1? new ResultInfo(-1, null, "点赞失败", request.getRequestURI()):
                new ResultInfo(0, null, "成功", null);
    }

    /**
     * 查询收藏次数
     * @param productId
     * @param request
     * @return
     */
    @GetMapping("/findLikeCount")
    public  ResultInfo findLikeCount(@RequestParam(value = "product_id",required = true)int productId,
                                     HttpServletRequest request){
        Integer integer = goodsService.likeCount(productId);
        return new ResultInfo(0, integer, "", request.getRequestURI());
    }



}

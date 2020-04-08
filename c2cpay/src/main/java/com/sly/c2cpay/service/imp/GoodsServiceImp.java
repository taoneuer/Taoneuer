package com.sly.c2cpay.service.imp;

import com.sly.c2cpay.mapper.GoodsMapper;
import com.sly.c2cpay.pojo.ProductInfo;
import com.sly.c2cpay.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GoodsServiceImp implements GoodsService {


    @Resource
    GoodsMapper goodsMapper;


    /**
     * 用户发布商品信息
     * @param productInfo
     * @return
     */
    @Override
    public Integer release(ProductInfo productInfo) {
        return goodsMapper.release(productInfo);
    }

    /**
     * 用户下架商品
     * @param goodsId
     * @return
     */
    @Override
    public Integer put(int goodsId) {
        return goodsMapper.put(goodsId);
    }


    @Override
    public List<ProductInfo> findRelease(int uid,String productName) {
        return goodsMapper.findRelease(uid,productName);
    }

    @Override
    public ProductInfo findById(int goodsId) {
        return goodsMapper.findById(goodsId);
    }

    @Override
    public boolean addCollection(int goodsId, String collectUid) {
        Integer integer = goodsMapper.addCollection(goodsId, collectUid);
        if (integer<=0){
            return false;
        }
        return true;
    }

    /**
     * 商品收藏次数
     * @param goodsId
     * @return
     */
    @Override
    public Integer findCollectionCount(Integer goodsId) {
        return goodsMapper.findCollectionCount(goodsId);
    }

    /**
     * 查询用户收藏商品
     * @param uid
     * @param goodsTitle
     * @return
     */
    @Override
    public List<ProductInfo> findCollectedGoods(String uid, String goodsTitle) {
        return  goodsMapper.findCollectedGoods(uid, goodsTitle);
    }

    @Override
    public boolean delCollected(int goodsId, int uid) {
        Integer integer = goodsMapper.delCollected(goodsId, uid);
        return integer > 0;
    }

    @Override
    public Integer addLike(String likeUid, int productId) {
        return goodsMapper.addLike(likeUid, productId);
    }

    @Override
    public Integer likeCount(int productId) {
        return goodsMapper.likeCount(productId);
    }

}

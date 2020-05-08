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

    /**
     * 根据id查询单个商品
     * @param goodsId
     * @return
     */
    @Override
    public ProductInfo findById(int goodsId) {
        return goodsMapper.findById(goodsId);
    }

    /**
     * 分类查询
     * @param cid
     * @param goodsName
     * @return
     */
    @Override
    public List<ProductInfo> findGoods(Integer cid, String goodsName) {

        return goodsMapper.findGoods(cid, goodsName);
    }

    @Override
    public List<ProductInfo> findAllGoods(String goodsName) {
        return goodsMapper.findAllGoods(goodsName);
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

    /**
     * 取消点赞
     * @param likeUid
     * @param productId
     * @return
     */
    @Override
    public Integer cancelledLike(String likeUid, int productId) {
        return goodsMapper.cancelledLike(likeUid, productId);
    }



    /**
     * 点赞数
     * @param productId
     * @return
     */
    @Override
    public Integer likeCount(int productId) {
        return goodsMapper.likeCount(productId);
    }

    /**
     * 查询商品点赞状态
     * @param likeUid
     * @param productId
     * @return
     */
    @Override
    public Integer findLikeState(String likeUid, int productId) {
        return  goodsMapper.findLikeState(likeUid, productId);
    }

}

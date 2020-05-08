package com.sly.c2cpay.service;

import com.sly.c2cpay.pojo.Goods;
import com.sly.c2cpay.pojo.ProductInfo;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface GoodsService {
    /**
     * 用户发布商品信息
     * @param productInfo
     * @return
     */
    Integer release(ProductInfo productInfo);
    /**
     * 用户下架商品
     * @param goodsId
     * @return
     */
    Integer put(int goodsId);


    /**
     * 用户查询已发布的商品
     * @param uid
     * @return
     */
    List<ProductInfo> findRelease(int uid,String productName);


    /**
     * 根据goods_id查找商品
     * @param goodsId
     * @return
     */
    ProductInfo findById(int goodsId);


    /**
     * 分类查询商品
     * @param cid
     * @param goodsName
     * @return
     */
    List<ProductInfo> findGoods(Integer cid,String goodsName);

    /**
     * 查询所有
     * @param goodsName
     * @return
     */
    List<ProductInfo> findAllGoods(String goodsName);

    /**
     * 根据商品id,用户id添加收藏
     * @param goodsId
     * @param collectUid
     * @return
     */
    boolean addCollection(int goodsId,String collectUid);

    /**
     * 查询商品收藏次数
     * @param goodsId
     * @return
     */
    Integer findCollectionCount(Integer goodsId);


    /**
     * 查询收藏商品
     * @param uid
     * @param goodsTitle
     * @return
     */
    List<ProductInfo> findCollectedGoods(String uid,String goodsTitle);

    /**
     * 取消收藏
     * @param goodsId
     * @param uid
     * @return
     */
    boolean delCollected(int goodsId,int uid);


    /**
     * 用户点赞
     * @param likeUid
     * @param productId
     * @return
     */
    Integer addLike(String likeUid,int productId);


    /**
     * 取消点赞
     * @param likeUid
     * @param productId
     * @return
     */
    Integer cancelledLike(String likeUid,int productId);


    /**
     * 商品点赞数
     * @param productId
     * @return
     */
    Integer likeCount(int productId);

    /**
     * 点赞状态
     * @param likeUid
     * @param productId
     * @return
     */
    Integer findLikeState(String likeUid,int productId);
}

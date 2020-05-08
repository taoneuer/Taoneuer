package com.sly.c2cpay.mapper;

import com.sly.c2cpay.pojo.Goods;
import com.sly.c2cpay.pojo.ProductInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 商品业务接口
 */
public interface GoodsMapper {

    /**
     * 用户发布商品信息
     * @param productInfo
     */
    @Insert("INSERT INTO product_info(`product_id`, `product_name`, `product_category`, `imageURL`, `product_price`, `product_detail`, `launch_time`, `owner_id`) VALUES (#{productId}, #{productName}, #{productCategory}, #{imageUrl}, #{productPrice}, #{productDetail}, #{launchTime}, #{ownerId})")
    Integer release(ProductInfo productInfo);


    /**
     * 用户下架商品
     * @param productId
     * @return
     */
    @Delete("delete from product_info where product_id=#{productId}")
    Integer put(int productId);


    /**
     * 用户查询自己发布的商品
     * @param ownerId
     * @param productName
     * @return
     */
    @Select("SELECT * from product_info WHERE owner_id=#{ownerId} and product_name like CONCAT('%',#{productName},'%')")
    List<ProductInfo> findRelease(int ownerId,String productName);

    /**
     * 根据id查找商品
     * @param productId
     * @return
     */
    @Select("select * from product_info where product_id=#{product_Id}")
    ProductInfo findById(int productId);


    /**
     * 分类搜索商品
     * @param cid
     * @param productName
     * @return
     */
    @Select(" SELECT * from product_info where product_category=#{cid} AND product_name LIKE CONCAT('%',#{productName},'%')")
    List<ProductInfo> findGoods(  Integer cid, String productName);

    /**
     * 查询所有
     * @param goodsName
     * @return
     */
    @Select(" SELECT * from product_info where product_name LIKE CONCAT('%',#{productName},'%') ORDER BY launch_time desc")
    List<ProductInfo> findAllGoods(String goodsName);


    /**
     * 用户收藏商品
     * @param productId
     * @param collectUid
     * @return
     */
    @Insert("insert into collection (product_id,collector_id) values(#{productId},#{collectUid})")
    Integer addCollection(int productId,String collectUid);

    /**
     * 查询商品收藏次数
     * @param productId
     * @return
     */
    @Select("SELECT COUNT(collector_id) FROM collection WHERE product_id=#{productId}")
    Integer findCollectionCount(Integer productId);

    /**
     * 查询已收藏商品
     * @param collectorId
     * @param productName
     * @return
     */
    @Select("SELECT * from product_info where product_id in(SELECT product_id from collection WHERE collector_id=#{collectorId}) and product_name like CONCAT('%',#{productName},'%')")
    List<ProductInfo> findCollectedGoods(String collectorId,String productName);


    /**
     * 取消收藏
     * @param productId
     * @param collectorId
     * @return
     */
    @Delete("DELETE FROM collection WHERE product_id=#{productId} AND collector_id=#{collectorId}")
    Integer delCollected(int productId,int collectorId);

    /**
     * 更新商品状态为1正在交易中
     * @param productId
     * @return
     */
    @Update(" UPDATE product_info SET product_state=1 where product_id=#{productId}")
    Integer updateStatus(int productId);


    /**
     * 用户点赞
     * @param likeUid
     * @param productId
     * @return
     */
    @Insert("INSERT INTO tab_like (like_uid, product_id,like_state) VALUES (#{likeUid}, #{productId},1)")
    Integer addLike(String likeUid,int productId);


    /**
     * 取消点赞
     * @param likeUid
     * @param productId
     * @return
     */
    @Update("UPDATE tab_like SET like_state = 0 WHERE like_uid = #{likeUid} AND product_id = #{productId}")
    Integer cancelledLike(String likeUid,int productId);


    /**
     * 商品点赞数
     * @param productId
     * @return
     */
    @Select(" SELECT COUNT(*) from tab_like WHERE (like_state=1 and product_id=#{productId})")
    Integer likeCount(int productId);


    @Select("SELECT  like_state from tab_like where like_uid=#{likeUid} AND product_id=#{productId}")
    Integer findLikeState(String likeUid,int productId);



}

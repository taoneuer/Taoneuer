package  com.sly.c2cpay.pojo;


import java.io.Serializable;

public class Goods implements Serializable {

  @Override
  public String toString() {
    return "Goods{" +
            "goodsId=" + goodsId +
            ", goodsTitle='" + goodsTitle + '\'' +
            ", goodsDetail='" + goodsDetail + '\'' +
            ", goodsImg='" + goodsImg + '\'' +
            ", goodsNum=" + goodsNum +
            ", uid=" + uid +
            ", goodsPrice=" + goodsPrice +
            '}';
  }

  private Integer goodsId;//自增id
  private String goodsTitle;//标题
  private String goodsDetail;//详情
  private String goodsImg;//图片
  private Integer goodsNum;//数量
  private Integer uid;//发布商品用户id
  private Integer goodsPrice;//商品价格
  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public Integer getGoodsPrice() {
    return goodsPrice;
  }

  public void setGoodsPrice(Integer goodsPrice) {
    this.goodsPrice = goodsPrice;
  }




  public Integer getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(Integer goodsId) {
    this.goodsId = goodsId;
  }



  public String getGoodsTitle() {
    return goodsTitle;
  }

  public void setGoodsTitle(String goodsTitle) {
    this.goodsTitle = goodsTitle;
  }


  public String getGoodsDetail() {
    return goodsDetail;
  }

  public void setGoodsDetail(String goodsDetail) {
    this.goodsDetail = goodsDetail;
  }


  public String getGoodsImg() {
    return goodsImg;
  }

  public void setGoodsImg(String goodsImg) {
    this.goodsImg = goodsImg;
  }


  public Integer getGoodsNum() {
    return goodsNum;
  }

  public void setGoodsNum(Integer goodsNum) {
    this.goodsNum = goodsNum;
  }

}

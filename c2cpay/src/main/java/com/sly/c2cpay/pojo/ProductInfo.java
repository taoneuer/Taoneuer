package  com.sly.c2cpay.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;

public class ProductInfo  implements Serializable {

  @JsonIgnore
  private Integer id;

  @JsonProperty("product_id")
  private Integer productId;//商品编号

  @JsonProperty("product_name")
  private String productName;//商品名称

  @JsonProperty("product_category")
  private String productCategory;//商品分类
  @JsonProperty("image_url")
  private String imageUrl;//商品图片

  @JsonProperty("product_price")
  private double productPrice;//商品价格

  private Integer productState;

  @JsonProperty("product_detail")
  private String productDetail;//商品详情
  @JsonProperty("launch_time")
  private Timestamp launchTime;//商品上架时间
  @JsonProperty("owner_id")
  private Integer ownerId; //发布者id
  private Integer zanNum;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }


  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }


  public String getProductCategory() {
    return productCategory;
  }

  public void setProductCategory(String productCategory) {
    this.productCategory = productCategory;
  }


  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }


  public double getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(double productPrice) {
    this.productPrice = productPrice;
  }


  public Integer getProductState() {
    return productState;
  }

  public void setProductState(Integer productState) {
    this.productState = productState;
  }


  public String getProductDetail() {
    return productDetail;
  }

  public void setProductDetail(String productDetail) {
    this.productDetail = productDetail;
  }


  public java.sql.Timestamp getLaunchTime() {
    return launchTime;
  }

  public void setLaunchTime(java.sql.Timestamp launchTime) {
    this.launchTime = launchTime;
  }


  public Integer getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(Integer ownerId) {
    this.ownerId = ownerId;
  }


  public Integer getZanNum() {
    return zanNum;
  }

  public void setZanNum(Integer zanNum) {
    this.zanNum = zanNum;
  }

}

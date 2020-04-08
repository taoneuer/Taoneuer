package  com.sly.c2cpay.pojo;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;

public class TradeRecord implements Serializable {

  public TradeRecord(){}

  public TradeRecord(String buyerId,int productId){
    this.buyerId=buyerId;
    this.productId=productId;
  }

  private Integer id;

  private Integer tradeId;

  @JsonProperty("product_id")
  private Integer productId;

  @JsonProperty("buyer_id")
  private String buyerId;

  private Timestamp tradeTime;
  private Integer tradeState;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getTradeId() {
    return tradeId;
  }

  public void setTradeId(Integer tradeId) {
    this.tradeId = tradeId;
  }


  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }


  public String getBuyerId() {
    return buyerId;
  }

  public void setBuyerId(String buyerId) {
    this.buyerId = buyerId;
  }


  public java.sql.Timestamp getTradeTime() {
    return tradeTime;
  }

  public void setTradeTime(java.sql.Timestamp tradeTime) {
    this.tradeTime = tradeTime;
  }


  public Integer getTradeState() {
    return tradeState;
  }

  public void setTradeState(Integer tradeState) {
    this.tradeState = tradeState;
  }

}

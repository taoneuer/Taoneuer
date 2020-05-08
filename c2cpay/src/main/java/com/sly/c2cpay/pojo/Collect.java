package com.sly.c2cpay.pojo;

import java.io.Serializable;

public class Collect implements Serializable {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getCollectUid() {
        return collectUid;
    }

    public void setCollectUid(Integer collectUid) {
        this.collectUid = collectUid;
    }

    public Collect(Integer id, Integer goodsId, Integer collectUid) {
        this.id = id;
        this.goodsId = goodsId;
        this.collectUid = collectUid;
    }
    public Collect(){}

    private Integer id;
    private Integer goodsId;
    private Integer collectUid;

}

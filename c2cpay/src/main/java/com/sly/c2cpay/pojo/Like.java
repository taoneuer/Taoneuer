package com.sly.c2cpay.pojo;

import java.io.Serializable;

/**
 * 点赞实体类
 */
public class Like implements Serializable {
        String likeUid;  //点赞用户id
        Integer productId; //商品id
        int  likeState; //状态 0无效赞，1有效赞
}

package com.sly.c2cpay.mapper;


import org.apache.ibatis.jdbc.SQL;

public class GoodsProvider {
    public String findGoods(final Integer cid,final String productName){
        SQL sql=new SQL();

        sql.SELECT("*").FROM("product_info");
        if(cid!= null){
            sql.WHERE("product_category=#{cid})");
        }
        if(productName!=null){
            sql.WHERE("product_name like CONCAT('%',#{productName},'%')");
        }
        System.out.println(sql.toString());
        return sql.toString();

    }
    }


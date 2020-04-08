package com.sly.c2cpay.pojo;

import java.io.Serializable;

/**
 * 返回信息
 */
public class ResultInfo  implements Serializable {

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ResultInfo(Integer code, Object data, String msg, String url) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.url = url;
    }
    public ResultInfo(Integer code){
        this.code=code;
    }

    private Integer code;//状态码

    private Object data; //数据

    private String msg; //信息

    private String url; //接口
}

package com.sly.c2cpay.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 页面实体类
 */
public class PageInfo<T> implements Serializable {

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    private int total;//总记录数

    private int page;//总页数

    private int pageNum;//当前第几页

    private List<T> list;//页面信息list
}

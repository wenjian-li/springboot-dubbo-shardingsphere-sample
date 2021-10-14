package com.sample.lwj.utils;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 分页
 * @date 2021/8/21 18:02
 */
public class PageUtils<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = -4298221163864349020L;
    /**
     * 查询数据列表
     */
    protected List<?> records = Collections.emptyList();

    /**
     * 总条数
     */
    protected long totalCount = 0;

    /**
     * 每页显示条数，默认 10
     */
    protected long pageSize = 10;

    /**
     * 当前页
     */
    protected long currentPage = 1;

    /**
     * 总页数
     */
    private long totalPage;

    /**
     * 查询条件
     */
    private T params;


    public PageUtils() {
    }

    public PageUtils(List<?> records, long currentPage, long pageSize, long totalCount, long totalPage) {
        this.records = records;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
    }

    public PageUtils(PageUtils pageUtils, List<?> records) {
        this.records = records;
        this.currentPage = pageUtils.getCurrentPage();
        this.pageSize = pageUtils.getPageSize();
        this.totalCount = pageUtils.getTotalCount();
        this.totalPage = pageUtils.getTotalPage();
    }


    public List<?> getRecords() {
        return records;
    }

    public void setRecords(List<?> records) {
        this.records = records;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }
}

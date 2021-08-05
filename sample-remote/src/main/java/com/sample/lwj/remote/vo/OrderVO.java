package com.sample.lwj.remote.vo;

import java.io.Serializable;
import java.util.Date;

public class OrderVO implements Serializable {
	private static final long serialVersionUID = -1381807586939825350L;
	private Long id;

	private String orderNo;

	private Integer status;

	private Date createTime;

	private Date updateTime;

	public OrderVO() {
	}

	public OrderVO(String orderNo, Integer orderStatus) {
		this.orderNo = orderNo;
		this.status = orderStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
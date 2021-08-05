package com.sample.lwj.web.service;

import com.sample.lwj.remote.vo.OrderVO;

import java.util.Date;
import java.util.List;

public interface IOrderService {

    Boolean save(OrderVO orderVO);

    int updateOrderStatus(String json);

    List<OrderVO> selectByDateRange(Date start, Date end);

    OrderVO selectByOrderNo(String orderNo);
}
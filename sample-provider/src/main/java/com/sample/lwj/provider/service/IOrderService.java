package com.sample.lwj.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sample.lwj.entity.Order;

import java.util.Date;
import java.util.List;

public interface IOrderService extends IService<Order> {

    int updateOrderStatus(String json);

    List<Order> selectByDateRange(Date start, Date end);

    Order selectByOrderNo(String orderNo);
}
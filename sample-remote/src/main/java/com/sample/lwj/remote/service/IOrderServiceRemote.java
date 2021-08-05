package com.sample.lwj.remote.service;

import com.sample.lwj.remote.dto.OrderDTO;

import java.util.Date;
import java.util.List;

public interface IOrderServiceRemote {

    OrderDTO selectByOrderNo(String orderNo);

    Boolean save(OrderDTO orderDTO);

    Boolean updateByPrimaryKeySelective(OrderDTO orderDTO);

    int updateOrderStatus(String json);

    List<OrderDTO> selectByDateRange(Date start, Date end);
}
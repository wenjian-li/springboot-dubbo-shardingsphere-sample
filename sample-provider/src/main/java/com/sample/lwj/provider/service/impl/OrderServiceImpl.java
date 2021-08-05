package com.sample.lwj.provider.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sample.lwj.provider.service.IOrderService;
import com.sample.lwj.entity.Order;
import com.sample.lwj.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Override
    public int updateOrderStatus(String json) {
        JSONObject order = JSONObject.parseObject(json);
        String orderNo = order.getString("orderNo");
        Integer orderStatus = order.getInteger("orderStatus");
        return baseMapper.updateByOrderNo(new Order(orderNo, orderStatus));
    }

    @Override
    public List<Order> selectByDateRange(Date start, Date end) {
        return baseMapper.selectByDateRange(start, end);
    }

    @Override
    public Order selectByOrderNo(String orderNo) {
        return baseMapper.selectByOrderNo(orderNo);
    }

}

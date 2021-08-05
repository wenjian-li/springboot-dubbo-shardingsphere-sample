package com.sample.lwj.web.service.impl;

import com.sample.lwj.remote.dto.OrderDTO;
import com.sample.lwj.remote.service.IOrderServiceRemote;
import com.sample.lwj.remote.vo.OrderVO;
import com.sample.lwj.web.service.IOrderService;
import com.sample.lwj.web.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderServiceRemote orderServiceRemote;

    @Override
    public Boolean save(OrderVO orderVO) {
        return orderServiceRemote.save(BeanUtils.toBean(orderVO, OrderDTO.class));
    }

    @Override
    public int updateOrderStatus(String json) {
        return orderServiceRemote.updateOrderStatus(json);
    }

    @Override
    public List<OrderVO> selectByDateRange(Date start, Date end) {
        return BeanUtils.toList(orderServiceRemote.selectByDateRange(start, end), OrderVO.class);
    }

    @Override
    public OrderVO selectByOrderNo(String orderNo) {
        return BeanUtils.toBean(orderServiceRemote.selectByOrderNo(orderNo), OrderVO.class);
    }
}

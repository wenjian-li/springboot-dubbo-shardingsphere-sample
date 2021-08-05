package com.sample.lwj.provider.remote;

import com.sample.lwj.provider.service.IOrderService;
import com.sample.lwj.provider.utils.BeanUtils;
import com.sample.lwj.entity.Order;
import com.sample.lwj.remote.dto.OrderDTO;
import com.sample.lwj.remote.service.IOrderServiceRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("orderServiceRemote")
public class OrderServiceRemoteImpl implements IOrderServiceRemote {

    @Autowired
    private IOrderService orderService;

    @Override
    public OrderDTO selectByOrderNo(String orderNo) {
        return BeanUtils.toBean(orderService.selectByOrderNo(orderNo),OrderDTO.class);
    }

    @Override
    public Boolean save(OrderDTO orderDTO) {
        return orderService.save(BeanUtils.toBean(orderDTO, Order.class));
    }

    @Override
    public Boolean updateByPrimaryKeySelective(OrderDTO orderDTO) {
        return orderService.updateById(BeanUtils.toBean(orderDTO, Order.class));
    }


    @Override
    public int updateOrderStatus(String json) {
        return orderService.updateOrderStatus(json);
    }

    @Override
    public List<OrderDTO> selectByDateRange(Date start, Date end) {
        return BeanUtils.toList(orderService.selectByDateRange(start, end), OrderDTO.class);
    }
}

package com.sample.lwj.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sample.lwj.entity.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrderMapper extends BaseMapper<Order> {

    int updateByOrderNo(Order order);

    List<Order> selectByDateRange(@Param("start") Date start, @Param("end") Date end);

    Order selectByOrderNo(@Param("orderNo") String orderNo);
}
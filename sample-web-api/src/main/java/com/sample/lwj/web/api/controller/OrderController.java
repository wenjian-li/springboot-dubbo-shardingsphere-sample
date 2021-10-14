package com.sample.lwj.web.api.controller;

import com.sample.lwj.remote.vo.OrderVO;
import com.sample.lwj.utils.DateUtils;
import com.sample.lwj.utils.ResultData;
import com.sample.lwj.web.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api(tags = "订单模块")
@RestController
@RequestMapping(value = "/api/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @ApiOperation("根据订单号查询订单信息")
    @RequestMapping(value = "/getOrderInfo", method = RequestMethod.GET)
    @ResponseBody
    public ResultData<OrderVO> getOrderInfo(@RequestParam(name = "orderNo") String orderNo) {
        return ResultData.success(orderService.selectByOrderNo(orderNo));
    }

    @ApiOperation("新增订单")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public ResultData add() {
        OrderVO orderVO = new OrderVO();
        orderVO.setStatus(1);
        orderVO.setCreateTime(new Date());
        orderVO.setUpdateTime(new Date());
        orderService.save(orderVO);
        return ResultData.success();
    }


    /**
     * @param start 开始时间
     * @param end   结束时间
     * @return
     */
    @ApiOperation(value = "根据时间范围查询订单列表")
    @RequestMapping(value = "/selectByDateRange", method = RequestMethod.GET)
    @ResponseBody
    public ResultData<List<OrderVO>> selectByDateRange(@RequestParam(name = "start") String start,
                                                       @RequestParam(name = "end") String end) {
        return ResultData.success(orderService.selectByDateRange(DateUtils.stringToDate(start, DateUtils.YYYYMMDD), DateUtils.stringToDate(end, DateUtils.YYYYMMDD)));
    }

}

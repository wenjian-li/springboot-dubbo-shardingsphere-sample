package com.sample.lwj.web.api.controller;

import com.sample.lwj.remote.vo.ScheduleJobVO;
import com.sample.lwj.web.constant.Constant;
import com.sample.lwj.web.service.IScheduleJobService;
import com.sample.lwj.web.utils.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 定时任务Controller
 * @date 2021/8/30 17:15
 */

@Api(tags = "定时任务模块")
@RestController
@RequestMapping(value = "/api/scheduleJob")
public class ScheduleJobController {

    @Autowired
    private IScheduleJobService scheduleJobService;

    @ApiOperation("保存定时任务")
    @PostMapping(value = "/save", produces = Constant.PRODUCES_JSON_UTF8)
    @ResponseBody
    public ResultData<Boolean> save(@RequestBody ScheduleJobVO scheduleJobVO) {
        scheduleJobService.saveJob(scheduleJobVO);
        return ResultData.success();
    }


    @ApiOperation("更新定时任务")
    @PostMapping(value = "/update", produces = Constant.PRODUCES_JSON_UTF8)
    @ResponseBody
    public ResultData<Boolean> update(@RequestBody ScheduleJobVO scheduleJobVO) {
        scheduleJobService.update(scheduleJobVO);
        return ResultData.success();
    }

    @ApiOperation("立即执行任务")
    @PostMapping(value = "/run", produces = Constant.PRODUCES_JSON_UTF8)
    @ResponseBody
    public ResultData<Boolean> run(@RequestBody Long[] jobIds) {
        scheduleJobService.run(jobIds);
        return ResultData.success();
    }

    @ApiOperation("暂停定时任务")
    @PostMapping(value = "/pause", produces = Constant.PRODUCES_JSON_UTF8)
    @ResponseBody
    public ResultData<Boolean> pause(@RequestBody Long[] jobIds) {
        scheduleJobService.pause(jobIds);
        return ResultData.success();
    }

    @ApiOperation("恢复定时任务")
    @PostMapping(value = "/resume", produces = Constant.PRODUCES_JSON_UTF8)
    @ResponseBody
    public ResultData<Boolean> resume(@RequestBody Long[] jobIds) {
        scheduleJobService.resume(jobIds);
        return ResultData.success();
    }


}

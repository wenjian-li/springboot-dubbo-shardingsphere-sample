package com.sample.lwj.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sample.lwj.entity.ScheduleJobLog;
import com.sample.lwj.mapper.ScheduleJobLogMapper;
import com.sample.lwj.provider.service.IScheduleJobLogService;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service("scheduleJobLogService")
public class ScheduleJobLogServiceImpl extends ServiceImpl<ScheduleJobLogMapper, ScheduleJobLog>
        implements IScheduleJobLogService {

}





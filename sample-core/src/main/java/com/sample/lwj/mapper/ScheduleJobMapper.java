package com.sample.lwj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sample.lwj.entity.ScheduleJob;

import java.util.Map;

/**
 * @Entity com.sample.lwj.entity.ScheduleJob
 */
public interface ScheduleJobMapper extends BaseMapper<ScheduleJob> {
    /**
     * 批量更新状态
     */
    int updateBatch(Map<String, Object> map);
}





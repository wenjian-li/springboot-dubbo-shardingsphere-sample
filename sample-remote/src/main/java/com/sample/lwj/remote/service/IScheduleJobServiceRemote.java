package com.sample.lwj.remote.service;

import com.sample.lwj.remote.dto.ScheduleJobDTO;

/**
 * 定时任务
 */
public interface IScheduleJobServiceRemote {
    /**
     * 保存定时任务
     */
    void saveJob(ScheduleJobDTO scheduleJobDTO);

    /**
     * 更新定时任务
     */
    void update(ScheduleJobDTO scheduleJobDTO);

    /**
     * 批量删除定时任务
     */
    void deleteBatch(Long[] jobIds);

    /**
     * 批量更新定时任务状态
     */
    int updateBatch(Long[] jobIds, int status);

    /**
     * 立即执行
     */
    void run(Long[] jobIds);

    /**
     * 暂停运行
     */
    void pause(Long[] jobIds);

    /**
     * 恢复运行
     */
    void resume(Long[] jobIds);
}

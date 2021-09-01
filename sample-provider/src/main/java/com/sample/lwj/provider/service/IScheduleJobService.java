package com.sample.lwj.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sample.lwj.entity.ScheduleJob;

/**
 *
 */
public interface IScheduleJobService extends IService<ScheduleJob> {
    /**
     * 保存定时任务
     */
    void saveJob(ScheduleJob scheduleJob);

    /**
     * 更新定时任务
     */
    void update(ScheduleJob scheduleJob);

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

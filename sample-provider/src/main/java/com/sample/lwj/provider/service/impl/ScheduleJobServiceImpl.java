package com.sample.lwj.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sample.lwj.entity.ScheduleJob;
import com.sample.lwj.mapper.ScheduleJobMapper;
import com.sample.lwj.provider.constant.Constants;
import com.sample.lwj.provider.service.IScheduleJobService;
import com.sample.lwj.provider.utils.SchedulerUtils;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 *
 */
@Service("scheduleJobService")
public class ScheduleJobServiceImpl extends ServiceImpl<ScheduleJobMapper, ScheduleJob>
        implements IScheduleJobService {


    @Autowired
//    @Qualifier("scheduler")
    private Scheduler scheduler;

    /**
     * 项目启动时，初始化定时器
     */
    @PostConstruct
    public void init() {
        List<ScheduleJob> scheduleJobList = this.list();
        for (ScheduleJob scheduleJob : scheduleJobList) {
            CronTrigger cronTrigger = SchedulerUtils.getCronTrigger(scheduler, scheduleJob.getJobId());
            //如果不存在，则创建
            if (cronTrigger == null) {
                SchedulerUtils.createScheduleJob(scheduler, scheduleJob);
            } else {
                SchedulerUtils.updateScheduleJob(scheduler, scheduleJob);
            }
        }
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveJob(ScheduleJob scheduleJob) {
        scheduleJob.setCreateTime(new Date());
        scheduleJob.setStatus(Constants.ScheduleStatus.NORMAL.getValue());
        this.save(scheduleJob);

        SchedulerUtils.createScheduleJob(scheduler, scheduleJob);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ScheduleJob scheduleJob) {
        SchedulerUtils.updateScheduleJob(scheduler, scheduleJob);

        this.updateById(scheduleJob);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[] jobIds) {
        for(Long jobId : jobIds){
            SchedulerUtils.deleteScheduleJob(scheduler, jobId);
        }

        //删除数据
        this.removeByIds(Arrays.asList(jobIds));
    }

    @Override
    public int updateBatch(Long[] jobIds, int status){
        Map<String, Object> map = new HashMap<>(2);
        map.put("list", Arrays.asList(jobIds));
        map.put("status", status);
        return baseMapper.updateBatch(map);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void run(Long[] jobIds) {
        for(Long jobId : jobIds){
            SchedulerUtils.run(scheduler, this.getById(jobId));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void pause(Long[] jobIds) {
        for(Long jobId : jobIds){
            SchedulerUtils.pauseJob(scheduler, jobId);
        }

        updateBatch(jobIds, Constants.ScheduleStatus.PAUSE.getValue());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void resume(Long[] jobIds) {
        for(Long jobId : jobIds){
            SchedulerUtils.resumeJob(scheduler, jobId);
        }

        updateBatch(jobIds, Constants.ScheduleStatus.NORMAL.getValue());
    }

}





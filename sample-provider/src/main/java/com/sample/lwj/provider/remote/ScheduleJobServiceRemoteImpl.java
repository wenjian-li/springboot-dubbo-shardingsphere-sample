package com.sample.lwj.provider.remote;

import com.sample.lwj.entity.ScheduleJob;
import com.sample.lwj.provider.service.IScheduleJobService;
import com.sample.lwj.provider.utils.BeanUtils;
import com.sample.lwj.remote.dto.ScheduleJobDTO;
import com.sample.lwj.remote.service.IScheduleJobServiceRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 定时任务RPC实现类
 * @date 2021/8/30 17:22
 */
@Service("scheduleJobServiceRemote")
public class ScheduleJobServiceRemoteImpl implements IScheduleJobServiceRemote {

    @Autowired
    private IScheduleJobService scheduleJobService;

    @Override
    public void saveJob(ScheduleJobDTO scheduleJobDTO) {
        scheduleJobService.saveJob(BeanUtils.toBean(scheduleJobDTO, ScheduleJob.class));
    }

    @Override
    public void update(ScheduleJobDTO scheduleJobDTO) {
        scheduleJobService.update(BeanUtils.toBean(scheduleJobDTO, ScheduleJob.class));
    }

    @Override
    public void deleteBatch(Long[] jobIds) {
        scheduleJobService.deleteBatch(jobIds);
    }

    @Override
    public int updateBatch(Long[] jobIds, int status) {
        return scheduleJobService.updateBatch(jobIds, status);
    }

    @Override
    public void run(Long[] jobIds) {
        scheduleJobService.run(jobIds);
    }

    @Override
    public void pause(Long[] jobIds) {
        scheduleJobService.pause(jobIds);
    }

    @Override
    public void resume(Long[] jobIds) {
        scheduleJobService.resume(jobIds);
    }
}

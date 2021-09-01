package com.sample.lwj.web.service.impl;

import com.sample.lwj.remote.dto.ScheduleJobDTO;
import com.sample.lwj.remote.service.IScheduleJobServiceRemote;
import com.sample.lwj.remote.vo.ScheduleJobVO;
import com.sample.lwj.web.service.IScheduleJobService;
import com.sample.lwj.web.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 定时任务实现类
 * @date 2021/8/30 17:28
 */
@Service
public class ScheduleJobServiceImpl implements IScheduleJobService {

    @Autowired
    private IScheduleJobServiceRemote scheduleJobServiceRemote;

    @Override
    public void saveJob(ScheduleJobVO scheduleJobVO) {
        scheduleJobServiceRemote.saveJob(BeanUtils.toBean(scheduleJobVO, ScheduleJobDTO.class));
    }

    @Override
    public void update(ScheduleJobVO scheduleJobVO) {
        scheduleJobServiceRemote.update(BeanUtils.toBean(scheduleJobVO, ScheduleJobDTO.class));
    }

    @Override
    public void deleteBatch(Long[] jobIds) {
        scheduleJobServiceRemote.deleteBatch(jobIds);
    }

    @Override
    public int updateBatch(Long[] jobIds, int status) {
        return scheduleJobServiceRemote.updateBatch(jobIds, status);
    }

    @Override
    public void run(Long[] jobIds) {
        scheduleJobServiceRemote.run(jobIds);
    }

    @Override
    public void pause(Long[] jobIds) {
        scheduleJobServiceRemote.pause(jobIds);
    }

    @Override
    public void resume(Long[] jobIds) {
        scheduleJobServiceRemote.resume(jobIds);
    }
}

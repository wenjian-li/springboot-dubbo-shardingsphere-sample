package com.sample.lwj.provider.utils;

import com.sample.lwj.entity.ScheduleJob;
import com.sample.lwj.entity.ScheduleJobLog;
import com.sample.lwj.provider.service.IScheduleJobLogService;
import org.apache.commons.lang3.StringUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 定时任务
 * @date 2021/8/29 15:57
 * @PersistJobDataAfterExecution: 告诉Quartz在成功执行了Job实现类的execute方法后（没有发生任何异常），更新JobDetail中JobDataMap的数据，使得该JobDetail实例在下一次执行的时候，JobDataMap中是更新后的数据，而不是更新前的旧数据。
 * @DisallowConcurrentExecution: 告诉Quartz不要并发地执行同一个JobDetail实例。
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class SchedulerJobBean extends QuartzJobBean {

    private Logger logger = LoggerFactory.getLogger(SchedulerJobBean.class);


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ScheduleJob scheduleJob = (ScheduleJob) jobExecutionContext.getMergedJobDataMap()
                .get(ScheduleJob.JOB_PARAM_KEY);


        IScheduleJobLogService scheduleJobLogService = (IScheduleJobLogService) SpringContextUtils.getBean("scheduleJobLogService");

        //数据库保存执行记录
        ScheduleJobLog log = new ScheduleJobLog();
        log.setJobId(scheduleJob.getJobId());
//        log.setName(scheduleJob.getName());
        log.setBeanName(scheduleJob.getBeanName());
        log.setParams(scheduleJob.getParams());
        log.setCreateTime(new Date());

        //任务开始时间
        long startTime = System.currentTimeMillis();

        try {
            //执行任务
            logger.debug("任务准备执行，任务ID：" + scheduleJob.getJobId());

            Object target = SpringContextUtils.getBean(scheduleJob.getBeanName());
            Method method = target.getClass().getDeclaredMethod("run", String.class);
            method.invoke(target, scheduleJob.getParams());

            //任务执行总时长
            long times = System.currentTimeMillis() - startTime;
            log.setTimes((int) times);
            //任务状态    0：成功    1：失败
            log.setStatus(0);

            logger.debug("任务执行完毕，任务ID：" + scheduleJob.getJobId() + "  总共耗时：" + times + "毫秒");
        } catch (Exception e) {
            logger.error("任务执行失败，任务ID：" + scheduleJob.getJobId(), e);

            //任务执行总时长
            long times = System.currentTimeMillis() - startTime;
            log.setTimes((int) times);

            //任务状态    0：成功    1：失败
            log.setStatus(1);
            log.setError(StringUtils.substring(e.toString(), 0, 2000));
        } finally {
            scheduleJobLogService.save(log);
        }
    }
}

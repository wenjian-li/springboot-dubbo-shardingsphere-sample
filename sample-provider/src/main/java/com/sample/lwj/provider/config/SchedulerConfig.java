package com.sample.lwj.provider.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 定时任务配置
 * @date 2021/8/29 15:52
 */
@Configuration
public class SchedulerConfig {
//
//
//    @Value("${org.quartz.dataSource.driver}")
//    String driverClass;
//    @Value("${org.quartz.dataSource.URL}")
//    String url;
//    @Value("${org.quartz.dataSource.user}")
//    String userName;
//    @Value("${org.quartz.dataSource.password}")
//    String password;
//
//    @QuartzDataSource
//    public DataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(driverClass);
//        dataSource.setUrl(url);
//        dataSource.setUsername(userName);
//        dataSource.setPassword(password);
//        return dataSource;
//    }
//
//    @Bean
//    public SchedulerFactoryBean schedulerFactoryBean() {
//        SchedulerFactoryBean factory = new SchedulerFactoryBean();
//        //配置独立的DataSource，因为共享当前应用服务ShardingSphere（5.0.0-alpha版本，后期版本会修复？）分库分表的DataSource出现不兼容问题，导致Quartz无法写入数据库库
//        factory.setDataSource(this.dataSource());
//
//        //quartz参数
//        Properties prop = new Properties();
//        prop.put("org.quartz.scheduler.instanceName", "SampleScheduler");
//        prop.put("org.quartz.scheduler.instanceId", "AUTO");
//        //线程池配置
//        prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
//        prop.put("org.quartz.threadPool.threadCount", "20");
//        prop.put("org.quartz.threadPool.threadPriority", "5");
//        //JobStore配置
//        prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
//        //集群配置
//        prop.put("org.quartz.jobStore.isClustered", "true");
//        prop.put("org.quartz.jobStore.clusterCheckinInterval", "15000");
//        prop.put("org.quartz.jobStore.maxMisfiresToHandleAtATime", "1");
//
//        prop.put("org.quartz.jobStore.misfireThreshold", "12000");
//        prop.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
//        prop.put("org.quartz.jobStore.selectWithLockSQL", "SELECT * FROM {0}LOCKS UPDLOCK WHERE LOCK_NAME = ?");
//
//        //PostgreSQL数据库，需要打开此注释
//        //prop.put("org.quartz.jobStore.driverDelegateClass", "org.quartz.impl.jdbcjobstore.PostgreSQLDelegate");
//
//        factory.setQuartzProperties(prop);
//
//        factory.setSchedulerName("SampleScheduler");
//        //延时启动
//        factory.setStartupDelay(5);
//        factory.setApplicationContextSchedulerContextKey("applicationContextKey");
//        //可选，QuartzScheduler 启动时更新己存在的Job，这样就不用每次修改targetObject后删除qrtz_job_details表对应记录了
//        factory.setOverwriteExistingJobs(true);
//        //设置自动启动，默认为true
//        factory.setAutoStartup(true);
//
//        return factory;
//    }
//
//
//    /**
//     * 通过SchedulerFactoryBean获取Scheduler的实例
//     *
//     * @return
//     */
//    @Bean("scheduler")
//    public Scheduler scheduler() {
//        return this.schedulerFactoryBean().getScheduler();
//    }
}

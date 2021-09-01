package com.sample.lwj.provider.task;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 定时任务接口
 * @date 2021/8/29 17:42
 */
public interface ITask {
    /**
     * 执行定时任务接口
     *
     * @param params   参数，多参数使用JSON数据
     */
    void run(String params);
}

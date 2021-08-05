package com.sample.lwj.web.utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 线程池
 * @date 2021/8/2 16:35
 */
public class ExecutorPool {
    /**
     * 线程数（处理器个数）
     */
    private static final Integer CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    /**
     * 线程池最大能创建的线程数目大小
     */
    private static final Integer MAXIMUM_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 10;
    /**
     * 线程有效时间
     */
    private static final long KEEP_ALIVE_TIME = 200L;

    public static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(CORE_POOL_SIZE,
            MAXIMUM_POOL_SIZE,
            KEEP_ALIVE_TIME,
            TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(1024),
            r -> {
                Thread t = new Thread(r);
                t.setName(t.getName());
                if (t.isDaemon()) {
                    t.setDaemon(false);
                }
                if (Thread.NORM_PRIORITY != t.getPriority()) {
                    t.setPriority(Thread.NORM_PRIORITY);
                }
                return t;
            });
}

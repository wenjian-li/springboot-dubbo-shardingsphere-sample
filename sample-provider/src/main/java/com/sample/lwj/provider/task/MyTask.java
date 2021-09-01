package com.sample.lwj.provider.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: myTask
 * @date 2021/8/30 17:36
 */
@Component("myTask")
public class MyTask implements ITask {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void run(String params) {
        logger.info("this is my task!!!!!");
    }
}

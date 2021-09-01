package com.sample.lwj.provider.constant;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: provider服务常量
 * @date 2021/8/29 16:29
 */
public class Constant {
    /**
     * 定时任务状态
     */
    public enum ScheduleStatus {
        /**
         * 正常
         */
        NORMAL(0),
        /**
         * 暂停
         */
        PAUSE(1);

        private int value;

        ScheduleStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}

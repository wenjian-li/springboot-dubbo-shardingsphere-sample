package com.sample.lwj.provider.constant;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: provider服务常量
 * @date 2021/8/29 16:29
 */
public class Constants {
    /**
     * 常量0
     */
    public static final Integer ZERO = 0;

    /**
     * 常量1
     */
    public static final Integer ONE = 1;

    /**
     * 英文逗号分隔符
     */
    public static final String COMMA_SPLIT = ",";

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

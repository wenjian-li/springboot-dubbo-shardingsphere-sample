package com.sample.lwj.remote.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName T_SCHEDULE_JOB
 */
@Data
public class ScheduleJobVO implements Serializable {

    private static final long serialVersionUID = 6852116168781671071L;


    /**
     * 
     */
    private Long jobId;

    /**
     * 
     */
    private String beanName;

    /**
     * 
     */
    private String params;

    /**
     * 
     */
    private String cronExpression;

    /**
     * 
     */
    private Integer status;

    /**
     * 
     */
    private String remark;

    /**
     * 
     */
    private Date createTime;

}
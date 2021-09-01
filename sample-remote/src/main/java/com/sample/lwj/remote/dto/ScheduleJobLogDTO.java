package com.sample.lwj.remote.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName T_SCHEDULE_JOB_LOG
 */
@Data
public class ScheduleJobLogDTO implements Serializable {
    private static final long serialVersionUID = -7454716527740108018L;
    /**
     * 
     */
    private Long logId;

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
    private Integer status;

    /**
     * 
     */
    private String error;

    /**
     * 
     */
    private Integer times;

    /**
     * 
     */
    private Date createTime;

}
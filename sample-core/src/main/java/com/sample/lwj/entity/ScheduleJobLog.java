package com.sample.lwj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName t_schedule_job_log
 */
@TableName(value ="t_schedule_job_log")
public class ScheduleJobLog implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.ASSIGN_ID)
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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Long getLogId() {
        return logId;
    }

    /**
     * 
     */
    public void setLogId(Long logId) {
        this.logId = logId;
    }

    /**
     * 
     */
    public Long getJobId() {
        return jobId;
    }

    /**
     * 
     */
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    /**
     * 
     */
    public String getBeanName() {
        return beanName;
    }

    /**
     * 
     */
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    /**
     * 
     */
    public String getParams() {
        return params;
    }

    /**
     * 
     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     * 
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 
     */
    public String getError() {
        return error;
    }

    /**
     * 
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * 
     */
    public Integer getTimes() {
        return times;
    }

    /**
     * 
     */
    public void setTimes(Integer times) {
        this.times = times;
    }

    /**
     * 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
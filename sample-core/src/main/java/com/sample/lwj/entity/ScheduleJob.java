package com.sample.lwj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName t_schedule_job
 */
@TableName(value ="t_schedule_job")
public class ScheduleJob implements Serializable {

    /**
     * 任务调度参数key
     */
    public static final String JOB_PARAM_KEY = "JOB_PARAM_KEY";

    /**
     * 
     */
    @TableId(type = IdType.ASSIGN_ID)
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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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
    public String getCronExpression() {
        return cronExpression;
    }

    /**
     * 
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
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
    public String getRemark() {
        return remark;
    }

    /**
     * 
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
package com.sample.lwj.remote.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色
 * @TableName t_role
 */
public class RoleDTO implements Serializable {
    private static final long serialVersionUID = 3488065489630849765L;
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


    /**
     * 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 角色名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
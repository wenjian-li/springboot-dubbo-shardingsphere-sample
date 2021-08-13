package com.sample.lwj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName t_user
 */
@TableName(value ="t_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1092779287325005777L;
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 
     */
    private Integer roleId;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 修改日期
     */
    private Date updateTime;


    /**
     * 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 姓名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 姓名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 创建日期
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建日期
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改日期
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改日期
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
package com.sample.lwj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 菜单管理
 * @TableName t_menu
 */
@TableName(value ="t_menu")
public class Menu implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 父ID，一级菜单为0
     */
    private Integer pid;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String permission;

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private Integer type;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 父ID，一级菜单为0
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 父ID，一级菜单为0
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 菜单名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 菜单URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 菜单URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    public Integer getType() {
        return type;
    }

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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
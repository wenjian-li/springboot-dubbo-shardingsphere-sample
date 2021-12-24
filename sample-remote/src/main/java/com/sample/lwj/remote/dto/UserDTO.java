package com.sample.lwj.remote.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -7492128196992680601L;

    /**
     * 超级管理员ID
     */
    public static final long SUPER_ADMIN_ID = 1;

    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
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
     * 用户权限
     */
    private Set<String> permissions;



    /**
     * 是否为超级管理员
     *
     * @param userId 用户ID
     * @return 校验结果
     */
    public static boolean isSuperAdmin(Long userId) {
        return userId != null && userId == UserDTO.SUPER_ADMIN_ID;
    }

    /**
     * 是否为超级管理员
     *
     * @return 校验结果
     */
    public boolean isSuperAdmin() {
        return isSuperAdmin(this.id);
    }
}
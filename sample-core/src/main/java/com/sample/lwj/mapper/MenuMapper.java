package com.sample.lwj.mapper;

import com.sample.lwj.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Entity com.sample.lwj.entity.Menu
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 根据角色ID查询菜单
     *
     * @param roleId 角色ID
     * @return 菜单列表
     */
    List<Menu> selectByRoleId(@Param("roleId") Integer roleId);

    /**
     * 根据角色ID查询权限列表
     *
     * @param roleId 角色ID
     * @return 权限列表
     */
    List<String> selectPermissionsByRoleId(@Param("roleId") Integer roleId);

    /**
     * 根据用户ID查询菜单
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
    List<Menu> selectByUserId(@Param("userId") Long userId);

    /**
     * 查询超级管理员权限
     *
     * @return 权限列表
     */
    List<String> selectSuperAdminPermissions();
}





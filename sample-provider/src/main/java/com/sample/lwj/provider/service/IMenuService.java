package com.sample.lwj.provider.service;

import com.sample.lwj.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface IMenuService extends IService<Menu> {
    /**
     * 根据角色ID查询菜单
     *
     * @param roleId 角色ID
     * @return 菜单列表
     */
    List<Menu> selectByRoleId(Integer roleId);

    /**
     * 根据角色ID查询权限列表
     *
     * @param roleId 角色ID
     * @return 权限列表
     */
    List<String> selectPermissionsByRoleId(Integer roleId);
}

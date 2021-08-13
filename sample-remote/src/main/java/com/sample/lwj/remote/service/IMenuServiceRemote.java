package com.sample.lwj.remote.service;


import com.sample.lwj.remote.dto.MenuDTO;

import java.util.List;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 菜单RPC接口
 * @date 2021/8/10 14:08
 */
public interface IMenuServiceRemote {
    /**
     * 根据角色ID查询菜单
     *
     * @param roleId 角色ID
     * @return 菜单列表
     */
    List<MenuDTO> selectByRoleId(Integer roleId);

    /**
     * 根据角色ID查询权限列表
     *
     * @param roleId 角色ID
     * @return 权限列表
     */
    List<String> selectPermissionsByRoleId(Integer roleId);
}

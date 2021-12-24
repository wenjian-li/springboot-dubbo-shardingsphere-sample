package com.sample.lwj.remote.service;


import com.sample.lwj.remote.dto.MenuDTO;

import java.util.List;
import java.util.Set;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 菜单RPC接口
 * @date 2021/8/10 14:08
 */
public interface IMenuServiceRemote extends IBaseServiceRemote<MenuDTO> {
    /**
     * 根据角色ID查询菜单
     *
     * @param roleId 角色ID
     * @return 菜单列表
     */
    List<MenuDTO> selectByRoleId(Integer roleId);

    /**
     * 根据父ID查询菜单
     *
     * @param pid 父ID
     * @return 菜单列表
     */
    List<MenuDTO> selectByPid(Integer pid);

    /**
     * 根据角色ID查询权限列表
     *
     * @param roleId 角色ID
     * @return 权限列表
     */
    Set<String> selectPermissionsByRoleId(Integer roleId);

    /**
     * 查询超级管理员权限
     *
     * @return 权限列表
     */
    Set<String> selectSuperAdminPermissions();

    /**
     * 根据用户ID查询菜单
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
    List<MenuDTO> selectListByUserId(Long userId);

    /**
     * 根据用户ID查询树形菜单
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
    List<MenuDTO> selectMenuTreeByUserId(Long userId);

    /**
     * 获取导航树形菜单
     *
     * @param userId 用户ID
     * @return 导航列表
     */
    List<MenuDTO> selectNavTreeByUserId(Long userId);


    /**
     * 获取全部菜单树形结构
     *
     * @return 菜单列表
     */
    List<MenuDTO> selectAllMenuTree();
}

package com.sample.lwj.web.service;

import com.sample.lwj.remote.dto.MenuDTO;
import com.sample.lwj.remote.dto.MenuTreeDTO;
import com.sample.lwj.utils.ResultData;

import java.util.List;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 菜单接口
 * @date 2021/12/24 13:58
 */
public interface IMenuService {
    /**
     * 保存
     *
     * @param menuDTO
     * @return
     */
    ResultData<Boolean> save(MenuDTO menuDTO);

    /**
     * 更新
     *
     * @param menuDTO
     * @return
     */
    ResultData<Boolean> updateById(MenuDTO menuDTO);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    ResultData<Boolean> deleteById(Integer id);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    MenuDTO selectById(Long id);

    /**
     * 根据用户ID查询菜单
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
    List<MenuDTO> selectByUserId(Long userId);

    /**
     * 获取导航菜单
     *
     * @param userId 用户ID
     * @return 导航列表
     */
    List<MenuDTO> selectNavTreeByUserId(Long userId);


    /**
     * 获取角色树形菜单
     *
     * @param userId 用户ID
     * @param roleId 角色ID
     * @return 树形菜单列表
     */
    List<MenuTreeDTO> roleMenuTree(Long userId, Integer roleId);

    /**
     * 获取树形菜单
     *
     * @param userId         用户ID
     * @param permissionFlag 是否显示权限标识
     * @return 树形菜单列表
     */
    List<MenuTreeDTO> menuTree(Long userId, Boolean permissionFlag);
}

package com.sample.lwj.web.service.impl;

import com.sample.lwj.remote.dto.MenuDTO;
import com.sample.lwj.remote.dto.MenuTreeDTO;
import com.sample.lwj.remote.service.IMenuServiceRemote;
import com.sample.lwj.utils.ResultData;
import com.sample.lwj.web.service.IMenuService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 菜单接口实现类
 * @date 2021/12/24 14:02
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private IMenuServiceRemote menuServiceRemote;

    @Override
    public ResultData<Boolean> save(MenuDTO menuDTO) {
        Boolean bool = menuServiceRemote.save(menuDTO);
        return bool ? ResultData.success(bool) : ResultData.fail(bool);
    }

    @Override
    public ResultData<Boolean> updateById(MenuDTO menuDTO) {
        Boolean bool = menuServiceRemote.updateById(menuDTO);
        return bool ? ResultData.success(bool) : ResultData.fail(bool);
    }

    @Override
    public ResultData<Boolean> deleteById(Integer id) {
        //查找是否存在子级菜单
        List<MenuDTO> list = menuServiceRemote.selectByPid(id);
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultData.fail("请先删除子菜单！");
        }
        Boolean bool = menuServiceRemote.deleteById(id);
        return bool ? ResultData.success(bool) : ResultData.fail(bool);
    }

    @Override
    public MenuDTO selectById(Integer id) {
        MenuDTO menuDTO = menuServiceRemote.selectById(id);
        if (menuDTO != null && menuDTO.getPid() != null && menuDTO.getPid() != 0L) {
            MenuDTO parent = menuServiceRemote.selectById(menuDTO.getPid());
            menuDTO.setParentName(parent == null ? "" : parent.getName());
        }
        return menuDTO;
    }

    @Override
    public List<MenuDTO> selectByUserId(Long userId) {
        return menuServiceRemote.selectListByUserId(userId);
    }

    @Override
    public List<MenuDTO> selectNavTreeByUserId(Long userId) {
        return menuServiceRemote.selectNavTreeByUserId(userId);
    }

    @Override
    public List<MenuTreeDTO> roleMenuTree(Long userId, Integer roleId) {
        List<MenuTreeDTO> menuTreeList = new ArrayList<>();
        List<MenuDTO> menuList = menuServiceRemote.selectMenuTreeByUserId(userId);
        if (roleId != null) {
            List<MenuDTO> roleMenuDTOList = menuServiceRemote.selectByRoleId(roleId);
            List<String> roleMenuList = CollectionUtils.isEmpty(roleMenuDTOList) ? null :
                    roleMenuDTOList.parallelStream().map(item -> item.getId() + item.getPermission()).collect(Collectors.toList());
            return getMenuTreeList(menuTreeList, menuList, roleMenuList, true);
        }
        return getMenuTreeList(menuTreeList, menuList, null, true);
    }

    @Override
    public List<MenuTreeDTO> menuTree(Long userId, Boolean permissionFlag) {
        List<MenuTreeDTO> menuTreeList = new ArrayList<>();
        List<MenuDTO> menuList = menuServiceRemote.selectMenuTreeByUserId(userId);
        return getMenuTreeList(menuTreeList, menuList, null, permissionFlag);
    }

    /**
     * 将菜单转换为树形结构
     *
     * @param menuTreeList   树形结构
     * @param menuList       菜单集合
     * @param roleMenuList   角色菜单字符串集合
     * @param permissionFlag 是否显示权限标识
     * @return
     */
    private List<MenuTreeDTO> getMenuTreeList(List<MenuTreeDTO> menuTreeList, List<MenuDTO> menuList, List<String> roleMenuList, Boolean permissionFlag) {
        if (CollectionUtils.isEmpty(menuList)) {
            return menuTreeList;
        }
        menuList.forEach(menuDTO -> {
            //节点标题
            String title = permissionFlag && StringUtils.isNotBlank(menuDTO.getPermission()) ? menuDTO.getName() + "<font color=\"#888\">&nbsp;&nbsp;&nbsp;" + menuDTO.getPermission() + "</font>" : menuDTO.getName();
            MenuTreeDTO menuTree = new MenuTreeDTO();
            menuTree.setId(menuDTO.getId());
            menuTree.setTitle(title);
            //选中状态
            menuTree.setChecked(CollectionUtils.isEmpty(roleMenuList) ? false : roleMenuList.contains(menuDTO.getId() + menuDTO.getPermission()));
            if (CollectionUtils.isNotEmpty(menuDTO.getSubList())) {
                //layui树形组件BUG,回显的时候，如果父节点checked=true，则下面的子节点会全部勾选
                //这里设置为false，当子节点checked=true时，会自动勾选父节点
                menuTree.setChecked(false);
                List<MenuTreeDTO> chidren = new ArrayList<>();
                menuTree.setChildren(getMenuTreeList(chidren, menuDTO.getSubList(), roleMenuList, permissionFlag));
            }
            menuTreeList.add(menuTree);
        });
        return menuTreeList;
    }
}

package com.sample.lwj.provider.remote;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sample.lwj.entity.Menu;
import com.sample.lwj.entity.RoleMenu;
import com.sample.lwj.provider.constant.Constants;
import com.sample.lwj.provider.service.IMenuService;
import com.sample.lwj.provider.service.IRoleMenuService;
import com.sample.lwj.remote.dto.MenuDTO;
import com.sample.lwj.remote.dto.UserDTO;
import com.sample.lwj.remote.enums.MenuTypeEnum;
import com.sample.lwj.remote.service.IMenuServiceRemote;
import com.sample.lwj.utils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 菜单RPC实现类
 * @date 2021/8/10 14:11
 */
@Service("menuServiceRemote")
public class MenuServiceRemoteImpl implements IMenuServiceRemote {


    @Autowired
    private IMenuService menuService;

    @Autowired
    private IRoleMenuService roleMenuService;

    @Override
    public List<MenuDTO> selectByRoleId(Integer roleId) {
        return BeanUtils.toList(menuService.selectByRoleId(roleId), MenuDTO.class);
    }

    @Override
    public List<MenuDTO> selectByPid(Integer pid) {
        List<Menu> menuList = menuService.list(new QueryWrapper<Menu>().eq("pid", pid));
        return BeanUtils.toList(menuList, MenuDTO.class);
    }

    @Override
    public Set<String> selectPermissionsByRoleId(Integer roleId) {
        List<String> permissons = menuService.selectPermissionsByRoleId(roleId);
        Set<String> all = new HashSet<>();
        if (CollectionUtils.isEmpty(permissons)) {
            return all;
        }
        permissons.forEach(item -> {
            if (StringUtils.isBlank(item)) {
                return;
            }
            //例如：item = user:list,user:info
            all.addAll(Stream.of(item.split(Constants.COMMA_SPLIT)).collect(Collectors.toSet()));
        });
        return all;
    }

    @Override
    public Set<String> selectSuperAdminPermissions() {
        List<String> permissons = menuService.selectSuperAdminPermissions();
        Set<String> all = new HashSet<>();
        if (CollectionUtils.isEmpty(permissons)) {
            return all;
        }
        permissons.forEach(item -> {
            if (StringUtils.isBlank(item)) {
                return;
            }
            //例如：item = user:list,user:info
            all.addAll(Stream.of(item.split(Constants.COMMA_SPLIT)).collect(Collectors.toSet()));
        });
        return all;
    }

    @Override
    public List<MenuDTO> selectListByUserId(Long userId) {
        List<Menu> list = UserDTO.isSuperAdmin(userId) ? menuService.list(new QueryWrapper<Menu>().orderByAsc("SORT")) : menuService.selectByUserId(userId);
        return BeanUtils.toList(list, MenuDTO.class);
    }

    @Override
    public List<MenuDTO> selectMenuTreeByUserId(Long userId) {
        //超级管理员则直接获取所有菜单
        List<Menu> userMenuList = UserDTO.isSuperAdmin(userId) ? menuService.list(new QueryWrapper<Menu>().orderByAsc("SORT")) : menuService.selectByUserId(userId);
        return getTopMenuTreeList(userMenuList, null);
    }

    @Override
    public List<MenuDTO> selectNavTreeByUserId(Long userId) {
        //获取导航,导航只显示菜单即type=1
        //超级管理员则直接获取所有菜单
        List<Menu> userMenuList = UserDTO.isSuperAdmin(userId) ? menuService.list(new QueryWrapper<Menu>().orderByAsc("SORT")) : menuService.selectByUserId(userId);
        return getTopMenuTreeList(userMenuList, MenuTypeEnum.MENU);
    }

    @Override
    public List<MenuDTO> selectAllMenuTree() {
        List<Menu> menuList = menuService.list(new QueryWrapper<Menu>().orderByAsc("SORT"));
        return getTopMenuTreeList(menuList, null);
    }

    /**
     * 获取顶级菜单结构
     *
     * @param menuList   菜单列表
     * @param filterType 菜单类型过滤条件（filterType = null 表示获取所有类型菜单数据，包括目录、菜单、按钮）
     * @return
     */
    private List<MenuDTO> getTopMenuTreeList(List<Menu> menuList, MenuTypeEnum filterType) {
        List<MenuDTO> allMenuList = BeanUtils.toList(menuList, MenuDTO.class);
        //获取顶级菜单即parentId=0,并且类型为目录即type=0
        List<MenuDTO> topMenuList = getMenuListByParentId(Constants.ZERO, MenuTypeEnum.CATALOG, allMenuList);
        //递归获取子菜单，顶级菜单无父级菜单parentName=null
        getMenuTreeList(null, filterType, topMenuList, allMenuList);
        return topMenuList;
    }

    /**
     * 根据父菜单ID获取子菜单
     *
     * @param parentId    父菜单ID
     * @param filterType  菜单类型过滤条件
     * @param allMenuList 所有菜单列表
     * @return
     */
    private List<MenuDTO> getMenuListByParentId(Integer parentId, MenuTypeEnum filterType, List<MenuDTO> allMenuList) {
        //判断条件：1、菜单父ID与parentId一致 2、类型与filterType一致
        Stream<MenuDTO> stream = allMenuList.parallelStream().filter(menu -> parentId.equals(menu.getPid()));
        if (filterType != null) {
            stream = stream.filter(menu -> filterType.getCode().equals(menu.getType()));
        }
        return stream.collect(Collectors.toList());
    }

    /**
     * 递归取得子菜单
     *
     * @param parentName  父菜单名称
     * @param filterType  菜单类型过滤条件
     * @param menuList    待赋值子菜单的菜单列表
     * @param allMenuList 所有菜单列表
     * @return
     */
    private List<MenuDTO> getMenuTreeList(String parentName, MenuTypeEnum filterType, List<MenuDTO> menuList, List<MenuDTO> allMenuList) {
        for (MenuDTO menuDTO : menuList) {
            //赋值父菜单名称
            menuDTO.setParentName(parentName);
            //获取子菜单
            List<MenuDTO> subList = getMenuListByParentId(menuDTO.getId(), filterType, allMenuList);
            //递归子菜单
            menuDTO.setSubList(getMenuTreeList(menuDTO.getName(), filterType, subList, allMenuList));
        }
        return menuList;
    }

    @Override
    public Boolean save(MenuDTO dto) {
        return menuService.save(BeanUtils.toBean(dto, Menu.class));
    }

    @Override
    public Boolean updateById(MenuDTO dto) {
        return menuService.updateById(BeanUtils.toBean(dto, Menu.class));
    }

    @Override
    public Boolean deleteById(Serializable id) {
        Boolean result = menuService.removeById(id);
        if (result) {
            //删除菜单与角色关联数据
            roleMenuService.remove(new QueryWrapper<RoleMenu>().eq("MENU_ID", id));
        }
        return result;
    }

    @Override
    public MenuDTO selectById(Serializable id) {
        return BeanUtils.toBean(menuService.getById(id), MenuDTO.class);
    }
}

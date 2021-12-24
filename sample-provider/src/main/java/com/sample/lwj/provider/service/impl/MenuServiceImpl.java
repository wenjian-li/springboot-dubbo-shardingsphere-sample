package com.sample.lwj.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sample.lwj.entity.Menu;
import com.sample.lwj.mapper.MenuMapper;
import com.sample.lwj.provider.service.IMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
        implements IMenuService {


    @Override
    public List<Menu> selectByRoleId(Integer roleId) {
        return baseMapper.selectByRoleId(roleId);
    }

    @Override
    public List<String> selectPermissionsByRoleId(Integer roleId) {
        return baseMapper.selectPermissionsByRoleId(roleId);
    }

    @Override
    public List<Menu> selectByUserId(Long userId) {
        return baseMapper.selectByUserId(userId);
    }

    @Override
    public List<String> selectSuperAdminPermissions() {
        return baseMapper.selectSuperAdminPermissions();
    }
}





package com.sample.lwj.provider.remote;

import com.sample.lwj.provider.service.IMenuService;
import com.sample.lwj.provider.utils.BeanUtils;
import com.sample.lwj.remote.dto.MenuDTO;
import com.sample.lwj.remote.service.IMenuServiceRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<MenuDTO> selectByRoleId(Integer roleId) {
        return BeanUtils.toList(menuService.selectByRoleId(roleId), MenuDTO.class);
    }

    @Override
    public List<String> selectPermissionsByRoleId(Integer roleId) {
        List<String> permissons = menuService.selectPermissionsByRoleId(roleId);
        Set<String> all = new HashSet<>();
        if (permissons != null) {
            permissons.forEach(item -> {
                //例如：item = user:list,user:info
                all.addAll(Stream.of(item.split(",")).collect(Collectors.toSet()));
            });
        }
        return new ArrayList<>(all);
    }
}

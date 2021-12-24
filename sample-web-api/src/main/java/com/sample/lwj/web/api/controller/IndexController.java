package com.sample.lwj.web.api.controller;

import com.sample.lwj.remote.dto.MenuDTO;
import com.sample.lwj.remote.dto.UserDTO;
import com.sample.lwj.web.service.IMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 首页
 * @date 2021/12/24 13:56
 */
@Api(tags = "首页")
@Controller
public class IndexController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IMenuService menuService;

    @GetMapping("/")
    public String index(ModelMap modelMap) {
        //todo
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setRoleId(1);
        userDTO.setUsername("admin");
        List<MenuDTO> navTrees = menuService.selectNavTreeByUserId(userDTO.getId());
        modelMap.put("navTrees", navTrees);
//        modelMap.put("loginUser", getCurrentUser());
        modelMap.put("loginUser", userDTO);
        return "index";
    }


    @GetMapping("/unauthorized")
    @ApiOperation("无权限页")
    public String unauthorized() {
        return "unauthorized";
    }
}

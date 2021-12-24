package com.sample.lwj.web.api.controller;

import com.sample.lwj.remote.dto.UserDTO;
import com.sample.lwj.web.service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 控制器基类
 * @date 2021/8/10 18:53
 */
public abstract class BaseController {

    @Autowired
    private ITokenService tokenService;

    /**
     * 获取当前登录用户
     *
     * @return 当前登录用户
     */
    public UserDTO getCurrentUser() {
        //todo 模拟数据
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setRoleId(1);
        userDTO.setUsername("admin");
        return userDTO;
//        return tokenService.queryByToken(getCurrentToken());
    }

    /**
     * 获取当前登录用户ID
     *
     * @return 当前登录用户ID
     */
    public Long getCurrentUserId() {
        return getCurrentUser().getId();
    }

    /**
     * 获取当前请求token
     *
     * @return 请求头token
     */
    public String getCurrentToken() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest servletRequest = attributes.getRequest();
        return servletRequest.getHeader("token");
    }
}

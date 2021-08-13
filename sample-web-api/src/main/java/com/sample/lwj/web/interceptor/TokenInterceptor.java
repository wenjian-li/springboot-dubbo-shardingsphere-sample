package com.sample.lwj.web.interceptor;

import com.sample.lwj.web.config.AppException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 权限拦截器
 * @date 2021/8/10 19:18
 */
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");
        //token为空
        if (StringUtils.isBlank(token)) {
            throw new AppException("token不能为空");
        }
        return true;
    }
}

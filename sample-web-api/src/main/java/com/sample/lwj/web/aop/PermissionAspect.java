package com.sample.lwj.web.aop;

import com.sample.lwj.exception.BizException;
import com.sample.lwj.remote.dto.UserDTO;
import com.sample.lwj.web.service.ITokenService;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 权限控制拦截器
 * @date 2021/8/9 15:30
 */
@Component
@Aspect
public class PermissionAspect {

    private final static Logger logger = LoggerFactory.getLogger(PermissionAspect.class);

    @Autowired
    private ITokenService tokenService;


    @Before("@annotation(com.sample.lwj.web.aop.RequiresPermissions)")
    public void before(JoinPoint joinPoint) {
        logger.debug("开始校验[操作权限]");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest servletRequest = attributes.getRequest();
        String token = servletRequest.getHeader("token");
        //token为空
        if (StringUtils.isBlank(token)) {
            throw new BizException("token不能为空");
        }
        UserDTO userInfo = tokenService.queryByToken(token);
        if (userInfo == null) {
            throw new BizException("token失效,请重新登录");
        }
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        RequiresPermissions rp = methodSignature.getMethod().getAnnotation(RequiresPermissions.class);
        //请求所需权限
        List<String> values = Arrays.asList(rp.value());
        //取两者权限交集
        Set<String> intersection = userInfo.getPermissions().parallelStream().filter(item -> values.contains(item)).collect(Collectors.toSet());
        //没有权限 1、Logical.AND必须包含要求的每个权限,无权限即交集不等于请求所需权限 2、Logical.OR多个权限只需包含其中一种即可，无权限即交集等于0
        Boolean unauthorized = rp.logical() == Logical.AND ? intersection.size() != values.size() : intersection.size() == 0;
        if (unauthorized) {
            //抛出[权限不足]的异常
            throw new BizException("权限不足");
        }
    }
}

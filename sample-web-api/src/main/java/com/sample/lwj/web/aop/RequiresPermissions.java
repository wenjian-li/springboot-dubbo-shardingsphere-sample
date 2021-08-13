package com.sample.lwj.web.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 权限验证AOP
 * @date 2021/8/9 15:23
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresPermissions {

    String[] value();

    Logical logical() default Logical.AND;
}

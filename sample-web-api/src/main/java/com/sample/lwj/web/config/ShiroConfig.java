

package com.sample.lwj.web.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.sample.lwj.web.shiro.UserRealm;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.ServletContainerSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro的配置文件
 */
@Configuration
public class ShiroConfig {

    /**
     * 单机环境，session交给shiro管理
     */
    @Bean
    @ConditionalOnProperty(prefix = "config", name = "cluster", havingValue = "false")
    public DefaultWebSessionManager sessionManager(@Value("${config.globalSessionTimeout:3600}") long globalSessionTimeout) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        sessionManager.setSessionValidationInterval(globalSessionTimeout * 1000);
        sessionManager.setGlobalSessionTimeout(globalSessionTimeout * 1000);

        return sessionManager;
    }

    /**
     * 集群环境，session交给spring-session管理
     */
    @Bean
    @ConditionalOnProperty(prefix = "config", name = "cluster", havingValue = "true")
    public ServletContainerSessionManager servletContainerSessionManager() {
        return new ServletContainerSessionManager();
    }

    /**
     * 配置shiro的CacheManager对象，缓存用户权限
     *
     * @return
     */
    @Bean
    public CacheManager shiroCacheManager() {
        return new MemoryConstrainedCacheManager();
    }

    @Bean("securityManager")
    public DefaultWebSecurityManager securityManager(UserRealm userRealm, CacheManager cacheManager, CookieRememberMeManager rememberMeManager,
                                                     SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        securityManager.setCacheManager(cacheManager);
        securityManager.setRememberMeManager(rememberMeManager);
        securityManager.setSessionManager(sessionManager);

        return securityManager;
    }

    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    @Bean(name = "shiroDialect")
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        shiroFilter.setUnauthorizedUrl("/unauthorized.html");
        shiroFilter.setLoginUrl("/login");
        shiroFilter.setSuccessUrl("/");
//        Map<String, Filter> filter = new LinkedHashMap<>();
//        filter.put("authc", new AjaxPermissionsAuthorizationFilter());
//        shiroFilter.setFilters(filter);


        Map<String, String> filterMap = new LinkedHashMap<>();


        filterMap.put("/swagger/**", "anon");
        filterMap.put("/v2/api-docs", "anon");
        filterMap.put("/swagger-ui.html", "anon");
        filterMap.put("/webjars/**", "anon");
        filterMap.put("/swagger-resources/**", "anon");
        filterMap.put("/doc.html", "anon");

        filterMap.put("/static/**", "anon");
        filterMap.put("/js/**", "anon");
        filterMap.put("/css/**", "anon");
        filterMap.put("/font/**", "anon");
        filterMap.put("/layui/font/**", "anon");
        filterMap.put("/layui/css/**", "anon");
        filterMap.put("/layui/css/modules/**", "anon");
        filterMap.put("/layui/css/modules/layer/**", "anon");
        filterMap.put("/layui/css/modules/layer/default/**", "anon");
        filterMap.put("/layui/**", "anon");

        filterMap.put("/font-awesome/**", "anon");
        filterMap.put("/images/**", "anon");

        filterMap.put("/login", "anon");
        filterMap.put("/favicon.ico", "anon");
        filterMap.put("/captcha.jpg", "anon");


        filterMap.put("/license/**", "anon");
        filterMap.put("/collector/**", "anon");
        filterMap.put("/api/**", "anon");


        filterMap.put("/**", "user");


        shiroFilter.setFilterChainDefinitionMap(filterMap);

        return shiroFilter;
    }

    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    /**
     * 1.配置cookie管理对象
     * 2.配置Cookie对象
     *
     * @return CookieRememberMeManager
     */
    @Bean
    public CookieRememberMeManager cookieRememberMeManager(@Value("${config.cookieMaxAge:7}") Integer cookieMaxAge) {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        // rememberMe cookie加密的密钥
        cookieRememberMeManager.setCipherKey("managementsystem".getBytes(StandardCharsets.UTF_8));
        // 配置Cookie对象
        // 记住我的cookie：rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("demo.rememberMe");
        //simpleCookie.setHttpOnly(true);
        //单位(秒)，默认7天
        simpleCookie.setMaxAge(60 * 60 * 24 * cookieMaxAge);
        cookieRememberMeManager.setCookie(simpleCookie);
        return cookieRememberMeManager;
    }

}

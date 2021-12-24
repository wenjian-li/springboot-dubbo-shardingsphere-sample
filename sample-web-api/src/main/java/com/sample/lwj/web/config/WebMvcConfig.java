package com.sample.lwj.web.config;

import com.sample.lwj.web.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: token拦截器
 * @date 2021/8/10 19:41
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //token
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/")
                .excludePathPatterns("/api/login")
                .excludePathPatterns("/server/*")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/font/**")
                .excludePathPatterns("/layui/**")
                .excludePathPatterns("/font-awesome/**")
                .excludePathPatterns("/images/**");
        //国际化
        registry.addInterceptor(localeChangeInterceptor());

    }

    /**
     * Cookie存储国际化信息
     *
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new CookieLocaleResolver();
    }

    /**
     * 切换语言按钮URL?language=zh_CN，切换后将语言信息存入cookie；
     * 例如：
     * http://localhost:8082/?language=zh_CN
     * http://localhost:8082/?language=en_US
     * http://localhost:8082/api/login?language=en_US
     * 语言参考Locale类
     *
     * @return
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("language");
        return lci;
    }
}

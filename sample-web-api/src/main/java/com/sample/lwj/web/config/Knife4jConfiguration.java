package com.sample.lwj.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: swagger配置
 * @date 2021/8/2 16:34
 */
@Configuration
public class Knife4jConfiguration {

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
//                        .title(" swagger-bootstrap-ui-demo  RESTful APIs")
                        .description("#  swagger-bootstrap-ui-demo  RESTful APIs")
                        .termsOfServiceUrl("http://www.xx.com/")
                        .contact(new Contact("vincent.li", "", ""))
                        .version("1.0.0")
                        .build())
                //分组名称
                .groupName("v2.0版本")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.sample.lwj.web.api.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}

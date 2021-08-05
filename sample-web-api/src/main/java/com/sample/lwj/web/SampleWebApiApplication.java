package com.sample.lwj.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: web api 启动类
 * @date 2021/8/1 12:00
 */
@SpringBootApplication
@ImportResource(value = {"classpath:dubbo.xml"})
public class SampleWebApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleWebApiApplication.class, args);
    }

}

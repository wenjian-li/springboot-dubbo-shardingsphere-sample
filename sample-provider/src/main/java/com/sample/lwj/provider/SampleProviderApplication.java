package com.sample.lwj.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("com.sample.lwj.mapper")
@ImportResource(value = {"classpath:dubbo.xml"})
public class SampleProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleProviderApplication.class, args);
    }

}

package com.lyu.excute.easy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.lyu.excute.easy.mapper")
@SpringBootApplication
@EnableEurekaClient
public class ExcuteEasyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExcuteEasyApplication.class, args);
    }

}

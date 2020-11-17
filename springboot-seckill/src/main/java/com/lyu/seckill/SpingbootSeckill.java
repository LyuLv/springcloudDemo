package com.lyu.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.lyu.seckill.dao")
@EnableEurekaClient
public class SpingbootSeckill {

    public static void main(String[] args) {
        SpringApplication.run(SpingbootSeckill.class, args);
    }

}

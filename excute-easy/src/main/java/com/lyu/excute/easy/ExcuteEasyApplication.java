package com.lyu.excute.easy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lyu.excute.easy.mapper")
@SpringBootApplication
public class ExcuteEasyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExcuteEasyApplication.class, args);
    }

}

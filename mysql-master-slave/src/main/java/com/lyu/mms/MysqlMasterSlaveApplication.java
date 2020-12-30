package com.lyu.mms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.lyu.mms.mapper"})
public class MysqlMasterSlaveApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlMasterSlaveApplication.class, args);
    }

}

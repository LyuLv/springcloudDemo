package com.lyu.mms;

import com.lyu.mms.domain.User;
import com.lyu.mms.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MysqlMasterSlaveApplicationTests {

    @Resource
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    public void test1() {
        User user = new User();
        user.setId("00001");
        user.setName("张三");
        user.setAge(23);
        user.setRemarks("刺客");
        userService.save(user);
    }


}

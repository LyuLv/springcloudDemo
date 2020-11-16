package com.lyu.excute.easy.controller;

import com.lyu.excute.easy.entity.User;
import com.lyu.excute.easy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author: Lyu
 * @Description:
 * @Date: Created in 17:10 2020/11/10
 * @Modified By:
 */
@RestController
@RequestMapping(name = "user", value = "/user")
public class UserController {
    @Autowired
    UserService UserService;

    @GetMapping(name = "主键查询", value = {"/{id}"})
    public User get(@PathVariable("id") String id) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        return UserService.get(id);
    }


}

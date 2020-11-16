package com.lyu.excute.easy.service;

import com.lyu.excute.easy.entity.User;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author: Lyu
 * @Description:
 * @Date: Created in 17:11 2020/11/10
 * @Modified By:
 */
public interface UserService {

    User get(String id) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}

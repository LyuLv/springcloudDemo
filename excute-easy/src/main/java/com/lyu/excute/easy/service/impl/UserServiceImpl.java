package com.lyu.excute.easy.service.impl;

import com.lyu.excute.easy.dao.BaseDao;
import com.lyu.excute.easy.entity.User;
import com.lyu.excute.easy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author: Lyu
 * @Description:
 * @Date: Created in 17:11 2020/11/10
 * @Modified By:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    BaseDao baseDao;
    @Override
    public User get(String id) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        User user = (User) baseDao.excute(User.class, "selectByPrimaryKey", "com.lyu.excute.easy.mapper.UserMapper", "1");
        return user;
    }
}

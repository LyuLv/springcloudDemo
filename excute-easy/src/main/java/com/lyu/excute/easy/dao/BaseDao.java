package com.lyu.excute.easy.dao;

import com.lyu.excute.easy.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: Lyu
 * @Description:
 * @Date: Created in 16:38 2020/11/10
 * @Modified By:
 */
@Component
public class BaseDao<T> {

    Logger LOGGER = LoggerFactory.getLogger(BaseDao.class);
    /**
     *
     * @param responseClass 返回对象类
     * @param xmlId sqlId
     * @param fullMapperName 全限定Mapper类名
     * @param params 入参
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public final T excute(Class<T> responseClass, String xmlId, String fullMapperName, String params) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        if (responseClass == null) {
            throw new NullPointerException();
        }
        //获取Mapper对象
        Class aClass = Class.forName(fullMapperName);
        LOGGER.info("Mapper对象为：" + aClass.getTypeName());
        Method method = aClass.getMethod(xmlId, String.class);
        LOGGER.info("Method为：" + method.getName());
        T t = (T) method.invoke(aClass.newInstance(), params);
        return t;
    }


    public static void main(String[] args) {
        System.out.println(User.class.getSimpleName());
    }

}

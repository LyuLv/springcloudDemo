package com.lyu.springboot.redis.spingbootredis.polymorphic;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: Lyu
 * @Description: 获取bean
 * @Date: Created in 10:26 2020/10/12
 * @Modified By:
 */
@Component
public class AppContent<T> implements ApplicationContextAware {
    private static ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    /**
     * 根据Class获取bean
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T  getBean(Class<T> clazz) {
        return context != null ? context.getBean(clazz) : null;
    }

    /**
     * 获取该类型的所有实现bean，并封装为map
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> clazz) {
        return context.getBeansOfType(clazz);
    }

}

package com.lyu.mms.annotation;

import com.lyu.mms.config.DBTypeEnum;

import java.lang.annotation.*;

/**
 * @Author: Lyu
 * @Description: 数据源切换注解
 * @Date: Created in 17:49 2020/12/29
 * @Modified By:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface DataSourceSwitcher {

    /**
     * 默认数据源
     * @return
     */
    String value() default DBTypeEnum.MASTER;

    /**
     * 默认清除ThreadLocal中上下文
     * @return
     */
    boolean clear() default true;
}

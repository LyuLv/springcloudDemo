package com.lyu.mms.annotation;

import com.lyu.mms.config.DBContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: Lyu
 * @Description:
 * @Date: Created in 18:03 2020/12/29
 * @Modified By:
 */
@Aspect
@Component
public class DataSourceContextAop {
    private final static Logger LOGGER = LoggerFactory.getLogger(DataSourceContextAop.class);

    @Around("@annotation(com.lyu.mms.annotation.DataSourceSwitcher)")
    public Object setDataSource(ProceedingJoinPoint point) {
        boolean clear = false;
        try {
            MethodSignature signature = (MethodSignature) point.getSignature();
            Method method = signature.getMethod();
            DataSourceSwitcher dataSourceSwitcher = method.getAnnotation(DataSourceSwitcher.class);
            clear = dataSourceSwitcher.clear();
            DBContextHolder.set(dataSourceSwitcher.value());
            LOGGER.info("切换数据源至->{}", dataSourceSwitcher.value());
            return point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            if (clear) {
                DBContextHolder.clear();
            }
        }
        return null;
    }
}

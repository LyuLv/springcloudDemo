package com.lyu.springboot.redis.spingbootredis.polymorphic.impl2;

import com.lyu.springboot.redis.spingbootredis.polymorphic.InterSuper;
import org.springframework.stereotype.Component;

/**
 * @Author: Lyu
 * @Description:
 * @Date: Created in 10:07 2020/10/12
 * @Modified By:
 */
@Component
public class InterSuperImpl implements InterSuper {
    @Override
    public void dispatch(String s) {
        if ("2".equals(s)) {
            System.out.println("InterSuperImpl2--->" + s);
        }
    }
}

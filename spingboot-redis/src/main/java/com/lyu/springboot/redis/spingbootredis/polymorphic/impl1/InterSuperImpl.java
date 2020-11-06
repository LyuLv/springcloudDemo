package com.lyu.springboot.redis.spingbootredis.polymorphic.impl1;

import com.lyu.springboot.redis.spingbootredis.polymorphic.InterSuper;
import org.springframework.stereotype.Component;

/**
 * @Author: Lyu
 * @Description:
 * @Date: Created in 10:07 2020/10/12
 * @Modified By:
 */
@Component("interSuperImpl1")
public class InterSuperImpl implements InterSuper {
    @Override
    public void dispatch(String s) {
        if ("1".equals(s)) {
            System.out.println("InterSuperImpl1--->" + s);
        }
    }
}

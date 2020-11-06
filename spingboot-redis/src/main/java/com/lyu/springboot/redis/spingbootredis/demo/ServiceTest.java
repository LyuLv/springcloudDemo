package com.lyu.springboot.redis.spingbootredis.demo;

import com.lyu.springboot.redis.spingbootredis.config.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @Author: Lyu
 * @Description:
 * @Date: Created in 18:09 2020/8/21
 * @Modified By:
 */
@Component
public class ServiceTest {
    private Logger LOGGER = LoggerFactory.getLogger(ServiceTest.class);

    @Resource
    private RedisUtils redisUtils;

    /**
     * redis中设置值
     */
    @Scheduled(cron = "0 0/15 * * * ?")
    public void task() {
        String key = "lyu:1st" + Math.random() * 10;
        redisUtils.set(key, String.valueOf(System.currentTimeMillis()));
        redisUtils.expire(key, 15*60);
        LOGGER.info("set key-->{}, value-->{}", key, redisUtils.get(key));
    }

    @Scheduled(cron = "0 0/20 * * * ?")
    public void surplus() {
        Set<String> set = redisUtils.keys("lyu:1st*");
        set.forEach(s -> {
            LOGGER.info(s + "剩余时间：" + redisUtils.ttl(s) + "秒");
        });
    }


}

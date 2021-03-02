package com.lyu.lv.singleton.singlecase;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Lyu
 * @Description: 单例模式--懒汉模式---处理成线程安全的
 * @Date: Created in 10:49 2021/3/2
 * @Modified By:
 */
public class SingletonLh {
    private volatile static SingletonLh instance = null;

    /**
     * 私有的构造函数
     */
    private SingletonLh() {}

    public static SingletonLh getInstance() {
        //先检查实例是否存在，不存在进入同步块
        if (instance == null) {
            synchronized (SingletonLh.class) {
                //再次检查实例是否存在，不存在创建实例
                if (instance == null) {
                    instance = new SingletonLh();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
//        new Thread(() -> System.out.println("thread-1-->" + getInstance())).start();
//        new Thread(() -> System.out.println("thread-2-->" + getInstance())).start();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.MINUTES, new LinkedBlockingQueue<>(10));
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> System.out.println(Thread.currentThread().getName() + "-->" + getInstance()));
        }

        executor.shutdown();
    }
}

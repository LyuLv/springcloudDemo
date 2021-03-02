package com.lyu.lv.singleton.singlecase;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Lyu
 * @Description: 单例模式--饿汉模式，线程安全的
 * @Date: Created in 10:35 2021/3/2
 * @Modified By:
 */
public class SingletonEh {
    /**
     * 创建实例对象
     */
    private static SingletonEh instance = new SingletonEh();

    /**
     * 私有的构造函数
     */
    private SingletonEh() {}

    /**
     * 公用的静态方法
     * @return SingletonEh
     */
    public static SingletonEh getInstance() {
        return instance;
    }

    public static void main(String[] args) {
//        System.out.println(getInstance());
//
//        new Thread(() -> System.out.println("thread-1-->" + getInstance())).start();
//        new Thread(() -> System.out.println("thread-2-->" + getInstance())).start();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> System.out.println(Thread.currentThread().getName() + "-->" + getInstance()));
        }

        executor.shutdown();
    }

}

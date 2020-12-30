package com.lyu.mms.config;

/**
 * @Author: Lyu
 * @Description: 通过ThreadLocal将数据源设置到每个线程上下文中
 * @Date: Created in 17:06 2020/12/29
 * @Modified By:
 */
public class DBContextHolder {
    private final static ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /**
     * 设置数据源
     * @param dbType
     */
    public static void set(String dbType) {
        contextHolder.set(dbType);
    }

    /**
     * 设置数据源
     * @return
     */
    public static String get() {
        return contextHolder.get();
    }

    /**
     * 清除ThreadLocal中的上下文
     */
    public static void clear() {
        contextHolder.remove();
    }
}

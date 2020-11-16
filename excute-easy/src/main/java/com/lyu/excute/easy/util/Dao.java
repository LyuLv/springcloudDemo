package com.lyu.excute.easy.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dao {
    public static <T> List<T> execute(String namespace, String sqlName, Map<String, Object> paramsMap) {
        return DaoUtil.execute(namespace, sqlName, paramsMap);
    }

    public static <T> List<T> execute(String namespace, String sqlName, String... params){
        Map<String, Object> paramsMap = new HashMap<>();
        for (int i = 0; i < params.length - 1; i++) {
            paramsMap.put(params[i],params[i+1]);
        }
        return execute(namespace, sqlName, paramsMap);
    }

    public static <T> List<T> execute(String namespace, String sqlName, Object objParam) {
        return execute(namespace, sqlName, JSONObject.parseObject(JSON.toJSONString(objParam)));
    }
}

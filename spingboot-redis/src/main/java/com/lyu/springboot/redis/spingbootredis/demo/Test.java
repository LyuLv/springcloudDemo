package com.lyu.springboot.redis.spingbootredis.demo;

import com.alibaba.fastjson.JSONObject;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @Author: Lyu
 * @Description:
 * @Date: Created in 16:38 2020/8/24
 * @Modified By:
 */
public class Test {

    public static void main(String[] args) {
        LocalDate start = LocalDate.parse("2019-10-01");
        LocalDate end = LocalDate.parse("2020-03-01");
        System.out.println(start.getMonthValue());
        List<String> time = new ArrayList<>();
        time.add(String.valueOf(start).substring(0, start.toString().lastIndexOf("-")));
        LocalDate temp = start;
        for (int i = 0; i < 6; i++) {
            LocalDate tp = temp.plusMonths(1);
            System.out.println(i + "--" + tp);
            if (temp.isBefore(end)) {
                time.add(String.valueOf(tp).substring(0, tp.toString().lastIndexOf("-")));
            }
            temp = tp;
        }
        time.forEach(s -> System.out.println("---" + s));

        Integer number = 13;
        String rule = "[{\"target\":\"D\"},{\"unit\":\"元/月\"},{\"vaule\":[{120:[\"min\",6]}, {160:[6, 14]}, {200:[14, 19]}, {240:[\"max\",20]}]}]";
        String rule1 = "[{\"target\":\"D\"},{\"vaule\":[{\"flag\":\"expr\"},{\"productTypeName\":\"勘察设计\",\"unit\":\"元/月\",\"value\":1500},{\"region\":\"西藏\",\"unit\":\"元/人\",\"value\":350},{\"region\":\"other\",\"unit\":\"元/人\",\"value\":350}]}]";
        String rule2 = "[{\"target\":\"D\"},{\"unit\":\"元/月\"},{\"vaule\":[{\"object\":\"TTTT\"},{\"flag\":\"ppp\"},{120:[\"min\",6]}, {160:[6, 14]}, {200:[14, 19]}, {240:[\"max\",20]}]}]";
        String rule3 = "[{\"target\":\"D\"},{\"source\":[{\"value\":120,\"unit\":\"元/月\",\"rule\":\"x<6\",\"field\":\"C\"}, {\"value\":160,\"unit\":\"元/月\",\"rule\":\"x>=6&&x<14\",\"field\":\"C\"}, {\"value\":200,\"unit\":\"元/月\",\"rule\":\"x>=14&&x<19\",\"field\":\"C\"}, {\"value\":240,\"unit\":\"元/月\",\"rule\":\"x>20\",\"field\":\"C\"}]}]";
        System.out.println(rule3);

        String flag = "x >= 1 && x < 3";
        flag = flag.replaceAll("x", "2");
        boolean s = Boolean.valueOf(flag).booleanValue();
        boolean ss = Boolean.parseBoolean(flag);
        System.out.println(s);
        System.out.println(ss);

        String flag1 = "x != '西藏'";
        String x = "上海";
        flag1 = flag1.replaceAll("x", x);

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object result = null;
        try {
            result = engine.eval(flag);
            result = engine.eval(flag1);
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        System.out.println("结果类型:" + result.getClass().getName() + ",计算结果:" + result);

        List<Map<Object, Object>> list = JSONObject.parseObject(rule, ArrayList.class);
        List<Map<Object, Object>> list1 = JSONObject.parseObject(rule1, ArrayList.class);
        List<Map<Object, Object>> list2 = JSONObject.parseObject(rule2, ArrayList.class);
        System.out.println(list);
        System.out.println(list1);
        System.out.println(list2);

        List<Map<String, Object>> list5 = new ArrayList();
        Map<String, Object> map = new HashMap<>();
        map.put("1","ppp");
        map.put("3","ppp3");
        map.put("2","ppp2");
        List list3 = new ArrayList();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        map.put("list3",list3);
        Map<String, Object> map1 = new HashMap<>();
        map1.put("11","ppp");
        map1.put("33","ppp3");
        map1.put("22","ppp2");
        List list4 = new ArrayList();
        list4.add(1);
        list4.add(2);
        list4.add(3);
        map1.put("list4",list4);

        list5.add(map);
        list5.add(map1);

//        Map<String, Object> map2 = list5.stream().collect(Collectors.toMap(Objects::toString, LinkedHashMap::new, (k1,k2)->k2));
        Map<String, Object> map2 = new HashMap<>();
        for (Map<String, Object> stringObjectMap : list5) {
            map2.putAll(stringObjectMap);
        }
        System.out.println(map2.toString());
//        list.forEach(integerObjectLinkedHashMap -> {
//            Iterator iterator = integerObjectLinkedHashMap.entrySet().iterator();
//            while (iterator.hasNext()) {
//                Map.Entry entry = (Map.Entry) iterator.next();
//                BigDecimal key = new BigDecimal(entry.getKey().toString());
//                List<Object> array = (List<Object>) entry.getValue();
//                if ("min".equals(array.get(0).toString())) {
//                    if (number < Integer.valueOf(array.get(1).toString())) {
//                        System.out.println("key-" + key);
//                        break;
//                    }
//                } else if ("max".equals(array.get(0).toString())) {
//                    if (number > Integer.valueOf(array.get(1).toString())) {
//                        System.out.println("key-" + key);
//                        break;
//                    }
//                } else {
//                    Boolean aBoolean = (number > Integer.valueOf(array.get(0).toString()) || number.equals(Integer.valueOf(array.get(0).toString()))) && (number < Integer.valueOf(array.get(1).toString()));
//                    if (aBoolean) {
//                        System.out.println("key-" + key);
//                        break;
//                    }
//                }
//
//            }
//        });

        LocalDateTime ti = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = formatter.format(ti);
        System.out.println(format);

    }
}

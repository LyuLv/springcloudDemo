package com.lyu.excute.easy.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lyu.excute.easy.entity.User;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DaoUtil {
    private static String defaultResourceLocation = "src/main/resources/mapper/";
    private static Map<String, ArrayList<Map<String, String>>> sqlMap = new HashMap<>();
    private static Pattern pattern = Pattern.compile("\\{([^}])*\\}");

    @PostConstruct
    private static void loadAllSql () throws Exception {
        File file = new File(defaultResourceLocation);
        if (!file.exists()) {
            return;
        }
        for (File listFile : file.listFiles()) {
            SAXReader reader = new SAXReader();
            Document doc = reader.read(listFile);
            Element root = doc.getRootElement();
            String namespace = root.attribute("namespace").getData().toString();
            sqlMap.put(namespace,new ArrayList<>());
            List<Element> elementList = root.elements();
            for (Element element : elementList) {
                List<Attribute> attributeList = element.attributes();
                for (Attribute attribute : attributeList) {
                    String sql = attribute.getParent().getText().trim();
                    List<Map<String, String>> mapList = sqlMap.get(namespace);
                    Map<String, String> map = new HashMap<>();
                    map.put(attribute.getValue(),sql);
                    mapList.add(map);
                }
            }
        }
    }

    private static String getSql(String namespace, String sqlName){
        if (sqlMap.isEmpty()) {
            try {
                loadAllSql();
            }catch (Exception e){

            }
        }
        ArrayList<Map<String, String>> namespaceList = sqlMap.get(namespace);
        for (Map<String, String> map : namespaceList) {
            return map.get(sqlName);
        }
        return null;
    }

    private static String parseSql(String sql,Map<String, Object> paramsMap){
        Matcher matcher = pattern.matcher(sql);
        List<String> matchList = new ArrayList<>();
        while (matcher.find()) {
            matchList.add(matcher.group());
        }
        for (String s : matchList) {
            for (String key : paramsMap.keySet()) {
                if (s.replaceAll("\\{|}", "").equals(key)) {
                    Object obj = paramsMap.get(key);
                    if (obj instanceof Integer) {
                        String string = obj.toString();
                        sql = sql.replace(s,string);
                    }
                    if (obj instanceof String) {
                        String string = obj.toString();
                        string = "'" + string + "'";
                        sql = sql.replace(s,string);
                    }
                    if (obj instanceof List) {
                        List list = (List)obj;
                        String join = String.join(",", list);
                        sql = sql.replace(s,join);
                    }
                }
            }
        }
        sql = sql.replace("#","");
        return sql;
    }

    private static String sql(String namespace, String sqlName, Map<String, Object> paramsMap){
        String oldSql = getSql(namespace, sqlName);
        if (!oldSql.contains("#{")) {
            return oldSql;
        }
        String sql = parseSql(oldSql, paramsMap);
        System.out.println(sql);
        return sql;
    }

    private static <T> List<T> execute(String namespace, String sqlName, Map<String, Object> paramsMap){
        String sql = parseSql(getSql(namespace, sqlName), paramsMap);
        List<User> list = db().query(sql, new BeanPropertyRowMapper<>(User.class));
        //System.out.println(list);
        return (List<T>) list;
    }

    public static <T> List<T> execute(String namespace, String sqlName, Object params){
        String sql = parseSql(getSql(namespace, sqlName), JSONObject.parseObject(JSON.toJSONString(params)));
        List<User> list = db().query(sql, new BeanPropertyRowMapper<>(User.class));
        //System.out.println(list);
        return (List<T>) list;
    }

    private static JdbcTemplate db(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://1272000000/r_media_sit?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai");
        dataSource.setUsername("*******");
        dataSource.setPassword("********");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

    public static void main(String[] args) throws Exception {
        //Map<String,Object> paramsMap = new HashMap<>();
        //paramsMap.put("userId","sdaj");
        //paramsMap.put("age",89);
        //paramsMap.put("idList", Arrays.asList("1","2"));
        //paramsMap.put("nameList", Arrays.asList("'rose'","'jack'"));
        //List<User> userList = DaoUtil.execute("userMapper","getUserByParams",paramsMap);
        //System.out.println(userList);

        User userReq = new User();
        List<User> usersList = DaoUtil.execute("userMapper","getUserByParams", userReq);
        System.out.println(usersList);
    }
}

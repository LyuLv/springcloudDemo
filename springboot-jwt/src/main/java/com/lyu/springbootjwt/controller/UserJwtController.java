package com.lyu.springbootjwt.controller;

import com.alibaba.fastjson.JSONObject;
import com.lyu.springbootjwt.anno.JwtToken;
import com.lyu.springbootjwt.util.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: Lyu
 * @Description:
 * @Date: Created in 18:30 2020/11/5
 * @Modified By:
 */
@RestController
@RequestMapping(name = "springboot整合jwt的token", value = "/jwt")
@Api(tags = "springboot整合jwt的token")
public class UserJwtController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserJwtController.class);

    @PostMapping(name = "登录", value = {"/login"})
    @ApiOperation("登录")
    public Object login(@RequestBody LoginVo loginVo) {
        JSONObject jsonObject = new JSONObject();
        // 检验用户是否存在(为了简单，这里假设用户存在，并制造一个uuid假设为用户id)
        String userId = UUID.randomUUID().toString();
        // 生成签名
        String token = JwtUtils.sign(userId);
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("userId", userId);
        userInfo.put("userName", loginVo.getUserName());
        userInfo.put("passWord", loginVo.getPassWord());
        jsonObject.put("token", token);
        jsonObject.put("user", userInfo);
        LOGGER.info("登录信息：" + jsonObject.toJSONString());
        return jsonObject;
    }

    /**
     * 该接口需要带签名才能访问
     * @return
     */
    @JwtToken
    @GetMapping("/getMessage")
    @ApiOperation("测试token")
    public String getMessage(){
        return "你已通过验证";
    }


}

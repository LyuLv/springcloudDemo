package com.lyu.springbootjwt.interceptor;


import com.lyu.springbootjwt.anno.JwtToken;
import com.lyu.springbootjwt.util.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Author: Lyu
 * @Description: jwt自定义拦截器，拦截带有jwt注解的接口；
 * 自定义拦截器的步骤：创建注册类------实现WebMvcConfig接口----------重写addInterceptors方法
 * @Date: Created in 18:06 2020/11/5
 * @Modified By:
 */
public class JwtInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) {
        //从http请求头中获取token
        String token = httpServletRequest.getHeader("token");
        //注解不是添加在方法上直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }

        //获取方法
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查方法是否添加注解
        if (method.isAnnotationPresent(JwtToken.class)) {
            JwtToken jwtToken = method.getAnnotation(JwtToken.class);
            if (jwtToken.required()) {
                //认证
                if (token == null) {
                    throw new RuntimeException("无token或者token已过期，请重新登录！");
                }
                //获取token中的userId
                String userId = JwtUtils.getUserId(token);
                LOGGER.info("userd-->" + userId);
                LOGGER.info("jwt校验通过");
                //验证
                JwtUtils.checkSign(token);
            }
        }
        LOGGER.info("jwt拦截放行");
        return true;
    }

}

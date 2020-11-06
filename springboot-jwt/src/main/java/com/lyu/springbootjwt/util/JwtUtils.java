package com.lyu.springbootjwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @Author: Lyu
 * @Description: JWT认证工具类
 * @Date: Created in 17:33 2020/11/5
 * @Modified By:
 */
public class JwtUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtils.class);
    /**
     * token过期时间
     */
    private static final long EXPIRE_TIME = 5 * 60 * 1000;
    /**
     * jwt 密钥
     */
    private static final String SECRET = "jwt_secret";

    /**
     * 生成token，5分钟过期
     * @return
     */
    public static String sign(String userId) {
        try {
            //构建失效时钟
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            //对密钥进行加密
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            //创建令牌
            return JWT.create()
                    //保存userId
                    .withAudience(userId)
                    //保存过期时间
                    .withExpiresAt(date)
                    //令牌
                    .sign(algorithm);
        } catch (IllegalArgumentException e) {
            LOGGER.error("生成token失败：");
            e.printStackTrace();
        } catch (JWTCreationException e) {
            LOGGER.error("生成token失败：");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取userId
     * @param token
     * @return
     */
    public static String getUserId(String token) {
        try {
            String userId = JWT.decode(token).getAudience().get(0);
            return userId;
        } catch (JWTDecodeException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public static boolean checkSign(String token) {
        try {
            //生成校验器
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            //校验
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (JWTVerificationException e) {
            e.printStackTrace();
        }
        return false;
    }



}

package com.lyu.springbootjwt.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: Lyu
 * @Description:
 * @Date: Created in 10:18 2020/11/6
 * @Modified By:
 */
@ApiModel(description = "登录传参model")
public class LoginVo {
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", name = "userName", dataType = "String", example = "admin")
    private String userName;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", name = "passWord", dataType = "String", example = "123456")
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}

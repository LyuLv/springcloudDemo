package com.lyu.mms.service.impl;

import com.lyu.mms.annotation.DataSourceSwitcher;
import com.lyu.mms.domain.User;
import com.lyu.mms.mapper.UserMapper;
import com.lyu.mms.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Lyu
 * @Description:
 * @Date: Created in 18:24 2020/12/29
 * @Modified By:
 */
@Service
public class UserServiceImpl implements UserService {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    private UserMapper userMapper;

    /**
     * 保存
     * @param user
     */
    @DataSourceSwitcher
    //master数据源为默认值，不需要指明
    //@DataSourceSwitcher(DBTypeEnum.SLAVE)
    @Override
    public void save(User user) {
        userMapper.insert(user);
        LOGGER.info("新增成功，{}", user);
    }
}

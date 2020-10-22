package com.shaolin.springcloud.dal.biz.impl;

import com.shaolin.springcloud.dal.entity.User;
import com.shaolin.springcloud.dal.mapper.UserBizMapper;
import com.shaolin.springcloud.dal.biz.UserServiceBiz;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author leisl
 * @since 2020-10-22
 */
@Service
public class UserServiceBizImpl extends ServiceImpl<UserBizMapper, User> implements UserServiceBiz {

}

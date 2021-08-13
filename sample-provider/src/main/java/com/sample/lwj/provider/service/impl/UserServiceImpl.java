package com.sample.lwj.provider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sample.lwj.entity.User;
import com.sample.lwj.mapper.UserMapper;
import com.sample.lwj.provider.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements IUserService {

    @Override
    public List<User> select(User user) {
        return baseMapper.select(user);
    }

    @Override
    public List<User> selectByDateRange(Date start, Date end) {
        return baseMapper.selectByDateRange(start, end);
    }

    @Override
    public List<User> selectByDate(Date date) {
        return baseMapper.selectByDate(date);
    }

    @Override
    public User selectByUsername(String username) {
        return baseMapper.selectOne(new QueryWrapper<User>().eq("username", username));
    }
}





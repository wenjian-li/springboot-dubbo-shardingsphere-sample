package com.sample.lwj.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sample.lwj.entity.User;

import java.util.Date;
import java.util.List;

public interface IUserService extends IService<User> {

	List<User> select(User user);

	List<User> selectByDateRange(Date start, Date end);

    List<User> selectByDate(Date date);

    User selectByUsername(String username);
}
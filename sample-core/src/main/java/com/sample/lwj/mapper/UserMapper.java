package com.sample.lwj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sample.lwj.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserMapper extends BaseMapper<User> {

	List<User> select(User user);

	List<User> selectByDateRange(@Param("start") Date start, @Param("end") Date end);

	List<User> selectByDate(@Param("date") Date date);
}
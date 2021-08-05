package com.sample.lwj.web.service;


import com.sample.lwj.remote.vo.UserVO;

import java.util.Date;
import java.util.List;

public interface IUserService {

    UserVO selectByPrimaryKey(Long id);

    Boolean insertSelective(UserVO userVO);

    List<UserVO> selectByDateRange(Date start, Date end);

    List<UserVO> selectByDate(Date date);

}
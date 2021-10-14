package com.sample.lwj.web.service;


import com.sample.lwj.remote.dto.CommonParamDTO;
import com.sample.lwj.remote.vo.UserVO;
import com.sample.lwj.utils.PageUtils;

import java.util.Date;
import java.util.List;

public interface IUserService {

    UserVO selectByPrimaryKey(Long id);

    Boolean insertSelective(UserVO userVO);

    List<UserVO> selectByDateRange(Date start, Date end);

    List<UserVO> selectByDate(Date date);

    String login(String username, String password);

    void logout(String currentToken);

    PageUtils<UserVO> selectByPage(PageUtils<CommonParamDTO> pageUtils);

}
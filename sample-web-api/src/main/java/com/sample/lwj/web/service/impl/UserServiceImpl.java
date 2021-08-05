package com.sample.lwj.web.service.impl;

import com.sample.lwj.remote.dto.UserDTO;
import com.sample.lwj.remote.vo.UserVO;
import com.sample.lwj.web.service.IUserService;
import com.sample.lwj.remote.service.IUserServiceRemote;
import com.sample.lwj.web.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserServiceRemote userServiceRemote;

    @Override
    public UserVO selectByPrimaryKey(Long id) {
        return BeanUtils.toBean(userServiceRemote.selectByPrimaryKey(id), UserVO.class);
    }

    @Override
    public Boolean insertSelective(UserVO userVO) {
        return userServiceRemote.insertSelective(BeanUtils.toBean(userVO, UserDTO.class));
    }

    @Override
    public List<UserVO> selectByDateRange(Date start, Date end) {
        return BeanUtils.toList(userServiceRemote.selectByDateRange(start, end), UserVO.class);
    }

    @Override
    public List<UserVO> selectByDate(Date date) {
        return BeanUtils.toList(userServiceRemote.selectByDate(date), UserVO.class);
    }
}

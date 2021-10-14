package com.sample.lwj.web.service.impl;

import com.sample.lwj.exception.BizException;
import com.sample.lwj.remote.dto.CommonParamDTO;
import com.sample.lwj.remote.dto.UserDTO;
import com.sample.lwj.remote.service.IMenuServiceRemote;
import com.sample.lwj.remote.vo.UserVO;
import com.sample.lwj.utils.BeanUtils;
import com.sample.lwj.utils.PageUtils;
import com.sample.lwj.web.service.ITokenService;
import com.sample.lwj.web.service.IUserService;
import com.sample.lwj.remote.service.IUserServiceRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserServiceRemote userServiceRemote;

    @Autowired
    private IMenuServiceRemote menuServiceRemote;

    @Autowired
    private ITokenService tokenService;

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
    @Override
    public String login(String username, String password) {
        UserDTO userDTO = userServiceRemote.selectByUsername(username);
        if (userDTO == null) {
            throw new BizException("账号或密码错误");
        }
        boolean validate = DigestUtils.md5DigestAsHex(password.trim().getBytes(StandardCharsets.UTF_8)).equals(userDTO.getPassword());
        if (!validate) {
            throw new BizException("账号或密码错误");
        }
        List<String> permissions = menuServiceRemote.selectPermissionsByRoleId(userDTO.getRoleId());
        userDTO.setPermissions(permissions);
        return tokenService.createToken(userDTO);
    }

    @Override
    public void logout(String token) {
        tokenService.invalidateToken(token);
    }

    @Override
    public PageUtils<UserVO> selectByPage(PageUtils<CommonParamDTO> pageUtils) {
        PageUtils<UserDTO> page = userServiceRemote.selectByPage(pageUtils);
        return new PageUtils<>(page, BeanUtils.toList(page.getRecords(), UserVO.class));
    }
}

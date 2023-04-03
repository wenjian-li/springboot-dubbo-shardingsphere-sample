package com.sample.lwj.provider.remote;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sample.lwj.entity.User;
import com.sample.lwj.provider.service.IUserService;
import com.sample.lwj.remote.dto.CommonParamDTO;
import com.sample.lwj.remote.dto.UserDTO;
import com.sample.lwj.remote.service.IUserServiceRemote;
import com.sample.lwj.utils.BeanUtils;
import com.sample.lwj.utils.PageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value = "userServiceRemote")
public class UserServiceRemoteImpl implements IUserServiceRemote {

    private static Logger logger = LoggerFactory.getLogger(UserServiceRemoteImpl.class);

    @Autowired
    private IUserService userService;

    @Override
    public UserDTO selectByUsername(String username) {
        return BeanUtils.toBean(userService.selectByUsername(username), UserDTO.class);
    }

    @Override
    public Boolean insertSelective(UserDTO userDTO) {
        return userService.save(BeanUtils.toBean(userDTO, User.class));
    }

    @Override
    public UserDTO selectByPrimaryKey(Long id) {
        return BeanUtils.toBean(userService.getById(id), UserDTO.class);
    }

    @Override
    public Boolean updateByPrimaryKeySelective(UserDTO userDTO) {
        return userService.updateById(BeanUtils.toBean(userDTO, User.class));
    }

    @Override
    public List<UserDTO> select(UserDTO userDTO) {
        return BeanUtils.toList(userService.select(BeanUtils.toBean(userDTO, User.class)), UserDTO.class);
    }

    @Override
    public List<UserDTO> selectByDateRange(Date start, Date end) {
        List<User> list = userService.selectByDateRange(start, end);
        logger.info("用户数据：{}", JSONObject.toJSONString(list));
        return BeanUtils.toList(list, UserDTO.class);
    }

    @Override
    public List<UserDTO> selectByDate(Date date) {
        return BeanUtils.toList(userService.selectByDate(date), UserDTO.class);
    }

    @Override
    public PageUtils<UserDTO> selectByPage(PageUtils<CommonParamDTO> pageUtils) {
        Page<User> page = userService.page(
                new Page(pageUtils.getCurrentPage(), pageUtils.getPageSize()),
                new QueryWrapper()
                        .ge(pageUtils.getParams().getSearchStartTime() != null, "CREATE_TIME", pageUtils.getParams().getSearchStartTime())
                        .le(pageUtils.getParams().getSearchEndTime() != null, "CREATE_TIME", pageUtils.getParams().getSearchEndTime()));
        return new PageUtils<>(BeanUtils.toList(page.getRecords(), UserDTO.class), page.getCurrent(), page.getSize(), page.getTotal(), page.getPages());
    }

    @Override
    public UserDTO selectByUserAccount(String username) {
        return BeanUtils.toBean(userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username), false), UserDTO.class);
    }
}

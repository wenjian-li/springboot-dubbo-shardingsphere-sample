package com.sample.lwj.web.service;


import com.sample.lwj.remote.dto.UserDTO;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 登录token接口
 * @date 2021/8/9 16:10
 */
public interface ITokenService {

    /**
     * 生成token
     *
     * @param userDTO 用户信息
     * @return token
     */
    public String createToken(UserDTO userDTO);

    /**
     * 将token置为失效
     *
     * @param token
     */
    public void invalidateToken(String token);

    /**
     * 根据token查询用户信息
     *
     * @param token
     * @return 用户信息
     */
    public UserDTO queryByToken(String token);
}

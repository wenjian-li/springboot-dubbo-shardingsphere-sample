package com.sample.lwj.web.service.impl;

import com.github.benmanes.caffeine.cache.Cache;
import com.sample.lwj.remote.dto.UserDTO;
import com.sample.lwj.web.service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: token实现类
 * @date 2021/8/9 16:25
 */
@Service("tokenService")
public class TokenServiceImpl implements ITokenService {

    @Autowired
    Cache<String, UserDTO> caffeineCache;

    @Override
    public String createToken(UserDTO userDTO) {
        String s = UUID.randomUUID().toString() + userDTO.getPassword();
        String token = DigestUtils.md5DigestAsHex(s.getBytes(StandardCharsets.UTF_8));
        caffeineCache.put(token, userDTO);
        return token;
    }

    @Override
    public void invalidateToken(String token) {
        caffeineCache.invalidate(token);
    }

    @Override
    public UserDTO queryByToken(String token) {
        return caffeineCache.getIfPresent(token);
    }
}

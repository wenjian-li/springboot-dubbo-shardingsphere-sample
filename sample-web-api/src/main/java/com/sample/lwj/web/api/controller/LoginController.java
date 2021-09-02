package com.sample.lwj.web.api.controller;

import com.sample.lwj.web.service.IUserService;
import com.sample.lwj.web.utils.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 登录模块
 * @date 2021/8/9 16:51
 */
@Api(tags = "登录模块")
@RequestMapping("/api")
@Controller
public class LoginController extends BaseController {


    @Autowired
    private IUserService userService;


    @GetMapping("/login")
    @ApiOperation("登录页")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    @ApiOperation("登录")
    @ResponseBody
    public ResultData login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {

        String token = userService.login(username, password);

        return ResultData.success(token);
    }

    @PostMapping("logout")
    @ApiOperation("登出")
    @ResponseBody
    public ResultData logout() {
        userService.logout(getCurrentToken());
        return ResultData.success();
    }
}

package com.sample.lwj.web.api.controller;

import com.sample.lwj.constant.Constants;
import com.sample.lwj.utils.ResultData;
import com.sample.lwj.web.utils.ServerInfoUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 服务器资源
 * @date 2021/12/24 14:29
 */
@Api(tags = "服务器资源信息")
@Controller
public class ServerInfoController {

    private final static Logger logger = LoggerFactory.getLogger(ServerInfoController.class);


    @ResponseBody
    @ApiOperation(value = "服务器资源信息")
    @GetMapping(value = "server/info", produces = Constants.PRODUCES_JSON_UTF8)
    public ResultData<ServerInfoUtils.ServerDTO> info() {
        return ResultData.success(ServerInfoUtils.getServerInfo());
    }

    @GetMapping("/server")
    public String index(ModelMap modelMap) {
        modelMap.put("server", ServerInfoUtils.getServerInfo());
        return "server";
    }
}

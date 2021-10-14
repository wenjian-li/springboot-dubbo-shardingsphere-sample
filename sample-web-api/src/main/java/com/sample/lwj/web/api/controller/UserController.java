package com.sample.lwj.web.api.controller;

import com.sample.lwj.remote.dto.CommonParamDTO;
import com.sample.lwj.remote.vo.UserVO;
import com.sample.lwj.utils.DateUtils;
import com.sample.lwj.utils.PageUtils;
import com.sample.lwj.utils.ResultData;
import com.sample.lwj.web.aop.Logical;
import com.sample.lwj.web.aop.RequiresPermissions;
import com.sample.lwj.web.constant.Constant;
import com.sample.lwj.web.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Api(tags = "用户模块")
@RestController
@RequestMapping(value = "/api/user")
public class UserController extends BaseController{

    @Autowired
    private IUserService userService;

    @RequiresPermissions("user:info")
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ResponseBody
    public UserVO getUserInfo(@RequestParam(name = "id") Long id) {
        return userService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public void add(@RequestParam(name = "username") String username) {
        UserVO user = new UserVO();
        user.setUsername(username);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userService.insertSelective(user);
    }

    /**
     * @param pageNum  当前分页页码
     * @param pageSize 每页显示数据条数
     * @return
     */
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<UserVO> getUsers(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                 @RequestParam(name = "pageSize", defaultValue = "1") Integer pageSize) {
        UserVO user = new UserVO();
        user.setCreateTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        return Arrays.asList();
    }

    /**
     * @param date 开始时间
     * @return
     */
    @RequestMapping(value = "/selectByDate", method = RequestMethod.GET)
    @ResponseBody
    public List<UserVO> selectByDate(@RequestParam(name = "date") String date) throws ParseException {

        return userService.selectByDate(DateUtils.stringToDate(date, DateUtils.YYYYMMDD));
    }

    /**
     * @param start 开始时间
     * @param end   结束时间
     * @return
     */
    @RequiresPermissions(value = {"user:list", "user:info"}, logical = Logical.OR)
    @ApiOperation(value = "根据时间范围查询用户列表")
    @RequestMapping(value = "/selectByDateRange", method = RequestMethod.GET)
    @ResponseBody
    public ResultData<List<UserVO>> selectByDateRange(@RequestParam(name = "start") String start,
                                                      @RequestParam(name = "end") String end) throws ParseException {

        return ResultData.success(userService.selectByDateRange(DateUtils.stringToDate(start, DateUtils.YYYYMMDD), DateUtils.stringToDate(end, DateUtils.YYYYMMDD)));
    }

    /**
     * 分页查询
     *
     * @return 操作日志分页
     */
    @ApiOperation(value = "分页查询")
    @PostMapping(value = "/selectByPage", produces = Constant.PRODUCES_JSON_UTF8)
    @ResponseBody
    public ResultData<PageUtils<UserVO>> selectByPage(@Valid @RequestBody PageUtils<CommonParamDTO> pageUtils) {
        return ResultData.success(userService.selectByPage(pageUtils));
    }


}

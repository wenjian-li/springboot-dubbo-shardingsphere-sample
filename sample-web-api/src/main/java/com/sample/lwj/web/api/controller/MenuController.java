package com.sample.lwj.web.api.controller;

import com.sample.lwj.constant.Constants;
import com.sample.lwj.remote.dto.MenuDTO;
import com.sample.lwj.remote.dto.MenuTreeDTO;
import com.sample.lwj.remote.enums.MenuTypeEnum;
import com.sample.lwj.utils.ResultData;
import com.sample.lwj.web.aop.RequiresPermissions;
import com.sample.lwj.web.service.IMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 菜单管理
 * @date 2021/12/24 15:25
 */
@Api(tags = "菜单管理")
@Controller
@RequestMapping(value = "/menu")
public class MenuController extends BaseController {

    @Autowired
    private IMenuService menuService;

    /**
     * 列表
     *
     * @return
     */
//    @RequiresPermissions("sys:menu:view")
    @GetMapping(value = "/list")
    public String list() {
        return "menu/list";
    }

    /**
     * 新增
     *
     * @param modelMap
     * @return
     */
//    @RequiresPermissions("sys:menu:add")
    @GetMapping(value = "/add")
    public String add(ModelMap modelMap) {
        modelMap.put("typeList", MenuTypeEnum.values());
        return "menu/add";
    }

    /**
     * 编辑
     *
     * @param modelMap
     * @param menuId
     * @return
     */
//    @RequiresPermissions("sys:menu:edit")
    @GetMapping(value = "/edit/{menuId}")
    public String edit(ModelMap modelMap, @PathVariable("menuId") Integer menuId) {
        modelMap.put("menu", menuService.selectById(menuId));
        modelMap.put("typeList", MenuTypeEnum.values());
        return "menu/edit";
    }

    /**
     * 保存
     *
     * @param menuDTO
     * @return
     */
//    @RequiresPermissions("sys:menu:add")
    @ApiOperation("保存")
    @PostMapping(value = "/save", produces = Constants.PRODUCES_JSON_UTF8)
    @ResponseBody
    public ResultData save(@RequestBody MenuDTO menuDTO) {
        return menuService.save(menuDTO);
    }

    /**
     * 更新
     *
     * @param menuDTO
     * @return
     */
//    @RequiresPermissions("sys:menu:edit")
    @ApiOperation("更新")
    @PostMapping(value = "/update", produces = Constants.PRODUCES_JSON_UTF8)
    @ResponseBody
    public ResultData update(@RequestBody MenuDTO menuDTO) {
        return menuService.updateById(menuDTO);
    }


    /**
     * 删除
     *
     * @param menuId
     * @return
     */
//    @RequiresPermissions("sys:menu:delete")
    @ApiOperation("删除")
    @PostMapping(value = "/delete", produces = Constants.PRODUCES_JSON_UTF8)
    @ResponseBody
    public ResultData delete(@RequestParam(name = "menuId") Integer menuId) {
        return menuService.deleteById(menuId);
    }

    /**
     * 主键ID查询
     *
     * @param menuId
     * @return
     */
    @ApiOperation("主键ID查询")
    @PostMapping(value = "/info", produces = Constants.PRODUCES_JSON_UTF8)
    @ResponseBody
    public ResultData<MenuDTO> info(@RequestParam(name = "menuId") Integer menuId) {
        return ResultData.success(menuService.selectById(menuId));
    }


//    /**
//     * 导航菜单
//     */
//    @ApiOperation(value = "导航菜单")
//    @PostMapping(value = "/navigation", produces = Constants.PRODUCES_JSON_UTF8)
//    @ResponseBody
//    public ResultData<List<MenuVO>> navigation() {
//        return ;
//    }

    /**
     * 菜单列表
     */
//    @RequiresPermissions("sys:menu:list")
    @ApiOperation(value = "菜单列表")
    @PostMapping(value = "/menuList", produces = Constants.PRODUCES_JSON_UTF8)
    @ResponseBody
    public ResultData<List<MenuDTO>> menuList() {
        return ResultData.success(menuService.selectByUserId(getCurrentUserId()));
    }


    /**
     * 角色树形菜单
     */
    @ApiOperation(value = "角色树形菜单")
    @PostMapping(value = "/roleMenuTree", produces = Constants.PRODUCES_JSON_UTF8)
    @ResponseBody
    public ResultData<List<MenuTreeDTO>> roleMenuTree(@RequestParam(name = "roleId", required = false) Integer roleId) {
        return ResultData.success(menuService.roleMenuTree(getCurrentUserId(), roleId));
    }

    /**
     * 树形菜单
     */
    @ApiOperation(value = "树形菜单")
    @PostMapping(value = "/menuTree", produces = Constants.PRODUCES_JSON_UTF8)
    @ResponseBody
    public ResultData<List<MenuTreeDTO>> menuTree() {
        return ResultData.success(menuService.menuTree(getCurrentUserId(), false));
    }

}

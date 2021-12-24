package com.sample.lwj.remote.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 树形菜单结构实体
 * @date 2021/12/24 13:58
 */
@Data
public class MenuTreeDTO implements Serializable {
    private static final long serialVersionUID = -3112132178588484403L;

    /**
     * 节点唯一索引值，用于对指定节点进行各类操作
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer id;

    /**
     * 节点字段名
     */
    private String field;

    /**
     * 节点标题
     */
    private String title;

    /**
     * 节点是否初始展开，默认 false
     */
    private Boolean spread = true;

    /**
     * 节点是否初始为选中状态（如果开启复选框的话），默认 false
     */
    private Boolean checked = false;

    /**
     * 节点是否为禁用状态。默认 false
     */
    private Boolean disabled = false;

    /**
     * 子节点。支持设定选项同父节点
     */
    private List<MenuTreeDTO> children;
}

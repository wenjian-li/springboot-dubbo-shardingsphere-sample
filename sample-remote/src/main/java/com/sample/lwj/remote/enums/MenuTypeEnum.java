package com.sample.lwj.remote.enums;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 菜单类型
 * @date 2021/12/24 14:06
 */
public enum MenuTypeEnum {
    /**
     * 目录
     */
    CATALOG(0, "目录"),
    /**
     * 菜单
     */
    MENU(1, "菜单"),
    /**
     * 按钮
     */
    BUTTON(2, "按钮");

    private Integer code;
    private String text;

    MenuTypeEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    public Integer getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

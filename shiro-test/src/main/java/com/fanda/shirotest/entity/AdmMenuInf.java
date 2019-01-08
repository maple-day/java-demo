package com.fanda.shirotest.entity;

import java.util.List;

public class AdmMenuInf {

    /**
     * ID prop , 主键ID,自增.
     */
    private Long amnId;


    /**
     * 父菜单ID,0为顶级菜单
     */
    private Long parentId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单类型,U为地址菜单,F为功能菜单
     */
    private String menuType;

    /**
     * 是否打开新窗口，1打开
     */
    private Integer isOpenWindow;

    /**
     * 菜单地址
     */
    private String menuUrl;

    /**
     * 菜单图标
     */
    private String iconInf;

    /**
     * 子菜单信息
     */
    List<AdmMenuInf> subMenus;


    public Long getAmnId() {
        return amnId;
    }


    public void setAmnId(Long amnId) {
        this.amnId = amnId;
    }


    public Long getParentId() {
        return parentId;
    }


    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }


    public String getMenuName() {
        return menuName;
    }


    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }


    public String getMenuType() {
        return menuType;
    }


    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }


    public String getMenuUrl() {
        return menuUrl;
    }


    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getIconInf() {
        return iconInf;
    }

    public void setIconInf(String iconInf) {
        this.iconInf = iconInf;
    }

    public List<AdmMenuInf> getSubMenus() {
        return subMenus;
    }


    public void setSubMenus(List<AdmMenuInf> subMenus) {
        this.subMenus = subMenus;
    }

    public Integer getIsOpenWindow() {
        return isOpenWindow;
    }

    public void setIsOpenWindow(Integer isOpenWindow) {
        this.isOpenWindow = isOpenWindow;
    }
}

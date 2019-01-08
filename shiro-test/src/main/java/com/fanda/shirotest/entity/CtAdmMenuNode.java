package com.fanda.shirotest.entity;


import java.util.Date;

/**
 * <p>
 * 系统管理-菜单树结点信息
 * </p>
 *
 * @author skh
 * @since 2019-01-08
 */
public class CtAdmMenuNode {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID,自增.
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
     * 创建时间
     */
    private Date amnCtime;
    /**
     * 修改时间
     */
    private Date amnMtime;


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

    public Integer getIsOpenWindow() {
        return isOpenWindow;
    }

    public void setIsOpenWindow(Integer isOpenWindow) {
        this.isOpenWindow = isOpenWindow;
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

    public Date getAmnCtime() {
        return amnCtime;
    }

    public void setAmnCtime(Date amnCtime) {
        this.amnCtime = amnCtime;
    }

    public Date getAmnMtime() {
        return amnMtime;
    }

    public void setAmnMtime(Date amnMtime) {
        this.amnMtime = amnMtime;
    }


    @Override
    public String toString() {
        return "CtAdmMenuNode{" +
                ", amnId=" + amnId +
                ", parentId=" + parentId +
                ", menuName=" + menuName +
                ", menuType=" + menuType +
                ", isOpenWindow=" + isOpenWindow +
                ", menuUrl=" + menuUrl +
                ", iconInf=" + iconInf +
                ", amnCtime=" + amnCtime +
                ", amnMtime=" + amnMtime +
                "}";
    }
}

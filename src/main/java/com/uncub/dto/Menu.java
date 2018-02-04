package com.uncub.dto;

public class Menu {
    private Integer id;

    /**
    * 菜单名
    */
    private Integer menuName;

    private String path;

    private String menuDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMenuName() {
        return menuName;
    }

    public void setMenuName(Integer menuName) {
        this.menuName = menuName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc == null ? null : menuDesc.trim();
    }
}
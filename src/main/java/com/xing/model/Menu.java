package com.xing.model;

import java.util.List;

/**
 * @author @kawhi-leonard@qq.com
 * @date 2018-10-22 20:33:02
 *
 * 菜单
 * https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141013
 */


public class Menu {

    private String id;

    private String parentId;

    private String name;

    private String type;

    private String key;

    private String media_id;

    private String url;

    // 小程序 id
    private String appid;

    // 小程序路径
    private String pagepath;

    // 二级菜单
    private List<Menu> sub_button;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }

    public List<Menu> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<Menu> sub_button) {
        this.sub_button = sub_button;
    }
}

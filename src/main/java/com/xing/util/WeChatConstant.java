package com.xing.util;

/**
 * @author @kawhi-leonard@qq.com
 * @date 2018-10-22 20:25:47
 */


public class WeChatConstant {
    //第三方用户唯一凭证
    public final static String APPID = "";

    //第三方用户唯一凭证密钥，即 APPSECRET
    public final static String APPSECRET = "";

    // app token
    public final static String TOKEN = "";

    // 平台名称
    public final static String PLATFORM_NAME = "";

    // 移动端前缀路径
    public final static String MOBILE_VIEW_PREFIX = "";

    // 小程序的 appid
    public final static String MINIPROGRAM_ID = "";

    // 小程序页面路径
    public final static String MINIPROGRAM_PAGEPATH = "";

    // 绑定指令
    public final static String SYMBOL_BIND = "@";

    // 解绑指令
    public final static String SYMBOL_UNBIND = "#";

    // 分隔符
    public final static String SYMBOL_SEPARATOR = "/";

    // 微信字符集
    public final static String WEIXIN_CHARSET = "ISO-8859-1";

    // 获取 access_token url
    public final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    // 创建菜单 url
    public final static String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    // 菜单查询
    public final static String GET_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

    // 删除菜单
    public final static String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

    // 创建个性化菜单 url
    public final static String ADDCONDITIONAL_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN";


    // 消息类型 以 MESSAGE_TYPE 开头
    // 文本
    public final static String MESSAGE_TYPE_TEXT = "text";

    // 图片
    public final static String MESSAGE_TYPE_IMAGE = "image";

    // 语音
    public final static String MESSAGE_TYPE_VOICE = "voice";

    // 视频
    public final static String MESSAGE_TYPE_VIDEO = "video";

    // 小视频
    public final static String MESSAGE_TYPE_SHORTVIDEO = "shortvideo";

    // 地理位置
    public final static String MESSAGE_TYPE_LOCATION = "location";

    // 链接
    public final static String MESSAGE_TYPE_LINK = "link";

    // 事件
    public final static String MESSAGE_TYPE_EVENT = "event";


    //  事件类型 以 EVENT_TYPE 开头
    // 订阅
    public final static String EVENT_TYPE_SUBSCRIBE = "subscribe";

    // 取消订阅
    public final static String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

    // 用户已扫描
    public final static String EVENT_TYPE_SCAN = "SCAN";

    // 上报地理位置
    public final static String EVENT_TYPE_LOCATION = "LOCATION";

    // 点击
    public final static String EVENT_TYPE_CLICK = "CLICK";

    // 跳转
    public final static String EVENT_TYPE_VIEW = "VIEW";


    // 菜单类型
    // 点击
    public final static String MENU_TYPE_CLICK = "click";

    // 跳转 url
    public final static String MENU_TYPE_VIEW = "view";

    // 小程序类型
    public final static String MENU_TYPE_MINIPROGRAM = "miniprogram";

    // 扫码推事件用户点击按钮后，微信客户端将调起扫一扫工具
    public final static String MENU_TYPE_SCANCODE_PUSH = "scancode_push";

    // 扫码推事件且弹出“消息接收中”提示框用户点击按钮后
    public final static String MENU_TYPE_SCANCODE_WAITMSG = "scancode_waitmsg";

    // 弹出系统拍照发图用户点击按钮后
    public final static String MENU_TYPE_PIC_SYSPHOTO = "pic_sysphoto";

    // 弹出拍照或者相册发图用户点击按钮后，微信客户端将弹出选择器供用户选择“拍照”或者“从手机相册选择”
    public final static String MENU_TYPE_PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";

    // 弹出微信相册发图器用户点击按钮后
    public final static String MENU_TYPE_PIC_WEIXIN = "pic_weixin";

    // 弹出地理位置选择器用户点击按钮后
    public final static String MENU_TYPE_LOCATION_SELECT = "location_select";

    // 下发消息（除文本消息）用户点击media_id类型按钮后
    public final static String MENU_TYPE_MEDIA_ID = "media_id";

    // 跳转图文消息URL用户点击view_limited类型按钮后
    public final static String MENU_TYPE_VIEW_LIMITED = "view_limited";


}

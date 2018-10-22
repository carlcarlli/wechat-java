package com.xing.service;

import com.xing.util.MessageUtil;
import com.xing.util.WeChatConstant;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author @kawhi-leonard@qq.com
 * @date 2018-10-22 19:16:21
 */


@Service
public class MessageService {

    // 按消息类型处理请求
    public String handleMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String> map = MessageUtil.parseXml(request);

        String msgType = map.get("MsgType");
        String result = "";

        if (WeChatConstant.MESSAGE_TYPE_TEXT.equals(msgType)) {
            // 文本类型
            result = handleText(map, request, response);
        } else if (WeChatConstant.MESSAGE_TYPE_EVENT.equals(msgType)) {
            // 事件类型
            result = handleEvent(map, request, response);
        } else if (WeChatConstant.MESSAGE_TYPE_IMAGE.equals(msgType)) {
            // 图片类型
            result = "您好，本公众号暂不支持图片消息,请用文字描述你所要咨询的问题！";
        } else if (WeChatConstant.MESSAGE_TYPE_VIDEO.equals(msgType)) {
            // 视频类型
            result = "您好，本公众号暂不支持视频消息,请用文字描述你所要咨询的问题！";
        } else if (WeChatConstant.MESSAGE_TYPE_VOICE.equals(msgType)) {
            // 语音类型
            result = "您好，本公众号暂不支持语音消息,请用文字描述你所要咨询的问题！";
        } else if (WeChatConstant.MESSAGE_TYPE_SHORTVIDEO.equals(msgType)) {
            // 短视频类型
            result = "您好，本公众号暂不支持短视频消息,请用文字描述你所要咨询的问题！";
        } else if (WeChatConstant.MESSAGE_TYPE_LOCATION.equals(msgType)) {
            // 地理位置类型
            result = "您好，本公众号暂不支持位置消息,请用文字描述你所要咨询的问题！";
        } else if (WeChatConstant.MESSAGE_TYPE_LINK.equals(msgType)) {
            // 链接类型
            result = "您好，本公众号暂不支持链接消息,请用文字描述你所要咨询的问题！";
        } else {
            result = handleText(map, request, response);
        }
        return result;
    }

    // 处理文本类型
    private String handleText(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
        String result = "请求成功";
        String requestContent = map.get("Content");

        if ((requestContent.indexOf(WeChatConstant.SYMBOL_BIND) == 0) && (requestContent.indexOf(WeChatConstant.SYMBOL_SEPARATOR) > -1)) {
            // 绑定账号
            result = bindAccount(map);
        } else if ((requestContent.indexOf(WeChatConstant.SYMBOL_UNBIND) == 0) && (requestContent.indexOf(WeChatConstant.SYMBOL_SEPARATOR) > -1)) {
            // 解绑账号
            result = unbindAccount(map);
        } else {
            result = requestContent;
        }

        return MessageUtil.buildTextMessage(map, result);
    }


    // 处理事件类型
    private String handleEvent(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
        String eventType = map.get("Event");
        String content = "";
        if (WeChatConstant.EVENT_TYPE_CLICK.equals(eventType)) {
            // 点击事件类型
            String eventKey = map.get("EventKey");
            content = "Hello WeChat";
            return MessageUtil.buildTextMessage(map, content);

        } else if (WeChatConstant.EVENT_TYPE_SUBSCRIBE.equals(eventType)) {
            // 订阅
            content = "欢迎关注，" + WeChatConstant.PLATFORM_NAME;
            return MessageUtil.buildTextMessage(map, content);
        } else if (WeChatConstant.EVENT_TYPE_UNSUBSCRIBE.equals(eventType)) {
            // 取消订阅
            content = "取消关注";
            return MessageUtil.buildTextMessage(map, content);
        }

        return MessageUtil.buildTextMessage(map, content);
    }


    // 解绑账号
    private String unbindAccount(Map<String, String> map) {
        String msg = "解绑成功";

        // 发送方帐号（open_id）
        String openId = map.get("FromUserName");

        // 请求内容
        String requestContent = map.get("Content").trim();

        int separatorIndex = requestContent.indexOf(WeChatConstant.SYMBOL_SEPARATOR);
        String userAccount = requestContent.substring(1, separatorIndex);
        String password = requestContent.substring(separatorIndex + 1);

        // 判断账号密码是否正确


        return msg;
    }

    // 绑定账号
    private String bindAccount(Map<String, String> map) {
        String msg = "绑定成功";

        // 发送方帐号（open_id）
        String openId = map.get("FromUserName");

        // 请求内容
        String requestContent = map.get("Content").trim();

        int separatorIndex = requestContent.indexOf(WeChatConstant.SYMBOL_SEPARATOR);
        String userAccount = requestContent.substring(1, separatorIndex);
        String password = requestContent.substring(separatorIndex + 1);

        // 判断账号密码是否正确

        return msg;
    }

    public String emoji(int hexEmoji) {
        return String.valueOf(Character.toChars(hexEmoji));
    }

    public void responseStr(HttpServletResponse response, String result) throws Exception {
        response.setCharacterEncoding("utf-8");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("pragma", "no-cache");
        response.setDateHeader("expires", 0L);

        response.getWriter().write(result);
        response.getWriter().flush();
        response.getWriter().close();

    }
}

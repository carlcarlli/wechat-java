package com.xing.util;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author @kawhi-leonard@qq.com
 * @date 2018-10-22 20:41:41
 * 消息工具
 */


public class MessageUtil {
    private static Logger logger = LoggerFactory.getLogger(MessageUtil.class);

    // 解析微信请求
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap();
        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);

        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();

        // 遍历所有子节点
        for (Element e : elementList) {
            map.put(e.getName(), e.getText());
        }
        // 释放资源
        inputStream.close();

        return map;
    }

    // 构造文本消息
    public static String buildTextMessage(Map<String, String> map, String content) {
        String fromUserName = map.get("FromUserName");
        String toUserName = map.get("ToUserName");

        String format = "<xml>" +
                "<ToUserName><![CDATA[%s]]></ToUserName>" +
                "<FromUserName><![CDATA[%s]]></FromUserName>" +
                "<CreateTime>%s</CreateTime>" +
                "<MsgType><![CDATA[text]]></MsgType>" +
                "<Content><![CDATA[%s]]></Content>" +
                "</xml>";

        return String.format(format, fromUserName, toUserName, getUtcTime(), content);
    }

    private static String getUtcTime() {
        Date date = new Date();
        DateFormat dateFormatter = new SimpleDateFormat("yyyyMMddHHmm");
        String curDate = dateFormatter.format(date);
        long dd = Long.valueOf(0);

        try {
            dd = dateFormatter.parse(curDate).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return String.valueOf(dd);
    }
}

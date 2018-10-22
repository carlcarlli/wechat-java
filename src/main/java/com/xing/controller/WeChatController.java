package com.xing.controller;

import com.xing.service.MessageService;
import com.xing.util.SignatureUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author @kawhi-leonard@qq.com
 * @date 2018-10-22 19:13:49
 * 微信公众号入口
 */

@Controller
@RequestMapping("/wechat")
public class WeChatController {

    private Logger logger = LoggerFactory.getLogger(WeChatController.class);

    @Autowired
    private MessageService messageService;

    // 验证消息的确来自微信服务器
    @GetMapping()
    public void valid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        if (SignatureUtil.checkSignature(signature, timestamp, nonce)) {
            // 验证通过
            logger.info("========== 微信公众号验证通过 ========== ");
            messageService.responseStr(response, echostr);
        } else {
            logger.error("========== 微信公众号验证失败 ========== ");
        }
    }


    // 处理请求
    @PostMapping()
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String result = messageService.handleMessage(request, response);

        messageService.responseStr(response, result);

    }
}

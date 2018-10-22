package com.xing.util;

import com.xing.model.AccessToken;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author @kawhi-leonard@qq.com
 * @date 2018-10-22 20:45:50
 */


public class TokenUtil {
    private static Logger logger = LoggerFactory.getLogger(TokenUtil.class);

    private static AccessToken accessToken = null;

    public static AccessToken getAccessToken() {

        if (accessToken != null) {
            long curTimestamp = System.currentTimeMillis();
            long timestamp = accessToken.getTimestamp();
            long diff = (curTimestamp - timestamp) / 1000 + 500;
            if (diff < accessToken.getExpiresIn()) {
                return accessToken;// * 未过期返回当前的accessToken
            }
        }
        String requestUrl = WeChatConstant.ACCESS_TOKEN_URL.replace("APPID", WeChatConstant.APPID).replace("APPSECRET", WeChatConstant.APPSECRET);
        JSONObject jsonObject = HttpUtil.sendRequest(requestUrl, "GET", null);
        // 如果请求成功
        if (null != jsonObject) {
            try {
                accessToken = new AccessToken();
                accessToken.setAccessToken(jsonObject.getString("access_token"));
                accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
                accessToken.setTimestamp(System.currentTimeMillis());
            } catch (JSONException e) {
                accessToken = null;
                // 获取token失败
                try {
                    logger.error("获取token失败 errcode:{} errmsg:{}" + jsonObject.getInt("errcode") + jsonObject.getString("errmsg"));
                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return accessToken;
    }
}

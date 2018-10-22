package com.xing.util;

import com.xing.model.Menu;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author @kawhi-leonard@qq.com
 * @date 2018-10-22 20:24:33
 */


public class MenuUtil {
    private static Logger logger = LoggerFactory.getLogger(MenuUtil.class);

    /**
     * 创建菜单
     *
     * @return 0表示成功，其他值表示失败
     */
    public static int createMenu() {
        int result = 0;
        String requestUrl = WeChatConstant.CREATE_MENU_URL.replace("ACCESS_TOKEN", TokenUtil.getAccessToken().getAccessToken());
        JSONObject treeJson = new JSONObject(buildMenuTree());
        String menuStr = treeJson.toString();
        logger.info(menuStr);
        JSONObject resultJson = HttpUtil.sendRequest(requestUrl, "POST", menuStr);

        if (null != resultJson) {
            try {
                if (0 != resultJson.getInt("errcode")) {
                    result = resultJson.getInt("errcode");
                    logger.error("创建菜单失败 errcode:{} errmsg:{}" + resultJson.getInt("errcode") + resultJson.getString("errmsg"));
                } else {
                    logger.info("菜单创建成功");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    // 构造菜单树结构
    private static Map buildMenuTree() {
        Map menuMap = new HashMap();

        List<Menu> menuList = new ArrayList();
        menuMap.put("button", menuList);

        return menuMap;
    }

    public static void main(String[] args) {
        createMenu();
    }
}

package com.xing.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author @kawhi-leonard@qq.com
 * @date 2018-10-22 20:45:01
 */


public class SignatureUtil {

    /**
     * 验证签名
     */
    public static boolean checkSignature(String reqSignature, String timestamp, String nonce) {
        boolean validate = false;

        String signature = getSignature(timestamp, nonce);

        if ((null != signature) && (!"".equals(signature)) && (signature.equals(reqSignature))) {
            validate = true;
        }

        return validate;
    }

    public static String getSignature(String timestamp, String nonce) {
        String sortString = sortString(WeChatConstant.TOKEN, timestamp, nonce);
        return encryptString(sortString, "SHA-1");
    }

    private static String encryptString(String sortString, String algorithm) {

        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            digest.update(sortString.getBytes());

            byte[] bytes = digest.digest();
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < bytes.length; i++) {
                String shaHex = Integer.toHexString(bytes[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }

                hexString.append(shaHex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }

    private static String sortString(String token, String timestamp, String nonce) {
        String[] strArr = {token, timestamp, nonce};
        Arrays.sort(strArr);

        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }

        return sb.toString();
    }
}

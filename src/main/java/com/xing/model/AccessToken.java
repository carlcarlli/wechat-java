package com.xing.model;

/**
 * @author @kawhi-leonard@qq.com
 * @date 2018-10-22 20:34:51
 */


public class AccessToken {
    // 获取到的凭证
    private String accessToken;

    // 凭证有效时间，单位：秒
    private Integer expiresIn;

    private Long timestamp = Long.valueOf(0);

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}

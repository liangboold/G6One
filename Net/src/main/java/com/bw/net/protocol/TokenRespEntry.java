package com.bw.net.protocol;

/**
 * @package:com.bw.net.protocol
 * @fileName:TokenRespEntry
 * @date on:2021/8/20 8:55
 * @another:HG
 * @email:1572651596@qq.com
 */
public class TokenRespEntry {
    private String access_token;
    private String token_type;
    private int expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}

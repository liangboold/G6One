package com.bw.net.api;

import com.bw.net.protocol.TokenRespEntry;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @package:com.bw.net.api
 * @fileName:TokenApi
 * @date on:2021/8/20 8:53
 * @another:HG
 * @email:1572651596@qq.com
 */
public interface TokenApi {
    @FormUrlEncoded
    @POST("token")
    Call<TokenRespEntry>getToken(@Field("grant_type")String grant_type,@Field("username")String username,@Field("password")String password);
}

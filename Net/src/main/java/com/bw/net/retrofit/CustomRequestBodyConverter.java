package com.bw.net.retrofit;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * @package:com.bw.net.retrofit
 * @fileName:CustomRequestBodyConverter
 * @date on:2021/8/20 9:06
 * @another:HG
 * @email:1572651596@qq.com
 */
public class CustomRequestBodyConverter<T>implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    @Override
    public RequestBody convert(T value) throws IOException {
        String jsonContent = new Gson().toJson(value);
        return RequestBody.create(MEDIA_TYPE,jsonContent);
    }
}

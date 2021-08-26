package com.bw.net;

import android.text.TextUtils;
import android.util.Log;

import com.bw.net.api.TokenApi;
import com.bw.net.common.Config;
import com.bw.net.protocol.TokenRespEntry;
import com.bw.net.retrofit.CustomGsonConverterFactory;
import com.bw.net.retrofit.LiveDataCallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @package:com.bw.net
 * @fileName:RetrofitFactory
 * @date on:2021/8/20 8:53
 * @another:HG
 * @email:1572651596@qq.com
 */
public class RetrofitFactory {
    private Retrofit retrofit;
    private volatile static RetrofitFactory retrofitFactory;

    public static RetrofitFactory getRetrofitFactory() {
        if(retrofitFactory==null){
            synchronized (RetrofitFactory.class){
                if(retrofitFactory==null){
                    retrofitFactory = new RetrofitFactory();
                }
            }
        }
        return retrofitFactory;
    }

    public RetrofitFactory(){
        retrofit = createRetrofit();
    }

    private String mToken = "";

    public Retrofit createRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASEURL)  //BuildConfig如果未生成，在设置->file types忽略文件删除build;
                .addConverterFactory(CustomGsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
                .client(createOkHttp())
                .build();
        return retrofit;
    }

    private OkHttpClient createOkHttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(Config.TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(Config.TIMEOUT,TimeUnit.SECONDS)
                .connectTimeout(Config.TIMEOUT,TimeUnit.SECONDS)
                .addInterceptor(createTokenInterCeptor())
                .addNetworkInterceptor(createNetInterceptor())
                .build();
        return okHttpClient;
    }

    private Interceptor createNetInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    private Interceptor createTokenInterCeptor() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                //获取本地ToKen
                String localToKen = mToken;//StorageManager.getInstance().get("token");
                if(!TextUtils.isEmpty(localToKen)){
                    return restRequest(request,localToKen,chain);
                }
                Response response = chain.proceed(request);
                //401
                if(checkHttpCode401(response)){
                    String token = requestToKen();
                    if(TextUtils.isEmpty(token)){
                        return response;
                    }
                    mToken = token;
                    return restRequest(request,token,chain);
                }
                return response;
            }
        };
        return interceptor;
    }


    private String requestToKen() {
        TokenApi tokenApi = create(TokenApi.class);
        Call<TokenRespEntry>tokenService = tokenApi.getToken("password",Config.AUTH_CODE,"");
        try {
            retrofit2.Response<TokenRespEntry>result = tokenService.execute();
            if(result!=null&&result.body()!=null){
                return result.body().getAccess_token();
            }
        } catch (IOException e) {
            Log.e("123", "requestToKen: "+e.getMessage() );
        }
        return "";
    }

    public <T> T create(Class<?> service) {
        return (T)retrofit.create(service);
    }

    private boolean checkHttpCode401(Response response) {
        if(null==response){
            return false;
        }
        if(response.code()==401){
            return true;
        }else{
            return false;
        }
    }

    private Response restRequest(Request request, String localToKen, Interceptor.Chain chain) {
        Request.Builder newBuilder = request.newBuilder().addHeader("Authorization", "bearer " + localToKen);
        Request newRequest = newBuilder.build();
        try {
            return chain.proceed(newRequest);
        } catch (IOException e) {
            Log.e("123", "restRequest: "+e.getMessage() );
        }
        return null;
    }
}

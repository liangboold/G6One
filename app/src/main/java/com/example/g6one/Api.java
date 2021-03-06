package com.example.g6one;



import androidx.lifecycle.LiveData;

import com.bw.net.protocol.BaseRespEntry;
import com.example.g6one.bean.MessageEntity;
import com.example.g6one.bean.NewsDetailEntity;
import com.example.g6one.bean.NewsEntity;
import com.example.g6one.bean.TypeBean;
import com.example.g6one.bean.WeitouEntity;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*
 * @ClassName Api
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/8/21 11:03
 * @Version 1.0
 */
public interface Api {
    @GET("api/NewsType/getAllTypes")
    LiveData<BaseRespEntry<ArrayList<TypeBean>>> getType();

    @GET("api/News/getNews")
    LiveData<BaseRespEntry<ArrayList<NewsEntity>>> getNews(@Query("newstype")int newstype,@Query("pagenum")int pagenum,@Query("pagesize")int pagesize);

    @GET("api/NewsDetail/getNewsDetail")
    LiveData<BaseRespEntry<NewsDetailEntity>> getNewsDetail(@Query("newscode")String newscode);
    @GET("api/HeadLine/getAttentHeadline")
    LiveData<BaseRespEntry<ArrayList<WeitouEntity>>> getAttentHeadline(@Query("userid")int userid);

    @GET("api/Comment/getComment?")
    LiveData<BaseRespEntry<ArrayList<MessageEntity>>> getCommtexs(@Query("newscode") String newscode, @Query("parentid") int parentid, @Query("userid") int userid);

}

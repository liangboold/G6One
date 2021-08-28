package com.example.g6one.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.blankj.utilcode.util.ThreadUtils;
import com.bw.net.RetrofitFactory;
import com.bw.net.protocol.BaseRespEntry;
import com.example.g6one.Api;
import com.example.g6one.bean.NewsEntity;
import com.example.mvvm_lib.model.IModel;

import java.util.ArrayList;

/**
 * @package:com.example.g6one.model
 * @fileName:NewsModel
 * @date on:2021/8/24 8:39
 * @another:HG
 * @email:1572651596@qq.com
 */
public class NewsModel implements IModel {
    MutableLiveData<NewsEntity> mutableLiveData = new MutableLiveData<>();

    public LiveData<BaseRespEntry<ArrayList<NewsEntity>>> news(int newstype){
        LiveData<BaseRespEntry<ArrayList<NewsEntity>>> news = RetrofitFactory.getRetrofitFactory().createRetrofit().create(Api.class).getNews(newstype, 12, 10);
        return news;
    }


}

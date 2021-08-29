package com.example.g6one.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bw.net.RetrofitFactory;
import com.bw.net.protocol.BaseRespEntry;
import com.example.g6one.Api;
import com.example.g6one.bean.NewsDetailEntity;
import com.example.mvvm_lib.model.IModel;

import java.util.ArrayList;

/**
 * @package:com.example.g6one.model
 * @fileName:NewsDetailsModel
 * @date on:2021/8/28 8:11
 * @another:HG
 * @email:1572651596@qq.com
 */
public class NewsDetailsModel implements IModel {
    MutableLiveData<NewsDetailEntity>mutableLiveData = new MutableLiveData<>();

    public LiveData<BaseRespEntry<NewsDetailEntity>>newsDetails(String newscode){
        LiveData<BaseRespEntry<NewsDetailEntity>> newsDetail = RetrofitFactory.getInstance().createRetrofit().create(Api.class).getNewsDetail(newscode);
        return newsDetail;
    }
}

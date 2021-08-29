package com.example.g6one.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bw.net.RetrofitFactory;
import com.bw.net.protocol.BaseRespEntry;
import com.example.g6one.Api;
import com.example.g6one.bean.WeitouEntity;
import com.example.mvvm_lib.model.IModel;

import java.util.ArrayList;

/**
 * @ClassName WeiModel
 * @Description TODO
 * @Author 梁波
 * @Date 2021/8/28 11:34
 * @Version 1.0
 */
public class WeiModel implements IModel {
    MutableLiveData<WeitouEntity> mutableLiveData = new MutableLiveData<>();

    public LiveData<BaseRespEntry<ArrayList<WeitouEntity>>>getAttentHeadline(int i){
        LiveData<BaseRespEntry<ArrayList<WeitouEntity>>> attentHeadline = RetrofitFactory.getInstance().createRetrofit().create(Api.class).getAttentHeadline(3);
        return attentHeadline;
    }














}

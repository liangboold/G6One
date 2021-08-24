package com.example.g6one.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.blankj.utilcode.util.ThreadUtils;
import com.example.g6one.entity.NewsEntity;
import com.example.mvvm_lib.model.IModel;

/**
 * @package:com.example.g6one.model
 * @fileName:NewsModel
 * @date on:2021/8/24 8:39
 * @another:HG
 * @email:1572651596@qq.com
 */
public class NewsModel implements IModel {
    MutableLiveData<NewsEntity> mutableLiveData = new MutableLiveData<>();

    public LiveData<NewsEntity>news(NewsEntity newsEntity){
        if(ThreadUtils.isMainThread()){
            mutableLiveData.setValue(newsEntity);
        }else{
            mutableLiveData.postValue(newsEntity);
        }
        return mutableLiveData;

    }


}

package com.example.g6one.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.blankj.utilcode.util.ThreadUtils;
import com.bw.net.protocol.BaseRespEntry;
import com.example.g6one.bean.NewsEntity;
import com.example.g6one.repository.NewsRepository;
import com.example.mvvm_lib.viewmodel.BaseViewModel;

import java.util.ArrayList;

/**
 * @package:com.example.g6one.viewmodel
 * @fileName:NewsViewModel
 * @date on:2021/8/24 8:43
 * @another:HG
 * @email:1572651596@qq.com
 */
public class NewsViewModel extends BaseViewModel<NewsRepository> {
    public MutableLiveData<NewsEntity>mutableLiveData = new MutableLiveData<>();
    public NewsViewModel(LifecycleOwner owner) {
        super(owner);
        NewsEntity newsEntity = new NewsEntity();
        if(ThreadUtils.isMainThread()){
            mutableLiveData.setValue(newsEntity);
        }else{
            mutableLiveData.postValue(newsEntity);
        }
    }

    @Override
    protected NewsRepository createRepository() {
        return new NewsRepository();
    }

    public LiveData<BaseRespEntry<ArrayList<NewsEntity>>> baseRespEntryLiveData(int newstype,int pagenum){
        return mRepository.news(newstype,pagenum);
    }
}

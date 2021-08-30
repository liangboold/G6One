package com.example.g6one.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.blankj.utilcode.util.ThreadUtils;
import com.bw.net.protocol.BaseRespEntry;
import com.example.g6one.bean.MessageEntity;
import com.example.g6one.bean.NewsDetailEntity;
import com.example.g6one.bean.NewsEntity;
import com.example.g6one.model.CommentNetModel;
import com.example.g6one.repository.NewsDetailsRepository;
import com.example.mvvm_lib.model.Model;
import com.example.mvvm_lib.viewmodel.BaseViewModel;

import java.util.ArrayList;

/**
 * @package:com.example.g6one.viewmodel
 * @fileName:NewsDetailsViewModel
 * @date on:2021/8/28 8:22
 * @another:HG
 * @email:1572651596@qq.com
 */
public class NewsDetailsViewModel extends BaseViewModel<NewsDetailsRepository> {

    public MutableLiveData<MessageEntity> pageViewModel = new MutableLiveData<>();
    public MutableLiveData<NewsDetailEntity>mutableLiveData = new MutableLiveData<>();
    public NewsDetailsViewModel(LifecycleOwner owner) {
        super(owner);
        NewsDetailEntity newsDetailEntity = new NewsDetailEntity();
        MessageEntity commentEntity = new MessageEntity();
        if(ThreadUtils.isMainThread()){
            mutableLiveData.setValue(newsDetailEntity);
            pageViewModel.setValue(commentEntity);
        }else{
            mutableLiveData.postValue(newsDetailEntity);
            pageViewModel.postValue(commentEntity);
        }
    }

    @Override
    protected NewsDetailsRepository createRepository() {
        return new NewsDetailsRepository();
    }
    public LiveData<BaseRespEntry<NewsDetailEntity>> baseRespEntryLiveData(String newscode){
        return mRepository.newsDetails(newscode);
    }
    public LiveData<BaseRespEntry<ArrayList<MessageEntity>>> comment(String newsCode, Integer parentid, Integer userid){
        return mRepository.comment(newsCode,parentid,userid);
    }


}

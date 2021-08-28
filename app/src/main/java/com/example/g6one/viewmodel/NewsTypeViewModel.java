package com.example.g6one.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.blankj.utilcode.util.ThreadUtils;
import com.bw.net.protocol.BaseRespEntry;
import com.example.g6one.bean.TypeBean;
import com.example.g6one.repository.NewsTypeRepository;
import com.example.mvvm_lib.viewmodel.BaseViewModel;

import java.util.ArrayList;

/*
 * @ClassName TypeViewModel
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/8/22 18:36
 * @Version 1.0
 */
public class NewsTypeViewModel extends BaseViewModel<NewsTypeRepository> {
    public MutableLiveData<TypeBean> mutableLiveData = new MutableLiveData<>();
    public NewsTypeViewModel(LifecycleOwner owner) {
        super(owner);
        TypeBean typeBean = new TypeBean();
        if (ThreadUtils.isMainThread()){
            mutableLiveData.setValue(typeBean);
        }else {
            mutableLiveData.postValue(typeBean);
        }
    }

    @Override
    protected NewsTypeRepository createRepository() {
        return new NewsTypeRepository();
    }


    public LiveData<BaseRespEntry<ArrayList<TypeBean>>> baseRespEntryLiveData(){
        return mRepository.Type();
    }
}

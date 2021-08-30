package com.example.g6one.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.blankj.utilcode.util.ThreadUtils;
import com.bw.net.protocol.BaseRespEntry;
import com.example.g6one.bean.WeitouEntity;
import com.example.g6one.repository.WeiRepository;
import com.example.mvvm_lib.viewmodel.BaseViewModel;

import java.util.ArrayList;

/**
 * @ClassName WeiViewModel
 * @Description TODO
 * @Author 梁波
 * @Date 2021/8/28 11:42
 * @Version 1.0
 */
public class WeiViewModel extends BaseViewModel<WeiRepository> {
    public MutableLiveData<WeitouEntity> mutableLiveData = new MutableLiveData<>();
    public WeiViewModel(LifecycleOwner owner) {
        super(owner);
        WeitouEntity weitouEntity = new WeitouEntity();
        if (ThreadUtils.isMainThread()){
            mutableLiveData.setValue(weitouEntity);
        }else {
            mutableLiveData.postValue(weitouEntity);
        }
    }

    @Override
    protected WeiRepository createRepository() {
        return new WeiRepository();
    }
    public LiveData<BaseRespEntry<ArrayList<WeitouEntity>>>getAttentHeadline(){
        return mRepository.getAttentHeadline();
    }
}

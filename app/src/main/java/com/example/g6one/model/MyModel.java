package com.example.g6one.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.blankj.utilcode.util.ThreadUtils;
import com.example.g6one.bean.TypeBean;
import com.example.mvvm_lib.model.IModel;

/*
 * @ClassName MyModel
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/8/22 18:42
 * @Version 1.0
 */
public class MyModel implements IModel {
    MutableLiveData<TypeBean> mutableLiveData = new MutableLiveData<>();

    public LiveData<TypeBean> Type(TypeBean typeBean){
        if (ThreadUtils.isMainThread()){
            mutableLiveData.setValue(typeBean);
        }else {
            mutableLiveData.postValue(typeBean);
        }
        return mutableLiveData;
    }
}

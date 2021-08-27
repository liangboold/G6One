package com.example.g6one.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.blankj.utilcode.util.ThreadUtils;
import com.bw.net.RetrofitFactory;
import com.bw.net.protocol.BaseRespEntry;
import com.example.g6one.Api;
import com.example.g6one.bean.TypeBean;
import com.example.mvvm_lib.model.IModel;

import java.util.ArrayList;

/*
 * @ClassName MyModel
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/8/22 18:42
 * @Version 1.0
 */
public class MyModel implements IModel {
    MutableLiveData<TypeBean> mutableLiveData = new MutableLiveData<>();

    public LiveData<BaseRespEntry<ArrayList<TypeBean>>> Type(){
        LiveData<BaseRespEntry<ArrayList<TypeBean>>> type = RetrofitFactory.getRetrofitFactory().createRetrofit().create(Api.class).getType();
        return type;
    }
}

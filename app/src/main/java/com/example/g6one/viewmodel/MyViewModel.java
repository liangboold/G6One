package com.example.g6one.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;

import com.blankj.utilcode.util.ThreadUtils;
import com.example.g6one.bean.TypeBean;
import com.example.g6one.repository.MyRepository;
import com.example.mvvm_lib.repository.BaseRepository;
import com.example.mvvm_lib.viewmodel.BaseViewModel;

/*
 * @ClassName MyViewModel
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/8/22 18:36
 * @Version 1.0
 */
public class MyViewModel extends BaseViewModel<MyRepository> {
    public MutableLiveData<TypeBean> mutableLiveData = new MutableLiveData<>();
    public MyViewModel(LifecycleOwner owner) {
        super(owner);
        TypeBean typeBean = new TypeBean();
        if (ThreadUtils.isMainThread()){
            mutableLiveData.setValue(typeBean);
        }else {
            mutableLiveData.postValue(typeBean);
        }
    }

    @Override
    protected MyRepository createRepository() {
        return new MyRepository();
    }


}

package com.example.g6one.repository;

import androidx.lifecycle.LiveData;

import com.example.g6one.bean.TypeBean;
import com.example.g6one.model.MyModel;
import com.example.mvvm_lib.model.Model;
import com.example.mvvm_lib.repository.BaseRepository;

/*
 * @ClassName MyRepository
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/8/22 18:41
 * @Version 1.0
 */
public class MyRepository extends BaseRepository {
    @Model
    MyModel myModel;

    public LiveData<TypeBean> Type(TypeBean typeBean){
        return myModel.Type(typeBean);
    }
}

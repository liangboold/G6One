package com.example.g6one.repository;

import androidx.lifecycle.LiveData;

import com.bw.net.protocol.BaseRespEntry;
import com.example.g6one.bean.TypeBean;
import com.example.g6one.model.NewsTypeModel;
import com.example.mvvm_lib.model.Model;
import com.example.mvvm_lib.repository.BaseRepository;

import java.util.ArrayList;

/*
 * @ClassName MyRepository
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/8/22 18:41
 * @Version 1.0
 */
public class NewsTypeRepository extends BaseRepository {
    @Model
    NewsTypeModel myModel;

    public LiveData<BaseRespEntry<ArrayList<TypeBean>>> Type(){
        return myModel.Type();
    }
}

package com.example.g6one.repository;

import androidx.lifecycle.LiveData;

import com.bw.net.protocol.BaseRespEntry;
import com.example.g6one.bean.WeitouEntity;
import com.example.g6one.model.WeiModel;
import com.example.mvvm_lib.model.Model;
import com.example.mvvm_lib.repository.BaseRepository;

import java.util.ArrayList;

/**
 * @ClassName WeiRepository
 * @Description TODO
 * @Author 梁波
 * @Date 2021/8/28 11:39
 * @Version 1.0
 */
public class WeiRepository extends BaseRepository {
    @Model
    WeiModel weiModel;
    public LiveData<BaseRespEntry<ArrayList<WeitouEntity>>>getAttentHeadline(){
        return weiModel.getAttentHeadline(3);
    }
}

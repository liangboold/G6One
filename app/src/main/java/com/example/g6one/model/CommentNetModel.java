package com.example.g6one.model;

import androidx.lifecycle.LiveData;

import com.bw.net.RetrofitFactory;
import com.bw.net.protocol.BaseRespEntry;
import com.example.g6one.Api;
import com.example.g6one.bean.MessageEntity;
import com.example.mvvm_lib.model.IModel;

import java.util.ArrayList;

/*
 * @ClassName CommentNetModel
 * @Description TODO
 * @Author 海
 * @Date 2021/8/29 20:11
 * @Version 1.0
 */
public class CommentNetModel implements IModel {
    public LiveData<BaseRespEntry<ArrayList<MessageEntity>>> comment(String newsCode,Integer parentid,Integer userid){
        LiveData<BaseRespEntry<ArrayList<MessageEntity>>> LiveData = RetrofitFactory.getInstance().createRetrofit().create(Api.class).getCommtexs(newsCode, parentid, userid);

        return LiveData;
    }
} 
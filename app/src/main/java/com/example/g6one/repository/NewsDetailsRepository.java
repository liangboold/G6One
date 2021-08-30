package com.example.g6one.repository;

import androidx.lifecycle.LiveData;

import com.bw.net.protocol.BaseRespEntry;
import com.example.g6one.bean.MessageEntity;
import com.example.g6one.bean.NewsDetailEntity;
import com.example.g6one.model.CommentNetModel;
import com.example.g6one.model.NewsDetailsModel;
import com.example.mvvm_lib.model.Model;
import com.example.mvvm_lib.repository.BaseRepository;

import java.util.ArrayList;

/**
 * @package:com.example.g6one.repository
 * @fileName:NewsDetailsRepository
 * @date on:2021/8/28 8:19
 * @another:HG
 * @email:1572651596@qq.com
 */
public class NewsDetailsRepository extends BaseRepository {
    @Model
    CommentNetModel commentNetModel;

    @Model
    NewsDetailsModel newsDetailsModel;
    public LiveData<BaseRespEntry<NewsDetailEntity>>newsDetails(String newscode){
        return newsDetailsModel.newsDetails(newscode);
    }


    public LiveData<BaseRespEntry<ArrayList<MessageEntity>>> comment(String newsCode, Integer parentid, Integer userid){
        return commentNetModel.comment(newsCode,parentid,userid);
    }
}

package com.example.g6one.repository;

import androidx.lifecycle.LiveData;

import com.example.g6one.entity.NewsEntity;
import com.example.g6one.model.NewsModel;
import com.example.mvvm_lib.model.Model;
import com.example.mvvm_lib.repository.BaseRepository;

/**
 * @package:com.example.g6one.repository
 * @fileName:NewsRepository
 * @date on:2021/8/24 8:38
 * @another:HG
 * @email:1572651596@qq.com
 */
public class NewsRepository extends BaseRepository {
    @Model
    NewsModel newsModel;

    public LiveData<NewsEntity>news(NewsEntity newsEntity){
        return newsModel.news(newsEntity);
    }

}

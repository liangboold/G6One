package com.example.g6one.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.bw.net.RetrofitFactory;

import com.bw.net.protocol.BaseRespEntry;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.g6one.Api;
import com.example.g6one.BR;
import com.example.g6one.R;

import com.example.g6one.activity.DetailsActivity;
import com.example.g6one.adapter.NewsAdapter;
import com.example.g6one.bean.NewsEntity;
import com.example.g6one.databinding.Newsfragment;
import com.example.g6one.viewmodel.NewsViewModel;
import com.example.mvvm_lib.view.BaseMVVMFragment;
import com.google.gson.Gson;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NewsFragment extends BaseMVVMFragment<NewsViewModel, Newsfragment> {
    private NewsAdapter newsAdapter;

    @Override
    protected void initEvent() {
        initData();
    }

    @Override
    protected void loadData() {
        initView();
    }

    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        mMap.put(BR.news,this);
    }

    @Override
    protected NewsViewModel createViewModel() {
        return new NewsViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    private void initData() {
        RetrofitFactory.getRetrofitFactory().createRetrofit().create(Api.class)
                .getNews(3,10,10)
                .observe(getActivity(), new Observer<BaseRespEntry<ArrayList<NewsEntity.DataBean>>>() {
                    @Override
                    public void onChanged(BaseRespEntry<ArrayList<NewsEntity.DataBean>> arrayListBaseRespEntry) {
                        String s = JSON.toJSONString(arrayListBaseRespEntry);
                        NewsEntity newsEntity = JSON.parseObject(s, NewsEntity.class);
                        List<NewsEntity.DataBean> data = newsEntity.getData();
                        newsAdapter = new NewsAdapter(data);
                        mBinding.rv.setAdapter(newsAdapter);
                        System.out.println(data);
                        newsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                                intent.putExtra("newscode",data.get(position).getNewscode());
                                startActivity(intent);
                            }
                        });
                    }
                });

        mBinding.pull.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                mBinding.pull.finishRefresh();
            }

            @Override
            public void loadMore() {
                mBinding.pull.finishLoadMore();
            }
        });

    }

    private void initView() {
        mBinding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
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
import com.example.g6one.R;

import com.example.g6one.activity.DetailsActivity;
import com.example.g6one.adapter.NewsAdapter;
import com.example.g6one.bean.NewsEntity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {
    private RecyclerView recyclerView;
    private NewsAdapter newsAdapter;
    private View inflate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_news, container, false);
        initView();
        initData();
        return inflate;
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
                        recyclerView.setAdapter(newsAdapter);
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

    }

    private void initView() {
        recyclerView = inflate.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
    }
}
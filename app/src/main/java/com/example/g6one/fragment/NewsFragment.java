package com.example.g6one.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.g6one.R;
import com.example.g6one.adapter.NewsAdapter;
import com.example.g6one.entity.NewsEntity;
import com.example.g6one.viewmodel.NewsViewModel;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.List;

public class NewsFragment extends Fragment {
    private RecyclerView recyclerView;;
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
//        OkGo.<String>get("http://v.juhe.cn/toutiao/index?type=top&key=3dc86b09a2ee2477a5baa80ee70fcdf5")
//                .execute(new StringCallback() {
//                    @Override
//                    public void onSuccess(Response<String> response) {
//                        String body = response.body();
//                        NewsEntity newsEntity = new Gson().fromJson(body, NewsEntity.class);
//                        List<NewsEntity.ResultBean.DataBean> data = newsEntity.getResult().getData();
//                        newsAdapter = new NewsAdapter(data);
//                        recyclerView.setAdapter(newsAdapter);
//                    }
//                });
    }

    private void initView() {
        recyclerView = inflate.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
    }
}
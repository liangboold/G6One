package com.example.g6one.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.net.RetrofitFactory;
import com.bw.net.protocol.BaseRespEntry;
import com.example.g6one.Api;
import com.example.g6one.R;

import com.example.g6one.adapter.NewsAdapter;
import com.example.g6one.bean.NewsEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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
        RetrofitFactory.getRetrofitFactory().createRetrofit().create(Api.class)
                .getNews(3,10,10)
                .observe(getActivity(), new Observer<BaseRespEntry<ArrayList<NewsEntity.DataBean>>>() {
                    @Override
                    public void onChanged(BaseRespEntry<ArrayList<NewsEntity.DataBean>> arrayListBaseRespEntry) {
                        ArrayList<NewsEntity.DataBean> data = arrayListBaseRespEntry.getData();

                    }
                });

//        List<NewsEntity.DataBean> data = newsEntity.getData();
//        newsAdapter = new NewsAdapter(data);
//        recyclerView.setAdapter(newsAdapter);

    }

    private void initView() {
        recyclerView = inflate.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
    }
}
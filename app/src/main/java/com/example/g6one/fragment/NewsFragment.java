package com.example.g6one.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.net.RetrofitFactory;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.g6one.Api;
import com.example.g6one.R;

import com.example.g6one.activity.XiangqingActivity;
import com.example.g6one.adapter.NewsAdapter;
import com.example.g6one.bean.NewsEntity;

import java.util.List;

import io.reactivex.Observer;
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
        RetrofitFactory.getRetrofitFactory().GsonRetrofit().create(Api.class)
                .getNews(3,10,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsEntity>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull NewsEntity newsEntity) {
                        List<NewsEntity.DataBean> data = newsEntity.getData();
                        newsAdapter = new NewsAdapter(data);
                        recyclerView.setAdapter(newsAdapter);
                        newsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                NewsEntity.DataBean dataBean = newsAdapter.getData().get(position);
                                Intent intent = new Intent(getActivity(), XiangqingActivity.class);
                                startActivity(intent);
                            }
                        });
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void initView() {
        recyclerView = inflate.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
    }
}
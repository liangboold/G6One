package com.example.g6one.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bw.net.RetrofitFactory;
import com.bw.net.protocol.BaseRespEntry;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.g6one.Api;
import com.example.g6one.BR;
import com.example.g6one.bean.NewsTypeBean;
import com.example.g6one.R;
import com.example.g6one.bean.TypeBean;

import com.example.g6one.databinding.ActivityMainBinding;
import com.example.g6one.viewmodel.MyViewModel;
import com.example.mvvm_lib.view.BaseMVVMActivity;
import com.example.mvvm_lib.viewmodel.BaseViewModel;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TypeActivity extends BaseMVVMActivity<MyViewModel, ActivityMainBinding> {
    ArrayList<NewsTypeBean> data = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();
    private RecyclerView newsType;
    private Button next;

    @Override
    protected MyViewModel createViewModel() {
        return new MyViewModel(this);
    }

    @Override
    protected void initEvent() {
        initView();
        initData();
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void prepareSetVars(HashMap mMap) {
        mMap.put(BR.MyViewModel,mViewModel);
    }

    private void initData() {

        mViewModel.baseRespEntryLiveData().observe(this, new Observer<BaseRespEntry<ArrayList<TypeBean>>>() {
            @Override
            public void onChanged(BaseRespEntry<ArrayList<TypeBean>> arrayListBaseRespEntry) {

                ArrayList<TypeBean> arraylist = arrayListBaseRespEntry.getData();
                for (TypeBean typeBean : arraylist) {
                    data.add(new NewsTypeBean(typeBean,false));
                }

                NewsTypeAdapter newsTypeAdapter = new NewsTypeAdapter(data);
                newsType.setAdapter(newsTypeAdapter);
                newsTypeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        if (data.get(position).isIschecked()){
                            data.get(position).setIschecked(false);
                            list.remove(data.get(position).getDataBean().getTypename());
                        }else {
                            data.get(position).setIschecked(true);
                            list.add(data.get(position).getDataBean().getTypename());
                        }
                        newsTypeAdapter.notifyItemChanged(position);
                    }
                });
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TypeActivity.this, HomeActivity.class);
                intent.putStringArrayListExtra("list",list);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        newsType = (RecyclerView) findViewById(R.id.news_type);
        newsType.setLayoutManager(new GridLayoutManager(this,3));
        next = (Button) findViewById(R.id.next);
    }

    private class NewsTypeAdapter extends BaseQuickAdapter<NewsTypeBean, BaseViewHolder>{

        public NewsTypeAdapter(@Nullable List<NewsTypeBean> data) {
            super(R.layout.item, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, NewsTypeBean item) {
            helper.setText(R.id.type,item.getDataBean().getTypename());
            TextView view = helper.getView(R.id.type);
            if (item.isIschecked()){
                view.setBackgroundResource(R.drawable.typetrue);
            }else {
                view.setBackgroundResource(R.drawable.typeflase);
            }
        }
    }
}
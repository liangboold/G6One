package com.example.g6one.activity;


import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;

import android.view.MotionEvent;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;


import com.alibaba.fastjson.JSON;
import com.bw.net.RetrofitFactory;
import com.bw.net.protocol.BaseRespEntry;
import com.example.g6one.Api;
import com.example.g6one.BR;
import com.example.g6one.R;
import com.example.g6one.bean.NewsDetailEntity;
import com.example.g6one.databinding.Detailsactivity;
import com.example.g6one.viewmodel.MyViewModel;
import com.example.mvvm_lib.view.BaseMVVMActivity;

import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import java.util.ArrayList;
import java.util.HashMap;

public class DetailsActivity extends BaseMVVMActivity<MyViewModel, Detailsactivity> {
    private String newscode;
    private NewsDetailEntity.DataBean data;
    private TextView actDetailHeadTitle;
    private ScrollView actDetailScrollView;
    private RelativeLayout headLayout;


    @Override
    protected MyViewModel createViewModel() {
        return new MyViewModel(this);
    }

    @Override
    protected void initEvent() {
        initData();
    }

    @Override
    protected void loadData() {
        initView();
        requestData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_xiangqing;
    }

    @Override
    protected void prepareSetVars(HashMap mMap) {
        mMap.put(BR.details,this);
    }

    private void requestData() {
        RetrofitFactory.getRetrofitFactory().createRetrofit().create(Api.class)
                .getNewsDetail(newscode)
                .observe(this, new Observer<BaseRespEntry<ArrayList<NewsDetailEntity.DataBean>>>() {
                    @Override
                    public void onChanged(BaseRespEntry<ArrayList<NewsDetailEntity.DataBean>> arrayListBaseRespEntry) {
                        String s = JSON.toJSONString(arrayListBaseRespEntry);
                        NewsDetailEntity newsDetailEntity = JSON.parseObject(s, NewsDetailEntity.class);
                        data = newsDetailEntity.getData();
                        System.out.println(data);
                        mBinding.loading.setVisibility(View.GONE);
                        mBinding.view.setVisibility(View.VISIBLE);
                        mBinding.tbsWvMain.loadUrl(data.getUrl());
                        mBinding.titlexiang.setText(data.getTitle());
                        mBinding.timexiang.setText(data.getPublishtime());
                    }
                });

    }

    private void ScrollViewEvent() {
        actDetailScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_MOVE){
                    int height = headLayout.getHeight();
                    int scaleY = actDetailScrollView.getScrollY();
                    if(scaleY>=height){
                        actDetailHeadTitle.setVisibility(View.VISIBLE);
                    }else{
                        actDetailHeadTitle.setVisibility(View.INVISIBLE);
                    }
                }
                return false;
            }
        });
    }

    private void initData() {
        mBinding.tbsWvMain.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String s) {
                Log.d("123", "shouldOverrideUrlLoading: "+s);
                return super.shouldOverrideUrlLoading(webView, s);
            }
        });
    }

    private void initView() {
        newscode = getIntent().getStringExtra("newscode");
    }

}
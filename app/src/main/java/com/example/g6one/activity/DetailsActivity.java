package com.example.g6one.activity;


import androidx.lifecycle.Observer;

import android.util.Log;

import android.view.MotionEvent;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;


import com.bw.net.protocol.BaseRespEntry;
import com.example.g6one.BR;
import com.example.g6one.R;
import com.example.g6one.bean.NewsDetailEntity;
import com.example.g6one.databinding.Detailsactivity;
import com.example.g6one.viewmodel.NewsDetailsViewModel;
import com.example.mvvm_lib.view.BaseMVVMActivity;

import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import java.util.HashMap;

public class DetailsActivity extends BaseMVVMActivity<NewsDetailsViewModel, Detailsactivity> {

    private String newscode;
    private TextView actDetailHeadTitle;
    private ScrollView actDetailScrollView;
    private RelativeLayout headLayout;

    @Override
    protected NewsDetailsViewModel createViewModel() {
        return new NewsDetailsViewModel(this);
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
        mViewModel.baseRespEntryLiveData(newscode).observe(this, new Observer<BaseRespEntry<NewsDetailEntity>>() {
            @Override
            public void onChanged(BaseRespEntry<NewsDetailEntity> arrayListBaseRespEntry) {
                NewsDetailEntity data = arrayListBaseRespEntry.getData();
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
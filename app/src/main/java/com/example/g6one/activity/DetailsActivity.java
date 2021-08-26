package com.example.g6one.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.bw.net.RetrofitFactory;
import com.bw.net.protocol.BaseRespEntry;
import com.example.g6one.Api;
import com.example.g6one.R;
import com.example.g6one.bean.NewsDetailEntity;
import com.google.gson.Gson;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    private WebView tbsWvMain;
    private EditText pinglun;
    private ImageView ping;
    private ImageView shouchang;
    private ImageView fenxiang;
    private String newscode;
    private NewsDetailEntity.DataBean data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqing);
        initView();
        requestData();
        initData();
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
                    }
                });
    }

    private void initData() {
        tbsWvMain.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String s) {
                Log.d("123", "shouldOverrideUrlLoading: "+s);
                return super.shouldOverrideUrlLoading(webView, s);
            }
        });
        tbsWvMain.loadUrl("https://www.baidu.com/");
    }

    private void initView() {
        tbsWvMain = (WebView) findViewById(R.id.tbs_wv_main);
        pinglun = (EditText) findViewById(R.id.pinglun);
        ping = (ImageView) findViewById(R.id.ping);
        shouchang = (ImageView) findViewById(R.id.shouchang);
        fenxiang = (ImageView) findViewById(R.id.fenxiang);
        newscode = getIntent().getStringExtra("newscode");
    }

}
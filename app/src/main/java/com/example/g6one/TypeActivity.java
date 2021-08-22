package com.example.g6one;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

public class TypeActivity extends AppCompatActivity {
    ArrayList<NewsTypeBean> data = new ArrayList<>();
    private RecyclerView newsType;
    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        OkGo.<String>get("http://39.98.153.96:8080/api/NewsType/getAllTypes")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        TypeBean typeBean = JSON.parseObject(response.body(), TypeBean.class);
                        for (TypeBean.DataBean datum : typeBean.getData()) {
                            data.add(new NewsTypeBean(datum,false));
                        }
                        NewsTypeAdapter newsTypeAdapter = new NewsTypeAdapter(data);
                        newsType.setAdapter(newsTypeAdapter);
                        newsTypeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                if (data.get(position).isIschecked()){
                                    data.get(position).setIschecked(false);
                                }else {
                                    data.get(position).setIschecked(true);
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
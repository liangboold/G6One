package com.example.g6one.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.net.protocol.BaseRespEntry;
import com.example.g6one.BR;
import com.example.g6one.R;
import com.example.g6one.activity.PublishActivity;
import com.example.g6one.adapter.WeitouAdarpter;
import com.example.g6one.bean.WeitouEntity;
import com.example.g6one.databinding.FragmentWTouTiaoBinding;
import com.example.g6one.viewmodel.WeiViewModel;
import com.example.mvvm_lib.view.BaseMVVMFragment;

import java.util.ArrayList;
import java.util.HashMap;

public class WTouTiaoFragment extends BaseMVVMFragment<WeiViewModel, FragmentWTouTiaoBinding> {

    private WeitouAdarpter weitouAdarpter;
    @Override
    protected void initEvent() {
        initview();
        initData();
    }

    private void initData() {
        mViewModel.getAttentHeadline().observe(this, new Observer<BaseRespEntry<ArrayList<WeitouEntity>>>() {
            @Override
            public void onChanged(BaseRespEntry<ArrayList<WeitouEntity>> arrayListBaseRespEntry) {
                ArrayList<WeitouEntity> data = arrayListBaseRespEntry.getData();
                weitouAdarpter = new WeitouAdarpter(data);
                mBinding.dongRv.setAdapter(weitouAdarpter);
            }
        });

        mBinding.Publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PublishActivity.class));
            }
        });
    }

    private void initview() {
        mBinding.dongRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        mMap.put(BR.wei,this);
    }

    @Override
    protected WeiViewModel createViewModel() {
        return new WeiViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_w_tou_tiao;
    }
}
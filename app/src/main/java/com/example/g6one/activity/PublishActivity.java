package com.example.g6one.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.g6one.BR;
import com.example.g6one.R;
import com.example.g6one.databinding.Publish;
import com.example.g6one.viewmodel.WeiViewModel;
import com.example.mvvm_lib.view.BaseMVVMActivity;
import com.wildma.pictureselector.PictureBean;
import com.wildma.pictureselector.PictureSelector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PublishActivity extends BaseMVVMActivity<WeiViewModel, Publish> {
    ArrayList<Object> objects = new ArrayList<>();
    private Publishrv publishrv;


    @Override
    protected WeiViewModel createViewModel() {
        return new WeiViewModel(this);
    }

    @Override
    protected void initEvent() {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PictureSelector.SELECT_REQUEST_CODE && data!= null){
            PictureBean parcelableExtra = data.getParcelableExtra(PictureSelector.PICTURE_RESULT);
            objects.add(parcelableExtra.getUri());
            Collections.reverse(objects);
            publishrv.notifyItemInserted(0);
        }
    }

    @Override
    protected void loadData() {
        objects.add(R.drawable.addpicture);
        mBinding.publishrv.setLayoutManager(new GridLayoutManager(this,3));
        publishrv = new Publishrv(objects);
        mBinding.publishrv.setAdapter(publishrv);
        publishrv.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                PictureSelector.create(PublishActivity.this,PictureSelector.SELECT_REQUEST_CODE)
                        .selectPicture();
            }
        });
    }

    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        mMap.put(BR.publish,this);
    }

    private class Publishrv extends BaseQuickAdapter<Object, BaseViewHolder>{

        public Publishrv(@Nullable List<Object> data) {
            super(R.layout.publishitem, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, Object item) {
            Glide.with(mContext).load(item).into((ImageView) helper.getView(R.id.img));
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_publish;
    }
}
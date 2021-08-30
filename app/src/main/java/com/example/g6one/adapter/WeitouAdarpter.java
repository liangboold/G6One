package com.example.g6one.adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.g6one.R;
import com.example.g6one.bean.WeitouEntity;

import java.util.List;

/**
 * @ClassName WeitouAdarpter
 * @Description TODO
 * @Author 梁波
 * @Date 2021/8/28 11:26
 * @Version 1.0
 */
public class WeitouAdarpter extends BaseQuickAdapter<WeitouEntity, BaseViewHolder> {
    public WeitouAdarpter(List<WeitouEntity> data) {
        super(R.layout.witem, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WeitouEntity item) {
        helper.setText(R.id.wei_tv,item.getContent());
        helper.setText(R.id.time_wei,item.getCtime());
            Glide.with(mContext).load(item.getImgs()).into((ImageView) helper.getView(R.id.wei_imone));
            Glide.with(mContext).load(item.getImgs()).into((ImageView) helper.getView(R.id.wei_imtwo));
            Glide.with(mContext).load(item.getImgs()).into((ImageView) helper.getView(R.id.wei_imthere));
            Glide.with(mContext).load(item.getImgs()).into((ImageView) helper.getView(R.id.wei_imfor));

    }
}

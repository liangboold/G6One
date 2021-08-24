package com.example.g6one.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.g6one.R;
import com.example.g6one.entity.NewsEntity;

import java.util.List;

/**
 * @package:com.example.g6one.adapter
 * @fileName:NewsAdapter
 * @date on:2021/8/23 18:43
 * @another:HG
 * @email:1572651596@qq.com
 */
public class NewsAdapter extends BaseMultiItemQuickAdapter<NewsEntity.ResultBean.DataBean, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public NewsAdapter(List<NewsEntity.ResultBean.DataBean> data) {
        super(data);
        addItemType(0,R.layout.item_news_one);
        addItemType(1,R.layout.item_news_two);
        addItemType(2,R.layout.item_news_three);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsEntity.ResultBean.DataBean item) {

        switch (item.getItemType()){
            case 0:
                helper.setText(R.id.text_news_one,item.getTitle());
                break;
            case 1:
                helper.setText(R.id.text_news_two,item.getTitle());
                Glide.with(mContext).load(item.getThumbnail_pic_s()).into((ImageView) helper.getView(R.id.image_news_two));
                break;
            case 2:
                helper.setText(R.id.text_news_three,item.getTitle());
                Glide.with(mContext).load(item.getThumbnail_pic_s02()).into((ImageView) helper.getView(R.id.image_news_three));
                break;
        }
    }
}

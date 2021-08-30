package com.example.g6one.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.g6one.R;
import com.example.g6one.bean.MessageEntity;

import java.util.List;

/*
 * @ClassName CommentAdapter
 * @Description TODO
 * @Author 海
 * @Date 2021/8/29 20:42
 * @Version 1.0
 */
public class CommentAdapter extends BaseQuickAdapter<MessageEntity, BaseViewHolder> {
    public CommentAdapter(List<MessageEntity> data) {
        super(R.layout.item_message,data);
    }




    @Override
    protected void convert(BaseViewHolder helper, MessageEntity item) {
        helper.setText(R.id.comment_title,item.getContent());
        helper.setText(R.id.comment_time,item.getCommenttime());
    }
}
package com.example.mvvm_lib.cmds;

import android.view.View;

import androidx.databinding.BindingAdapter;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import io.reactivex.functions.Consumer;

/**
 * @ClassName ViewAdapter
 * @Description TODO
 * @Author 梁波
 * @Date 2021/8/18 13:59
 * @Version 1.0
 */
public class ViewAdapter {
    @BindingAdapter(value = {"onClickCmd"},requireAll = false)
    public static void onClickCmd(View view, final BindCommand clickCmd){
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (null!=clickCmd){
//                    clickCmd.execute();
//                }
//            }
//        });
        RxView.clicks(view).throttleFirst(3, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        if (null!=clickCmd){
                            clickCmd.execute();
                        }
                    }
                });


    }
}

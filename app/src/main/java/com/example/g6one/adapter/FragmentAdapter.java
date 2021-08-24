package com.example.g6one.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * @package:com.bw.xiangmu
 * @fileName:FragmentAdapter
 * @date on:2021/8/20 13:39
 * @another:HG
 * @email:1572651596@qq.com
 */
public class FragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment>list;

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior,ArrayList<Fragment> list) {
        super(fm, behavior);
        this.list = list;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}

package com.example.g6one.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.g6one.R;
import com.example.g6one.activity.MainActivityQuerys;
import com.example.g6one.entity.MyBtnEntity;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;


public class HomePageFragment extends Fragment {
    ArrayList<CustomTabEntity> customTabEntities = new ArrayList<>();
    View inflate;
    private EditText query;
    ArrayList<Fragment> fragments = new ArrayList<>();
    Intent intent;
    ArrayList<String> list;
    private ViewPager tabvp;
    private CommonTabLayout titletab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        inflate = inflater.inflate(R.layout.fragment_home_page, container, false);
        intent = getActivity().getIntent();
        list = intent.getStringArrayListExtra("list");

        initView();
        initData();
        return inflate;
    }


    private void initData() {
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivityQuerys.class);
                startActivity(intent);
            }
        });

        for (String s : list) {
            fragments.add(new NewsFragment());
            customTabEntities.add(new MyBtnEntity(s,0,0));
        }

        tabvp.setAdapter(new TabVp(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT));
        titletab.setTabData(customTabEntities);
        titletab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                tabvp.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        tabvp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                titletab.setCurrentTab(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        query = (EditText) inflate.findViewById(R.id.query);
        tabvp = (ViewPager) inflate.findViewById(R.id.tabvp);
        titletab = (CommonTabLayout) inflate.findViewById(R.id.titletab);
    }

    private class TabVp extends FragmentPagerAdapter {


        public TabVp(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        customTabEntities.clear();
        fragments.clear();
    }
}
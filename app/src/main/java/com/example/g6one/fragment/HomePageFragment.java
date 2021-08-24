package com.example.g6one.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
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
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

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
    private ImageView share;

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
            customTabEntities.add(new MyBtnEntity(s, 0, 0));
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

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMImage image = new UMImage(getActivity(),"https://dss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2858426577,4189650377&fm=26&gp=0.jpg");//网络图片
                new ShareAction(getActivity()).withMedia(image).setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(new UMShareListener() {
                            @Override
                            public void onStart(SHARE_MEDIA share_media) {

                            }

                            @Override
                            public void onResult(SHARE_MEDIA share_media) {

                            }

                            @Override
                            public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                                Log.e("TAG", "onError: "+throwable.getMessage());
                            }

                            @Override
                            public void onCancel(SHARE_MEDIA share_media) {

                            }
                        }).open();
            }
        });
    }

    private void initView() {
        query = (EditText) inflate.findViewById(R.id.query);
        tabvp = (ViewPager) inflate.findViewById(R.id.tabvp);
        titletab = (CommonTabLayout) inflate.findViewById(R.id.titletab);
        share = (ImageView) inflate.findViewById(R.id.share);
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
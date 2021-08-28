package com.example.g6one.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.g6one.BR;
import com.example.g6one.R;
import com.example.g6one.activity.MainActivityQuerys;
import com.example.g6one.bean.NewsTypeBean;
import com.example.g6one.bean.TypeBean;
import com.example.g6one.databinding.HomeFragment;
import com.example.g6one.viewmodel.NewsViewModel;
import com.example.mvvm_lib.view.BaseMVVMFragment;
import com.google.android.material.tabs.TabLayout;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.util.ArrayList;
import java.util.HashMap;


public class HomePageFragment extends BaseMVVMFragment<NewsViewModel, HomeFragment> {

    ArrayList<String> strings = new ArrayList<>();
    ArrayList<Fragment> fragments = new ArrayList<>();
    Intent intent;
    ArrayList<TypeBean> list;
    public static int typeid;
    private TextView tabtext;


    @Override
    protected void initEvent() {
        mBinding.query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivityQuerys.class);
                startActivity(intent);
            }
        });

        mBinding.titletab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                float selectsize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 16, getResources().getDisplayMetrics());
                tabtext.setTextSize(TypedValue.COMPLEX_UNIT_SP,selectsize);
                tabtext.setTextColor(Color.parseColor("#ff0000"));
                tabtext.setText(tab.getText());
                tabtext.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
                tab.setCustomView(tabtext);
                typeid = list.get(tab.getPosition()).getId();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setCustomView(null);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mBinding.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMImage image = new UMImage(getActivity(), "https://dss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2858426577,4189650377&fm=26&gp=0.jpg");//网络图片
                new ShareAction(getActivity()).withMedia(image).setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN)
                        .setCallback(new UMShareListener() {
                            @Override
                            public void onStart(SHARE_MEDIA share_media) {

                            }

                            @Override
                            public void onResult(SHARE_MEDIA share_media) {

                            }

                            @Override
                            public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                                Log.e("TAG", "onError: " + throwable.getMessage());
                            }

                            @Override
                            public void onCancel(SHARE_MEDIA share_media) {

                            }
                        }).open();
            }
        });
    }

    @Override
    protected void loadData() {
        initView();
        initData();
    }

    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        mMap.put(BR.HomePageFragment,this);
    }

    @Override
    protected NewsViewModel createViewModel() {
        return new NewsViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_page;
    }


    private void initData() {


        for (TypeBean s : list) {
            fragments.add(new NewsFragment());
            strings.add(s.getTypename());
        }
        mBinding.tabvp.setAdapter(new TabVp(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT));
        mBinding.titletab.setupWithViewPager(mBinding.tabvp);
        initIndexTab();
    }

    private void initIndexTab() {
        TabLayout.Tab indextab = mBinding.titletab.getTabAt(0);
        float selectsize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 16, getResources().getDisplayMetrics());
        tabtext.setTextSize(TypedValue.COMPLEX_UNIT_SP,selectsize);
        tabtext.setTextColor(Color.parseColor("#ff0000"));
        tabtext.setText(indextab.getText());
        indextab.setCustomView(tabtext);
    }

    private void initView() {
        intent = getActivity().getIntent();
        list = intent.getParcelableArrayListExtra("list");
        tabtext = new TextView(getActivity());
        typeid = list.get(0).getId();
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

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return strings.get(position);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        strings.clear();
        fragments.clear();
    }
}
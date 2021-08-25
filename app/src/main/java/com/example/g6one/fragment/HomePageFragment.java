package com.example.g6one.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.g6one.R;
import com.example.g6one.activity.MainActivityQuerys;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.android.material.tabs.TabLayout;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.util.ArrayList;


public class HomePageFragment extends Fragment {
    ArrayList<String> strings = new ArrayList<>();
    View inflate;
    private EditText query;
    ArrayList<Fragment> fragments = new ArrayList<>();
    Intent intent;
    ArrayList<String> list;
    private ViewPager tabvp;
    private ImageView share;
    private TabLayout titletab;
    private TextView tabtext;

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
            strings.add(s);
        }
        tabvp.setAdapter(new TabVp(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT));
        titletab.setupWithViewPager(tabvp);
        initIndexTab();
        titletab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                float selectsize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 16, getResources().getDisplayMetrics());
                tabtext.setTextSize(TypedValue.COMPLEX_UNIT_SP,selectsize);
                tabtext.setTextColor(Color.parseColor("#ff0000"));
                tabtext.setText(tab.getText());
                tab.setCustomView(tabtext);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setCustomView(null);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




        share.setOnClickListener(new View.OnClickListener() {
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

    private void initIndexTab() {
        TabLayout.Tab indextab = titletab.getTabAt(0);
        float selectsize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 16, getResources().getDisplayMetrics());
        tabtext.setTextSize(TypedValue.COMPLEX_UNIT_SP,selectsize);
        tabtext.setTextColor(Color.parseColor("#ff0000"));
        tabtext.setText(indextab.getText());
        indextab.setCustomView(tabtext);
    }

    private void initView() {
        tabtext = new TextView(getActivity());
        query = (EditText) inflate.findViewById(R.id.query);
        tabvp = (ViewPager) inflate.findViewById(R.id.tabvp);
        share = (ImageView) inflate.findViewById(R.id.share);
        titletab = (TabLayout) inflate.findViewById(R.id.titletab);
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
package com.example.g6one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;


import com.example.g6one.adapter.FragmentAdapter;
import com.example.g6one.entity.MyBtnEntity;
import com.example.g6one.fragment.HomePageFragment;
import com.example.g6one.fragment.MyFragment;
import com.example.g6one.fragment.VideoFragment;
import com.example.g6one.fragment.WTouTiaoFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private ViewPager vp;
    private CommonTabLayout tab;
    private ArrayList<Fragment> list = new ArrayList<>();
    private ArrayList<CustomTabEntity> tabEntitys = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        vp = (ViewPager) findViewById(R.id.vp);
        tab = (CommonTabLayout) findViewById(R.id.tab);
        list.add(new HomePageFragment());
        list.add(new VideoFragment());
        list.add(new WTouTiaoFragment());
        list.add(new MyFragment());
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(fragmentAdapter);
        tabEntitys.add(new MyBtnEntity("首页",0,0));
        tabEntitys.add(new MyBtnEntity("视频",0,0));
        tabEntitys.add(new MyBtnEntity("微头条",0,0));
        tabEntitys.add(new MyBtnEntity("我的",0,0));
        tab.setTabData(tabEntitys);
        tab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vp.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tab.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
    }
}
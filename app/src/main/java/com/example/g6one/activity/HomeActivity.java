package com.example.g6one.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;


import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.g6one.R;
import com.example.g6one.adapter.FragmentAdapter;
import com.example.g6one.fragment.HomePageFragment;
import com.example.g6one.fragment.MyFragment;
import com.example.g6one.fragment.VideoFragment;
import com.example.g6one.fragment.WTouTiaoFragment;
import com.flyco.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{

    private ViewPager vp;
    private ArrayList<Fragment> list = new ArrayList<>();
    private ArrayList<CustomTabEntity> tabEntitys = new ArrayList<>();
    private BottomNavigationBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        vp = (ViewPager) findViewById(R.id.vp);
        bar = (BottomNavigationBar) findViewById(R.id.bar);
        list.add(new HomePageFragment());
        list.add(new VideoFragment());
        list.add(new WTouTiaoFragment());
        list.add(new MyFragment());
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,list);
        vp.setAdapter(fragmentAdapter);

        bar.setTabSelectedListener(this)
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .setActiveColor("#ffffff")
                .setInActiveColor("#ff6600")
                .setBarBackgroundColor("#bdce8e");
        bar.addItem(new BottomNavigationItem(R.drawable.home_true,"首页"))
                .addItem(new BottomNavigationItem(R.drawable.video_true,"视频"))
                .addItem(new BottomNavigationItem(R.drawable.toutiao_true,"微头条"))
                .addItem(new BottomNavigationItem(R.drawable.my_true,"我的"))//添加小红点数据
                .initialise();//initialise 一定要放在 所有设置的最后一项
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bar.selectTab(0);
                        break;
                    case 1:
                        bar.selectTab(1);
                        break;
                    case 2:
                        bar.selectTab(2);
                        break;
                    case 3:
                        bar.selectTab(3);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
    }

    @Override
    public void onTabSelected(int position) {
        vp.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
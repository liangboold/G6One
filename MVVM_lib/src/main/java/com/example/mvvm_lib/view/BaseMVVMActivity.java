package com.example.mvvm_lib.view;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.mvvm_lib.viewmodel.BaseViewModel;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName BaseMVVMActivity
 * @Description TODO
 * @Author 梁波
 * @Date 2021/8/18 13:39
 * @Version 1.0
 */
public abstract class BaseMVVMActivity<VM extends BaseViewModel,Binding extends ViewDataBinding>extends AppCompatActivity {
    protected Binding mBinding;
    protected VM mViewModel;
    private HashMap<Integer,Object> mMap=new HashMap<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
        //设置生命周期的所有者 如果不设置使用LiveData页面将无法获取到数据的更新
        mBinding.setLifecycleOwner(this);
        mViewModel=createViewModel();
        prepareSetVars(mMap);
        setVars(mBinding,mMap);

        immersion();
        loadData();
        initEvent();
    }

    protected void immersion(){
        View decorView = getWindow().getDecorView();
        int v = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                |View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(v);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
    }

    //创建ViewModel实例

    protected abstract VM createViewModel();

    // 初始化事件

    protected abstract void initEvent();

    // 初始化数据

    protected abstract void loadData();

    //设置变量

    private void setVars(Binding mBinding, HashMap<Integer, Object> mMap) {
        if (mMap.size()==0){
            throw new RuntimeException("please set variable...");
        }

        for (Map.Entry<Integer,Object> entry:mMap.entrySet()){
            mBinding.setVariable(entry.getKey(),entry.getValue());
        }
    }

    // 准备设置数据源

    protected abstract void prepareSetVars(HashMap<Integer, Object> mMap);

    //获取布局资源id

    protected abstract int getLayoutId();
}

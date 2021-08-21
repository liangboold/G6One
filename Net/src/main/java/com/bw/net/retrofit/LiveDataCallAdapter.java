package com.bw.net.retrofit;

import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bw.net.protocol.BaseRespEntry;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @package:com.bw.net.retrofit
 * @fileName:LiveDataCallAdapter
 * @date on:2021/8/20 9:07
 * @another:HG
 * @email:1572651596@qq.com
 */
public class LiveDataCallAdapter<R>implements CallAdapter<R, LiveData<BaseRespEntry<R>>> {
    Type type;

    public LiveDataCallAdapter(Type _t) {
        this.type = _t;
    }

    @Override
    public Type responseType() {
        return type;
    }

    @Override
    public LiveData<BaseRespEntry<R>> adapt(Call<R> call) {
        final MutableLiveData<BaseRespEntry<R>>liveData = new MutableLiveData<>() ;
        call.enqueue(new Callback<R>() {
            @Override
            public void onResponse(Call<R> call, Response<R> response) {
                if(Looper.getMainLooper().getThread()==Thread.currentThread()){
                    liveData.setValue((BaseRespEntry<R>)response.body());
                }else{
                    liveData.postValue((BaseRespEntry<R>)response.body());
                }
            }

            @Override
            public void onFailure(Call<R> call, Throwable t) {
                BaseRespEntry entity = new BaseRespEntry();
                entity.setCode(-11);
                entity.setMsg(t.getMessage());
                if(Looper.getMainLooper().getThread()==Thread.currentThread()){
                    liveData.setValue(entity);
                }else{
                    liveData.postValue(entity);
                }
            }
        });
        return liveData;
    }
}

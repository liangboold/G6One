package com.example.g6one;



import androidx.lifecycle.LiveData;

import com.bw.net.protocol.BaseRespEntry;
import com.example.g6one.bean.TypeBean;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;

/*
 * @ClassName Api
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/8/21 11:03
 * @Version 1.0
 */
public interface Api {
    @GET("api/NewsType/getAllTypes")
    LiveData<BaseRespEntry<ArrayList<TypeBean.DataBean>>> getType();
}

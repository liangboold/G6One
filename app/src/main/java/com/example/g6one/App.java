package com.example.g6one;

import android.app.Application;
import android.content.Context;
import android.util.Log;


import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.socialize.PlatformConfig;

import java.util.HashMap;

/*
 * @ClassName App
 * @Description TODO
 * @Author 海
 * @Date 2021/8/23 18:36
 * @Version 1.0
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initTBS();
        UMConfigure.init(this, "612384524d740d4ecf98cefe"
                , "umeng", UMConfigure.DEVICE_TYPE_PHONE, "845b991fde4bffc570031f856d596026");//58edcfeb310c93091c000be2

        // 微信设置
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");

        // QQ设置
        PlatformConfig.setQQZone("101830139", "5d63ae8858f1caab67715ccd6c18d7a5");

        // 新浪微博设置
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");

        //钉钉设置
        PlatformConfig.setDing("dingoalmlnohc0wggfedpk");

        // 企业微信设置

        PlatformConfig.setDing("dingoalmlnohc0wggfedpk");
        PlatformConfig.setYixin("yxc0614e80c9304c11b0391514d09f13bf");
        PlatformConfig.setAlipay("2015111700822536");
        PlatformConfig.setLaiwang("laiwangd497e70d4", "d497e70d4c3e4efeab1381476bac4c5e");
        PlatformConfig.setTwitter("3aIN7fuF685MuZ7jtXkQxalyi", "MK6FEYG63eWcpDFgRYw4w9puJhzDl0tyuqWjZ3M7XJuuG7mMbO");
        PlatformConfig.setPinterest("1439206");
        PlatformConfig.setKakao("e4f60e065048eb031e235c806b31c70f");
        PlatformConfig.setVKontakte("5764965", "5My6SNliAaLxEm3Lyd9J");
        PlatformConfig.setDropbox("oz8v5apet3arcdy", "h7p2pjbzkkxt02a");

        //推送
        //        UMConfigure.init(Context context, String appkey, String channel, int deviceType, String pushSecret);
        //        UMConfigure.init(this, "612384524d740d4ecf98cefe",
        //                "DEF", UMConfigure.DEVICE_TYPE_PHONE , "845b991fde4bffc570031f856d596026");

        init(this);
    }

    public static void init(Context context) {

        //获取消息推送实例
        PushAgent pushAgent = PushAgent.getInstance(context);
        //注册推送服务，每次调用register方法都会回调该接口
        pushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回deviceToken deviceToken是推送消息的唯一标志
                Log.i("123", "注册成功：deviceToken：--> " + deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.e("123", "注册失败：--> " + "s:" + s + ",s1:" + s1);
            }
        });
    }

    private void initTBS() {
        // 在调用TBS初始化、创建WebView之前进行如下配置
        HashMap map = new HashMap();
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER, true);
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE, true);
        QbSdk.initTbsSettings(map);
    }
}
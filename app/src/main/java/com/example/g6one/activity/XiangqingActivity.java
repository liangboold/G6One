package com.example.g6one.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.g6one.R;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class XiangqingActivity extends AppCompatActivity {
    private WebView tbsWvMain;
    private EditText pinglun;
    private ImageView ping;
    private ImageView shouchang;
    private ImageView fenxiang;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqing);
        initfily();
        tbsWvMain.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String s) {
                Log.d("123", "shouldOverrideUrlLoading: "+s);
                return super.shouldOverrideUrlLoading(webView, s);
            }
        });
        tbsWvMain.loadUrl("https://www.baidu.com/");
    }

    private void initfily() {
        tbsWvMain = (WebView) findViewById(R.id.tbs_wv_main);
        pinglun = (EditText) findViewById(R.id.pinglun);
        ping = (ImageView) findViewById(R.id.ping);
        shouchang = (ImageView) findViewById(R.id.shouchang);
        fenxiang = (ImageView) findViewById(R.id.fenxiang);
    }

}
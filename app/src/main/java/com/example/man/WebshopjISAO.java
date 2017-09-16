package com.example.man;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import net.Ip;

public class WebshopjISAO extends AppCompatActivity {

    private WebView wb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webshopj_isao);


        wb = (WebView) findViewById(R.id.webview);

        Intent i = getIntent();

        String newurl = i.getStringExtra("weburl");
        String urls =newurl.replace("169.254.133.48", Ip.ip);


        wb.loadUrl(urls);

        wb.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
    }
}

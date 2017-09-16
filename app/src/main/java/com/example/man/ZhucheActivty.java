package com.example.man;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.https.HttpsUtils;

import net.Ip;
import net.Okhttp;
import net.onNetlistener;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import Bean.Ai;
import Bean.lalalal;

public class ZhucheActivty extends AppCompatActivity implements View.OnClickListener {


    private String urlz = Ip.TOU + Ip.ip + Ip.ZC;
    private ImageView mBacks;
    /**
     * 用户注册
     */
    private TextView mZhuces;
    private RelativeLayout mToumus;
    private ImageView mZ;
    /**
     * 请输入账号
     */
    private EditText mZh;
    private ImageView mM;
    /**
     * 请输入密码
     */
    private EditText mMimas;
    /**
     * 重新输入密码
     */
    private EditText mMima;
    /**
     * 输入邮箱
     */
    private EditText mYouxiang;
    /**
     * 注册
     */
    private Button mDenglu;
    private RelativeLayout mRealat;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuche_activty);
        initView();


    }

    private void initView() {
        mBacks = (ImageView) findViewById(R.id.backs);
        mZhuces = (TextView) findViewById(R.id.zhuces);
        mToumus = (RelativeLayout) findViewById(R.id.toumus);
        mZ = (ImageView) findViewById(R.id.z);
        mZh = (EditText) findViewById(R.id.zh);
        mM = (ImageView) findViewById(R.id.m);
        mMimas = (EditText) findViewById(R.id.mimas);
        mM = (ImageView) findViewById(R.id.m);
        mMima = (EditText) findViewById(R.id.mima);
        mM = (ImageView) findViewById(R.id.m);
        mYouxiang = (EditText) findViewById(R.id.youxiang);
        mDenglu = (Button) findViewById(R.id.zhuche);
        mDenglu.setOnClickListener(this);
        mRealat = (RelativeLayout) findViewById(R.id.realat);
        t = (TextView) findViewById(R.id.textView2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zhuche:
                    zc();
               break;
        }
    }

    private void zc() {

        String name = mZh.getText().toString();
        String pwd = mMima.getText().toString();
        String pwd2 = mMimas.getText().toString();
        String email = mYouxiang.getText().toString();
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pwd) && !TextUtils.isEmpty(pwd2) && !TextUtils.isEmpty(email)) {
            if(!pwd.equals(pwd2)){
                return;
            }


            Map<String, String> map = new HashMap<>();
//            map.put("act", "login");
//            map.put("op", "register");
            map.put("username", name);
            map.put("password", pwd);
            map.put("password_confirm", pwd2);
            map.put("email", email);
            map.put("client", "android");

            Okhttp.getOkhttp().post(ZhucheActivty.this, urlz, map, Ai.class, new onNetlistener() {
                @Override
                public void Onsuccess(Object o) {
                    Ai myRegisterBean = (Ai) o;
                    if (myRegisterBean.getCode()==200) {
                        Toast.makeText(ZhucheActivty.this, "成功", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(ZhucheActivty.this, myRegisterBean.getDatas().getError(), Toast.LENGTH_SHORT).show();
                    }

                }
            });
        } else {
            Toast.makeText(ZhucheActivty.this, "输入框不能为空~~~~~~", Toast.LENGTH_SHORT).show();
        }
    }
        }


package com.example.man;

import android.content.Intent;
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

import net.Ip;
import net.Okhttp;
import net.onNetlistener;

import java.util.HashMap;
import java.util.Map;

import Bean.Ai;
import Bean.LoginShi;

public class denglu extends AppCompatActivity implements View.OnClickListener {

    private ImageView mBack;
    /**
     * 用户登录
     */
    private TextView mDenlu;
    private RelativeLayout mToumu;
    private ImageView mZ;
    /**
     * 请输入账号
     */
    private EditText mZh;
    private ImageView mM;
    /**
     * 请输入密码
     */
    private EditText mMima;
    /**
     * 登录
     */
    private Button mDenglu;
    private RelativeLayout mRealat;
    /**
     * 注册密码
     */
    private TextView mZc;
    private TextView mZh1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denglu);
        initView();

    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.back);
        mBack.setOnClickListener(this);
        mDenlu = (TextView) findViewById(R.id.denlu);
        mToumu = (RelativeLayout) findViewById(R.id.toumu);
        mZ = (ImageView) findViewById(R.id.z);
        mZh = (EditText) findViewById(R.id.zh);
        mM = (ImageView) findViewById(R.id.m);
        mMima = (EditText) findViewById(R.id.mima);
        mDenglu = (Button) findViewById(R.id.denglu);
        mDenglu.setOnClickListener(this);
        mRealat = (RelativeLayout) findViewById(R.id.realat);
        mZc = (TextView) findViewById(R.id.zc);
        mZc.setOnClickListener(this);
        mZh1 = (TextView) findViewById(R.id.zh);
        mZh1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.denglu:

                Login();

                break;
            case R.id.zc:

                Intent intent=new Intent(denglu.this, ZhucheActivty.class);
                startActivity(intent);

                break;
        }
    }

    public interface jiekou{
        void fangfa(String name,int code);
    };

    public  static  jiekou jiekous;

    public static void setJiekous(jiekou jiekous) {
        denglu.jiekous = jiekous;
    }

    private void Login() {
      final String uname =    mZh.getText().toString();
      final String umima =  mMima.getText().toString();
      String url = Ip.TOU+Ip.ip+Ip.login;


      if(!TextUtils.isEmpty(uname)&&!TextUtils.isEmpty(umima)){

          Map<String, String> maps = new HashMap<>();
          maps.put("username", uname);
          maps.put("password", umima);
          maps.put("client", "android");
          Okhttp.getOkhttp().post(denglu.this, url , maps, LoginShi.class, new onNetlistener() {
              @Override
              public void Onsuccess(Object o) {
                  LoginShi log = (LoginShi) o;

                  if(log.getCode()==200){
                      Toast.makeText(denglu.this, "登录成功", Toast.LENGTH_SHORT).show();

                      mZh.setText(uname);


                      jiekous.fangfa(uname,log.getCode());

                      finish();
                  }else{
                      Toast.makeText(denglu.this, log.getDatas().getError(), Toast.LENGTH_SHORT).show();
                  }
              }
          });
      } else{
          Toast.makeText(this, "错误", Toast.LENGTH_SHORT).show();
      }


    }


}

package com.example.man;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Zhifu extends AppCompatActivity implements View.OnClickListener {

    private ImageView mBacks;
    /**
     * 支付
     */
    private TextView mZhuces;
    private RelativeLayout mToumus;
    /**
     * 收货地址：
     */
    private TextView mShouhuo;
    /**
     * 哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈
     */
    private TextView mDizhi;
    private RelativeLayout mS;
    /**
     * 支付方式
     */
    private TextView mZ;
    /**
     * 余额
     */
    private Button mYue;
    /**
     * 支付宝
     */
    private Button mZhifubao;
    /**
     * 微信
     */
    private Button mWeixin;
    private RelativeLayout mZhongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhifu);
        initView();


         Intent i = getIntent();

         int price=  i.getIntExtra("price",0);
         int liang=  i.getIntExtra("liang",0);

         mZ.setText("共"+liang+"件商品,支付"+price+"元");

    }

    private void initView() {
        mBacks = (ImageView) findViewById(R.id.backs);
        mBacks.setOnClickListener(this);
        mZhuces = (TextView) findViewById(R.id.zhuces);
        mToumus = (RelativeLayout) findViewById(R.id.toumus);
        mShouhuo = (TextView) findViewById(R.id.shouhuo);
        mDizhi = (TextView) findViewById(R.id.dizhi);
        mS = (RelativeLayout) findViewById(R.id.s);
        mZ = (TextView) findViewById(R.id.z);
        mYue = (Button) findViewById(R.id.yue);
        mYue.setOnClickListener(this);
        mZhifubao = (Button) findViewById(R.id.zhifubao);
        mZhifubao.setOnClickListener(this);
        mWeixin = (Button) findViewById(R.id.weixin);
        mWeixin.setOnClickListener(this);
        mZhongs = (RelativeLayout) findViewById(R.id.zhongs);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backs:

                finish();

                break;
            case R.id.yue:
                break;
            case R.id.zhifubao:
                break;
            case R.id.weixin:
                break;
        }
    }
}

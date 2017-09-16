package com.example.man;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import Fragments.SousuoFragment;
import Fragments.SymActitvc;
import Fragments.gouwuce;
import Fragments.wodeFrag;

public class ZhuyeActivity extends AppCompatActivity implements View.OnClickListener{

    private FrameLayout fragm;
    private RadioButton sy;
    private RadioButton ss;
    private RadioButton guc;
    private RadioButton wd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuye);

        Initkj();


    }

    private void Initkj() {
        fragm = (FrameLayout) findViewById(R.id.frag);
        fragm.setOnClickListener(this);
        sy = (RadioButton) findViewById(R.id.sy);
        sy.setOnClickListener(this);
        ss = (RadioButton) findViewById(R.id.ss);
        ss.setOnClickListener(this);
        guc = (RadioButton) findViewById(R.id.gouwuce);
        guc.setOnClickListener(this);
        wd = (RadioButton) findViewById(R.id.me);
        wd.setOnClickListener(this);


        Fragment(new SymActitvc());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sy :
                  Fragment(new SymActitvc());
                  sy.setTextColor(Color.BLUE);
                  ss.setTextColor(Color.BLACK);
                  guc.setTextColor(Color.BLACK);
                  wd.setTextColor(Color.BLACK);
                break;
            case R.id.ss :
                 Fragment(new SousuoFragment());
                 ss.setTextColor(Color.BLUE);
                guc.setTextColor(Color.BLACK);
                wd.setTextColor(Color.BLACK);
                sy.setTextColor(Color.BLACK);
                break;
            case  R.id.gouwuce :
                Fragment(new gouwuce());
                guc.setTextColor(Color.BLUE);
                wd.setTextColor(Color.BLACK);
                sy.setTextColor(Color.BLACK);
                ss.setTextColor(Color.BLACK);
                break;

            case R.id.me :
                Fragment(new wodeFrag());
                wd .setTextColor(Color.BLUE);
                sy.setTextColor(Color.BLACK);
                ss.setTextColor(Color.BLACK);
                guc.setTextColor(Color.BLACK);
                break;
        }
    }


    public void Fragment(Fragment f){
        // 获得 Fragment
       FragmentManager manager = getFragmentManager();
        FragmentTransaction beginTransaction = manager.beginTransaction();
        beginTransaction.replace(R.id.frag , f);
        beginTransaction.commit();
    }
}

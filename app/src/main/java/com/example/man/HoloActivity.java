package com.example.man;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import Untils.SharedpreferecnesUtils;

public class HoloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holo);



        boolean a = (boolean) SharedpreferecnesUtils.GetData(HoloActivity.this,"b",false);
        if(a){
            startActivity(new Intent(HoloActivity.this,ZhuyeActivity.class));
            finish();
        }else{
           Fangfa();
        }






    }

    private void Fangfa() {

        new Thread(){
            @Override
            public void run() {

                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent =new Intent(HoloActivity.this,ZhuyeActivity.class);

                startActivity(intent);

                SharedpreferecnesUtils.Setdata(HoloActivity.this,"b",true);
                finish();
            }
        }.start();

    }
}

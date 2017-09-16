package com.example.man;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.Ip;
import net.Okhttp;
import net.onNetlistener;

import java.util.ArrayList;
import java.util.List;

import Bean.Xiangqingyes;
import Fragments.gouwuce;
import Myadater.Recycleradater;
import Myadater.Recyr2;
import Myadater.Viepageradater;
import Untils.Dao;
import Untils.Mydb;

import static android.media.CamcorderProfile.get;

public class ZhenzhengdeMage extends AppCompatActivity implements View.OnClickListener{

    List<Xiangqingyes> list = new ArrayList<Xiangqingyes>(); //jihe
    List<Xiangqingyes.DatasBean.GoodsCommendListBean> jiage = new ArrayList<>();
    List<Xiangqingyes.DatasBean.SpecListBean> sptasbean = new ArrayList<>();
    List<String> str = new ArrayList<>();
    List<Xiangqingyes.DatasBean.StoreInfoBean> haoshangcheng = new ArrayList<>();
    List<Xiangqingyes.DatasBean.GoodsInfoBean> Goods = new ArrayList<>();
    List<Xiangqingyes.DatasBean.GoodsHairInfoBean> hairlinfo = new ArrayList<>();
    private String url  =Ip.TOU+Ip.ip+Ip.XQY+"&goods_id=";
    private TextView tname ;
    private TextView tprive;
    private TextView tavi;
    private ViewPager vp ;
    private RecyclerView re;
    private ImageView leftmeiyog;
    private TextView web;
    private WebView wb;
    private Button addgouwuce;
    private Recyr2 recyr2;
    private String i;
    private int ins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhenzhengde_mage);
        vp = (ViewPager) findViewById(R.id.vps);
        tname = (TextView) findViewById(R.id.mname);
        tprive = (TextView) findViewById(R.id.mprice);
        tavi = (TextView) findViewById(R.id.tvai);
        re = (RecyclerView) findViewById(R.id.res);
        leftmeiyog = (ImageView) findViewById(R.id.leftmeiyong);
        web = (TextView) findViewById(R.id.webtiaoz);
        addgouwuce = (Button) findViewById(R.id.addgwc);
        addgouwuce.setOnClickListener(this);
        re.setLayoutManager(new LinearLayoutManager(this));

        leftmeiyog.setOnClickListener(this);
        web.setOnClickListener(this);
        GetData();

    }
    private void GetData() {

        Intent  in  = getIntent();
        String s =  in.getStringExtra("goid");
        ins = in.getIntExtra("position" ,0);
        Okhttp.getOkhttp().getdata(url+s, Xiangqingyes.class, new onNetlistener() {
            @Override
            public void Onsuccess(Object o) {
                   Xiangqingyes xiangqingye = (Xiangqingyes) o;
                   list.add(xiangqingye);
                    jiage.addAll(xiangqingye.getDatas().getGoods_commend_list());
                    str.addAll(xiangqingye.getDatas().getSpec_image());
                    Goods.add(xiangqingye.getDatas().getGoods_info());
                    hairlinfo.add(xiangqingye.getDatas().getGoods_hair_info());
                    vp.setAdapter(new Viepageradater(ZhenzhengdeMage.this,str));

                    for(int i = 0 ; i < jiage.size() ; i++ ){
                        tname.setText(jiage.get(i).getGoods_name());

                        tprive.setText( jiage.get(i).getGoods_promotion_price());

                    }


                recyr2 = new Recyr2(jiage);

                re.setAdapter(recyr2);



                recyr2.setOnItemClickLitener(new Recyr2.OnItemClickLitener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent in =  new Intent(ZhenzhengdeMage.this,ZhenzhengdeMage.class);
                        in.putExtra("goid" , jiage.get(position).getGoods_id());
                        startActivity(in);
                        finish();
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {
                        Toast.makeText(ZhenzhengdeMage.this, "收藏", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.leftmeiyong:finish();break;
            case R.id.webtiaoz:
                  Intent intent = new Intent(ZhenzhengdeMage.this,WebshopjISAO.class);
                  for(int w = 0 ; w<Goods.size();w++) {
                    intent.putExtra("weburl", Goods.get(w).getGoods_url());
                      startActivity(intent);
                  }
                break;

            case R.id.addgwc:


                    Dao dao=new Dao(ZhenzhengdeMage.this);
                    dao.insert(jiage.get(ins).getGoods_name(),jiage.get(ins).getGoods_promotion_price(),jiage.get(ins).getGoods_image_url(),1);

                Toast.makeText(this, "已经加入购物车", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}

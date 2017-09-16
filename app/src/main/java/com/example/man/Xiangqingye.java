package com.example.man;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import net.Ip;
import net.Okhttp;
import net.onNetlistener;

import java.util.ArrayList;
import java.util.List;

import Bean.Liebiao;
import Myadater.Recycleradater;

public class Xiangqingye extends AppCompatActivity implements View.OnClickListener {

    private ImageView mLeft;
    /**
     * 搜索一下
     */
    private EditText mEd;
    private ImageView mRight;
    private RelativeLayout mLins;
    /**
     * 综合排序
     */
    private Button mLeftbutton;
    /**
     * 销售优先
     */
    private Button mMiddlebutton;
    /**
     * 筛选
     */
    private Button mRightbutton;
    private ImageView mRightLocn;
    private RecyclerView mRecyclerview;

    private String url = Ip.TOU + Ip.ip + Ip.LBYE + "&gc_id=" ;
    private List<Liebiao.DatasBean.GoodsListBean> list = new ArrayList<>();
    public static Recycleradater recycleradater;
    private  int count = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqingye);
        initView();

        initdata();



    }

    private void initdata() {

        final Intent intent = getIntent();

         String  id =intent.getStringExtra("id");

        Okhttp.getOkhttp().getdata(url + id, Liebiao.class, new onNetlistener() {
            @Override
            public void Onsuccess(Object o) {
                Liebiao  lie = (Liebiao) o;
                list.addAll(lie.getDatas().getGoods_list());
                recycleradater=  new Recycleradater(list);
                mRecyclerview.setAdapter(recycleradater);

                recycleradater.setOnItemClickLitener(new Recycleradater.OnItemClickLitener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent  intent2 =  new Intent(Xiangqingye.this,ZhenzhengdeMage.class);

                        intent2.putExtra("goid" , list.get(position).getGoods_id());
                        intent2.putExtra("position",position);
                        startActivity(intent2);
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {

                    }
                });
            }
        });
    }

    private void initView() {
        mLeft = (ImageView) findViewById(R.id.left);
        mLeft.setOnClickListener(this);
        mEd = (EditText) findViewById(R.id.ed);
        mRight = (ImageView) findViewById(R.id.right);
        mLeftbutton = (Button) findViewById(R.id.leftbutton);
        mLeftbutton.setOnClickListener(this);
        mMiddlebutton = (Button) findViewById(R.id.middlebutton);
        mMiddlebutton.setOnClickListener(this);
        mRightbutton = (Button) findViewById(R.id.rightbutton);
        mRightbutton.setOnClickListener(this);
        mRightLocn = (ImageView) findViewById(R.id.right_locn);
        mRightLocn.setOnClickListener(this);
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);

        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.left:

                finish();
                break;

            case R.id.leftbutton:
                View vs = View.inflate(Xiangqingye.this,R.layout.zhonghe,null);

                PopupWindow popupWindow = new PopupWindow(vs,400, 300 , true);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(true);
                popupWindow.setTouchable(true);
                   // 显示PopupWindow，其中：
                    // 第一个参数是PopupWindow的锚点，第二和第三个参数分别是PopupWindow相对锚点的x、y偏移
                    popupWindow.showAsDropDown(vs, 0,120);
                break;
            case R.id.middlebutton:
                break;
            case R.id.rightbutton:

                View mvss = View.inflate(Xiangqingye.this,R.layout.xiaoshou,null);

                PopupWindow mpopupWindows = new PopupWindow(mvss, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                mpopupWindows.setBackgroundDrawable(new BitmapDrawable());
                mpopupWindows.setOutsideTouchable(true);
                mpopupWindows.setFocusable(true);
                mpopupWindows.setTouchable(true);
                // 显示PopupWindow，其中：
                // 第一个参数是PopupWindow的锚点，第二和第三个参数分别是PopupWindow相对锚点的x、y偏移
                mpopupWindows.showAsDropDown(mvss, 100,190);

                break;


            case R.id.right_locn:
                count ++ ;
                if(count==2){
                    mRecyclerview.setLayoutManager(new GridLayoutManager(this,2));
                    mRightLocn.setImageResource(R.mipmap.greate);
                }else{
                    mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
                    mRightLocn.setImageResource(R.mipmap.listgrete);
                    count=1;
                }
                break;
        }
    }

}

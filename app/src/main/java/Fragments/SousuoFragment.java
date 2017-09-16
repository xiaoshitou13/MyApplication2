package Fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.man.R;
import com.xys.libzxing.zxing.activity.CaptureActivity;

import net.Ip;
import net.Okhttp;
import net.onNetlistener;

import java.util.List;

import Bean.Yonhudata;
import Myadater.Lvadater;


public class SousuoFragment extends Fragment {

    private ListView lv;
    private FrameLayout frameLayout;

    public static List<Yonhudata.DatasBean.ClassListBean> ls;
    private Lvadater lvadater;
   private ImageView imageview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sousuo, container, false);
        frameLayout = (FrameLayout) v.findViewById(R.id.fragment);
        lv = (ListView) v.findViewById(R.id.lv);

        imageview = (ImageView) v.findViewById(R.id.left);


        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(new Intent(getActivity(), CaptureActivity.class),0);

            }
        });



        String url = Ip.TOU+Ip.ip+Ip.FENLEILISTVIEW;

        Okhttp.getOkhttp().getdata(url, Yonhudata.class, new onNetlistener() {
            @Override
            public void Onsuccess(Object o) {
                Yonhudata yo = (Yonhudata) o;
                ls = yo.getDatas().getClass_list();

                lvadater= new Lvadater(getActivity(), ls);
                lv.setAdapter(lvadater);
        }
        });

        Fragmentss(new FenleiyIJI("1"));

       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (ls.get(position).getGc_name()) {
                            case "服饰鞋帽":
                                Fragmentss(new FenleiyIJI(ls.get(position).getGc_id()));
                                break;
                            case "礼品箱包":
                                Fragmentss(new FenleiyIJI(ls.get(position).getGc_id()));
                                break;
                            case "家居家装":
                                Fragmentss(new FenleiyIJI(ls.get(position).getGc_id()));
                                break;
                            case "数码办公":
                                Fragmentss(new FenleiyIJI(ls.get(position).getGc_id()));
                                break;
                            case "家用电器":
                                Fragmentss(new FenleiyIJI(ls.get(position).getGc_id()));
                                break;
                            case "个护化妆":
                                Fragmentss(new FenleiyIJI(ls.get(position).getGc_id()));
                                break;
                            case "珠宝手表":
                                Fragmentss(new FenleiyIJI(ls.get(position).getGc_id()));
                                break;
                            case "食品饮料":
                                Fragmentss(new FenleiyIJI(ls.get(position).getGc_id()));
                                break;
                            case "运动健康":
                                Fragmentss(new FenleiyIJI(ls.get(position).getGc_id()));
                                break;
                            case "汽车用品":
                                Fragmentss(new FenleiyIJI(ls.get(position).getGc_id()));
                                break;
                            case "玩具乐器":
                                Fragmentss(new FenleiyIJI(ls.get(position).getGc_id()));
                                break;
                            case "厨具":
                                Fragmentss(new FenleiyIJI(ls.get(position).getGc_id()));
                                break;
                            case "母婴用品":
                                Fragmentss(new FenleiyIJI(ls.get(position).getGc_id()));
                                break;
                            case "虚拟充值":
                                Fragmentss(new FenleiyIJI(ls.get(position).getGc_id()));
                                break;
                        }
                  }

       });

        return  v;
    }



    public void Fragmentss(Fragment f){
        // 获得 Fragment
        FragmentManager manager = getFragmentManager();
        FragmentTransaction beginTransaction = manager.beginTransaction();
        beginTransaction.replace(R.id.fragment , f);
        beginTransaction.commit();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(getActivity(), "Hahaha  傻了吧", Toast.LENGTH_SHORT).show();
    }
}

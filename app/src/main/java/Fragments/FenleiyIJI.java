package Fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.man.R;

import net.Ip;
import net.Okhttp;
import net.onNetlistener;

import java.util.ArrayList;
import java.util.List;

import Bean.ErjiBean;
import Bean.New;
import Myadater.Exerjiadater;


public class FenleiyIJI extends Fragment {

    String json;


    public FenleiyIJI(String page) {

        json = page;
    }

    ExpandableListView edand;

    List<ErjiBean.DatasBean.ClassListBean>  yiji = new ArrayList<>();


    ArrayList< List<New.DatasBean.ClassListBean> >  arr1 = new ArrayList<>() ;



    private String url = Ip.TOU + Ip.ip + Ip.FENLEILISTVIEW + "&gc_id=" ;
    private TextView t5;
    private TextView t6;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fenleiy_iji, container, false);

        edand  = (ExpandableListView) v.findViewById(R.id.expands);
//        t5 = (TextView) v.findViewById(R.id.t5);
//        t6  = (TextView) v.findViewById(R.id.t6);

        Okhttp.getOkhttp().getdata(url+json, ErjiBean.class, new onNetlistener() {
            @Override
            public void Onsuccess(Object o) {
                ErjiBean erjiBean = (ErjiBean) o;

                yiji.addAll(erjiBean.getDatas().getClass_list());


                for(ErjiBean.DatasBean.ClassListBean er : yiji){

                  // t5.setText(er.getGc_name());
                    String newurl = url + er.getGc_id();
                    Okhttp.getOkhttp().getdata(newurl, New.class, new onNetlistener() {
                        @Override
                        public void Onsuccess(Object o) {
                            New n = (New) o;
                            arr1.add(n.getDatas().getClass_list());

                             //   t6.setText(arr1.get(0).get(1).getGc_name());
                            edand.setAdapter(new Exerjiadater(getActivity(),yiji,arr1));
                        }
                    });

                }

                /**
                 *  做 父类的点击事件
                 */
                edand.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                    @Override
                    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                        return false;
                    }
                });

            }


        });



        return v;
    }

}

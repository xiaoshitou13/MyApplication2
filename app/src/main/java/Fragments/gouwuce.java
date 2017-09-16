package Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.man.R;
import com.example.man.Zhifu;

import java.util.ArrayList;
import java.util.List;

import Bean.StudentInfo;
import Bean.Xiangqingyes;
import Bean.Yiji;
import Myadater.MyExAdater;
import Untils.Dao;


public class gouwuce extends Fragment {

    private ListView listView;
    private List<StudentInfo> list;
    private MyExAdater myExAdater;
    private Dao dao;
    private Button jiesuan;
    private TextView textviews;
    private int jia;
    private int shu;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_gouwuce, container, false);

      //  swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.shua);


             listView = (ListView) v.findViewById(R.id.listview);
              textviews = (TextView) v.findViewById(R.id.textview);
              jiesuan = (Button) v.findViewById(R.id.js);
              dao =new Dao(getActivity());
             list = dao.findAllstudent();


             myExAdater = new MyExAdater(getActivity(),list);
             listView.setAdapter(myExAdater);


             myExAdater.setPrice(new MyExAdater.Price() {
                 @Override
                 public void jiesuan(int jiage, int shuliang) {
                     jia = jiage;
                     shu = shuliang;
                     textviews.setText("共"+shuliang+"件商品,共"+jiage+"元");
                 }

             });

             jiesuan.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {

                     Intent intent =new Intent(getActivity(), Zhifu.class);

                     intent.putExtra("price",jia);
                     intent.putExtra("liang",shu);

                     startActivity(intent);

                 }
             });

        return v;

    }




}

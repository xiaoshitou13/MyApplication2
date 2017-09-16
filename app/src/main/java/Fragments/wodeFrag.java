package Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.man.R;
import com.example.man.denglu;

import net.Okhttp;
import net.onNetlistener;

import org.w3c.dom.Text;

import Bean.Yonhudata;
import Untils.SharedpreferecnesUtils;

import static com.example.man.denglu.*;


public class wodeFrag extends Fragment{

    private TextView tv;//点击登录
    private View view;
    private RadioButton radio;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_wode, container, false);
        denglu denglu = new denglu();

        tv = (TextView) view.findViewById(R.id.dj);
        radio = (RadioButton) view.findViewById(R.id.wf);


           boolean b = (boolean) SharedpreferecnesUtils.GetData(getActivity(),"bo",false);

        if(b){
            view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    return true;
                }
            });
        }

        radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "keyy", Toast.LENGTH_SHORT).show();
            }
        });


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), denglu.class);
                    startActivity(intent);
                }
            });


            denglu.setJiekous(new jiekou() {
                @Override
                public void fangfa(final String name, int code) {
                    tv.setText(name);
                    if (code == 200) {
                        view.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                //执行别的
                                Toast.makeText(getActivity(), "200", Toast.LENGTH_SHORT).show();
                                SharedpreferecnesUtils.Setdata(getActivity(), "bo", true);
                               // getActivity().finish();
                                return true;
                            }
                        });
                    }
                }
            });

            return view;
        }



}

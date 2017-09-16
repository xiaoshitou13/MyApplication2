package Fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.man.R;
import com.xys.libzxing.zxing.activity.CaptureActivity;


public class SymActitvc extends Fragment {

    private ImageView imageview ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View  v = inflater.inflate(R.layout.fragment_sym_actitvc, container, false);

        imageview = (ImageView) v.findViewById(R.id.left);


        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(new Intent(getActivity(), CaptureActivity.class),0);

            }
        });


        return v;




    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(getActivity(), "傻了吧  哼", Toast.LENGTH_SHORT).show();
    }
}

package Myadater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.man.R;

import java.util.ArrayList;
import java.util.List;

import Bean.New;

/**
 * Created by 白玉春 on 2017/9/1.
 */

public class Greadater extends BaseAdapter {

   Context context;
   List<New.DatasBean.ClassListBean> arr;

    public Greadater(Context context, List<New.DatasBean.ClassListBean> arr) {
        this.context = context;
        this.arr = arr;
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int position) {

        return arr.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();

            convertView =View.inflate(context, R.layout.grideitem,null);

            holder.t3 = (TextView) convertView.findViewById(R.id.t3);

            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }


        holder.t3.setText(arr.get(position).getGc_name());

        return convertView;
    }

    class ViewHolder {
        TextView t3;
    }
}

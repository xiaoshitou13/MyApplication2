package Myadater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapperTransformation;
import com.example.man.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import Bean.Yonhudata;

/**
 * Created by 白玉春 on 2017/9/1.
 */

public class Lvadater extends BaseAdapter {
    Context context;
    private List<Yonhudata.DatasBean.ClassListBean> list;;
    private final DisplayImageOptions options;

    public Lvadater(Context context, List<Yonhudata.DatasBean.ClassListBean> list) {
        this.context = context;
        this.list = list;
        options = new DisplayImageOptions.Builder().cacheOnDisk(true).cacheInMemory(true).build();
    }

    @Override
    public int getCount() {
        return list !=null?list.size():0;
    }

    @Override
    public Object getItem(int position) {

        return list.get(position);
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

            convertView = LayoutInflater.from(context).inflate(R.layout.lvitem,null);

            holder.t1 = (TextView) convertView.findViewById(R.id.t1);
            holder.iv = (ImageView) convertView.findViewById(R.id.i1);
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }


        holder.t1.setText(list.get(position).getGc_name());


        String str =  list.get(position).getImage();

        String s = str.replace("192.168.56.1","169.254.157.125");

       if(list.get(position).getImage()!=null&&!list.get(position).getImage().equals("")) {
        ImageLoader.getInstance().displayImage(s, holder.iv, options);
        }

        return convertView;
    }

    class ViewHolder {
        TextView t1;
        ImageView iv;
    }
}

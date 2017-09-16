package Myadater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.man.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import net.Ip;

import java.util.List;

import Bean.StudentInfo;
import Untils.Dao;

/**
 * Created by 白玉春 on 2017/9/13.
 */

public class MyExAdater extends BaseAdapter {

    Context context;
    List<StudentInfo> list;
    private int count=1;
    private ViewHolder viewHolder;
    private Dao dao;
    private int yigong;

    public MyExAdater(Context context, List<StudentInfo> list) {
        this.context = context;
        this.list = list;
    }

    public interface Price{
        void jiesuan(int jiage,int shuliang);
    }
    public static  Price price;

    public static void setPrice(Price price) {
        MyExAdater.price = price;
    }

    @Override
    public int getCount() {
        return list.size();
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
    public View getView(final int position, View convertView, final ViewGroup parent) {

        viewHolder = null;
        if(convertView ==null){
            convertView = View.inflate(context, R.layout.gwcitem,null);
            viewHolder = new ViewHolder();
            viewHolder.image = (ImageView) convertView.findViewById(R.id.gwcimage);
            viewHolder.name = (TextView) convertView.findViewById(R.id.gwcname);
            viewHolder.peice = (TextView) convertView.findViewById(R.id.gwcprice);
            viewHolder.delete = (Button) convertView.findViewById(R.id.delete);
            viewHolder.shu = (TextView) convertView.findViewById(R.id.number);
            viewHolder.jian = (Button) convertView.findViewById(R.id.jian);
            viewHolder.jia = (Button) convertView.findViewById(R.id.jia);
            viewHolder.heji = (TextView) convertView.findViewById(R.id.heji);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String str = list.get(position).getUrl();
        String luji = str.replace("192.168.56.1", Ip.ip);
        ImageLoader.getInstance().displayImage(luji, viewHolder.image);
        viewHolder.name.setText(list.get(position).getName());
        viewHolder.peice.setText(""+list.get(position).getPrice());
        viewHolder.shu.setText(""+list.get(position).getCount());

        viewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao = new Dao(context);
                boolean b = dao.delete(list.get(position).getId());
                if(b){
                    Toast.makeText(context, "删除成功", Toast.LENGTH_SHORT).show();
                    list.remove(position);
                    notifyDataSetChanged();
                }
            }
        });

        viewHolder.jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Dao daos = new Dao(context);
                daos.updata(count,list.get(position).getId());
                list = daos.findAllstudent();
                notifyDataSetChanged();

                viewHolder.shu.setText(""+list.get(position).getCount());

                int shuliang=  list.get(position).getCount();
                double yuan = list.get(position).getPrice();

                yigong = (int) (shuliang*yuan);

                price.jiesuan(yigong,shuliang);

                viewHolder.heji.setText("共"+list.get(position).getCount()+"件商品，共"+yigong+"元");

            }
        });

        viewHolder.jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dao d = new Dao(context);
                count = list.get(position).getCount();
                count--;
                if(count>=1) {
                    d.updata(count, list.get(position).getId());
                    list = d.findAllstudent();
                    notifyDataSetChanged();
                    viewHolder.shu.setText(""+list.get(position).getCount());

                    int shuliang=  list.get(position).getCount();
                    double yuan = list.get(position).getPrice();

                    yigong= (int) (yuan*shuliang-yuan);

                    price.jiesuan(yigong,shuliang);
                    viewHolder.heji.setText("共"+list.get(position).getCount()+"件商品，共"+yigong+"元");



                }else{
                    count=1;
                }

            }
        });



        return convertView;
    }

    class ViewHolder{
        ImageView image;
        TextView name;
        TextView peice;
        TextView Number;
        Button delete;
        Button jian;
        Button jia;
        TextView shu;
        TextView heji;
    }
}

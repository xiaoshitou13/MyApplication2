package Myadater;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.man.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import net.Ip;

import java.util.List;

import Bean.Liebiao;
import Bean.Xiangqingyes;

/**
 * Created by 白玉春 on 2017/9/7.
 */

public class Recyr2 extends RecyclerView.Adapter<Recyr2.Viewholder1> {

    List<Xiangqingyes.DatasBean.GoodsCommendListBean> lists1;

    public Recyr2(List<Xiangqingyes.DatasBean.GoodsCommendListBean> lists1) {
        this.lists1 = lists1;
    }

    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public OnItemClickLitener mOnItemClickLitener;



    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    @Override
    public Viewholder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Viewholder1(LayoutInflater.from(parent.getContext()).inflate(R.layout.liebiaoye , parent ,false));
    }

    @Override
    public void onBindViewHolder(final Viewholder1 holder, int position) {
        String strr = lists1.get(position).getGoods_image_url();
        String newstrr = strr.replace("192.168.56.1", Ip.ip);
        ImageLoader.getInstance().displayImage(newstrr,holder.icon1);
        holder.tname1.setText(lists1.get(position).getGoods_name());
        holder.tprice1.setText(lists1.get(position).getGoods_promotion_price());
        holder.tyishou1.setText("已销售："+lists1.get(position).getGoods_price());

            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
    }

    @Override
    public int getItemCount() {
        return lists1 == null ? 0 : lists1.size();
    }

    public class Viewholder1 extends RecyclerView.ViewHolder{

          ImageView icon1;
          TextView tname1;
          TextView tprice1;
          TextView tyishou1;

        public Viewholder1(View itemView) {
            super(itemView);

             icon1 = (ImageView) itemView.findViewById(R.id.Liebiaoicon);
             tname1 = (TextView) itemView.findViewById(R.id.liebiapname);
             tprice1 = (TextView) itemView.findViewById(R.id.price);
             tyishou1 = (TextView) itemView.findViewById(R.id.yisou);
        }


    }
}

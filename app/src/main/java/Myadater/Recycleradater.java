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

/**
 * Created by 白玉春 on 2017/9/7.
 */

public class Recycleradater extends RecyclerView.Adapter<Recycleradater.Viewholder> {

    List<Liebiao.DatasBean.GoodsListBean> lists;

    public Recycleradater(List<Liebiao.DatasBean.GoodsListBean> lists) {
        this.lists = lists;
    }


    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view , int position);
    }

    public OnItemClickLitener mOnItemClickLitener;



    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.liebiaoye , parent ,false));
    }

    @Override
    public void onBindViewHolder(final Viewholder holder, int position) {
        String str = lists.get(position).getGoods_image_url();
        String newstr = str.replace("192.168.56.1", Ip.ip);
        ImageLoader.getInstance().displayImage(newstr,holder.icon);
        holder.tname.setText(lists.get(position).getGoods_name());
        holder.tprice.setText(lists.get(position).getGoods_price());
        holder.tyishou.setText("已销售："+lists.get(position).getGoods_salenum());

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
        return lists == null ? 0 : lists.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

          ImageView icon;
          TextView tname;
          TextView tprice;
          TextView tyishou;

        public Viewholder(View itemView) {
            super(itemView);

             icon = (ImageView) itemView.findViewById(R.id.Liebiaoicon);
             tname = (TextView) itemView.findViewById(R.id.liebiapname);
             tprice = (TextView) itemView.findViewById(R.id.price);
             tyishou = (TextView) itemView.findViewById(R.id.yisou);
        }


    }
}

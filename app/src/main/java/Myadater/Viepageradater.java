package Myadater;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.man.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import Bean.Xiangqingyes;

/**
 * Created by 白玉春 on 2017/9/8.
 */

public class Viepageradater extends PagerAdapter {

    Context context;
    List<String> enla;

    public Viepageradater(Context context, List<String> enla) {
        this.context = context;
        this.enla = enla;
    }



    @Override
    public int getCount() {
        return enla.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View v = LayoutInflater.from(context).inflate(R.layout.image ,null);
        ImageView i = (ImageView) v.findViewById(R.id.imagetup);
        String str = enla.get(position);
        ImageLoader.getInstance().displayImage(str.replace("192.168.56.1","169.254.157.125") , i);

        container.addView(v);

        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //      super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
 }

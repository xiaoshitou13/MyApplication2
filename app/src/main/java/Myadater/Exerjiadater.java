package Myadater;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.man.R;
import com.example.man.Xiangqingye;

import java.util.ArrayList;
import java.util.List;

import Bean.ErjiBean;
import Bean.New;

/**
 * Created by 白玉春 on 2017/9/1.
 */

public class Exerjiadater extends BaseExpandableListAdapter{


    Context context;

    List<ErjiBean.DatasBean.ClassListBean> erbean;
    ArrayList< List<New.DatasBean.ClassListBean> > arr;

    private TextView tv;
    private GridView gr;
    private List<New.DatasBean.ClassListBean> l;

    public Exerjiadater(Context context, List<ErjiBean.DatasBean.ClassListBean> erbean, ArrayList<List<New.DatasBean.ClassListBean>> arr) {
        this.context = context;
        this.erbean = erbean;
        this.arr = arr;
    }

    @Override
    public int getGroupCount() {

        return erbean.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return erbean.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return arr.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {

        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {

        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {


            convertView = LayoutInflater.from(context).inflate(R.layout.exejilistitem,null);
            tv = (TextView) convertView.findViewById(R.id.t2);


            tv.setText(erbean.get(groupPosition).getGc_name());

            return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        convertView = View.inflate(context,R.layout.zilst,null);

        gr = (GridView) convertView.findViewById(R.id.gridview);


               l = arr.get(groupPosition);

               gr.setAdapter(new Greadater(context, l));


        /**
         * 做子条目的点击是时间
         */
       gr.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                   Intent intent = new Intent(context, Xiangqingye.class);
                   intent.putExtra("id",l.get(position).getGc_id());
                   context.startActivity(intent);



           }
       });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {

        return false;
    }
}

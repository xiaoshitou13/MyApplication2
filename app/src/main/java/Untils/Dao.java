package Untils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import Bean.StudentInfo;

/**
 * Created by 白玉春 on 2017/9/14.
 */

public class Dao  {

    private final SQLiteDatabase db;

    public  Dao(Context context){
          Mydb mydb= new Mydb(context);
          db = mydb.getWritableDatabase();
    }


    public void insert(String name, String price, String url,int count) {
        ContentValues cv=new ContentValues();
        cv.put("name", name);
        cv.put("price", price);
        cv.put("url",url);
        cv.put("count",count);
        db.insert("person", null , cv);
    }

    public List<StudentInfo> findAllstudent(){
        List<StudentInfo> list = new ArrayList<StudentInfo>();
        Cursor cursor = db.rawQuery("select * from person",null);
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            StudentInfo info = new StudentInfo();
            info.setId(cursor.getInt(cursor.getColumnIndex("id")));
            info.setName(cursor.getString(cursor.getColumnIndex("name")));
            info.setPrice(cursor.getDouble(cursor.getColumnIndex("price")));
            info.setUrl(cursor.getString(cursor.getColumnIndex("url")));
            info.setCount(cursor.getInt(cursor.getColumnIndex("count")));
            list.add(info);
        }
        cursor.close();
        db.close();

        return list;
    }


    public boolean delete(int id) {
       int a =  db.delete("person", "id=?", new String[]{String.valueOf(id)});
        db.close();
        if(a>0){
            return true;
        }else{
            return false;
        }
    }

    public void  updata(int count,int id){
        //需要进行修改的内容
        ContentValues values = new ContentValues();
        values.put("count", count);
        //参数: 需要进行更新操作的表 , 需要更新的内容， 过滤条件 ，过滤条件的值
        //返回值： 返回受营销的行数
        db.update("person", values, "id = ?" ,new String[]{String.valueOf(id)});
     //   values.clear();
      //  Toast.makeText(this, String.valueOf(count), Toast.LENGTH_SHORT).show();
    }
}

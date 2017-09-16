package Untils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 白玉春 on 2017/9/14.
 */

public class Mydb extends SQLiteOpenHelper {
    public Mydb(Context context) {
        super(context, "My.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE  person (id integer primary key autoincrement, name varchar(20), price double,url varchar(30),count integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

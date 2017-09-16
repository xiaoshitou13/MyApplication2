package Untils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 白玉春 on 2017/8/31.
 */

public class SharedpreferecnesUtils {

    private static  final  String FILENAME = "share-frsh";


    /**
     * 保存数据用来 context 是上下文  key 是保存的名字  o 是传过来的基类
     * @param context
     * @param key
     * @param o
     */
    public static void  Setdata(Context context , String key,Object o){
       //判断传过来是什么类型
       String type = o.getClass().getSimpleName();

       SharedPreferences sh = context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);

       SharedPreferences.Editor ed = sh.edit();

       if("String".equals(type)){
           ed.putString(key, (String) o);
       }else if("Boolean" .equals(type)){
           ed.putBoolean(key, (Boolean) o);
       }else if("Integer".equals(type)){
           ed.putInt(key, (Integer) o);
       }else if("Float".equals(type)){
           ed.putFloat(key, (Float) o);
       }else if("Long".equals(type)){
           ed.putLong(key, (Long) o);
       }

       ed.commit();

    }



    public static Object GetData(Context context, String keys, Object os){

      String types =   os.getClass().getSimpleName();

      SharedPreferences sh =   context.getSharedPreferences(FILENAME,Context.MODE_PRIVATE);

        if("String".equals(types)){
          return  sh.getString(keys, (String) os);
        }else if("Boolean" .equals(types)){
            return  sh.getBoolean(keys, (Boolean) os);
        }else if("Integer".equals(types)){
          return  sh.getInt(keys, (Integer) os);
        }else if("Float".equals(types)){
            return  sh.getFloat(keys, (Float) os);
        }else if("Long".equals(types)){
            return  sh.getLong(keys, (Long) os);
        }
          return  null;
    }

}

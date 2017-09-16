package net;

import android.content.Context;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.PostFormBuilder;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.Map;

/**
 * Created by 白玉春 on 2017/9/1.
 */

public class Okhttp {

    private  static  volatile  Okhttp okhttp;


    private final Gson gson;

    private Okhttp(){

        gson = new Gson();
    }

    public static  Okhttp getOkhttp(){
        if(okhttp ==null){
            synchronized (Okhttp.class){
                if(okhttp == null){
                    okhttp=new Okhttp();
                }
            }
        }
        return okhttp;
    }

   public void getdata(  final String url, final Class clazz, final onNetlistener onnetlistener ) {


           OkHttpUtils.get().url(url).build().execute(new StringCallback() {
               @Override
               public void onError(Request request, Exception e) {

               }

               @Override
               public void onResponse(String response) {
                   if (onnetlistener != null) {
                       Object o = gson.fromJson(response, clazz);
                       onnetlistener.Onsuccess(o);
                   }
               }
           });
   }

   public void post(Context context , String url , Map<String,String> map, final Class clazz, final onNetlistener onnetlistrner){

       PostFormBuilder builder = OkHttpUtils.post().url(url);

       for(Map.Entry<String,String> entry : map.entrySet()){
           builder.addParams(entry.getKey(),entry.getValue());
       }

      builder.build().execute(new StringCallback() {
          @Override
          public void onError(Request request, Exception e) {

          }

          @Override
          public void onResponse(String response) {

              Object o=   new  Gson().fromJson(response,clazz);
              onnetlistrner.Onsuccess(o);
          }
      });
   }



    }

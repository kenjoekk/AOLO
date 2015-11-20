package com.library.model;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * Created by ChiaChia on 15/11/19.
 */
public class MySqlIO {
    public MySqlIO(){

    }
    //暫存的SQLite資料寫入MySQL後並刪除, 從線上拉下來的資料要刪掉重拉

    public void getUserProfile(String cus_id){//改到sqlite去
        String url="http://59.126.173.220/Aolo/getData.php?cmd=userProfile&cus_id="+cus_id;

        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.i("test", jsonObject.toString());
                //這邊把資料趴出來~~~
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.i("test", volleyError.toString());
            }
        });

        MyApplication.getInstance().addToRequestQueue(request);
    }
}

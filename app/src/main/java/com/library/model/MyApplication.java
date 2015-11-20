package com.library.model;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.Volley;

/**
 * Created by ChiaChia on 15/11/19.
 */
public class MyApplication extends Application{
    public static final String TAG="VolleyPatterns";
    private RequestQueue mRequestQueue;
    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance=this;
    }

    // 將application做成singleton
    public static synchronized MyApplication getInstance(){
        return sInstance;
    }

    //  獲得Volley的RequestQueue
    public RequestQueue getmRequestQueue(){
        if (mRequestQueue==null){
            mRequestQueue= Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public  void addToRequestQueue(Request req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        VolleyLog.d("Adding request to queue: %s", req.getUrl());
        getmRequestQueue().add(req);
    }

    public  void addToRequestQueue(Request req) {
        // set the default tag if tag is empty
        req.setTag(TAG);
        getmRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}

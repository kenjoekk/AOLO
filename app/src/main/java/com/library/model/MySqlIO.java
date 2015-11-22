package com.library.model;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ChiaChia on 15/11/19.
 */
public class MySqlIO {
    public MySqlIO() {

    }
    //暫存的SQLite資料寫入MySQL後並刪除, 從線上拉下來的資料要刪掉重拉

//    public JSONArray getUserProfile(String cus_id) {//改到sqlite去
//        String url = "http://59.126.173.220/Aolo/getData.php?cmd=userProfile&cus_id=" + cus_id;
//        final JSONArray jsonArray = new JSONArray();
//        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray array) {
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//
//            }
//        });
//
//
////        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
////            @Override
////            public void onResponse(JSONObject jsonObject) {
////                Log.i("test", jsonObject.toString());
////
////            }
////        }, new Response.ErrorListener() {
////            @Override
////            public void onErrorResponse(VolleyError volleyError) {
////                Log.i("test", volleyError.toString());
////            }
////        });
//
//        MyApplication.getInstance().addToRequestQueue(request);
//    }

    // TODO 從MySQL拉資料下來需要在背景執行
    public void queryCustomer(String cus_id){
        String url="http://59.126.173.220/Aolo/getData.php?cmd=queryCustomer&cus_id="+cus_id;
        JsonArrayRequest request=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                Log.i("test", jsonArray.toString());
                SqliteIO io=new SqliteIO();
                io.fromMySQL(jsonArray, 1);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        MyApplication.getInstance().addToRequestQueue(request);
    }

    public void queryRoute(String cus_id){
        String url="http://59.126.173.220/Aolo/getData.php?cmd=queryRoute&cus_id="+cus_id;
        JsonArrayRequest request=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                Log.i("test", jsonArray.toString());
                SqliteIO io=new SqliteIO();
                io.fromMySQL(jsonArray, 2);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        MyApplication.getInstance().addToRequestQueue(request);
    }

    public void queryFavoRoute(String cus_id){
        String url="http://59.126.173.220/Aolo/getData.php?cmd=queryFavoRoute&cus_id="+cus_id;
        JsonArrayRequest request=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                Log.i("test", jsonArray.toString());
                SqliteIO io=new SqliteIO();
                io.fromMySQL(jsonArray, 3);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        MyApplication.getInstance().addToRequestQueue(request);
    }

    public void queryPhotoRecord(String cus_id){
        String url="http://59.126.173.220/Aolo/getData.php?cmd=queryPhotoRecord&cus_id="+cus_id;
        JsonArrayRequest request=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                Log.i("test", jsonArray.toString());
                SqliteIO io=new SqliteIO();
                io.fromMySQL(jsonArray, 4);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        MyApplication.getInstance().addToRequestQueue(request);
    }

    public void queryCommunity(String cus_id){
        String url="http://59.126.173.220/Aolo/getData.php?cmd=queryCommunity&cus_id="+cus_id;
        JsonArrayRequest request=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                Log.i("test", jsonArray.toString());
                SqliteIO io=new SqliteIO();
                io.fromMySQL(jsonArray, 5);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        MyApplication.getInstance().addToRequestQueue(request);
    }

    public void queryMember(String cus_id){
        String url="http://59.126.173.220/Aolo/getData.php?cmd=queryMember&cus_id="+cus_id;
        JsonArrayRequest request=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                Log.i("test", jsonArray.toString());
                SqliteIO io=new SqliteIO();
                io.fromMySQL(jsonArray, 6);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        MyApplication.getInstance().addToRequestQueue(request);
    }

    public void queryPal(String cus_id){
        String url="http://59.126.173.220/Aolo/getData.php?cmd=queryPal&cus_id="+cus_id;
        JsonArrayRequest request=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                Log.i("test", jsonArray.toString());
                SqliteIO io=new SqliteIO();
                io.fromMySQL(jsonArray, 7);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        MyApplication.getInstance().addToRequestQueue(request);
    }

    public void queryTask(String cus_id){
        String url="http://59.126.173.220/Aolo/getData.php?cmd=queryTask&cus_id="+cus_id;
        JsonArrayRequest request=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                Log.i("test", jsonArray.toString());
                SqliteIO io=new SqliteIO();
                io.fromMySQL(jsonArray, 8);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        MyApplication.getInstance().addToRequestQueue(request);
    }

    public void queryTaskRecord(String cus_id){
        String url="http://59.126.173.220/Aolo/getData.php?cmd=queryTaskRecord&cus_id="+cus_id;
        JsonArrayRequest request=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                Log.i("test", jsonArray.toString());
                SqliteIO io=new SqliteIO();
                io.fromMySQL(jsonArray, 9);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        MyApplication.getInstance().addToRequestQueue(request);
    }

    public void querySportRecord(String cus_id){
        String url="http://59.126.173.220/Aolo/getData.php?cmd=querySportRecord&cus_id="+cus_id;
        JsonArrayRequest request=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                Log.i("test", jsonArray.toString());
                SqliteIO io=new SqliteIO();
                io.fromMySQL(jsonArray, 10);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        MyApplication.getInstance().addToRequestQueue(request);
    }

    //TODO 上傳到MySQL
    public void signIn(){
    }

    public void signUp(){
    }

    public void updateCustomer(){

    }
    public void updateCustRoute(){

    }
    public void updateFavoRoute(){

    }
    public void updatePhotoRecord(){

    }
    public void updateCommunity(){

    }
    public void updateMember(){

    }
    public void updatePal(){
        Log.i("test", "updatePal");
        String url="http://192.168.43.109/aolo/insertData.php";
        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.i("test", s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.i("test", volleyError.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("cmd", "updatePal");
                return params;
            }
        };

    }
    public void updateTask(){

    }
    public void updateTaskRecord(){

    }
    public void updateSportRecord(){

    }



}



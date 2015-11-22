package com.library.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ChiaChia on 15/11/19.
 */
public class SqliteIO {
    private SQLiteDatabase db;
    private Context context=MyApplication.getInstance().getApplicationContext();
    public SqliteIO(){
        db=DBHelper.getInstance(context).getWritableDatabase();
    }

    //對SQLite做操作, 回傳cursor
    public void writeIntoSQLite (){
        //從MySQL 拉資料寫入Sqlite
        db.execSQL("insert into pal (cus_id, pal_id) values (1, 1)");
        Log.i("test", "insert suessce");
    }

    //新增路線, 寫入Sqlite

    //撈推薦路線
    //撈出硬體數據寫入SQLite
    //撈出個人資料
//    select * from (Select cus_name, cus_photo, cus_level, cus_id from customer where cus_id=1) t1 join (Select SUM(sport_acc), AVG(sport_speed), COUNT(cus_id), MAX(sport_speed), AVG(sport_cad), AVG(sport_heart), cus_id from sport_record where cus_id=1) t2 on t1.cus_id=t2.cus_id
    public Cursor getUserProfile(){
        db.execSQL("select * from (Select cus_name, cus_photo, cus_level, cus_id from customer where cus_id=1) t1 join (Select SUM(sport_acc), AVG(sport_speed), COUNT(cus_id), MAX(sport_speed), AVG(sport_cad), AVG(sport_heart), cus_id from sport_record where cus_id=1) t2 on t1.cus_id=t2.cus_id");
        return null;
    }

    public Cursor testTest(){
        Cursor cursor=db.rawQuery("select * from pal", null);
        return cursor;
    }


    public void fromMySQL(JSONArray array, int cmd){
        switch (cmd){
            case 1:
                for (int i=0; i<array.length(); i++){
                    try {
                        JSONObject obj=array.getJSONObject(i);
                        //TODO 把抓到的資料寫入Sqlite
                        Log.i("test", obj.getString("cus_name"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 2:
                for (int i=0; i<array.length(); i++){
                    try {
                        JSONObject obj=array.getJSONObject(i);
                        //TODO 把抓到的資料寫入Sqlite
                        Log.i("test", obj.getString("cus_name"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 3:
                for (int i=0; i<array.length(); i++){
                    try {
                        JSONObject obj=array.getJSONObject(i);
                        //TODO 把抓到的資料寫入Sqlite
                        Log.i("test", obj.getString("cus_name"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 4:
                for (int i=0; i<array.length(); i++){
                    try {
                        JSONObject obj=array.getJSONObject(i);
                        //TODO 把抓到的資料寫入Sqlite
                        Log.i("test", obj.getString("cus_name"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 5:
                for (int i=0; i<array.length(); i++){
                    try {
                        JSONObject obj=array.getJSONObject(i);
                        //TODO 把抓到的資料寫入Sqlite
                        Log.i("test", obj.getString("cus_name"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 6:
                for (int i=0; i<array.length(); i++){
                    try {
                        JSONObject obj=array.getJSONObject(i);
                        //TODO 把抓到的資料寫入Sqlite
                        Log.i("test", obj.getString("cus_name"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 7:
                for (int i=0; i<array.length(); i++){
                    try {
                        JSONObject obj=array.getJSONObject(i);
                        //TODO 把抓到的資料寫入Sqlite
                        Log.i("test", obj.getString("cus_name"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 8:
                for (int i=0; i<array.length(); i++){
                    try {
                        JSONObject obj=array.getJSONObject(i);
                        //TODO 把抓到的資料寫入Sqlite
                        Log.i("test", obj.getString("cus_name"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 9:
                for (int i=0; i<array.length(); i++){
                    try {
                        JSONObject obj=array.getJSONObject(i);
                        //TODO 把抓到的資料寫入Sqlite
                        Log.i("test", obj.getString("cus_name"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 10:
                for (int i=0; i<array.length(); i++){
                    try {
                        JSONObject obj=array.getJSONObject(i);
                        //TODO 把抓到的資料寫入Sqlite
                        Log.i("test", obj.getString("cus_name"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }



    }


}

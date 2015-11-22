package com.library.model;

import android.content.ContentValues;
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

//        Cursor c=db.rawQuery("select * from (Select cus_name, cus_photo, cus_level, cus_id from customer where cus_id=1) t1 join (Select SUM(sport_acc), AVG(sport_speed), COUNT(cus_id), MAX(sport_speed), AVG(sport_cad), AVG(sport_heart), cus_id from sport_record where cus_id=1) t2 on t1.cus_id=t2.cus_id", null);
        Cursor c=db.rawQuery("select * from customer",null);
//        Log.i("test", c.getString(c.getColumnIndex("cus_name")));
        return c;
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
                        Log.i("test", obj.getString("cus_id"));
                        ContentValues cv=new ContentValues();
                        cv.put("cus_id", obj.getString("cus_id"));
                        cv.put("cus_account", obj.getString("cus_account"));
                        cv.put("cus_pwd", obj.getString("cus_pwd"));
                        cv.put("cus_sid", obj.getString("cus_sid"));
                        cv.put("cus_name", obj.getString("cus_name"));
                        cv.put("cus_facebook", obj.getString("cus_facebook"));
                        cv.put("cus_tel", obj.getString("cus_tel"));
                        cv.put("cus_gender", obj.getString("cus_gender"));
                        cv.put("cus_email", obj.getString("cus_email"));
                        cv.put("cus_address", obj.getString("cus_address"));
                        cv.put("cus_date", obj.getString("cus_date"));
                        cv.put("cus_photo", obj.getString("cus_photo"));
                        cv.put("cus_birth", obj.getString("cus_birth"));
                        cv.put("cus_level", obj.getString("cus_level"));
                        cv.put("cus_exp", obj.getString("cus_exp"));
                        cv.put("cus_logtime", obj.getString("cus_logtime"));
                        cv.put("cus_lat", obj.getString("cus_lat"));
                        cv.put("cus_lng", obj.getString("cus_lng"));
                        cv.put("cus_public", obj.getString("cus_public"));
                        cv.put("isUp", 1);
                        db.insert("customer", null, cv);


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

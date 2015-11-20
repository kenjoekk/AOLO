package com.library.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import java.io.File;

/**
 * Created by ChiaChia on 15/11/19.
 */
public class DBHelper extends SQLiteOpenHelper {
    private File sdroot=Environment.getExternalStorageDirectory();

    private static DBHelper dbInstance;
    private static final String DATABASE_NAME = "aolo";
    private static final int DATABASE_VERSION =2015111601;

    private static final String createCommunityTable=
            "CREATE TABLE community (com_id INTEGER PRIMARY KEY, com_name TEXT, com_icon TEXT, com_date INTEGER, com_level TEXT, com_preid INTEGER, com_viceid INTEGER, com_secid INTEGER)";
    private static final String createCustomerTable=
            "CREATE TABLE customer (cus_id INTEGER PRIMARY KEY, cus_account TEXT, cus_pwd TEXT, cus_sid TEXT, cus_name TEXT, cus_facebook TEXT, cus_tel TEXT, cus_gender INTEGER, cus_email TEXT, cus_address TEXT, cus_date INTEGER, cus_photo TEXT, cus_birth DATE, cus_level TEXT, cus_exp TEXT, cus_logtime INTEGER, cus_lat TEXT, cus_lng TEXT, cus_public INTEGER)";
    private static final String createFavoritesRouteTable=
            "CREATE TABLE favorites_route (fav_no INTEGER PRIMARY KEY, cus_id INTEGER, route_id INTEGER)";
    private static final String createMemberTable=
            "CREATE TABLE member (member_no INTEGER PRIMARY KEY, com_id INTEGER, cus_id INTEGER, pal_check INTEGER)";
    private static final String createPalTable=
            "CREATE TABLE pal (pal_no INTEGER PRIMARY KEY, cus_id INTEGER, pal_id INTEGER, pal_check INTEGER)";
    private static final String createPhotoRecordlTable=
            "CREATE TABLE photo_record (photo_no INTEGER PRIMARY KEY, cus_id INTEGER, task_id INTEGER, route_id INTEGER, photo_date DATE, photo_time TEXT, photo_lat TEXT, photo_lng TEXT, photo_path TEXT)";
    private static final String createRouteTable=
            "CREATE TABLE route (route_no INTEGER , route_id INTEGER, route_name TEXT, route_seq INTEGER, route_lat TEXT, route_lng TEXT, route_alt TEXT, route_scenery TEXT, cus_id INTEGER, route_share INTEGER, route_public INTEGER, route_demo TEXT)";
    private static final String createSportRecordTable=
            "CREATE TABLE sport_record (sportrec_no INTEGER PRIMARY KEY, cus_id INTEGER, task_id INTEGER, route_id INTEGER, sport_date INTEGER, sport_time INTEGER, sprot_lat TEXT, sport_lng TEXT, sport_acc TEXT, sport_alt TEXT, sport_gpssp TEXT, sport_speed TEXT, sport_heart TEXT, sport_cad TEXT)";
    private static final String createTaskTable=
            "CREATE TABLE task (task_id INTEGER PRIMARY KEY, task_name TEXT, cus_id INTEGER, task_date INTEGER, route_id INTEGER, task_dis INTEGER, task_time INTEGER, task_heart INTEGER, task_cad INTEGER, task_sp INTEGER, task_exp TEXT)";
    private static final String createTaskRecordTable=
            "CREATE TABLE task_record (taskrec_no INTEGER PRIMARY KEY, cus_id INTEGER, task_id INTEGER, route_id INTEGER, taskrec_date INTEGER, taskrec_start INTEGER, taskrec_end INTEGER, taskrec_dis INTEGER, taskrec_complete INTEGER, taskrec_maxsp INTEGER, taskrec_avgsp INTEGER, taskrec_maxcad INTEGER, taskrec_avgcad INTEGER, taskrec_maxheart INTEGER, taskrec_avgheart INTEGER, taskrec_cal INTEGER, taskrec_title TEXT)";


    //  手機暫存
    private static final String createCommunityUPTable=
            "CREATE TABLE communityUP (com_id INTEGER PRIMARY KEY, com_name TEXT, com_icon TEXT, com_date INTEGER, com_level TEXT, com_preid INTEGER, com_viceid INTEGER, com_secid INTEGER)";
    private static final String createCustomerUPTable=
            "CREATE TABLE customerUP (cus_id INTEGER PRIMARY KEY, cus_account TEXT, cus_pwd TEXT, cus_sid TEXT, cus_name TEXT, cus_facebook TEXT, cus_tel TEXT, cus_gender INTEGER, cus_email TEXT, cus_address TEXT, cus_date INTEGER, cus_photo TEXT, cus_birth DATE, cus_level TEXT, cus_exp TEXT, cus_logtime INTEGER, cus_lat TEXT, cus_lng TEXT, cus_public INTEGER)";
    private static final String createFavoritesRouteUPTable=
            "CREATE TABLE favorites_routeUP (fav_no INTEGER PRIMARY KEY, cus_id INTEGER, route_id INTEGER)";
    private static final String createMemberUPTable=
            "CREATE TABLE memberUP (member_no INTEGER PRIMARY KEY, com_id INTEGER, cus_id INTEGER, pal_check INTEGER)";
    private static final String createPalUPTable=
            "CREATE TABLE palUP (pal_no INTEGER PRIMARY KEY, cus_id INTEGER, pal_id INTEGER, pal_check INTEGER)";
    private static final String createPhotoRecordlUPTable=
            "CREATE TABLE photo_recordUP (photo_no INTEGER PRIMARY KEY, cus_id INTEGER, task_id INTEGER, route_id INTEGER, photo_date DATE, photo_time TEXT, photo_lat TEXT, photo_lng TEXT, photo_path TEXT)";
    private static final String createRouteUPTable=
            "CREATE TABLE routeUP (route_no INTEGER , route_id INTEGER, route_name TEXT, route_seq INTEGER, route_lat TEXT, route_lng TEXT, route_alt TEXT, route_scenery TEXT, cus_id INTEGER, route_share INTEGER, route_public INTEGER, route_demo TEXT)";
    private static final String createSportRecordUPTable=
            "CREATE TABLE sport_recordUP (sportrec_no INTEGER PRIMARY KEY, cus_id INTEGER, task_id INTEGER, route_id INTEGER, sport_date INTEGER, sport_time INTEGER, sprot_lat TEXT, sport_lng TEXT, sport_acc TEXT, sport_alt TEXT, sport_gpssp TEXT, sport_speed TEXT, sport_heart TEXT, sport_cad TEXT)";
    private static final String createTaskUPTable=
            "CREATE TABLE taskUP (task_id INTEGER PRIMARY KEY, task_name TEXT, cus_id INTEGER, task_date INTEGER, route_id INTEGER, task_dis INTEGER, task_time INTEGER, task_heart INTEGER, task_cad INTEGER, task_sp INTEGER, task_exp TEXT)";
    private static final String createTaskRecordUPTable=
            "CREATE TABLE task_recordUP (taskrec_no INTEGER PRIMARY KEY, cus_id INTEGER, task_id INTEGER, route_id INTEGER, taskrec_date INTEGER, taskrec_start INTEGER, taskrec_end INTEGER, taskrec_dis INTEGER, taskrec_complete INTEGER, taskrec_maxsp INTEGER, taskrec_avgsp INTEGER, taskrec_maxcad INTEGER, taskrec_avgcad INTEGER, taskrec_maxheart INTEGER, taskrec_avgheart INTEGER, taskrec_cal INTEGER, taskrec_title TEXT)";

    // 硬體數據儲存
    private static final String createHardwareData=
            "CREATE TABLE hardwareData (heaet_rate INTEGER, cad INTEGER, speed INTEGER, date DATE, time TEXT)";

    //建構子
    private DBHelper(Context context){ //參數建構子
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //將DB做成實體物件
    public static synchronized DBHelper getInstance(Context context){
        if (dbInstance==null){
            dbInstance=new DBHelper(context.getApplicationContext());
        }
        return dbInstance;
    }

    @Override //創建table
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createCommunityTable);
        db.execSQL(createCustomerTable);
        db.execSQL(createFavoritesRouteTable);
        db.execSQL(createMemberTable);
        db.execSQL(createPalTable);
        db.execSQL(createPhotoRecordlTable);
        db.execSQL(createRouteTable);
        db.execSQL(createSportRecordTable);
        db.execSQL(createTaskTable);
        db.execSQL(createTaskRecordTable);
        db.execSQL(createCommunityUPTable);
        db.execSQL(createCustomerUPTable);
        db.execSQL(createFavoritesRouteUPTable);
        db.execSQL(createMemberUPTable);
        db.execSQL(createPalUPTable);
        db.execSQL(createPhotoRecordlUPTable);
        db.execSQL(createRouteUPTable);
        db.execSQL(createSportRecordUPTable);
        db.execSQL(createTaskUPTable);
        db.execSQL(createTaskRecordUPTable);
        db.execSQL(createHardwareData);
        Log.i("test","Create db suesses");
    }

    @Override//當DB做更動時
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

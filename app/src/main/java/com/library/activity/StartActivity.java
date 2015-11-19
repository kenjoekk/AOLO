package com.library.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by joseph on 15/11/14.
 */
public class StartActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

    }
    public void set(View v){

        Toast.makeText(this,"gotosetdialog",Toast.LENGTH_SHORT).show();


    }
    public void start(View v){
        Toast.makeText(this,"gotostartdialog",Toast.LENGTH_SHORT).show();
        Intent it =new Intent(this,StartRunActivity.class);
        startActivityForResult(it, 1);
    }
    public void missionNormal(View v){
        Toast.makeText(this,"gotomissionNormaldialog",Toast.LENGTH_SHORT).show();

    }
    public void missionRoad(View v){
        Toast.makeText(this,"gotomissionRoaddialog",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        if(requestCode==1){

            finish();
        }
    }
}

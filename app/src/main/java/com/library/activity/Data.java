package com.library.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by joseph on 15/11/19.
 */



public class Data extends Activity{

    private ListView dataList;
    private LinkedList<Map<String,String>> Ddata=new LinkedList<Map<String,String>>();
    private String[] Dfrom={"D1","D2"};
    private int[] Dto={R.id.dataDis1,R.id.dataDis2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);


        dataList=(ListView)findViewById(R.id.dataList);

        changeList();

    }
    private void changeList(){

        Map<String,String> dMap =new HashMap<String, String>();

        dMap.put(Dfrom[0], "距離");
        dMap.put(Dfrom[1], "10KM");
        Ddata.add(dMap);


        SimpleAdapter adapter =new SimpleAdapter(this,Ddata,R.layout.list_data,Dfrom,Dto);
        dataList.setAdapter(adapter);
    }
    public void backData(View v){

        Intent it=new Intent(this,ShareActivity.class);
        startActivityForResult(it, 1);

    }
    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        if(requestCode==1){

            finish();
        }
    }

}

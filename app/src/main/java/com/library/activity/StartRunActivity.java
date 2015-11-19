package com.library.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by joseph on 15/11/14.
 */
public class StartRunActivity extends Activity{


    Button pauseButton,cameraButton,exitButton;
    int change=0; //0=開始 1=暫停
    int i;
    private TextView textView2;
    private mTask Task;
    private Timer timer;
    private static final int UI_CHANGE=1;
    private UIHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startrun);

        pauseButton=(Button)findViewById(R.id.pauseButton);
        cameraButton=(Button)findViewById(R.id.cameraButton);
        exitButton=(Button)findViewById(R.id.exitButton);

        cameraButton.setVisibility(cameraButton.INVISIBLE);
        exitButton.setVisibility(exitButton.INVISIBLE);

        textView2=(TextView)findViewById(R.id.textView2);

        handler=new UIHandler();

        timer =new Timer();

        getTime();





    }
    public void toPause(View v){

        if(change==0) {
            cameraButton.setVisibility(cameraButton.VISIBLE);
            exitButton.setVisibility(exitButton.VISIBLE);
            Task.cancel();
            exitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("KK","++");
                    Intent it =new Intent(StartRunActivity.this,ExitActivity.class);
                    startActivityForResult(it,1);
                }
            });
            pauseButton.setText("開始按鈕");
            change=1;
        }else if(change==1){

            cameraButton.setVisibility(cameraButton.INVISIBLE);
            exitButton.setVisibility(exitButton.INVISIBLE);
            pauseButton.setText("暫停按鈕");

            change=0;


            Task=new mTask();
            timer.schedule(Task,0, 1000);


        }


    }
    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        if(requestCode==1){

            finish();
        }
    }
    private void getTime(){

        Task=new mTask();
        timer.schedule(Task, 3000, 1000);


    }
    private class mTask extends TimerTask{
        @Override
        public void run() {

            i++;
            handler.sendEmptyMessage(UI_CHANGE);

            Log.i("KK",""+i);
        }
    }
    private class UIHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case  UI_CHANGE:
                    textView2.setText(""+i);

                    break;

            }
        }
    }

}

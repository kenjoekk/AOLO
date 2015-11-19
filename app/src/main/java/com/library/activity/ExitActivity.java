package com.library.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by joseph on 15/11/14.
 */
public class ExitActivity extends Activity {
    private Button shareb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);

        shareb1=(Button)findViewById(R.id.shareb1);
        shareb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ExitActivity.this,ShareActivity.class);
                startActivityForResult(it,1);
            }
        });
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        if(requestCode==1){

            finish();
        }
    }
}

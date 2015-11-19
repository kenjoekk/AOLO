package com.library.activity;

import android.app.Activity;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

/**
 * Created by joseph on 15/11/15.
 */
public class ShareActivity extends Activity{

    private WebView webView;
    private LocationManager lmgr;
    private ImageView iv_add,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        lmgr=(LocationManager)getSystemService(LOCATION_SERVICE);

        webView=(WebView)findViewById(R.id.webView);
        back=(ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent it =new Intent(ShareActivity.this, MainActivity.class);
//                startActivityForResult(it,1);

                finish();
            }
        });
        iv_add = (ImageView)findViewById(R.id.iv_add);
        iv_add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent it =new Intent(ShareActivity.this, StartActivity.class);

                startActivityForResult(it,1);
            }
        });
        initWebView();


    }
    private void initWebView(){

        MyWebClient client =new MyWebClient();
        webView.setWebViewClient(client);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);


        webView.loadUrl("file:///android_asset/MyMap.html");

    }
    private class MyWebClient extends WebViewClient{

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        if(requestCode==1){

            finish();
        }
    }
}

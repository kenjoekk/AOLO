package com.library.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class Login extends Activity {

	
	private String strAccount, strPasswd;
	private String PIN;
	private EditText account,passwd;
	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0:
				Log.i("brad", "5");
				show();

				break;
				
			

			default:
				break;
			}
		}

	};
	
	public void show() {
		Log.i("brad", "6");
		
		Toast.makeText(this, "新增完成", Toast.LENGTH_SHORT).show();
		Intent it=new Intent(Login.this,MainActivity.class);
		 
		startActivityForResult(it, 1);
		
	}
	
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==1){
			finish();
		}
		
	}
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		PIN = Build.SERIAL;
		account = (EditText) findViewById(R.id.account);
		passwd = (EditText) findViewById(R.id.passwd);
		Toast.makeText(this, "首次使用請先完善個人資料", Toast.LENGTH_SHORT).show();
		Log.i("brad", "TOAST");
	}
	
	
	public void enterOK(View v){
		String acc,pw;

		acc=account.getText().toString();
		pw=passwd.getText().toString();
//
		Log.i("brad", "acc:" + acc + "pw:" + pw);
		if(!(acc.equals(""))&&!(pw.equals(""))) {
			Log.i("brad", "die");
			new LoginPostThread().start();
		}
	}
	
	
private class LoginPostThread extends Thread {
		

		public LoginPostThread() {



			strAccount = account.getText().toString();
			strPasswd = passwd.getText().toString();
		}

		@Override
		public void run() {
			Log.i("brad", "run");
			try {
				URL url = new URL("http://59.126.173.220/Aolo/enter.php");
				Log.i("brad", "online");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setReadTimeout(5 * 1000);
				conn.setConnectTimeout(10 * 1000);
				Log.i("brad", "bPOST");
				conn.setRequestMethod("POST");
				Log.i("brad", "aPOST");
				// 處理輸入的參數
				ArrayList<NameValuePair> parms = new ArrayList<NameValuePair>();
				parms.add(new BasicNameValuePair("account", strAccount));
				parms.add(new BasicNameValuePair("passwd", strPasswd));
				parms.add(new BasicNameValuePair("pin", PIN));
				Log.i("brad", strAccount);
				// 處理輸入參數的輸出串流
				OutputStream os = conn.getOutputStream();
				Log.i("brad", "os:" + os);
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
				writer.write(getQuery(parms));
				Log.i("brad", getQuery(parms));
				writer.flush();
				Log.i("brad", "flush");
				writer.close();

				conn.connect();

				BufferedReader rin = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String result = rin.readLine();
				rin.close();
				Log.i("brad", "" + result);
				
				
				
				
				if (result.equals("OK")) {
					Log.i("brad", "LOG_OK");

					

					 
				} else {
					mHandler.sendEmptyMessage(0);
					Log.i("brad", "NONONONONONOO");
					
				}
			} catch (MalformedURLException e) {
			} catch (IOException e) {
			}
		}
	}

	private String getQuery(ArrayList<NameValuePair> p) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		for (NameValuePair pair : p) {
			if (isFirst)
				isFirst = false;
			else
				sb.append("&");

			sb.append(URLEncoder.encode(pair.getName(), "UTF-8"));
			sb.append("=");
			sb.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
		}
		return sb.toString();
	}

}
	


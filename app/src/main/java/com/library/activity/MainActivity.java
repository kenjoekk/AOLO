package com.library.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.library.fragment.IdentityFragment;
import com.library.fragment.RankFragment;
import com.library.fragment.RideBikeFragment;
import com.library.fragment.RoutineFragment;
import com.library.fragment.RecodeFragment;
import com.library.fragment.SocietyFragment;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;

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


public class MainActivity extends FragmentActivity implements
        View.OnClickListener, OnCheckedChangeListener {

    public ResideMenu resideMenu;

    private ResideMenuItem itemGuanZhangEmail;
    private ResideMenuItem itemGrRenXinXi;
    private ResideMenuItem itemZhuangban;
    private ResideMenuItem itemShoucang;
    private ResideMenuItem itemXiangce;
    private ResideMenuItem itemShare;
    public boolean paagee =true;


    DisplayMetrics dm = new DisplayMetrics();
    int Width, Height;
/* private ResideMenuInfo info; */

    private TextView text1, text2, text3;

    private boolean is_closed = false;
    private long mExitTime;


    private String PIN;


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

    private void show() {

        Toast.makeText(MainActivity.this, "載入成功", Toast.LENGTH_SHORT).show();

    }

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeFragment(new RideBikeFragment());
        PIN = Build.SERIAL;
        Log.i("brad",""+paagee);



        new LoginPostThread().start();

        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        // 寬
        Width = dm.widthPixels;
        // 高
        Height = dm.heightPixels;
        Log.i("brad", "Width:" + Width + "Height" + Height);

        setUpMenu();
        //changeFragment(new SocietyFragment());
        setListener();
        paagee=false;
        Log.i("brad",""+paagee);
    }



    private void changepage() {
        paagee = true;
        Log.i("brad",""+paagee);
        changeFragment(new RecodeFragment());

        resideMenu.closeMenu();

    }


    private class LoginPostThread extends Thread {

        public LoginPostThread() {

        }

        @Override
        public void run() {
            Log.i("brad", "run");
            try {
                URL url = new URL("http://59.126.173.220/Aolo/checkPIN.php");
                Log.i("brad", "online");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(5 * 1000);
                conn.setConnectTimeout(10 * 1000);
                Log.i("brad", "bPOST");
                conn.setRequestMethod("POST");
                Log.i("brad", "aPOST");
                // 處理輸入的參數
                ArrayList<NameValuePair> parms = new ArrayList<NameValuePair>();
                Log.i("brad", PIN);
                parms.add(new BasicNameValuePair("pin", PIN));
                Log.i("brad", getQuery(parms));
                // 處理輸入參數的輸出串流
                OutputStream os = conn.getOutputStream();
                Log.i("brad", "" + os);

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                Log.i("brad", "BufferedWriter");
                writer.write(getQuery(parms));
                Log.i("brad", "write");
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
                    mHandler.sendEmptyMessage(0);

                    // mHandler.sendEmptyMessage(0);
                    //
                    // Intent it=new Intent(Login.this,MainActivity.class);
                    // it.putExtra("account",strAccount );
                    // startActivity(it);
                } else {

                    Log.i("brad", "gotologin");
                    Intent it = new Intent(MainActivity.this, SplashActivity.class);
                    startActivityForResult(it, 1);

                }
            } catch (MalformedURLException e) {
            } catch (IOException e) {
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            paagee = false;
            finish();
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


    private void setUpMenu() {


        // attach to current activity;
        resideMenu = new ResideMenu(this);
        resideMenu.setBackground(R.drawable.test);
        resideMenu.attachToActivity(this);

        resideMenu.setMenuListener(menuListener);
        // valid scale factor is between 0.0f and 1.0f. leftmenu'width is
        // 150dip.
        resideMenu.setScaleValue(0.6f);

        // 禁止使用右侧菜单
        resideMenu.setDirectionDisable(ResideMenu.DIRECTION_RIGHT);

        // create menu items;
        itemGuanZhangEmail = new ResideMenuItem(this, "騎乘");
        itemGrRenXinXi = new ResideMenuItem(this, "個人資料");
        itemZhuangban = new ResideMenuItem(this, "社群");
        itemShoucang = new ResideMenuItem(this, "排行榜");
        itemXiangce = new ResideMenuItem(this, "路線");
        itemShare = new ResideMenuItem(this, "觀看騎乘記錄");

        itemGuanZhangEmail.setPadding(0, Height / 5, 0, 0);


        resideMenu.addMenuItem(itemGuanZhangEmail, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemGrRenXinXi, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemZhuangban, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemShoucang, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemXiangce, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemShare, ResideMenu.DIRECTION_LEFT);

//		info = new ResideMenuInfo(this, R.drawable.icon_profile, "我我我",
//				"2012012147");

    }

    private void setListener() {
//		resideMenu.addMenuInfo(info);

        itemGuanZhangEmail.setOnClickListener(this);
        itemGrRenXinXi.setOnClickListener(this);
        itemZhuangban.setOnClickListener(this);
        itemShoucang.setOnClickListener(this);
        itemXiangce.setOnClickListener(this);
        itemShare.setOnClickListener(this);


//		info.setOnClickListener(this);


    }


    //点击按钮显示左边侧滑栏
    public void onClickLiftMenu(View v) {
        resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }

    @Override
    public void onClick(View view) {
        if (view == itemGuanZhangEmail) {
//			Intent intent = new Intent();
//			intent.putExtra("flog", "ss");
//			intent.setClass(getApplicationContext(), SettingActivity.class);
//			startActivity(intent);
            changeFragment(new RideBikeFragment());

            resideMenu.closeMenu();
        } else if (view == itemGrRenXinXi) {
//			Intent intent = new Intent();
//			intent.putExtra("flog", "sw");
//			intent.setClass(getApplicationContext(), SettingActivity.class);
//			startActivity(intent);
            changeFragment(new IdentityFragment());

            resideMenu.closeMenu();

        } else if (view == itemZhuangban) {
//			Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
//			intent.putExtra("flog", "aa");
//			intent.setClass(getApplicationContext(), SettingActivity.class);
//			startActivity(intent);

            changeFragment(new SocietyFragment());

            resideMenu.closeMenu();
        } else if (view == itemShoucang) {
//			Intent intent = new Intent();
//			intent.putExtra("flog", "bb");
//			intent.setClass(getApplicationContext(), SettingActivity.class);
//			startActivity(intent);
            changeFragment(new RankFragment());

            resideMenu.closeMenu();
        } else if (view == itemXiangce) {
//			Intent intent = new Intent();
//			intent.putExtra("flog", "cc");
//			intent.setClass(getApplicationContext(), SettingActivity.class);
//			startActivity(intent);

            changeFragment(new RoutineFragment());
            resideMenu.closeMenu();
        } else if (view == itemShare) {
//			Intent intent = new Intent();
//			intent.putExtra("flog", "dd");
//			intent.setClass(getApplicationContext(), SettingActivity.class);
//			startActivity(intent);
            changeFragment(new RecodeFragment());
            resideMenu.closeMenu();
        }
        //else if (view == info) {
//			Intent intent = new Intent();
//			intent.putExtra("flog", "ee");
//			intent.setClass(getApplicationContext(), SettingActivity.class);
//			startActivity(intent);
//		}
    }

    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
            is_closed = false;
            //leftMenu.setVisibility(View.GONE);
        }

        @Override
        public void closeMenu() {
            is_closed = true;
            //leftMenu.setVisibility(View.VISIBLE);
        }
    };

    private void changeFragment(Fragment targetFragment) {
        //resideMenu.clearIgnoredViewList();
        Log.i("brad","changeFragment");
        if(targetFragment!=null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment, targetFragment, "fragment")
                    .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        }
    }

    // What good method is to access resideMenu？
    public ResideMenu getResideMenu() {
        return resideMenu;
    }

    // 监听手机上的BACK键
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 判断菜单是否关闭
            if (is_closed) {
                // 判断两次点击的时间间隔（默认设置为2秒）
                if ((System.currentTimeMillis() - mExitTime) > 2000) {
                    Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();

                    mExitTime = System.currentTimeMillis();
                } else {
                    finish();
                    System.exit(0);
                    super.onBackPressed();
                }
            } else {
                   // resideMenu.closeMenu();
                    finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onCheckedChanged(RadioGroup arg0, int checkedId) {

//		if (rb1.getId() == checkedId) {
//			changeFragment(new SocietyFragment());
//		} else if (rb2.getId() == checkedId) {
//			changeFragment(new RoutineFragment());
//		} else if (rb3.getId() == checkedId) {
//			changeFragment(new RideBikeFragment());
//		} else if (rb4.getId() == checkedId) {
//			changeFragment(new RankFragment());
//		} else if (rb5.getId() == checkedId) {
//			changeFragment(new IdentityFragment());
//		}
    }

    @Override
    protected void onRestart() {


        Log.i("brad","a");

//            changeFragment(new RecodeFragment());
//
//
//
//            resideMenu.closeMenu();

        Log.i("brad", "b");
        super.onRestart();
        Log.i("brad", "c");
    }
}

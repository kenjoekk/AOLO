package com.library.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by joseph on 15/11/14.
 */
public class StartActivity extends Activity {
    private ViewPager vp;
    private RadioGroup rg;
    private LayoutInflater inflater;
    private ArrayList<View> views;
    private MyPagerAdapter adapter;
    private Button page1_b,page2_b,page3_b,page4_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        vp = (ViewPager) findViewById(R.id.vp);
        rg = (RadioGroup) findViewById(R.id.rg);

        rg.check(R.id.one);
//------------------塞頁面------------------------------------------------
        inflater = LayoutInflater.from(this);
        views = new ArrayList<View>();
        views.add(inflater.inflate(R.layout.start_page1, null));
        views.add(inflater.inflate(R.layout.start_page2, null));
        views.add(inflater.inflate(R.layout.start_page3, null));
        views.add(inflater.inflate(R.layout.start_page4, null));

        adapter = new MyPagerAdapter();
        vp.setAdapter(adapter);
//-----------------------------------------------------------------------
//-----------------viewpager裡面的按鈕------------------------------------------------
        page1_b = (Button) views.get(0).findViewById(R.id.page1_b);
        page1_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(StartActivity.this, StartRunActivity.class);
                startActivityForResult(it, 1);
            }
        });
        page2_b = (Button) views.get(0).findViewById(R.id.page1_b);
        page2_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        page3_b = (Button) views.get(0).findViewById(R.id.page1_b);
        page3_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        page4_b = (Button) views.get(0).findViewById(R.id.page1_b);
        page4_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
//-----------------------------------------------------------------------
//---------------viewpager換頁事件--------------------------------------------------
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        rg.check(R.id.one);
                        break;
                    case 1:
                        rg.check(R.id.two);
                        break;
                    case 2:
                        rg.check(R.id.three);
                        break;
                    case 3:
                        rg.check(R.id.four);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//-----------------------------------------------------------------------
//--------------------------radiobutton點擊事件-------------------------------------
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.one:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.two:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.three:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.four:
                        vp.setCurrentItem(3);
                        break;
                }
            }
        });


    }

//-----------------------------------------------------------------------
//-------------------------塞頁面-------------------------------------
    private class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {

            return views.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {

            return arg0 == arg1;
        }

        @Override
        public Object instantiateItem(View container, int position) {
            View now = views.get(position);
            vp.addView(now);
            return now;
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
            vp.removeView(views.get(position));
        }

    }

//-----------------------------Intent返回做事-----------------------------------
    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        if (requestCode == 1) {
            finish();
        }
    }
//-----------------------------------------------------------------------
}

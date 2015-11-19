package com.library.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.SimpleExpandableListAdapter;

import com.library.activity.R;
import com.library.activity.ShareActivity;
import com.library.activity.StartActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by joseph on 15/11/15.
 */
public class RecodeFragment extends Fragment {
    private View parentView;
    private ImageView iv_add;
    private LinkedList<Map<String,String>> recordTitle =new LinkedList<Map<String, String>>();
    private ExpandableListView list;

    private SimpleAdapter simpleAdapter;
    private ExpandableListAdapter mExpalistadapter;


    private static final String [] rmTitlef= {"monthRecord","mileRecord","timeRecord"};
    private static final int[] rmTitlet={R.id.monthRecord,R.id.mileRecord,R.id.timeRecord};



    private LinkedList<Map<String,String>> recordTime =new LinkedList<Map<String, String>>();


    private static final String [] rmTimef={"date","distance","heart","step","cal1","cal2","time1","time2"};

    private static final int [] rmTimet={R.id.recordDate,R.id.recordDistance,R.id.recordHeartImg,R.id.recordStepImg,
            R.id.recordCal1,R.id.recordCal2,R.id.recordTime1,R.id.recordTime2};
    private List<List<Map<String,String>>> recordTime2=new ArrayList<List<Map<String, String>>>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_recode, container,
                false);
        iv_add = (ImageView) parentView.findViewById(R.id.iv_add);

        list=(ExpandableListView)parentView.findViewById(R.id.list);



        recordList();
        // 点击右边显示
        iv_add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//
                Intent it =new Intent(getActivity(), StartActivity.class);
                startActivity(it);

            }

        });

        return parentView;
    }
    private void recordList(){


        Map<String,String> recordTitleMap = new HashMap<String, String>();

        recordTitleMap.put(rmTitlef[0], "monthRecord");
        recordTitleMap.put(rmTitlef[1], "mileRecord");
        recordTitleMap.put(rmTitlef[2], "timeRecord");
        recordTitle.add(recordTitleMap);



        Map<String,String> recordTimesMap =new HashMap<String, String>();

        recordTimesMap.put(rmTimef[0], "date");
        recordTimesMap.put(rmTimef[1], "distance");
        recordTimesMap.put(rmTimef[2], "heart");
        recordTimesMap.put(rmTimef[3],"step");
        recordTimesMap.put(rmTimef[4],"cal1");
        recordTimesMap.put(rmTimef[5],"cal2");
        recordTimesMap.put(rmTimef[6],"time1");
        recordTimesMap.put(rmTimef[7], "time2");

        recordTime.add(recordTimesMap);
        recordTime2.add(recordTime);


        mExpalistadapter=new SimpleExpandableListAdapter(getActivity(),recordTitle,R.layout.recordmonthlist,rmTitlef,rmTitlet,
                recordTime2,R.layout.recordtimeslist,rmTimef,rmTimet);

        list.setAdapter(mExpalistadapter);

//        simpleAdapter =new SimpleAdapter(getActivity(),recordTitle,R.layout.recordmonthlist,rmTitlef,rmTitlet);
//
//
//        Log.i("KK",""+simpleAdapter);
//
//        list.setAdapter(simpleAdapter);



//        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Intent it =new Intent(getActivity(), ShareActivity.class);
//                startActivity(it);
//
//                Log.i("KK","????");
//                return false;
//
//
//            }
//        });

        list.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent it =new Intent(getActivity(), ShareActivity.class);
                startActivity(it);
                return false;
            }
        });
    }



}
package com.library.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.library.activity.R;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RoutineLikeFragment extends Fragment {

	private ListView listLikeRoute;
	private SimpleAdapter adapter;
	private static final String[] from={"img","title","length","builder"};
	private static final int[] to={R.id.routineImg,R.id.routineTitle,R.id.routineLength,R.id.routineBuilder};
	private LinkedList<Map<String,String>> rData=new LinkedList<Map<String, String>>();


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_like_routine, container, false);

		listLikeRoute=(ListView)view.findViewById(R.id.listLikeRoute);


		changeList();
		return view;

	}
	private void changeList(){

		Map<String,String> rMap =new HashMap<String, String>();

		rMap.put(from[0], "img");
		rMap.put(from[1], "title");
		rMap.put(from[2], "length");
		rMap.put(from[3], "length");

		rData.add(rMap);

		adapter=new SimpleAdapter(getActivity(),rData,R.layout.fragment_like_routine_list,from,to);

		listLikeRoute.setAdapter(adapter);

		listLikeRoute.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

				Log.i("KK","++");
				return false;
			}
		});

	}

	
}

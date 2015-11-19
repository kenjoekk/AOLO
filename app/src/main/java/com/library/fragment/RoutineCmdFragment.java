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

public class RoutineCmdFragment extends Fragment {

	private ListView cmdList;
	private SimpleAdapter adapter;
	private static final String[] fromCmd={"img","title","length","builder"};
	private static final int[] toCmd={R.id.routineCmdImg,R.id.routineCmdTitle,R.id.routineCmdLength,R.id.routineCmdBuilder};
	private LinkedList<Map<String,String>> rDataCmd=new LinkedList<Map<String, String>>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_cmd_routine, container, false);


		cmdList=(ListView)view.findViewById(R.id.cmdList);

		changeList();
		return view;

	}
	private void changeList(){

		Map<String,String> rMap =new HashMap<String, String>();

		rMap.put(fromCmd[0], "img");
		rMap.put(fromCmd[1], "title");
		rMap.put(fromCmd[2], "length");
		rMap.put(fromCmd[3], "length");

		rDataCmd.add(rMap);

		adapter=new SimpleAdapter(getActivity(),rDataCmd,R.layout.fragment_cmd_routine_list,fromCmd,toCmd);

		cmdList.setAdapter(adapter);

		cmdList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

				Log.i("KK", "123123123");
				return false;
			}
		});

	}

}

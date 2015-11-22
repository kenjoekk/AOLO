package com.library.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.library.activity.R;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FindFriendFragment extends Fragment {


	private ListView addFriend;
	private SimpleAdapter adapterFindFriend;
	private static final String [] fromFindFriend ={"bg","photo","id","ok"};
	private static final int[] toFindFriend={R.id.findFriendBg,R.id.findFriendPhoto,R.id.findFriendId,R.id.findFriendPlus};
	private LinkedList<Map<String,String>> dataFindFriend =new LinkedList<Map<String, String>>();



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_findfriend, container, false);

		addFriend=(ListView)view.findViewById(R.id.addFriend);

		changeList();
		return view;
	}

	private void changeList(){

		Map<String,String> iFMap =new HashMap<String, String>();
		iFMap.put(fromFindFriend[0], "bg");
		iFMap.put(fromFindFriend[1], "photo");
		iFMap.put(fromFindFriend[2], "id");
		iFMap.put(fromFindFriend[3], "ok");

		dataFindFriend.add(iFMap);



		adapterFindFriend=new SimpleAdapter(getActivity(),dataFindFriend,R.layout.list_findfriend,fromFindFriend,toFindFriend);
		addFriend.setAdapter(adapterFindFriend);

	}
	

}

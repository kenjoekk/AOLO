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

public class FriendFragment extends Fragment {

	private ListView listInviteFriend,listFriend;


	private SimpleAdapter iFadapter,friendAdapter;
	private static final String [] fromInviteFriend ={"bg","photo","id","ok","no"};
	private static final int[] toInviteFriend={R.id.InviteFriendBg,R.id.InviteFriendPhoto,R.id.InviteFriendId,R.id.InviteFriendOk,R.id.InviteFriendNo};
	private LinkedList<Map<String,String>> dataInviteFriend =new LinkedList<Map<String, String>>();

	private static  final String[] fromFriend={"bg","photo","id","query"};
	private static  final int[] toFriend={R.id.friendBg,R.id.friendPhoto,R.id.friendId,R.id.friendPlus};
	private LinkedList<Map<String,String>> dataFriend =new LinkedList<Map<String, String>>();


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_friend, container, false);
		listInviteFriend=(ListView)view.findViewById(R.id.listInviteFriend);

		listFriend=(ListView)view.findViewById(R.id.listFriend);

		changeList();
		return view;
	}
	private void changeList(){

		Map<String,String> iFMap =new HashMap<String, String>();
		iFMap.put(fromInviteFriend[0],"bg");
		iFMap.put(fromInviteFriend[1], "photo");
		iFMap.put(fromInviteFriend[2], "id");
		iFMap.put(fromInviteFriend[3], "ok");
		iFMap.put(fromInviteFriend[4], "no");
		dataInviteFriend.add(iFMap);



		iFadapter=new SimpleAdapter(getActivity(),dataInviteFriend,R.layout.list_invite_friend,fromInviteFriend,toInviteFriend);
		listInviteFriend.setAdapter(iFadapter);

		Map<String,String> FMap =new HashMap<String, String>();
		FMap.put(fromFriend[0],"bg");
		FMap.put(fromFriend[1], "photo");
		FMap.put(fromFriend[2], "id");
		FMap.put(fromFriend[3], "query");

		dataFriend.add(FMap);

		friendAdapter=new SimpleAdapter(getActivity(),dataFriend,R.layout.list_friend,fromFriend,toFriend);
		listFriend.setAdapter(friendAdapter);

	}

}

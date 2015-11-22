package com.library.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.library.activity.R;
import com.library.activity.R.layout;
import com.library.activity.StartActivity;
import com.library.model.SqliteIO;

public class IdentityFragment extends Fragment {

	private ImageView iv_add;
	private ListView list_identity;
	private TextView id_tvId,id_tvRank,id_tvScore;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(layout.fragment_identity,
				container, false);

		//list_identity=(ListView)view.findViewById(R.id.list_identity);

		iv_add = (ImageView) view.findViewById(R.id.iv_add);


		// 点击右边显示
		iv_add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent it = new Intent(getActivity(), StartActivity.class);
				startActivityForResult(it, 1);

			}

		});


		return view;


	}

	@Override
	public void startActivityForResult(Intent intent, int requestCode) {
		super.startActivityForResult(intent, requestCode);

		if (requestCode == 1) {


		}
	}



	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		//cus_photo TEXT, cus_level TEXT, cus_exp TEXT,
		// cus_logtime INTEGER, cus_lat TEXT, cus_lng TEXT, cus_public INTEGER, isUp INTEGER

		id_tvId =(TextView)this.getView().findViewById(R.id.id_id);
		id_tvRank=(TextView)this.getView().findViewById(R.id.id_rank);
		id_tvScore=(TextView)this.getView().findViewById(R.id.id_score);

		SqliteIO io = new SqliteIO();
		Cursor c = io.getUserProfile();
		while (c.moveToNext()) {

			String NAME = c.getString(c.getColumnIndex("cus_name"));
			String LEVEL= c.getString(c.getColumnIndex("cus_level"));
			String EXP  = c.getString(c.getColumnIndex("cus_exp"));
			String LAT  = c.getString(c.getColumnIndex("cus_lat"));
			String LNG  = c.getString(c.getColumnIndex("cus_lng"));
			int LOGTIME=c.getInt(c.getColumnIndex("cus_logtime"));
			int PUBLIC =c.getInt(c.getColumnIndex("cus_public"));
			int ISUP   =c.getInt(c.getColumnIndex("isUp"));


			Log.i("KK", NAME + ":" + LEVEL + ":" + EXP + ":" + LAT + ":" + LNG + ":" + "" + LOGTIME + ":" + "" + PUBLIC + ":"+""+ISUP);

			id_tvId.setText(NAME);

			id_tvRank.setText("LV:"+LEVEL);

			id_tvScore.setText("PT:"+EXP);



		}
	}
}

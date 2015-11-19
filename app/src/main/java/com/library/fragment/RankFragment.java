package com.library.fragment;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.library.activity.R;
import com.library.activity.StartActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RankFragment extends Fragment implements OnCheckedChangeListener {

	private RadioGroup radioGroup;
	private RadioButton rb_DangQian, rb_JieYue;
	private ViewPager vp;
	List<Fragment> list = null;

	private TextView tv;

	private ImageView iv_add;
	private RequestQueue queue;// 一隻程式 一個queue即可

	public static final String ITEM_ID = "id";
	public static final String ITEM_SID = "sid";
	public static final String ITEM_LAT = "lat";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_rank, container,
				false);
		vp = (ViewPager) view.findViewById(R.id.vp_rank);
		radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup_jieyue);
		rb_DangQian = (RadioButton) view.findViewById(R.id.rb_dangqianjieyue);
		rb_JieYue = (RadioButton) view.findViewById(R.id.rb_jieyuelishi);

		iv_add = (ImageView) view.findViewById(R.id.iv_add);

		queue = Volley.newRequestQueue(getActivity());

		tv=(TextView)view.findViewById(R.id.logo);
		list = new ArrayList<Fragment>();
		RankFriend rf = new RankFriend();
		RankAll ra = new RankAll();

		list.add(rf);
		list.add(ra);


		ZxzcAdapter zxzc = new ZxzcAdapter(getChildFragmentManager(), list);
		vp.setAdapter(zxzc);
		zxzc.notifyDataSetChanged();

		radioGroup.setOnCheckedChangeListener(this);
		rb_DangQian.setChecked(true);

		//滑动切换
		vp.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int arg0) {
				switch (arg0) {
					case 0:
						rb_DangQian.setChecked(true);



						break;
					case 1:
						rb_JieYue.setChecked(true);

						readMysql();
						break;


				}

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});


		// 点击右边显示
		iv_add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent it =new Intent(getActivity(), StartActivity.class);
				startActivity(it);
			}
		});

		return view;
	}

	class ZxzcAdapter extends FragmentStatePagerAdapter {

		List<Fragment> list;

		public ZxzcAdapter(FragmentManager fm, List<Fragment> list) {
			super(fm);
			this.list = list;
		}

		@Override
		public Fragment getItem(int arg0) {
			return list.get(arg0);
		}

		@Override
		public int getCount() {

			return list.size();
		}

	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int checkedId) {
		if (checkedId == rb_DangQian.getId()) {
			vp.setCurrentItem(0);
		} else if (checkedId == rb_JieYue.getId()) {
			vp.setCurrentItem(1);
		}
	}


		private void readMysql(){
			//db.delete("gpsread", null, null);   //squalite
			//String readurl = "http://59.126.173.220/readdbtest.php";
			String readurl = "http://59.126.173.220/readdbtest.php";

			// Item_List = new ArrayList<HashMap<String, String>>();
			// PD.show();
			Log.i("KK","++");
			JsonObjectRequest jreq = new JsonObjectRequest
					(readurl, null, new Response.Listener<JSONObject>() {

				@Override
				public void onResponse(JSONObject response) {
					try {
						int success = response.getInt("success");

						if (success == 1) {
							JSONArray ja = response.getJSONArray("aolo");//跟php一樣

							for (int i = 0; i < ja.length(); i++) {

								JSONObject jobj = ja.getJSONObject(i);


								tv.append(jobj.getString(ITEM_ID) + "." + jobj.getString(ITEM_SID) + "_"
										+ jobj.getString(ITEM_LAT) + "\nLoc:" + jobj.getString(ITEM_LAT) + "\n");

								ContentValues values = new ContentValues();
								values.put("id", jobj.getString(ITEM_ID));
								values.put("sid", jobj.getString(ITEM_SID));
								values.put("lat", jobj.getString(ITEM_LAT));

								Log.i("KK", jobj.getString(ITEM_ID));
								//db.insert("gpsread", null, values);//squal
								// HashMap<String, String> item = new
								// HashMap<String, String>();

								// item.put(ITEM_ID, jobj.getString(ITEM_ID));
								// item.put(ITEM_NAME, jobj.getString(ITEM_NAME));

								// Item_List.add(item);

							} // for loop ends

							// String[] from = { ITEM_ID, ITEM_NAME };
							// int[] to = { R.id.tv, R.id.tv };

							// adapter = new SimpleAdapter(getApplicationContext(),
							// Item_List, R.layout.activity_main, from, to);

							// setListAdapter(adapter);

							// PD.dismiss();

						} // if ends

					} catch (JSONException e) {
						e.printStackTrace();
					}

				}

				// private void setListAdapter(ListAdapter adapter) {

				// }
			}, new Response.ErrorListener() {

				@Override
				public void onErrorResponse(VolleyError error) {
					// PD.dismiss();
				}
			});

			// Adding request to request queue
			queue.add(jreq);
			// MyApplication.getInstance().addToReqQueue(jreq);

		}

	}


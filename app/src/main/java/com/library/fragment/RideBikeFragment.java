package com.library.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.library.activity.R;
import com.library.activity.StartActivity;

public class RideBikeFragment extends Fragment {

	private View parentView;
	private Button bottom;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.fragment_ridebike, container,
				false);


		bottom = (Button) parentView.findViewById(R.id.bottom);

		bottom.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent it =new Intent(getActivity(), StartActivity.class);
				startActivityForResult(it,1);
			}
		});

		return parentView;
	}

	@Override
	public void startActivityForResult(Intent intent, int requestCode) {
		super.startActivityForResult(intent, requestCode);
		if(requestCode==1){

			//finish();
		}
	}

	private void finish() {
		finish();
	}
}

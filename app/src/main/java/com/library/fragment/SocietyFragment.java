package com.library.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.library.activity.R;
import com.library.activity.StartActivity;

import java.util.ArrayList;
import java.util.List;



public class SocietyFragment extends Fragment implements OnCheckedChangeListener{

	private View parentView;
	private RadioGroup radioGroup;
	private RadioButton rbTongZhi, rbDongTai;
	private ViewPager  vp;

	List<Fragment> list = null;
    private ImageView iv_add;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.fragment_society, container, false);
		radioGroup = (RadioGroup) parentView.findViewById(R.id.radioGroup);
		rbTongZhi = (RadioButton) parentView.findViewById(R.id.rbTongZhi);
		rbDongTai = (RadioButton) parentView.findViewById(R.id.rbDongTai);
		vp=(ViewPager)parentView.findViewById(R.id.viewpagerHuDong);
		  iv_add = (ImageView) parentView.findViewById(R.id.iv_add);
		
		list = new ArrayList<Fragment>();
		FriendFragment friendFragment=new FriendFragment();
		FindFriendFragment findFriendFragment=new FindFriendFragment();
		list.add(friendFragment);
		list.add(findFriendFragment);
		
		ZxzcAdapter zxzc = new ZxzcAdapter(getChildFragmentManager(), list);
		vp.setAdapter(zxzc);
		zxzc.notifyDataSetChanged();
		
		radioGroup.setOnCheckedChangeListener(this);
		rbTongZhi.setChecked(true);
		
		
		
		
		//滑动切换
		vp.setOnPageChangeListener(new OnPageChangeListener() {		
			@Override
			public void onPageSelected(int arg0) {
				switch (arg0) {
				case 0:	
					rbTongZhi.setChecked(true);				
					break;
				case 1:
					rbDongTai.setChecked(true);
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
		
		//点击右边显示
		iv_add.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

				Intent it =new Intent(getActivity(), StartActivity.class);
				startActivity(it);
            }

        });

		return parentView;
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int cheakedId) {
		if (cheakedId == rbTongZhi.getId()) {
			vp.setCurrentItem(0);
		} else if (cheakedId == rbDongTai.getId()) {
			vp.setCurrentItem(1);
		}
	}

	
class ZxzcAdapter extends FragmentStatePagerAdapter {
		   
		
		List<Fragment> list;			
		public ZxzcAdapter(FragmentManager fm,List<Fragment> list) {
			super(fm);
			this.list=list;			
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
}

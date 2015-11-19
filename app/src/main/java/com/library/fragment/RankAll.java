package com.library.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.library.activity.LruImageCache;
import com.library.activity.R;


/**
 * Created by joseph on 15/11/12.
 */
public class RankAll extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.rankall, container, false);



        NetworkImageView networkImageView = (NetworkImageView) view.findViewById(R.id.nivTestView);

        RequestQueue mQueue = Volley.newRequestQueue(this.getActivity());

        ImageLoader imageLoader = new ImageLoader(mQueue, new LruImageCache());


        networkImageView.setDefaultImageResId(R.drawable.photo);
        Log.i("KK", "setDefault");
        networkImageView.setErrorImageResId(R.drawable.photo);
        Log.i("KK", "setError");
        networkImageView.setImageUrl("http://dreamatico.com/data_images/ocean/ocean-2.jpg", imageLoader);
        Log.i("KK", "setImageUrl");

        return view;
    }
}

package com.flyfanr.midapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by liuziyu on 16/8/2.
 */
public class Image2Fm extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ImageView iv = new ImageView(getActivity());
        iv.setImageResource(R.drawable.img2);
        return iv;
    }
}
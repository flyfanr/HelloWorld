package com.flyfanr.midapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by liuziyu on 16/8/1.
 */
public class AnotherFragment extends android.support.v4.app.Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("onCreat");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println("onCreatView");

        View root = inflater.inflate(R.layout.fragment_another,container,false);

        root.findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });

        return root;
    }

    @Override
    public void onPause() {
        super.onPause();

        System.out.println("onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        System.out.println("onDestroy");
    }


}

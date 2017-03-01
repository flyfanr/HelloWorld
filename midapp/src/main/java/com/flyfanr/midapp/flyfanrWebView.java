package com.flyfanr.midapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by liuziyu on 16/8/1.
 */
public class flyfanrWebView extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.flyfanr_web_view, container, false);
        WebView wv = (WebView) root.findViewById(R.id.wv);

        wv.loadUrl("http://flyfanr.com");

        return root;
    }
}

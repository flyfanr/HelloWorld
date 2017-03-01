package com.flyfanr.midapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RelativeLayoutAty extends AppCompatActivity {

    private RelativeLayout root;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_relative_layout_aty);

        root = new RelativeLayout(this);
        setContentView(root);

        textView = new TextView(this);
        textView.setText("flyfanr");

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 200;
        lp.topMargin = 500;
        

        root.addView(textView, lp);



    }
}

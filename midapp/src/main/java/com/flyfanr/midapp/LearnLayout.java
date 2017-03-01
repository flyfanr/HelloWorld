package com.flyfanr.midapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class LearnLayout extends AppCompatActivity {

    private LinearLayout root;

    private Button btnClickme;
    private Button btnFrameLayout;
    private Button btnRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        setContentView(root);

        btnClickme = new Button(this);
        btnClickme.setText("Click me");

        btnFrameLayout = new Button(this);
        btnFrameLayout.setText("Frame Layout");

        btnRelativeLayout = new Button(this);
        btnRelativeLayout.setText("Relative Layout");

        root.addView(btnClickme);

//        root.addView(btnClickme, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        root.addView(btnRelativeLayout);
        root.addView(btnFrameLayout);

        btnRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LearnLayout.this, RelativeLayoutAty.class));
            }
        });

        btnFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LearnLayout.this, FrameLayoutAty.class));
            }
        });

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
//        setContentView(R.layout.activity_learn_layout);
    }
}
